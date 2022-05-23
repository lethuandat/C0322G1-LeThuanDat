package models;

public class Booking {
    private int bookingID;
    private String dayStart;
    private String dayEnd;
    private int customerID;
    private String serviceName;
    private String serviceType;
    public static int countBookingID = 0;

    public Booking() {
    }

    public Booking(int bookingID, String dayStart, String dayEnd, int customerID, String serviceName, String serviceType) {
        this.bookingID = bookingID;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        countBookingID++;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "ID:" + bookingID +
                ", dayStart: " + dayStart +
                ", dayEnd: " + dayEnd +
                ", customer ID: " + customerID +
                ", service Name: " + serviceName +
                ", service Type: " + serviceType;
    }
}
