package controllers;

import java.util.Scanner;

public class FuramaController {
    public static int choice;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1.\tEmployee Management");
        System.out.println("2.\tCustomer Management");
        System.out.println("3.\tFacility Management ");
        System.out.println("4.\tBooking Management");
        System.out.println("5.\tPromotion Management");
        System.out.println("6.\tExit");

        System.out.println("Enter your choice: ");
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
                System.out.println("Input wrong");
                displayMainMenu();
        }
    }

    public static void displayEmployeeMenu() {
        System.out.println("1.\tEmployee Management SubMenu");
        System.out.println("\t1.\tDisplay list employees");
        System.out.println("\t2.\tAdd new employee");
        System.out.println("\t3.\tEdit employee");
        System.out.println("\t4.\tReturn main menu");

        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Input wrong");
                displayEmployeeMenu();
        }
    }

    public static void displayCustomerMenu() {
        System.out.println("2.\tCustomer Management SubMenu");
        System.out.println("\t1.\tDisplay list customers");
        System.out.println("\t2.\tAdd new customer");
        System.out.println("\t3.\tEdit customer");
        System.out.println("\t4.\tReturn main menu");

        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Input wrong");
                displayCustomerMenu();
        }
    }

    public static void displayFacilityMenu() {
        System.out.println("3.\tFacility Management SubMenu");
        System.out.println("\t1.\tDisplay list facility");
        System.out.println("\t2.\tAdd new facility");
        System.out.println("\t3.\tDisplay list facility maintenance");
        System.out.println("\t4.\tReturn main menu");

        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Input wrong");
                displayFacilityMenu();
        }
    }

    public static void displayBookingMenu() {
        System.out.println("4.\tBooking Managerment SubMenu");
        System.out.println("\t1.\tAdd new booking");
        System.out.println("\t2.\tDisplay list booking");
        System.out.println("\t3.\tCreate new constracts");
        System.out.println("\t4.\tDisplay list contracts");
        System.out.println("\t5.\tEdit contracts");
        System.out.println("\t6.\tReturn main menu");

        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                break;
            case 6:
                displayMainMenu();
                break;
            default:
                System.out.println("Input wrong");
                displayBookingMenu();
        }
    }

    public static void displayPromotionMenu() {
        System.out.println("5.\tPromotion Management SubMenu");
        System.out.println("\t1.\tDisplay list customers use service");
        System.out.println("\t2.\tDisplay list customers get voucher");
        System.out.println("\t3.\tReturn main menu");

        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(input.nextLine());
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
