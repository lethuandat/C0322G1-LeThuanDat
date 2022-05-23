package controllers;

import services.*;
import services.impl.*;

import java.util.Scanner;

public class FuramaController {
    public static int choice;
    public static Scanner input = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1.\tEmployee Management");
        System.out.println("2.\tCustomer Management");
        System.out.println("3.\tFacility Management ");
        System.out.println("4.\tBooking Management");
        System.out.println("5.\tPromotion Management");
        System.out.println("6.\tExit");

        System.out.println("Enter your choice: ");
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        switch (choice) {
            case 1:
                displayEmployeeMenu();
                break;
            case 2:
                displayCustomerMenu();
                break;
            case 3:
                displayFacilityMenu();
                break;
            case 4:
                displayBookingMenu();
                break;
            case 5:
                displayPromotionMenu();
                break;
            case 6:
                System.exit(6);
                break;
            default:
                System.out.println("Input wrong");
                displayMainMenu();
        }
    }

    public static void displayEmployeeMenu() {
        EmployeeService employeeService = new EmployeeServiceImpl();

        do {
            System.out.println("1.\tEmployee Management SubMenu");
            System.out.println("\t1.\tDisplay list employees");
            System.out.println("\t2.\tAdd new employee");
            System.out.println("\t3.\tEdit employee");
            System.out.println("\t4.\tReturn main menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Input wrong");
                    displayEmployeeMenu();
            }
        } while (true);
    }

    public static void displayCustomerMenu() {
        CustomerService customerService = new CustomerServiceImpl();
        do {
            System.out.println("2.\tCustomer Management SubMenu");
            System.out.println("\t1.\tDisplay list customers");
            System.out.println("\t2.\tAdd new customer");
            System.out.println("\t3.\tEdit customer");
            System.out.println("\t4.\tReturn main menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Input wrong");
                    displayCustomerMenu();
            }
        } while (true);
    }

    public static void displayFacilityMenu() {
        FacilityService facilityService = new FacilityServiceImpl();

        do {
            System.out.println("3.\tFacility Management SubMenu");
            System.out.println("\t1.\tDisplay list facility");
            System.out.println("\t2.\tAdd new facility");
            System.out.println("\t3.\tDisplay list facility maintenance");
            System.out.println("\t4.\tReturn main menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    addNewFacility();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Input wrong");
                    displayFacilityMenu();
            }
        } while (true);
    }

    public static void addNewFacility() {
        FacilityService facilityService = new FacilityServiceImpl();

        do {
            System.out.println("---Add new facility:");
            System.out.println("\t1.\tAdd new villa");
            System.out.println("\t2.\tAdd new house");
            System.out.println("\t3.\tAdd new room");
            System.out.println("\t4.\tReturn facility menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    facilityService.addNewVilla();
                    break;
                case 2:
                    facilityService.addNewHouse();
                    break;
                case 3:
                    facilityService.addNewRoom();
                    break;
                case 4:
                    displayFacilityMenu();
                    break;
                default:
                    System.out.println("Input wrong");
                    addNewFacility();
            }
        } while (true);
    }

    public static void displayBookingMenu() {
        BookingService bookingService = new BookingServiceImpl();
        ContractService contractService = new ContractServiceImpl();

        do {
            System.out.println("4.\tBooking Managerment SubMenu");
            System.out.println("\t1.\tAdd new booking");
            System.out.println("\t2.\tDisplay list booking");
            System.out.println("\t3.\tCreate new contracts");
            System.out.println("\t4.\tDisplay list contracts");
            System.out.println("\t5.\tEdit contracts");
            System.out.println("\t6.\tReturn main menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
                    bookingService.add();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    contractService.add();
                    break;
                case 4:
                    contractService.display();
                    break;
                case 5:
                    contractService.edit();
                    break;
                case 6:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Input wrong");
                    displayBookingMenu();
            }
        } while (true);

    }

    public static void displayPromotionMenu() {
        System.out.println("5.\tPromotion Management SubMenu");
        System.out.println("\t1.\tDisplay list customers use service");
        System.out.println("\t2.\tDisplay list customers get voucher");
        System.out.println("\t3.\tReturn main menu");

        System.out.println("Enter your choice: ");
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("Input wrong");
                displayPromotionMenu();
        }
    }
}
