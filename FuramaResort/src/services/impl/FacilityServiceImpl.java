package services.impl;

import controllers.FuramaController;
import models.*;
import services.FacilityService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_ID_VILLA = "(SVVL)[-]\\d{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-]\\d{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-]\\d{4}";
    public static final String REGEX_SERVICE_NAME = "[A-Z][a-z]+";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2})$";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_FLOOR = "^[1-9]|([1][0-9])$";
    public static final String REGEX_PRICE = "^[1-9]|([1-9][0-9])|([1-9][0-9][0-9])|([1-9][0-9][0-9][0-9])|([1-9][0-9][0-9][0-9][0-9])$";

    private static List<String[]> list = new ArrayList<>();

    private static final String VILLA_FILE_PATH = "src\\data\\villa.csv";
    private static final String HOUSE_FILE_PATH = "src\\data\\house.csv";
    private static final String ROOM_FILE_PATH = "src\\data\\room.csv";

    private static String choice;
    private static final Scanner scanner = new Scanner(System.in);

    public static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
    public static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    public static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();


    @Override
    public void display() {
        villaIntegerMap.clear();
        list = ReadAndWrite.readTextFile(VILLA_FILE_PATH);

        for (String[] value : list) {
            Villa villa = new Villa(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Double.parseDouble(value[7]),
                    Integer.parseInt(value[8]));
            int numUser = Integer.parseInt(value[9]);
            villaIntegerMap.put(villa, numUser);
        }

        list.clear();
        houseIntegerMap.clear();
        list = ReadAndWrite.readTextFile(HOUSE_FILE_PATH);

        for (String[] value : list) {
            House house = new House(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Integer.parseInt(value[7]));
            int numUser = Integer.parseInt(value[8]);
            houseIntegerMap.put(house, numUser);
        }

        list.clear();
        roomIntegerMap.clear();
        list = ReadAndWrite.readTextFile(ROOM_FILE_PATH);

        for (String[] value : list) {
            Room room = new Room(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6]);
            int numUser = Integer.parseInt(value[7]);
            roomIntegerMap.put(room, numUser);
        }

        System.out.println("List facility: ");
        for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", Numbers of used: " + entry.getValue());
        }

        for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", Numbers of used: " + entry.getValue());
        }

        for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", Numbers of used: " + entry.getValue());
        }
    }

    @Override
    public void add() {
        do {
            System.out.println("---Add new facility:");
            System.out.println("\t1.\tAdd new villa");
            System.out.println("\t2.\tAdd new house");
            System.out.println("\t3.\tAdd new room");
            System.out.println("\t4.\tReturn facility menu");

            System.out.println("Enter your choice: ");
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        addVilla();
                        break;
                    case "2":
                        addHouse();
                        break;
                    case "3":
                        addRoom();
                        break;
                    case "4":
                        FuramaController.displayFacilityMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        add();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
            }

        } while (true);
    }

    @Override
    public void addVilla() {
        villaIntegerMap.clear();
        list.clear();
        list = ReadAndWrite.readTextFile(VILLA_FILE_PATH);

        for (String[] value : list) {
            Villa villa = new Villa(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Double.parseDouble(value[7]),
                    Integer.parseInt(value[8]));
            int numUser = Integer.parseInt(value[9]);
            villaIntegerMap.put(villa, numUser);
        }
        System.out.println("-----Add new villa:");

        String villaID = inputVillaID();

        String nameVilla = inputServiceName();

        double area = Double.parseDouble(inputArea());

        double price = Double.parseDouble(inputRentPrice());

        int maxCustomer = Integer.parseInt(inputNumberCustomer());

        System.out.println("Enter rent type:");
        String rentType = addRentType();

        System.out.println("Enter standard room:");
        String standardRoom = addStandardRoom();

        double poolArea = Double.parseDouble(inputPoolArea());
        int floorQuantity = Integer.parseInt(inputFloor());

        Villa villa = new Villa(villaID, nameVilla, area, price, maxCustomer, rentType, standardRoom, poolArea, floorQuantity);
        villaIntegerMap.put(villa, 0);

        String line = "";
        for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "\n";
        }

        ReadAndWrite.writeTextFile(VILLA_FILE_PATH, line);
        System.out.println("Add villa successful!");
    }

    private String inputVillaID() {
        System.out.println("Enter ID villa:");
        return RegexData.regexVillaID(scanner.nextLine(), REGEX_ID_VILLA);
    }

    private String inputHouseID() {
        System.out.println("Enter ID house:");
        return RegexData.regexHouseID(scanner.nextLine(), REGEX_ID_HOUSE);
    }

    private String inputRoomID() {
        System.out.println("Enter ID room:");
        return RegexData.regexRoomID(scanner.nextLine(), REGEX_ID_ROOM);
    }

    private String inputServiceName() {
        System.out.println("Enter name:");
        return RegexData.regexUpperCaseFirstLetter(scanner.nextLine(), REGEX_SERVICE_NAME);
    }

    private String inputArea() {
        System.out.println("Enter area:");
        return RegexData.regexArea(scanner.nextLine(), REGEX_AREA);
    }

    private String inputRentPrice() {
        System.out.println("Enter rent price:");
        return RegexData.regexRentPrice(scanner.nextLine(), REGEX_PRICE);
    }

    private String inputNumberCustomer() {
        System.out.println("Enter max of customer:");
        return RegexData.regexNumberCustomer(scanner.nextLine(), REGEX_AMOUNT);
    }

    private String inputPoolArea() {
        System.out.println("Enter pool area:");
        return RegexData.regexPoolArea(scanner.nextLine(), REGEX_AREA);
    }

    private String inputFloor() {
        System.out.println("Enter number of floor:");
        return RegexData.regexFloor(scanner.nextLine(), REGEX_FLOOR);
    }

    @Override
    public void addHouse() {
        houseIntegerMap.clear();
        list.clear();
        list = ReadAndWrite.readTextFile(HOUSE_FILE_PATH);

        for (String[] value : list) {
            House house = new House(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Integer.parseInt(value[7]));
            int numUser = Integer.parseInt(value[8]);
            houseIntegerMap.put(house, numUser);
        }
        System.out.println("-----Add new house:");

        String houseID = inputHouseID();

        String nameHouse = inputServiceName();

        double area = Double.parseDouble(inputArea());

        double price = Double.parseDouble(inputRentPrice());

        int maxCustomer = Integer.parseInt(inputNumberCustomer());

        System.out.println("Enter rent type:");
        String rentType = addRentType();

        System.out.println("Enter standard room:");
        String standardRoom = addStandardRoom();

        int floorQuantity = Integer.parseInt(inputFloor());

        House house = new House(houseID, nameHouse, area, price, maxCustomer, rentType, standardRoom, floorQuantity);
        houseIntegerMap.put(house, 0);
        String line = "";

        for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "\n";
        }
        ReadAndWrite.writeTextFile(HOUSE_FILE_PATH, line);
        System.out.println("Add house successful!");
    }

    @Override
    public void addRoom() {
        roomIntegerMap.clear();
        list.clear();
        list = ReadAndWrite.readTextFile(ROOM_FILE_PATH);

        for (String[] value : list) {
            Room room = new Room(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6]);
            int numUser = Integer.parseInt(value[7]);
            roomIntegerMap.put(room, numUser);
        }

        System.out.println("-----Add new room:");

        String roomID = inputRoomID();

        String nameRoom = inputServiceName();

        double area = Double.parseDouble(inputArea());

        double price = Double.parseDouble(inputRentPrice());

        int maxCustomer = Integer.parseInt(inputNumberCustomer());

        System.out.println("Enter rent type:");
        String rentType = addRentType();

        System.out.println("Enter free service with:");
        String freeServiceWith = scanner.nextLine();

        Room room = new Room(roomID, nameRoom, area, price, maxCustomer, rentType, freeServiceWith);
        roomIntegerMap.put(room, 0);
        String line = "";

        for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "\n";
        }
        ReadAndWrite.writeTextFile(ROOM_FILE_PATH, line);
        System.out.println("Add room successful!");
    }

    @Override
    public void displayFacilityMaintenance() {
        villaIntegerMap.clear();
        list = ReadAndWrite.readTextFile(VILLA_FILE_PATH);

        for (String[] value : list) {
            Villa villa = new Villa(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Double.parseDouble(value[7]),
                    Integer.parseInt(value[8]));
            int numUser = Integer.parseInt(value[9]);
            villaIntegerMap.put(villa, numUser);
        }

        list.clear();
        houseIntegerMap.clear();
        list = ReadAndWrite.readTextFile(HOUSE_FILE_PATH);

        for (String[] value : list) {
            House house = new House(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6],
                    Integer.parseInt(value[7]));
            int numUser = Integer.parseInt(value[8]);
            houseIntegerMap.put(house, numUser);
        }

        list.clear();
        roomIntegerMap.clear();
        list = ReadAndWrite.readTextFile(ROOM_FILE_PATH);

        for (String[] value : list) {
            Room room = new Room(value[0],
                    value[1],
                    Double.parseDouble(value[2]),
                    Double.parseDouble(value[3]),
                    Integer.parseInt(value[4]),
                    value[5],
                    value[6]);
            int numUser = Integer.parseInt(value[7]);
            roomIntegerMap.put(room, numUser);
        }

        list.clear();

        System.out.println("List facility maintaince: ");

        for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", number of used: " + entry.getValue());
            }
        }

        for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", number of used: " + entry.getValue());
            }
        }

        for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", number of used: " + entry.getValue());
            }
        }
    }

    public String addRentType() {
        do {
            System.out.println("-----Type of rent-----");
            System.out.println("1. Year");
            System.out.println("2. Month");
            System.out.println("3. Day");
            System.out.println("4. Hour");
            System.out.println("Enter your choice, please!");

            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        return "Year";
                    case "2":
                        return "Month";
                    case "3":
                        return "Day";
                    case "4":
                        return "Hour";
                    default:
                        System.out.println("This option is not available.");
                        addRentType();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
            }
        } while (true);
    }

    public String addStandardRoom() {
        System.out.println("-----Standard room-----");
        System.out.println("1. 5 stars");
        System.out.println("2. 4 stars");
        System.out.println("3. 3 stars");
        System.out.println("Enter your choice, please!");

        try {
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "Five stars";
                case "2":
                    return "Four stars";
                case "3":
                    return "Three stars";
                default:
                    System.out.println("This option is not available.");
                    addStandardRoom();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
            addStandardRoom();
        }
        return null;
    }
}
