package models;

import comma.Comma;

public class House extends Facility {
    private String standardRoom;
    private int floorQuantity;

    public House() {
    }

    public House(String serviceID, String serviceName, double area, double rentPrice, int maxCustomer, String rentType, String standardRoom, int floorQuantity) {
        super(serviceID, serviceName, area, rentPrice, maxCustomer, rentType);
        this.standardRoom = standardRoom;
        this.floorQuantity = floorQuantity;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getFloorQuantity() {
        return floorQuantity;
    }

    public void setFloorQuantity(int floorQuantity) {
        this.floorQuantity = floorQuantity;
    }

    @Override
    public String toString() {
        return "House " + super.toString() +
                ", standard room:" + standardRoom +
                ", floor of quantity:" + floorQuantity;
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
                this.getFloorQuantity() + "\n";
    }
}
