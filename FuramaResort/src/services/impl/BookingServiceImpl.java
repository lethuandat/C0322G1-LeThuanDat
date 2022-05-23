package services.impl;

import models.*;
import services.BookingService;
import utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new LinkedList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        Customer customer1 = new Customer("Nguyễn Thị Hoa", 23, false, 32312332, 91234345, "hoadn@gmail.com", 1, "Gold", "Đà Nẵng");
        Customer customer2 = new Customer("Nguyễn Văn Vĩnh", 22, false, 32388332, 91874345, "vinhpro@gmail.com", 2, "Platinum", "Hà Nội");
        Customer customer3 = new Customer("Nguyễn Thị Hồng", 28, false, 37312332, 91754345, "honghong@gmail.com", 3, "Silver", "Huế");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        Villa villa1 = new Villa("Đa Phước", 500, 6000000, 20, "Day", "5*", 150, 4);
        House house1 = new House("Gió Biển", 200, 2000000, 6, "Month", "4*", 3);
        Room room1 = new Room("Cá chép", 40, 300000, 2, "Year", "wifi và nước lọc");
        facilityIntegerMap.put(house1, 1);
        facilityIntegerMap.put(room1, 1);
        facilityIntegerMap.put(villa1, 2);
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    @Override
    public void display() {
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
        System.out.println("Number of booking: " + Booking.countBookingID);
    }

    @Override
    public void add() {
        System.out.println("Enter day start:");
        String dayStart = scanner.nextLine();
        System.out.println("Enter day end:");
        String dayEnd = scanner.nextLine();
        int customerID = chooseCustomer();
        String facility = chooseFacility();
        System.out.println("Enter type of service:");
        String typeService = scanner.nextLine();

        Booking booking = new Booking(Booking.countBookingID + 1, dayStart, dayEnd, customerID, facility, typeService);
        bookingSet.add(booking);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    public static int chooseCustomer() {
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
        System.out.println("List facility having:");
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getKey());
        }

        System.out.println("Enter service name facility:");
        String serviceName = scanner.nextLine();

        do {
            for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
                if (item.getKey().getServiceName().equals(serviceName)) {
                    return item.getKey().getServiceName();
                }
            }

            System.out.println("Service name wrong, try again.");
            System.out.println("Enter service name facility:");
            serviceName = scanner.nextLine();
        } while (true);
    }
}
