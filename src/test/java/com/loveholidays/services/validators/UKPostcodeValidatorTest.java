package com.loveholidays.services.validators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by linleysmith on 15/05/2017.
 * Wikipedia tells us UK postcodes can use the following formats ('A' stands for any letter, and '9' for any digit):

 - AA9A 9AA
 - A9A 9AA
 - A9 9AA
 - A99 9AA
 - AA9 9AA
 - AA99 9AA
 */
public class UKPostcodeValidatorTest {

    private PostcodeValidator validator;

    @Before
    public void setup() {
        validator = new UKPostcodeValidator();
    }

    @Test
    public void validUKPoscodes() {
        assertTrue(validator.isValid("AA9A 9AA"));
        assertTrue(validator.isValid("A9A 9AA"));
        assertTrue(validator.isValid("A9 9AA"));
        assertTrue(validator.isValid("AA9 9AA"));
        assertTrue(validator.isValid("A99 9AA"));
        assertTrue(validator.isValid("AA99 9AA"));
    }

    @Test
    public void invalidUKPoscodes() {
        assertFalse(validator.isValid("99A9 A99"));
        assertFalse(validator.isValid("9A9 A99"));
        assertFalse(validator.isValid("9A A99"));
        assertFalse(validator.isValid("99A A99"));
        assertFalse(validator.isValid("9AA A99"));
        assertFalse(validator.isValid("99AA A99"));
    }

}