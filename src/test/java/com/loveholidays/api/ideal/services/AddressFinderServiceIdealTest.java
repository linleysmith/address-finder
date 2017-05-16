package com.loveholidays.api.ideal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loveholidays.api.ideal.json.IdealAddressResult;
import com.loveholidays.domain.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressFinderServiceIdealTest {

    private static final String TEST_POSTCODE = "BT486DQ";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AddressFinderServiceIdeal service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noResultsReturnedOnErrorResponse() throws Exception {
        IdealAddressResult errorResult = getResult("AddressResponseError.json");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(errorResult);
        Set<Address> addresses = service.findAddresses(TEST_POSTCODE);
        assertTrue(addresses.isEmpty());
    }

    @Test
    public void singleResultsReturnedSuccessfully() throws Exception {
        IdealAddressResult singleResult = getResult("AddressResponseSuccessForBT486DQ.json");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(singleResult);
        Set<Address> addresses = service.findAddresses(TEST_POSTCODE);
        assertEquals(1, addresses.size());
        Address address = addresses.stream().findFirst().get();
        assertEquals("BT48 6DQ", address.getPostcode());
        assertEquals("Registrar Of Births Deaths & Marriages", address.getOrganisationName());
        assertEquals("Shipquay Place", address.getStreet());
    }

    @Test
    public void multipleResultsReturnedSuccessfully() throws Exception {
        IdealAddressResult multipleResults = getResult("AddressResponseSuccessForW60LG.json");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(multipleResults);
        Set<Address> addresses = service.findAddresses(TEST_POSTCODE);
        assertEquals(13, addresses.size());
        addresses.forEach(address -> assertEquals("W6 0LG", address.getPostcode()));
    }

    private IdealAddressResult getResult(String filename) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
        StringBuilder json = new StringBuilder();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> {
            json.append(line).append("\n");
        });
        lines.close();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toString(), IdealAddressResult.class);
    }

}