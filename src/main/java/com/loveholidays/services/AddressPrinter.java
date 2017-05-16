package com.loveholidays.services;

import com.loveholidays.domain.Address;

import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 *
 */
public interface AddressPrinter {
    void print(String postcode, Set<Address> addresses);
}
