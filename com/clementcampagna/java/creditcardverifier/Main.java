package com.clementcampagna.java.creditcardverifier;

/**
 *
 * @productname     Credit Card Verifier (Luhn’s algorithm)
 * @packagename     com.clementcampagna.java.creditcardverifier
 * @filename        Main.java
 * @author          Clément Campagna (https://clementcampagna.com)
 * @created         07 September 2020
 * @lastrevision    07 September 2020
 * @licensetype     MIT License (https://opensource.org/licenses/MIT)
 * @ide             IntelliJ IDEA 2020.2.1 (Ultimate Edition)
 * @javasdkversion  1.8.0_60
 *
 **/

import java.util.Scanner;
import static com.clementcampagna.java.creditcardverifier.Checker.performCreditCardCheck;
import static com.clementcampagna.java.creditcardverifier.StringUtils.removeWhiteSpacesFromString;

public class Main {
    public static void main(String[] args)
    {
        if (args.length > 0) // Argument(s) are being parsed to the application, let's deal with them
        {
            for (String arg : args)
            {
                System.out.println("Verifying card " + arg);

                if (arg.matches("[0-9]{16}")) // A potentially valid credit card number must have 16 digits
                {
                    if (performCreditCardCheck(arg))
                        System.out.println("This credit card number is valid.\n");
                    else
                        System.out.println("This credit card number is invalid.\n");
                }
                else
                    System.out.println("This credit card number is invalid (must have exactly 16 digits).\n");
            }
        }
        else // Interactive mode begins
        {
            Scanner scanner = new Scanner(System.in);
            String userInput;
            boolean exit = false;

            // We display the first prompt in interactive mode
            System.out.println("Please enter a credit card number or 'q' to quit:");

            do
            {
                if (scanner.hasNextLine())
                {
                    userInput = scanner.nextLine();

                    if (!userInput.equals("q"))
                    {
                        String cardNumber = removeWhiteSpacesFromString(userInput);

                        if (cardNumber.matches("[0-9]{16}")) // A potentially valid credit card number must have 16 digits
                        {
                            if (performCreditCardCheck(cardNumber))
                                System.out.println("This credit card number is valid.\n");
                            else
                                System.out.println("This credit card number is invalid.\n");
                        }
                        else
                            System.out.println("This credit card number is invalid (must have exactly 16 digits).\n");

                        // We display n prompt (n > 1) in interactive mode
                        System.out.println("Please enter another credit card number or 'q' to quit:");
                    }
                    else
                        exit = true;
                }
            } while (!exit);
        } // Interactive mode ends
    }
}
