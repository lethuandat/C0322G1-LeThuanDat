package models;

public class House extends Facility {
    private String standardRoom;
    private int floorQuantity;

    public House() {
    }

    public House(String serviceName, double area, double rentPrice, int maxCustomer, String rentType, String standardRoom, int floorQuantity) {
        super(serviceName, area, rentPrice, maxCustomer, rentType);
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
}
