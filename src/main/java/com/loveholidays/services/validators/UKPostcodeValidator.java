package com.loveholidays.services.validators;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by linleysmith on 15/05/2017.
 * A validator for UK postcodes
 */
@Service
public class UKPostcodeValidator implements PostcodeValidator {

    private static final String VALID_UK_POSTCODE_REGEX = "^[a-zA-Z]{1,2}([0-9]{1,2}|[0-9][a-zA-Z])\\s*[0-9][a-zA-Z]{2}$";

    /**
     * A simple validator for UK postcodes
     *
     * @param postcode the UK postcode to be validated
     * @return true if is a UK postcode, else false
     */
    @Override
    public boolean isValid(String postcode) {
        Pattern pattern = Pattern.compile(VALID_UK_POSTCODE_REGEX);
        Matcher matcher = pattern.matcher(postcode);
        return matcher.matches();
    }
}
