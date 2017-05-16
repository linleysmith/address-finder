package com.loveholidays.services;


import com.loveholidays.api.AddressFinderService;
import com.loveholidays.domain.Address;
import com.loveholidays.services.validators.PostcodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 * Utilities for finding postal addresses
 */
@Service
public class AddressFinderImpl implements AddressFinder {

    @Autowired
    private PostcodeValidator validator;
    @Autowired
    private AddressFinderService addressFinderService;

    /**
     * Retrieve a group of addresses based on a postcode
     *
     * @param postcode used for the address search
     * @return A collection of Addresses*
     */
    @Override
    public Set<Address> getAddresses(String postcode) {
        String cleanedPostcode = postcode.replace(" ", "");
        boolean validPostcode = validator.isValid(cleanedPostcode);
        if (validPostcode) {
            return addressFinderService.findAddresses(cleanedPostcode);
        } else {
            throw new IllegalArgumentException("Invalid postcode: " + postcode);
        }
    }
}
