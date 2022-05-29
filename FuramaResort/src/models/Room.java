package models;

public class Room extends Facility {
    private String freeServiceWith;

    public Room() {
    }

    public Room(String serviceID, String serviceName, double area, double rentPrice, int maxCustomer, String rentType, String freeServiceWith) {
        super(serviceID, serviceName, area, rentPrice, maxCustomer, rentType);
        this.freeServiceWith = freeServiceWith;
    }

    public String getFreeServiceWith() {
        return freeServiceWith;
    }

    public void setFreeServiceWith(String freeServiceWith) {
        this.freeServiceWith = freeServiceWith;
    }

    @Override
    public String toString() {
        return "Room " + super.toString() +
                ", free service: " + freeServiceWith;
    }
}