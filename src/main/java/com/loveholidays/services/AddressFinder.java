package com.loveholidays.services;

import com.loveholidays.domain.Address;

import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 * A group of utilities for finding postal addresses
 */
public interface AddressFinder {
    Set<Address> getAddresses(String postcode);
}
