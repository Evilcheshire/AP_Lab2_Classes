package customer;

/**
 * Represents a customer with personal and financial details.
 * Provides methods to get and set customer attributes
 */
public class Customer {

    private int id;
    private String lName;
    private String fName;
    private String mName;
    private String address;
    private String creditCard;
    private double balance;

    /**
     * Constructs a new Customer with the specified details
     *
     * @param id The unique identifier for the customer
     * @param fName The first name of the customer
     * @param lName The last name of the customer
     * @param mName The middle name of the customer
     * @param address The address of the customer
     * @param creditCard The credit card number of the customer
     * @param balance The balance of the customer
     */
    public Customer(int id, String fName, String lName, String mName, String address, String creditCard, double balance) {
        this.id = id;
        this.lName = fName;
        this.fName = lName;
        this.mName = mName;
        this.address = address;
        this.creditCard = creditCard;
        this.balance = balance;
    }

    /**
     * Returns the unique identifier of the customer
     *
     * @return The customer ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the first name of the customer
     *
     * @return The customer's first name
     */
    public String getFname() {
        return fName;
    }

    /**
     * Returns the last name of the customer
     *
     * @return The customer's last name
     */
    public String getLname() {
        return lName;
    }

    /**
     * Returns the middle name of the customer
     *
     * @return The customer's middle name
     */
    public String getMname() {
        return mName;
    }

    /**
     * Returns the address of the customer
     *
     * @return The customer's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the credit card number of the customer
     *
     * @return The customer's credit card number
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Returns the balance of the customer
     *
     * @return The customer's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * The following methods are not used in the program
     * Sets the unique identifier for the customer
     *
     * @param id The new customer ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the first name of the customer
     *
     * @param fName The new first name
     */
    public void setF_name(String fName) {
        this.fName = fName;
    }

    /**
     * Sets the last name of the customer
     *
     * @param lName The new last name
     */
    public void setL_name(String lName) {
        this.lName = lName;
    }

    /**
     * Sets the middle name of the customer
     *
     * @param mName The new middle name
     */
    public void setM_name(String mName) {
        this.mName = mName;
    }

    /**
     * Sets the address of the customer
     *
     * @param address The new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the credit card number of the customer
     *
     * @param creditCard The new credit card number
     */
    public void setCredit_card(String creditCard) {
        this.creditCard = creditCard;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns a string representation of the customer
     *
     * @return A string representing the customer's details
     */
    public String toString() {
        return " Customer:" +
                "ID:" + id +
                ", Last name: " + lName +
                ", FirstName: " + fName +
                ", MiddleName: " + mName +
                ", Address: " + address +
                ", Credit Card: " + creditCard +
                ", Balance = " + balance +
                ';';
    }
}