package woche12_jUnit_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import woche12_jUnit_Methoden.WebAddressValidator;

class WebAddressTest {
    private WebAddressValidator webAddressValidator = new WebAddressValidator();

    private String[] positiveNumericAddresses = {
            "192.168.0.1", "10.0.0.1", "172.16.0.1",
            "0.0.0.0", "255.255.255.255"
    };

    private String[] negativeNumericAddresses = {
            "-256.0.0.1", "-300.200.100.50", "-192.168.256.1",
            "-8.8", "-8", "-8.8.8.8.8"
    };
    
    private String[] positiveSymbolicAddresses = {
            "example.com", "www.example.com",
            "mail.server.edu", "test.ch"
    };

    private String[] negativeSymbolicAddresses = {
            ".example.com", "example.com.",
            "example,com", "com", "com.", ".com"
    };

    @Test
    void testPositiveNumericAddresses() {
        for (String address : positiveNumericAddresses) {
            assertTrue(webAddressValidator.isValidWebAddress(address), "Failed for address: " + address);
     
        }
    }

    @Test
    void testNegativeNumericAddresses() {
        for (String address : negativeNumericAddresses) {
            assertFalse(webAddressValidator.isValidWebAddress(address), "Unexpectedly valid: " + address);

        }
    }

    @Test
    void testPositiveSymbolicAddresses() {
        for (String address : positiveSymbolicAddresses) {
            assertTrue(webAddressValidator.isValidWebAddress(address), "Failed for address: " + address);

        }
    }

    @Test
    void testNegativeSymbolicAddresses() {
        for (String address : negativeSymbolicAddresses) {
            assertFalse(webAddressValidator.isValidWebAddress(address), "Unexpectedly valid: " + address);

        }
    }
}

