package models;

import comma.Comma;

public class Villa extends Facility {
    private String standardRoom;
    private double poolArea;
    private int floorQuantity;

    public Villa() {
    }

    public Villa(String serviceID, String serviceName, double area, double rentPrice, int maxCustomer, String rentType, String standardRoom, double poolArea, int floorQuantity) {
        super(serviceID, serviceName, area, rentPrice, maxCustomer, rentType);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.floorQuantity = floorQuantity;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorQuantity() {
        return floorQuantity;
    }

    public void setFloorQuantity(int floorQuantity) {
        this.floorQuantity = floorQuantity;
    }

    @Override
    public String toString() {
        return "Villa " + super.toString() +
                ", standard room: " + standardRoom +
                ", area pool: " + poolArea +
                ", floor of quantity: " + floorQuantity;
    }

    @Override
    public String getInfo() {
        return super.getServiceID() + Comma.COMMA +
                super.getServiceName() + Comma.COMMA +
                super.getArea() + Comma.COMMA +
                super.getRentPrice() + Comma.COMMA +
                super.getMaxCustomer() + Comma.COMMA +
                super.getRentType() + Comma.COMMA +
                this.getStandardRoom() + Comma.COMMA +
                this.getPoolArea() + Comma.COMMA +
                this.getFloorQuantity();
    }
}
