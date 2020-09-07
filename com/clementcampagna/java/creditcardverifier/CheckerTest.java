package com.clementcampagna.java.creditcardverifier;

/**
 *
 * @productname     Credit Card Verifier (Luhn’s algorithm)
 * @packagename     com.clementcampagna.java.creditcardverifier
 * @filename        CheckerTest.java
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

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    @DisplayName("Double every second digit from right to left (start from the second digit from the right). If this “doubling” results in a two-digit number, subtract 9 from it get a single digit.")
    void testDoubleEverySecondDigitBackwardAndAddThemToEachOther()
    {
        String simulatedUserInput = "4556737586899855";
        String[] expectedCardNumber = new String[16];

        // Build our expected card number String[] for this test
        for (int i = 0; i < simulatedUserInput.length(); i++)
            expectedCardNumber[i] = String.valueOf(simulatedUserInput.charAt(i));

        assertEquals(43, Checker.doubleEverySecondDigitBackwardAndAddThemToEachOther(expectedCardNumber));
    }

    @Test
    @DisplayName("Add all digits in the odd places from right to left in the credit card number.")
    void testAddAllDigitsInOddPlacesFromRightToLeft()
    {
        String simulatedUserInput = "4556737586899855";
        String[] expectedCardNumber = new String[16];

        // Build our expected card number String[] for this test
        for (int i = 0; i < simulatedUserInput.length(); i++)
            expectedCardNumber[i] = String.valueOf(simulatedUserInput.charAt(i));

        assertEquals(47, Checker.addAllDigitsInOddPlacesFromRightToLeft(expectedCardNumber));
    }

    @Test
    @DisplayName("Take a card number as a string and return true is the card number is valid, or false if it isn't.")
    void testPerformCreditCardCheck_isValid()
    {
        assertTrue(Checker.performCreditCardCheck("4556737586899855"));
    }

    @Test
    @DisplayName("Take a card number as a string and return true is the card number is valid, or false if it isn't.")
    void testPerformCreditCardCheck_isInvalid()
    {
        assertFalse(Checker.performCreditCardCheck("4556737586899856"));
    }
}