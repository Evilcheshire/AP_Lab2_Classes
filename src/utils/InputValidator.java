package utils;

import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * Utility class for validating and retrieving user input from a {@link Scanner}.
 * It provides methods for obtaining valid integer, double, and credit card number inputs
 */
public class InputValidator {

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

    // card number can only be 16-digit code()
    public static String getValidCardNumber(Scanner sc) {
        String cardNumber;
        while (true) {
            cardNumber = sc.nextLine();
            if (cardNumber.matches("\\d{16}"))
                return cardNumber;
             else
                System.out.print("Invalid input. Please enter a valid 16-digit card number.\n\t\t -> ");
        }
    }
}
