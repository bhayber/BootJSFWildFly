package de.adesso.testJSF.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.adesso.testJSF.model.Country;

public interface CountryService {

	Country[] getCountries() throws JsonParseException, JsonMappingException, IOException;

}
