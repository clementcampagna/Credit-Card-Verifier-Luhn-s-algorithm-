package com.clementcampagna.java.creditcardverifier;

/**
 *
 * @productname     Credit Card Verifier (Luhn’s algorithm)
 * @packagename     com.clementcampagna.java.creditcardverifier
 * @filename        Checker.java
 * @author          Clément Campagna (https://clementcampagna.com)
 * @created         07 September 2020
 * @lastrevision    07 September 2020
 * @licensetype     MIT License (https://opensource.org/licenses/MIT)
 * @ide             IntelliJ IDEA 2020.2.1 (Ultimate Edition)
 * @javasdkversion  1.8.0_60
 *
 **/

import static com.clementcampagna.java.creditcardverifier.StringUtils.convertStringToStringArray;

public class Checker
{
    /* Double every second digit from right to left (start from the second digit from the right).
       If this “doubling” results in a two-digit number, subtract 9 from it get a single digit. */
    public static int doubleEverySecondDigitBackwardAndAddThemToEachOther(String[] cardNumber)
    {
        int result = 0;

        for (int i = cardNumber.length - 1; i >= 0; i--)
        {
            if (i % 2 == 0)
            {
                if ((Integer.parseInt(cardNumber[i]) * 2) > 9)
                    result += (Integer.parseInt(cardNumber[i]) * 2) - 9;
                else
                    result += (Integer.parseInt(cardNumber[i]) * 2);
            }
        }

        return result;
    }

    /* Add all digits in the odd places from right to left in the credit card number
       (start from the first digit from the right).
     */
    public static int addAllDigitsInOddPlacesFromRightToLeft(String[] cardNumber)
    {
        int result = 0;

        for (int i = cardNumber.length - 1; i >= 0; i--)
        {
            if (i % 2 != 0)
                result += (Integer.parseInt(cardNumber[i]));
        }

        return result;
    }

    /* Take a card number as a string and return true is the card number is valid;
       Or False is card number is invalid */
    public static boolean performCreditCardCheck(String userInput)
    {
        String[] cardNumber;
        int   step1; //1. Double every second digit from right to left (start from the second digit from the right). If this “doubling” results in a two-digit number, subtract 9 from it get a single digit.
        int   step2; //2. Now add all single digit numbers from step 1.
        int   step3; //3. Add all digits in the odd places from right to left in the credit card number (start from the first digit from the right).
        int   step4; //4. Sum the results from steps 2 & 3.
        float step5; //5. If the result from step 4 is divisible by 10, the card number is valid; otherwise, it is invalid.

        // Remove all white spaces from userInput and assign the result to card string
        cardNumber = convertStringToStringArray(userInput);

        /* 1. Double every second digit from right to left (start from the second digit from the right).
           If this “doubling” results in a two-digit number, subtract 9 from it get a single digit. */
        step1 = doubleEverySecondDigitBackwardAndAddThemToEachOther(cardNumber);

        // 2. Now add all single digit numbers from step 1.
        step2 = step1; // This has already been done as part of step 1. Only keeping var step2 to make code more logical to read.

        /* 3. Add all digits in the odd places from right to left in the credit card number
           (start from the first digit from the right). */
        step3 = addAllDigitsInOddPlacesFromRightToLeft(cardNumber);

        // 4. Sum the results from steps 2 & 3.
        step4 = step2 + step3;

        /* 5. If the result from step 4 is divisible by 10, the card number is valid;
           otherwise, it is invalid. */
        step5 = (float)step4 / 10;

        /* Use modulus operator to return true if the result from step 5 can be written without a fractional component;
           Otherwise, return false */
        return step5 % 1 == 0;
    }
}
