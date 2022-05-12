package controllers;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Menu");
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");

            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.\tEmployee Management SubMenu");
                    System.out.println("\t1.\tDisplay list employees");
                    System.out.println("\t2.\tAdd new employee");
                    System.out.println("\t3.\tEdit employee");
                    System.out.println("\t4.\tReturn main menu");

                    System.out.println("Enter your choice: ");
                    break;
                case 2:
                    System.out.println("2.\tCustomer Management SubMenu");
                    System.out.println("\t1.\tDisplay list customers");
                    System.out.println("\t2.\tAdd new customer");
                    System.out.println("\t3.\tEdit customer");
                    System.out.println("\t4.\tReturn main menu");

                    System.out.println("Enter your choice: ");
                    break;
                case 3:
                    System.out.println("3.\tFacility Management SubMenu");
                    System.out.println("\t1.\tDisplay list facility");
                    System.out.println("\t2.\tAdd new facility");
                    System.out.println("\t3.\tDisplay list facility maintenance");
                    System.out.println("\t4.\tReturn main menu");

                    System.out.println("Enter your choice: ");
                    break;
                case 4:
                    System.out.println("4.\tBooking Managerment SubMenu");
                    System.out.println("\t1.\tAdd new booking");
                    System.out.println("\t2.\tDisplay list booking");
                    System.out.println("\t3.\tCreate new constracts");
                    System.out.println("\t4.\tDisplay list contracts");
                    System.out.println("\t5.\tEdit contracts");
                    System.out.println("\t6.\tReturn main menu");

                    System.out.println("Enter your choice: ");
                    break;
                case 5:
                    System.out.println("5.\tPromotion Management SubMenu");
                    System.out.println("\t1.\tDisplay list customers use service");
                    System.out.println("\t2.\tDisplay list customers get voucher");
                    System.out.println("\t3.\tReturn main menu");

                    System.out.println("Enter your choice: ");
                    break;
                case 6:
                    System.exit(6);
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
