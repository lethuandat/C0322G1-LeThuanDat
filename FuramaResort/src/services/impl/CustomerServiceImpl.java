package services.impl;

import models.Customer;
import models.Employee;
import services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new LinkedList<>();
    private static int choice;

    static {
        Customer customer1 = new Customer("Nguyễn Thị Hoa", 23, false, 32312332, 91234345, "hoadn@gmail.com", 1, "Gold", "Đà Nẵng");
        Customer customer2 = new Customer("Nguyễn Văn Vĩnh", 22, false, 32388332, 91874345, "vinhpro@gmail.com", 2, "Platinum", "Hà Nội");
        Customer customer3 = new Customer("Nguyễn Thị Hồng", 28, false, 37312332, 91754345, "honghong@gmail.com", 3, "Silver", "Huế");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("List customers: " + Customer.countCustomer + " person.");
    }

    @Override
    public void add() {
        System.out.println("-----Add new customer:");
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter gender:");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter identity:");
        long identity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter phone number:");
        long phoneNumber = Long.parseLong(scanner.nextLine());
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter type:");
        String customerType = addCustomerType();
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, age, gender, identity, phoneNumber, email, Customer.countCustomer + 1, customerType, address);
        customerList.add(customer);
        System.out.println("Add successful!");
    }

    @Override
    public void edit() {
        System.out.println("Enter ID customer want update: ");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        int index = 0;

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID() == idUpdate) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter age:");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter gender:");
            boolean gender = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Enter identity:");
            long identity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter phone number:");
            long phoneNumber = Long.parseLong(scanner.nextLine());
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter type:");
            String customerType = addCustomerType();
            System.out.println("Enter address:");
            String address = scanner.nextLine();

            customerList.get(index).setName(name);
            customerList.get(index).setAge(age);
            customerList.get(index).setGender(gender);
            customerList.get(index).setIdentity(identity);
            customerList.get(index).setPhoneNumber(phoneNumber);
            customerList.get(index).setEmail(email);
            customerList.get(index).setCustomerType(customerType);
            customerList.get(index).setAddress(address);

            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    @Override
    public void remove() {

    }

    public String addCustomerType() {
        System.out.println("-----Type of customer-----");
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.println("Enter your type, please!");

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                return "Diamond";
            case 2:
                return "Platinum";
            case 3:
                return "Gold";
            case 4:
                return "Silver";

            case 5:
                return "Member";
            default:
                System.out.println("Wrong choice");
                addCustomerType();
        }
        return null;
    }
}
