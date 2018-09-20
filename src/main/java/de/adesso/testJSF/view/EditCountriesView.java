package de.adesso.testJSF.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.DependsOn;

import de.adesso.testJSF.model.Country;
import de.adesso.testJSF.service.CountryServiceImpl;

@ManagedBean(name = "editCountriesView", eager = true)
@SessionScoped
@DependsOn(value = { "countryServiceImpl" })
public class EditCountriesView implements Serializable {

	Logger log = Logger.getLogger(EditCountriesView.class);

	private List<Country> countryList;

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{countryServiceImpl}")
	private CountryServiceImpl countryService;

	@PostConstruct
	public void init() {
		try {
			countryList = Arrays.asList(countryService.getCountries());
		} catch (Exception e) {
			log.error("Error occured", e);
		}
	}

	/**
	 * @return the countryService
	 */
	public CountryServiceImpl getCountryService() {
		return countryService;
	}

	/**
	 * @param countryService
	 *            the countryService to set
	 */
	public void setCountryService(CountryServiceImpl countryService) {
		this.countryService = countryService;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited", ((Country) event.getObject()).getIso());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Country) event.getObject()).getIso());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the countryList
	 */
	public List<Country> getCountryList() {
		return countryList;
	}

	/**
	 * @param countryList
	 *            the countryList to set
	 */
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

}