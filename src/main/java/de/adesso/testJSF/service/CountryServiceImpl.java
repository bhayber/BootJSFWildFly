/**
 * 
 */
package de.adesso.testJSF.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.adesso.testJSF.model.Country;
import de.adesso.testJSF.model.CountryJSON;

/**
 * @author hayber
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger logger = LogManager.getLogger(CountryServiceImpl.class);

    @Override
    public Country[] getCountries() throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	CountryJSON countryJSON = mapper.readValue(
		new File(new ClassPathResource("countries-DE.json").getFile().getAbsolutePath()), CountryJSON.class);
	return countryJSON.getCountries();
    }

    @PostConstruct
    private void init() {
	logger.info("Ich bin da");
    }
}
