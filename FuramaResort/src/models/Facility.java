package models;

import java.util.Scanner;

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
        System.out.println("-----Type of rent-----");
        System.out.println("1. Year");
        System.out.println("2. Month");
        System.out.println("3. Day");
        System.out.println("4. Hour");
        System.out.println("Enter your choice, please!");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                rentType = "Rent for year";
                break;
            case 2:
                rentType = "Rent for month";
                break;
            case 3:
                rentType = "Rent for day";
                break;
            case 4:
                rentType = "Rent for hour";
                break;
            default:
                System.out.println("Wrong choice");
                getRentType();
        }
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", rentPrice=" + rentPrice +
                ", maxCustomer=" + maxCustomer +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
