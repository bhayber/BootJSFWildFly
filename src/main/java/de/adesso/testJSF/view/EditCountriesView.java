package de.adesso.testJSF.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import de.adesso.testJSF.model.Country;
import de.adesso.testJSF.service.CountryServiceImpl;

@Named
@SessionScoped
public class EditCountriesView implements Serializable {

    private static final Logger logger = LogManager.getLogger(EditCountriesView.class);

    private List<Country> countryList;

    private static final long serialVersionUID = 1L;

    @Autowired
    private CountryServiceImpl countryService;

    @PostConstruct
    public void init() {
	try {
	    logger.info("init EditCountriesView");
	    countryList = Arrays.asList(countryService.getCountries());
	} catch (Exception e) {
	    logger.error("Error occured", e);
	}
    }

    /**
     * @return the countryService
     */
    public CountryServiceImpl getCountryService() {
	return countryService;
    }

    /**
     * @param countryService the countryService to set
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
     * @param countryList the countryList to set
     */
    public void setCountryList(List<Country> countryList) {
	this.countryList = countryList;
    }

}