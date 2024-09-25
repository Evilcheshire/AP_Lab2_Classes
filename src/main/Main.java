package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import customer.Customer;
import utils.InputValidator;

/*
 * Main class of the program, allows the user to search for a specific customer or customers based on such parameters:
 *  - customer's first name
 *  - range of customer's credit card number
 *  - whether the customer is in debt
 *  The program has additional package <i>InputValidator</i> with code that checks whether entered data is correct.
 *  Furthermore, there is also a console menu that allows the user to enter data
 *  and then display the data about the customers according to the selected parameter
 */
public class Main {

    /*
     * Entry point of the program. It provides a menu to interact with customer data
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("\t\t -> Choose an option: ");
            int choice = InputValidator.getValidInt(sc);

            switch (choice) {
                case 1:
                    enterCustomers(customers, sc);
                    break;
                case 2:
                    SearchByName(customers, sc);
                    break;
                case 3:
                    SearchByCardRange(customers, sc);
                    break;
                case 4:
                    SearchByDebt(customers);
                    break;
                case 0:
                    exit = true;
                    System.out.println(" Exiting...");
                    break;
                default:
                    System.out.println(" Invalid choice, please try again.");
                    break;
            }
        }
    }


    public static void displayMenu() {
        System.out.println("\n\t\t\tMenu" +
                "\n\t-> 1. Enter customer information" +
                "\n\t-> 2. Print customers with a specific name" +
                "\n\t-> 3. Print customers by credit card number range" +
                "\n\t-> 4. Print customers with debt" +
                "\n\t-> 0. Exit");
    }

    /*
     * Allows the user to enter information about multiple customers
     */
    public static void enterCustomers(ArrayList<Customer> customers,Scanner sc) {
        System.out.print(" How many customers do you want to enter?\n\t\t -> ");
        int n = InputValidator.getValidInt(sc);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for customer №" + (customers.size() + i + 1));
            System.out.print("\t\tID -> ");
            int id = InputValidator.getValidInt(sc);
            System.out.print("\t\tLast Name -> ");
            String lname = sc.nextLine();
            System.out.print("\t\tFirst Name -> ");
            String fname = sc.nextLine();
            System.out.print("\t\tMiddle Name -> ");
            String mname = sc.nextLine();
            System.out.print("\t\tAddress -> ");
            String address = sc.nextLine();
            System.out.print("\t\tCredit Card Number -> ");
            String creditCard = InputValidator.getValidCardNumber(sc);
            System.out.print("\t\tBalance -> ");
            double balance = InputValidator.getValidDouble(sc);

            customers.add(new Customer(id, lname, fname, mname, address, creditCard, balance));
        }
    }

    /*
     * Searches for customers by their first name
     */
    private static void SearchByName(ArrayList<Customer> customers, Scanner sc) {
        if (customers.isEmpty()) {
            System.out.println(" You have to enter data about customers first.");
            return;
        }
        System.out.print(" Enter the name for search:\n\t\t -> ");
        String name = sc.nextLine();
        printCustomersByName(customers, name);
    }

    /*
     * Searches for customers by their credit card number range
     */
    private static void SearchByCardRange(ArrayList<Customer> customers, Scanner sc) {
        if (customers.isEmpty()) {
            System.out.println(" You have to enter data about customers first.");
            return;
        }
        System.out.print(" Enter the start range of the card number:\n\t\t -> ");
        String start = InputValidator.getValidCardNumber(sc);
        System.out.print(" Enter the end range of the card number:\n\t\t -> ");
        String end = InputValidator.getValidCardNumber(sc);
        printCustomersByCardRange(customers, start, end);
    }

    /*
     * Searches for customers who have debt (negative balance)
     */
    private static void SearchByDebt(ArrayList<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println(" You have to enter data about customers first.");
            return;
        }
        printCustomersByDebt(customers);
    }

    /*
     * Prints customers that match the specified first name
     */
    public static void printCustomersByName(ArrayList<Customer> customers, String name) {
        boolean found = false;
        System.out.println(" Customers with the specified name:");
        for (Customer customer : customers) {
            if (customer != null && customer.getFname().equalsIgnoreCase(name)) {
                System.out.println(customer);
                found = true;
            }
        }
        if (!found)
            System.out.println("\tNo customers found with the given name (" + name + ").");
    }

    /*
     * Prints customers whose credit card numbers fall within the specified range
     */
    public static void printCustomersByCardRange(ArrayList<Customer> customers, String start, String end) {
        BigInteger startCard = new BigInteger(start),
                   endCard = new BigInteger(end);
        boolean found = false;

        if (startCard.compareTo(endCard) > 0) {
            System.out.println(" Invalid range: Start card number must be less than or equal to end card number.");
            return;
        }

        System.out.println(" Customers with card numbers in the range " + start + " - " + end + ":");

        for (Customer customer : customers) {
            if (customer != null) {
                BigInteger customerCard = new BigInteger(customer.getCreditCard());
                if (customerCard.compareTo(startCard) >= 0 && customerCard.compareTo(endCard) <= 0) {
                    System.out.println(customer);
                    found = true;
                }
            }
        }
        if (!found)
            System.out.println("\tNo customers found with card numbers in the specified range.");
    }

    /*
     * Prints customers who have a negative balance (debt)
     */
    public static void printCustomersByDebt(ArrayList<Customer> customers) {
        System.out.println(" Customers with debt:");
        boolean found = false;
        for (Customer customer : customers) {
            if (customer != null && customer.getBalance() < 0) {
                System.out.println(customer);
                found = true;
            }
        }
        if (!found)
            System.out.println("\tNo customers with debt!");
    }
}
