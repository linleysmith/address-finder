package com.loveholidays;

/**
 * Created by linleysmith on 14/05/2017.
 */

import com.loveholidays.domain.Address;
import com.loveholidays.services.AddressFinder;
import com.loveholidays.services.AddressPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        String postcodes[] = {"W6 0LG", "SW1A 2AA", "BT48 6DQ"};
        SpringApplication.run(Application.class, postcodes);
    }

    @Bean
    public CommandLineRunner run(AddressFinder addressFinder, AddressPrinter printer) throws Exception {
        return args -> {
            String postcode = args[0];
            Set<Address> addresses = addressFinder.getAddresses(postcode);
            printer.print(postcode, addresses);

            postcode = args[1];
            addresses = addressFinder.getAddresses(postcode);
            printer.print(postcode, addresses);

            postcode = args[2];
            addresses = addressFinder.getAddresses(postcode);
            printer.print(postcode, addresses);
        };
    }
}
