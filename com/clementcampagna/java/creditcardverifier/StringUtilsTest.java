package com.clementcampagna.java.creditcardverifier;

/**
 *
 * @productname     Credit Card Verifier (Luhn’s algorithm)
 * @packagename     com.clementcampagna.java.creditcardverifier
 * @filename        StringUtilsTest.java
 * @author          Clément Campagna (https://clementcampagna.com)
 * @created         07 September 2020
 * @lastrevision    07 September 2020
 * @licensetype     MIT License (https://opensource.org/licenses/MIT)
 * @ide             IntelliJ IDEA 2020.2.1 (Ultimate Edition)
 * @javasdkversion  1.8.0_60
 *
 **/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    @DisplayName("Convert a string to a string array")
    void TestConvertStringToStringArray()
    {
        String simulatedUserInput = "1234567890123456";
        String[] expectedCardNumber = new String[16];

        // Build our expected card number String[] for this test
        for (int i = 0; i < simulatedUserInput.length(); i++)
            expectedCardNumber[i] = String.valueOf(simulatedUserInput.charAt(i));

        // Test if the expectedCardNumber string array equals the values returned by function StringUtils.convertStringToStringArray
        assertArrayEquals(expectedCardNumber, StringUtils.convertStringToStringArray(simulatedUserInput));
    }

    @Test
    @DisplayName("Remove all white spaces from a string and returns it once trimmed")
    void TestRemoveWhiteSpacesFromString()
    {
        assertEquals("1234567890123456", StringUtils.removeWhiteSpacesFromString("1234 5678 9012 3456"));
    }
}