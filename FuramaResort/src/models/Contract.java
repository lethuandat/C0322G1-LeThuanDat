package models;

public class Contract {
    private int contractID;
    private int bookingID;
    private int customerID;
    private double deposit;
    private double totalMoney;
    public static int countContract = 0;

    public Contract() {
    }

    public Contract(int contractID, int bookingID, int customerID, double deposit, double totalMoney) {
        this.contractID = contractID;
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        countContract++;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Contract ID: " + contractID +
                ", booking ID: " + bookingID +
                ", customer ID: " + customerID +
                ", deposit money: " + deposit +
                ", total money:" + totalMoney;
    }
}
