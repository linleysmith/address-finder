package com.loveholidays.api;

import com.loveholidays.domain.Address;

import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 *
 */
public interface AddressFinderService {
    Set<Address> findAddresses(String postcode);
}
