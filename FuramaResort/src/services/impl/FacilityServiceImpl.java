package services.impl;

import models.*;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static int choice;
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        Villa villa1 = new Villa("Đa Phước", 500, 6000000, 20, "Year", "VIP", 150, 4);
        House house1 = new House("Gió Biển", 200, 2000000, 6, "Month", "Medium", 3);
        Room room1 = new Room("Cá chép", 40, 300000, 2, "Day", "wifi và nước lọc");
        facilityIntegerMap.put(house1, 1);
        facilityIntegerMap.put(room1, 1);
        facilityIntegerMap.put(villa1, 2);
    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getKey() + "\nNumber of uses: " + item.getValue());
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void addNewVilla() {
        System.out.println("-----Add new villa:");
        System.out.println("Enter name villa:");
        String nameVilla = scanner.nextLine();
        System.out.println("Enter area:");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rent price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of customer:");
        int maxCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type:");
        String rentType = addRentType();
        System.out.println("Enter standard room:");
        String standardRoom = addStandardRoom();
        System.out.println("Enter pool area:");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter floor of quantity :");
        int floorQuantity = Integer.parseInt(scanner.nextLine());


        Villa villa = new Villa(nameVilla, area, price, maxCustomer, rentType, standardRoom, poolArea, floorQuantity);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Add villa successful!");
    }

    @Override
    public void addNewHouse() {
        System.out.println("-----Add new house:");
        System.out.println("Enter name house:");
        String nameHouse = scanner.nextLine();
        System.out.println("Enter area:");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rent price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of customer:");
        int maxCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type:");
        String rentType = addRentType();
        System.out.println("Enter standard room:");
        String standardRoom = addStandardRoom();
        System.out.println("Enter floor of quantity :");
        int floorQuantity = Integer.parseInt(scanner.nextLine());

        House house = new House(nameHouse, area, price, maxCustomer, rentType, standardRoom, floorQuantity);
        facilityIntegerMap.put(house, 0);
        System.out.println("Add house successful!");
    }

    @Override
    public void addNewRoom() {
        System.out.println("-----Add new room:");
        System.out.println("Enter name room:");
        String nameRoom = scanner.nextLine();
        System.out.println("Enter area:");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter rent price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max of customer:");
        int maxCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rent type:");
        String rentType = addRentType();
        System.out.println("Enter free service with:");
        String freeServiceWith = scanner.nextLine();

        Room room = new Room(nameRoom, area, price, maxCustomer, rentType, freeServiceWith);
        facilityIntegerMap.put(room, 0);
        System.out.println("Add room successful!");
    }

    public String addRentType() {
        System.out.println("-----Type of rent-----");
        System.out.println("1. Year");
        System.out.println("2. Month");
        System.out.println("3. Day");
        System.out.println("4. Hour");
        System.out.println("Enter your choice, please!");

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                return "Year";
            case 2:
                return "Month";
            case 3:
                return "Day";
            case 4:
                return "Hour";
            default:
                System.out.println("Wrong choice");
                addRentType();
        }
        return null;
    }

    public String addStandardRoom() {
        System.out.println("-----Standard room-----");
        System.out.println("1. 5 stars");
        System.out.println("2. 4 stars");
        System.out.println("3. 3 stars");
        System.out.println("Enter your choice, please!");

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                return "5*";
            case 2:
                return "4*";
            case 3:
                return "3*";
            default:
                System.out.println("Wrong choice");
                addStandardRoom();
        }
        return null;
    }
}
