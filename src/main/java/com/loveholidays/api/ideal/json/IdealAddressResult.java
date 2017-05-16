package com.loveholidays.api.ideal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

/**
 * Created by linleysmith on 14/05/2017.
 * Json representation of the ideal address search result
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdealAddressResult {

    @JsonProperty("result")
    private Set<IdealAddress> idealAddresses;
    @JsonProperty
    private Integer code;
    @JsonProperty
    private String message;

    public Set<IdealAddress> getIdealAddresses() {
        return idealAddresses;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "IdealAddressResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", idealAddresses=" + idealAddresses +
                '}';
    }

}
