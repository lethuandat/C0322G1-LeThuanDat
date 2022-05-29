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
                    System.out.println("This option is not available.");
                    displayMainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
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
                switch (choice) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        employeeService.addNewEmployee();
                        break;
                    case 3:
                        employeeService.editEmployee();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        displayEmployeeMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
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
                switch (choice) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        customerService.addNewCustomer();
                        break;
                    case 3:
                        customerService.editCustomer();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        displayCustomerMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
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
                switch (choice) {
                    case 1:
                        facilityService.display();
                        break;
                    case 2:
                        facilityService.addNewFacility();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        displayFacilityMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
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
                switch (choice) {
                    case 1:
                        bookingService.addNewBooking();
                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        contractService.createNewContract();
                        break;
                    case 4:
                        contractService.display();
                        break;
                    case 5:
                        contractService.editContract();
                        break;
                    case 6:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        displayBookingMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
            }
        } while (true);
    }

    public static void displayPromotionMenu() {
        PromotionService promotionService = new PromotionServiceImpl();

        do {
            System.out.println("5.\tPromotion Management SubMenu");
            System.out.println("\t1.\tDisplay list customers use service");
            System.out.println("\t2.\tDisplay list customers get voucher");
            System.out.println("\t3.\tReturn main menu");

            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        promotionService.displayCustomerUseService();
                        break;
                    case 2:
                        promotionService.displayCustomerGetVoucher();
                        break;
                    case 3:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println("This option is not available.");
                        displayPromotionMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Cannot enter the character.");
            }
        } while (true);
    }
}