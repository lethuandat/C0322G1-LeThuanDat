package services.impl;

import models.*;
import services.BookingService;
import utils.BookingComparator;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final String BOOKING_FILE_PATH = "src\\data\\booking.csv";
    private static final String CUSTOMER_FILE_PATH = "src\\data\\customer.csv";
    private static final String VILLA_FILE_PATH = "src\\data\\villa.csv";
    private static final String HOUSE_FILE_PATH = "src\\data\\house.csv";
    private static final String ROOM_FILE_PATH = "src\\data\\room.csv";

    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    private static List<String[]> list = new ArrayList<>();
    static List<Customer> customerList = new LinkedList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
    private static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    private static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();

    @Override
    public void display() {
        list = ReadAndWrite.readTextFile(BOOKING_FILE_PATH);
        bookingSet.clear();

        for (String[] item : list) {
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    Integer.parseInt(item[3]),
                    item[4],
                    item[5]);
            bookingSet.add(booking);
        }

        System.out.println("Lists of booking: ");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
        System.out.println("Number of booking: " + bookingSet.size());
    }

    @Override
    public void add() {
        list = ReadAndWrite.readTextFile(BOOKING_FILE_PATH);
        bookingSet.clear();

        for (String[] item : list) {
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    Integer.parseInt(item[3]),
                    item[4],
                    item[5]);
            bookingSet.add(booking);
        }

        int id = 0;
        int max = 0;
        if (bookingSet.size() == 0) {
            id = 1;
        } else {
            for (Booking booking : bookingSet) {
                if (booking.getBookingID() > max) {
                    max = booking.getBookingID();
                }
            }
            id = max + 1;
        }

        System.out.println("Enter day start:");
        String dayStart = RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date incorrect.");

        System.out.println("Enter day end:");
        String dayEnd = RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date incorrect.");

        int customerID = chooseCustomer();

        String facilityID = chooseFacility();

        list.clear();
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
            int numUsed = Integer.parseInt(value[9]);
            villaIntegerMap.put(villa, numUsed);
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
            int numUsed = Integer.parseInt(value[8]);
            houseIntegerMap.put(house, numUsed);
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
            int numUsed = Integer.parseInt(value[7]);
            roomIntegerMap.put(room, numUsed);
        }

        list.clear();

        for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
            if (entry.getKey().getServiceID().equals(facilityID)) {
                entry.setValue(entry.getValue() + 1);
            }
        }

        String line = "";

        for (Map.Entry<Villa, Integer> entry : villaIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "," + entry.getValue() + "\n";
        }

        ReadAndWrite.writeTextFile(VILLA_FILE_PATH, line);

        for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
            if (entry.getKey().getServiceID().equals(facilityID)) {
                entry.setValue(entry.getValue() + 1);
            }
        }

        line = "";

        for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "," + entry.getValue() + "\n";
        }

        ReadAndWrite.writeTextFile(HOUSE_FILE_PATH, line);

        for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
            if (entry.getKey().getServiceID().equals(facilityID)) {
                entry.setValue(entry.getValue() + 1);
            }
        }

        line = "";

        for (Map.Entry<Room, Integer> entry : roomIntegerMap.entrySet()) {
            line += entry.getKey().getInfo() + "," + entry.getValue() + "\n";
        }

        ReadAndWrite.writeTextFile(ROOM_FILE_PATH, line);


        System.out.println("Enter type of service:");
        String typeService = addRentType();

        Booking booking = new Booking(id, dayStart, dayEnd, customerID, facilityID, typeService);
        bookingSet.add(booking);

        line = "";

        for (Booking value : bookingSet) {
            line += value.getInfo() + "\n";
        }

        ReadAndWrite.writeTextFile(BOOKING_FILE_PATH, line);
        System.out.println("Add successful!");
    }

    public static int chooseCustomer() {
        list = ReadAndWrite.readTextFile(CUSTOMER_FILE_PATH);
        customerList.clear();

        for (String[] value : list) {
            Customer customer = new Customer(value[0],
                    value[1],
                    value[2],
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8]);
            customerList.add(customer);
        }

        System.out.println("List customer having:");

        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        System.out.println("Enter ID customer:");
        int id = Integer.parseInt(scanner.nextLine());

        do {
            for (Customer customer : customerList) {
                if (id == customer.getCustomerID()) {
                    return customer.getCustomerID();
                }
            }
            System.out.println("ID wrong, try again.");
            System.out.println("Enter ID customer:");
            id = Integer.parseInt(scanner.nextLine());
        } while (true);
    }

    public static String chooseFacility() {
        list = ReadAndWrite.readTextFile(VILLA_FILE_PATH);
        facilityIntegerMap.clear();

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
            int numUsed = Integer.parseInt(value[9]);
            facilityIntegerMap.put(villa, numUsed);
        }

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
            int numUsed = Integer.parseInt(value[8]);
            facilityIntegerMap.put(house, numUsed);
        }

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
            int numUsed = Integer.parseInt(value[7]);
            facilityIntegerMap.put(room, numUsed);
        }

        list.clear();

        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", Numbers of used: " + entry.getValue());
        }

        System.out.println("Enter service ID facility:");
        String serviceID = scanner.nextLine();

        do {
            for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
                if (item.getKey().getServiceID().equals(serviceID)) {
                    return item.getKey().getServiceID();
                }
            }

            System.out.println("Service ID wrong, try again.");
            System.out.println("Enter service ID facility:");
            serviceID = scanner.nextLine();
        } while (true);
    }

    public String addRentType() {
        do {
            System.out.println("-----Type of rent-----");
            System.out.println("1. Year");
            System.out.println("2. Month");
            System.out.println("3. Day");
            System.out.println("4. Hour");
            System.out.println("Enter your choice, please!");

            String choice = null;
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
}