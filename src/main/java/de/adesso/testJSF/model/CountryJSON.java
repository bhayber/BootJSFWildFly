package de.adesso.testJSF.model;

import java.io.Serializable;


public class CountryJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Country[] getCountries() {
		return countries;
	}

	public void setCountries(Country[] countries) {
		this.countries = countries;
	}

	private Country[] countries;

}
