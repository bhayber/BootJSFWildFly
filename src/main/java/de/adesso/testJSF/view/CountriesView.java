package de.adesso.testJSF.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.DependsOn;

import de.adesso.testJSF.model.Country;
import de.adesso.testJSF.service.CountryServiceImpl;

@ManagedBean(name = "countriesView", eager = true)
@SessionScoped
@DependsOn(value = { "login", "countryServiceImpl" })
public class CountriesView implements Serializable {

	Logger log = Logger.getLogger(CountriesView.class);

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{countryServiceImpl}")
	private CountryServiceImpl countryService;

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

	@ManagedProperty(value = "#{login}")
	private Login login;

	private String[] selectedCountryIsos;

	/**
	 * @return the selectedCountryIsos
	 */
	public String[] getSelectedCountryIsos() {
		return selectedCountryIsos;
	}

	/**
	 * @param selectedCountryIsos
	 *            the selectedCountryIsos to set
	 */
	public void setSelectedCountryIsos(String[] selectedCountryIsos) {
		this.selectedCountryIsos = selectedCountryIsos;
	}

	/**
	 * @return the countries
	 */
	public Country[] getCountries() {
		try {
			return countryService.getCountry();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	private String loginName = "default";

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		if (login != null) {
			return login.getEmail();
		}
		System.out.println(login);
		return loginName;
	}

	public CountriesView() {
		System.out.println("Countryview started!");
	}

}