package com.loveholidays.api.ideal.services;

import com.loveholidays.api.AddressFinderService;
import com.loveholidays.api.ideal.json.IdealAddressResult;
import com.loveholidays.api.ideal.utilities.AddressTransformer;
import com.loveholidays.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 * A service to look up postcodes from the Ideal API
 */
@Service
public class AddressFinderServiceIdeal implements AddressFinderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressFinderServiceIdeal.class);
    private static final String POST_CODE_FINDER_URL_PREFIX = "https://api.ideal-postcodes.co.uk/v1/postcodes/";
    private static final String POST_CODE_FINDER_API_KEY = "?api_key=iddqd";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Returns a collection of addresses for the provided postcode
     *
     * @param postcode the postcode to search on
     * @return a collection of addresses
     */
    @Override
    public Set<Address> findAddresses(String postcode) {
        IdealAddressResult result = restTemplate.getForObject(constructUrl(postcode), IdealAddressResult.class);
        if (result.getCode() != 2000) {
            LOGGER.warn("Error retrieving addresses for postcode: " + postcode + ", Error code: " + result.getCode() + ", Error Message: " + result.getMessage());
        }
        Set<Address> addresses = new HashSet<>();
        if (result.getCode() == 2000 && !result.getIdealAddresses().isEmpty()) {
            result.getIdealAddresses().forEach(idealAddress -> addresses.add(AddressTransformer.transform(idealAddress)));
        }
        return addresses;
    }

    private String constructUrl(String postcode) {
        return POST_CODE_FINDER_URL_PREFIX + postcode + POST_CODE_FINDER_API_KEY;
    }

}
