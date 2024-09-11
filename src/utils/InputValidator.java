package utils;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Utility class for validating and retrieving user input from a {@link Scanner}.
 * It provides methods for obtaining valid integer, double, and credit card number inputs
 */
public class InputValidator {

    /**
     * Retrieves a valid integer input from the user.
     * Repeatedly prompts the user until a valid integer is provided
     *
     * @param sc The {@link Scanner} object used to read user input
     * @return The valid integer input provided by the user
     */
    public static int getValidInt(Scanner sc) {
        int value;
        while (true) {
            try {
                value = sc.nextInt();
                sc.nextLine(); // clear the buffer
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid integer.\n\t\t -> ");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Retrieves a valid double input from the user.
     * Repeatedly prompts the user until a valid double is provided
     *
     * @param sc The {@link Scanner} object used to read user input
     * @return The valid double input provided by the user
     */
    public static double getValidDouble(Scanner sc) {
        double value;
        while (true) {
            try {
                value = sc.nextDouble();
                sc.nextLine(); // clear the buffer
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number.\n\t\t -> ");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    /**
     * Retrieves a valid credit card number input from the user.
     * The input must be a 16-digit number. If the input does not match this format,
     * the user is repeatedly prompted until a valid number is provided
     *
     * @param sc The {@link Scanner} object used to read user input
     * @return The valid 16-digit credit card number provided by the user
     */
    public static String getValidCardNumber(Scanner sc) {
        String cardNumber;
        while (true) {
            cardNumber = sc.nextLine();
            if (cardNumber.matches("\\d{16}")) {
                return cardNumber;
            } else {
                System.out.print("Invalid input. Please enter a valid 16-digit card number.\n\t\t -> ");
            }
        }
    }
}
