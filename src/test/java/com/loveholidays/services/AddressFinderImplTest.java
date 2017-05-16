package com.loveholidays.services;

import com.loveholidays.api.AddressFinderService;
import com.loveholidays.domain.Address;
import com.loveholidays.services.validators.PostcodeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressFinderImplTest {

    @Mock
    private PostcodeValidator validator;
    @Mock
    private AddressFinderService addressFinderService;
    @InjectMocks
    private AddressFinderImpl addressFinder;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPostcodeThrowsException() {
        when(validator.isValid(anyString())).thenReturn(false);
        addressFinder.getAddresses("invalid");
        verify(validator).isValid(anyString());
    }

    @Test
    public void successfulResult() {
        Address address = new Address("postcode", "organisation", "street");
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        when(validator.isValid(anyString())).thenReturn(true);
        when(addressFinderService.findAddresses(anyString())).thenReturn(addresses);
        addressFinder.getAddresses("valid");
        verify(validator).isValid(anyString());
        verify(addressFinderService).findAddresses(anyString());
    }

}