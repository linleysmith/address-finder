package com.loveholidays.api.ideal.utilities;

import com.loveholidays.api.ideal.json.IdealAddress;
import com.loveholidays.domain.Address;

/**
 * Created by linleysmith on 15/05/2017.
 * A simple utility class to transform Address objects
 */
public class AddressTransformer {

    /**
     * Transforms an IdealAddress into an Address object
     * @param idealAddress the Ideal address to transform from
     * @return a transformed address
     */
    public static Address transform(IdealAddress idealAddress) {
        return new Address(idealAddress.getPostcode(), idealAddress.getOrganisationName(), idealAddress.getThoroughfare());
    }
}
