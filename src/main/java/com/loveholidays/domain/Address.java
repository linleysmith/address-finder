package com.loveholidays.domain;

/**
 * Created by linleysmith on 15/05/2017.
 * A loveholidays address
 */
public final class Address {

    private final String postcode;
    private final String organisationName;
    private final String street;

    public Address(String postcode, String organisationName, String street) {
        this.postcode = postcode;
        this.organisationName = organisationName;
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!postcode.equals(address.postcode)) return false;
        if (organisationName != null ? !organisationName.equals(address.organisationName) : address.organisationName != null)
            return false;
        return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = postcode.hashCode();
        result = 31 * result + (organisationName != null ? organisationName.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postcode='" + postcode + '\'' +
                ", organisationName='" + organisationName + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
