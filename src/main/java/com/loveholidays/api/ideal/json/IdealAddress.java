package com.loveholidays.api.ideal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by linleysmith on 14/05/2017.
 * Json representation of an ideal address
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdealAddress {
    @JsonProperty
    private String postcode;
    @JsonProperty("postcode_inward")
    private String postcodeInward;
    @JsonProperty("postcode_outward")
    private String postcodeOutward;
    @JsonProperty("post_town")
    private String postTown;
    @JsonProperty("dependant_locality")
    private String dependantLocality;
    @JsonProperty("double_dependant_locality")
    private String doubleDependantLocality;
    @JsonProperty
    private String thoroughfare;
    @JsonProperty("dependant_thoroughfare")
    private String dependantThoroughfare;
    @JsonProperty("building_number")
    private String buildingNumber;
    @JsonProperty("building_name")
    private String buildingName;
    @JsonProperty("sub_building_name")
    private String subBuildingName;
    @JsonProperty("po_box")
    private String poBox;
    @JsonProperty("department_name")
    private String departmentName;
    @JsonProperty("organisation_name")
    private String organisationName;
    @JsonProperty
    private String udprn;
    @JsonProperty
    private String umprn;
    @JsonProperty("postcode_type")
    private String postcodeType;
    @JsonProperty("su_organisation_indicator")
    private String suOrganisationIndicator;
    @JsonProperty("delivery_point_suffix")
    private String deliveryPointSuffix;
    @JsonProperty("line_1")
    private String lineOne;
    @JsonProperty("line_2")
    private String lineTwo;
    @JsonProperty("line_3")
    private String lineThree;
    @JsonProperty
    private String premise;
    @JsonProperty
    private Long longitude;
    @JsonProperty
    private Long latitude;
    @JsonProperty
    private Integer eastings;
    @JsonProperty
    private Integer northings;
    @JsonProperty
    private String country;
    @JsonProperty("traditional_county")
    private String traditionalCounty;
    @JsonProperty("administrative_county")
    private String administrative_county;
    @JsonProperty("postal_county")
    private String postalCounty;
    @JsonProperty
    private String county;
    @JsonProperty
    private String district;
    @JsonProperty
    private String ward;

    public String getPostcode() {
        return postcode;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public String getThoroughfare() {
        return thoroughfare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdealAddress that = (IdealAddress) o;

        if (organisationName != null ? !organisationName.equals(that.organisationName) : that.organisationName != null)
            return false;
        return udprn != null ? udprn.equals(that.udprn) : that.udprn == null;
    }

    @Override
    public int hashCode() {
        int result = organisationName != null ? organisationName.hashCode() : 0;
        result = 31 * result + (udprn != null ? udprn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "IdealAddress{" +
                "  postcode='" + postcode + '\'' +
                ", postcodeInward='" + postcodeInward + '\'' +
                ", postcodeOutward='" + postcodeOutward + '\'' +
                ", postTown='" + postTown + '\'' +
                ", dependantLocality='" + dependantLocality + '\'' +
                ", doubleDependantLocality='" + doubleDependantLocality + '\'' +
                ", thoroughfare='" + thoroughfare + '\'' +
                ", dependantThoroughfare='" + dependantThoroughfare + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", subBuildingName='" + subBuildingName + '\'' +
                ", poBox='" + poBox + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", organisationName='" + organisationName + '\'' +
                ", udprn='" + udprn + '\'' +
                ", umprn='" + umprn + '\'' +
                ", postcodeType='" + postcodeType + '\'' +
                ", suOrganisationIndicator='" + suOrganisationIndicator + '\'' +
                ", deliveryPointSuffix='" + deliveryPointSuffix + '\'' +
                ", lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", lineThree='" + lineThree + '\'' +
                ", premise='" + premise + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", eastings=" + eastings +
                ", northings=" + northings +
                ", country='" + country + '\'' +
                ", traditionalCounty='" + traditionalCounty + '\'' +
                ", administrative_county='" + administrative_county + '\'' +
                ", postalCounty='" + postalCounty + '\'' +
                ", county='" + county + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                '}';
    }

}
