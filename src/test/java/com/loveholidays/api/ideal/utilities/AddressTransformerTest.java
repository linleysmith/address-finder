package com.loveholidays.api.ideal.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loveholidays.api.ideal.json.IdealAddress;
import com.loveholidays.api.ideal.json.IdealAddressResult;
import com.loveholidays.domain.Address;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class AddressTransformerTest {

    @Test
    public void idealAddressIsTransformedToAddress() throws Exception {
        IdealAddressResult result = getSuccessfulResult();
        Set<IdealAddress> idealAddresses = result.getIdealAddresses();
        idealAddresses.forEach(idealAddress -> {
            Address address = AddressTransformer.transform(idealAddress);
            assertEquals("SW1A 2AA", address.getPostcode());
            assertEquals("Prime Minister & First Lord Of The Treasury", address.getOrganisationName());
            assertEquals("Downing Street", address.getStreet());
        });
    }

    private IdealAddressResult getSuccessfulResult() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("AddressResponseSuccessForSW1A2AA.json").toURI());
        StringBuilder json = new StringBuilder();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> json.append(line).append("\n"));
        lines.close();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.reader().forType(IdealAddressResult.class).readValue(json.toString());
    }

}