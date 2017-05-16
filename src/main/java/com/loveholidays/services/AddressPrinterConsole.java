package com.loveholidays.services;

import com.loveholidays.domain.Address;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by linleysmith on 15/05/2017.
 *
 */
@Service
public class AddressPrinterConsole implements AddressPrinter {

    /**
     * Prints postcode search results to console
     * @param postcode the postcode used for searching
     * @param addresses the collection of addresses found
     */
    @Override
    public void print(String postcode, Set<Address> addresses) {
        System.out.println();
        if (addresses.isEmpty()) {
            System.err.println("No addresses found for postcode: " + postcode);
            return;
        }
        System.err.println(addresses.size() + " address(es) found for postcode: " + postcode);
        addresses.forEach(System.err::println);
        System.out.println();
    }
}
