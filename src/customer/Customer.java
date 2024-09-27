package customer;

/*
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

    public Customer(int id, String fName, String lName, String mName, String address, String creditCard, double balance) {
        this.id = id;
        this.lName = fName;
        this.fName = lName;
        this.mName = mName;
        this.address = address;
        this.creditCard = creditCard;
        this.balance = balance;
    }

    // getters

    public int getId() {
        return id;
    }
    public String getFname() {
        return fName;
    }
    public String getLname() {
        return lName;
    }
    public String getMname() {
        return mName;
    }
    public String getAddress() {
        return address;
    }
    public String getCreditCard() {
        return creditCard;
    }
    public double getBalance() {
        return balance;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    } // is unnecessary
    public void setF_name(String fName) {
        this.fName = fName;
    }
    public void setL_name(String lName) {
        this.lName = lName;
    }
    public void setM_name(String mName) {
        this.mName = mName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCredit_card(String creditCard) {
        this.creditCard = creditCard;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // method to display information about the customer
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