package models;

import java.util.Scanner;

public class Customer extends Person{
    private int customerID;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, int date, boolean gender, int identity, int phoneNumber, String email, int customerID, String customerType, String address) {
        super(name, date, gender, identity, phoneNumber, email);
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
        System.out.println("-----Type of customer-----");
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.println("Enter your type, please!");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                customerType = "Diamond";
                break;
            case 2:
                customerType = "Platinum";
                break;
            case 3:
                customerType = "Gold";
                break;
            case 4:
                customerType = "Silver";
                break;
            case 5:
                customerType = "Member";
                break;
            default:
                System.out.println("Wrong choice");
                getCustomerType();
        }
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
        return "Customer{" + super.toString() +
                "customerID=" + customerID +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
