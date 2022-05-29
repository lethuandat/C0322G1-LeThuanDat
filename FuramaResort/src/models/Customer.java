package models;

public class Customer extends Person {
    private int customerID;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, int age, boolean gender, long identity, long phoneNumber, String email, int customerID, String customerType, String address) {
        super(name, age, gender, identity, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID:" + customerID +
                super.toString() +
                ", Type:" + customerType +
                ", address: " + address;
    }
}
