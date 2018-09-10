/**
 * 
 */
package de.adesso.testJSF.service;

import java.io.File;
import java.io.IOException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.adesso.testJSF.model.Country;
import de.adesso.testJSF.model.CountryJSON;

/**
 * @author hayber
 *
 */

@ManagedBean(name = "countryServiceImpl", eager = true)
@ApplicationScoped
public class CountryServiceImpl implements CountryService {

	@Override
	public Country[] getCountry() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		CountryJSON countryJSON = mapper.readValue(
				new File(new ClassPathResource("countries-DE.json").getFile().getAbsolutePath()), CountryJSON.class);
		System.out.println(countryJSON);
		return countryJSON.getCountries();
	}

}
