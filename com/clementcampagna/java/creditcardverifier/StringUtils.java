package com.clementcampagna.java.creditcardverifier;

/**
 *
 * @productname     Credit Card Verifier (Luhn’s algorithm)
 * @packagename     com.clementcampagna.java.creditcardverifier
 * @filename        StringUtils.java
 * @author          Clément Campagna (https://clementcampagna.com)
 * @created         07 September 2020
 * @lastrevision    07 September 2020
 * @licensetype     MIT License (https://opensource.org/licenses/MIT)
 * @ide             IntelliJ IDEA 2020.2.1 (Ultimate Edition)
 * @javasdkversion  1.8.0_60
 *
 **/

public class StringUtils
{
    public static String[] convertStringToStringArray(String userInput)
    {
        String[] strArrayResult = new String[16];

        for (int i = 0; i < userInput.length(); i++)
            strArrayResult[i] = String.valueOf(userInput.charAt(i));

        return strArrayResult;
    }

    public static String removeWhiteSpacesFromString(String userInput)
    {
        return userInput.replaceAll("\\s", "");
    }
}
