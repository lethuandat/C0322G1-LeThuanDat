package models;

import comma.Comma;

public class Booking {
    private int bookingID;
    private String dayStart;
    private String dayEnd;
    private int customerID;
    private String serviceID;
    private String serviceType;

    public Booking() {
    }

    public Booking(int bookingID, String dayStart, String dayEnd, int customerID, String serviceID, String serviceType) {
        this.bookingID = bookingID;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.serviceType = serviceType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceName) {
        this.serviceID = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInfo() {
        return this.bookingID + Comma.COMMA +
                this.dayStart + Comma.COMMA +
                this.dayEnd + Comma.COMMA +
                this.customerID + Comma.COMMA +
                this.serviceID + Comma.COMMA +
                this.serviceType;
    }

    @Override
    public String toString() {
        return "ID:" + bookingID +
                ", dayStart: " + dayStart +
                ", dayEnd: " + dayEnd +
                ", customer ID: " + customerID +
                ", service ID: " + serviceID +
                ", service Type: " + serviceType;
    }
}
