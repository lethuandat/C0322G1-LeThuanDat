package models;

public abstract class Facility {
    private String serviceName;
    private double area;
    private double rentPrice;
    private int maxCustomer;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceName, double area, double rentPrice, int maxCustomer, String rentType) {
        this.serviceName = serviceName;
        this.area = area;
        this.rentPrice = rentPrice;
        this.maxCustomer = maxCustomer;
        this.rentType = rentType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getMaxCustomer() {
        return maxCustomer;
    }

    public void setMaxCustomer(int maxCustomer) {
        this.maxCustomer = maxCustomer;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return serviceName +
                ", area: " + area +
                ", rent price: " + rentPrice +
                ", max customer:" + maxCustomer +
                ", rentType: " + rentType;
    }
}
