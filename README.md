# Credit Card Verifier (Luhn’s algorithm)

Credit Card Verifier is a small open-source Java console application written by Clément Campagna to verify if a credit card number appears to be valid or not.\
\
It does not check the credit card number anywhere on the internet but simply applies Luhn’s algorithm to validate or not the credit card number(s) entered by the user.\
\
This application supports arguments parsing and interactive mode.\
\
For security reasons, I do not offer a compiled version of this application, but the whole source code is available on this repository.

### Luhn’s algorithm:

Most cards use an algorithm invented by Hans Peter Luhn, a nice fellow from IBM.\
\
According to Luhn’s algorithm, you can determine if a credit card number is (syntactically) valid as follows:

1. Double every second digit from right to left (start from the second digit from the right). If this “doubling” results in a two-digit number, subtract 9 from it get a single digit.

2. Now add all single digit numbers from step 1.

3. Add all digits in the odd places from right to left in the credit card number (start from the first digit from the right).

4. Sum the results from steps 2 & 3.

5. If the result from step 4 is divisible by 10 (no remainders), the card number is valid; otherwise, it is invalid.

### Development:

Want to contribute? Great, Credit Card Verifier is open-source!\
\
Please feel free to clone this repository, fork it, make changes to the code, submit pull requests, raise issues, and/or email me using the address below for any suggestions, questions or remarks you may have.

### Contact Information:

Author's email adress: clementcampagna+github@gmail.com\
Author's website: https://clementcampagna.com
