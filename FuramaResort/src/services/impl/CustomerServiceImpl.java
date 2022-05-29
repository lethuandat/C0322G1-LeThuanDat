package services.impl;

import models.Customer;
import services.CustomerService;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMER_FILE_PATH = "src\\data\\customer.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new LinkedList<>();
    private static List<String[]> list = new ArrayList<>();
    private static int choice;

    @Override
    public void display() {
        list = ReadAndWrite.readTextFile(CUSTOMER_FILE_PATH);
        customerList.clear();
        for (String[] value : list) {
            Customer customer = new Customer(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8]);
            customerList.add(customer);
        }
        System.out.println("List customers: ");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("List customers: " + customerList.size() + " person.");
    }

    @Override
    public void addNewCustomer() {
        list = ReadAndWrite.readTextFile(CUSTOMER_FILE_PATH);
        customerList.clear();
        for (String[] value : list) {
            Customer customer = new Customer(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8]);
            customerList.add(customer);
        }

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

        Customer customer = new Customer(name, age, gender, identity, phoneNumber, email, (list.size() + 1), customerType, address);
        customerList.add(customer);
        String line = "";
        for (int i = 0; i < customerList.size(); i++) {
            if (i == (customerList.size() - 1)) {
                line += customerList.get(i).getName() + "," +
                        customerList.get(i).getAge() + "," +
                        customerList.get(i).isGender() + "," +
                        customerList.get(i).getIdentity() + "," +
                        customerList.get(i).getPhoneNumber() + "," +
                        customerList.get(i).getEmail() + "," +
                        customerList.get(i).getCustomerID() + "," +
                        customerList.get(i).getCustomerType() + "," +
                        customerList.get(i).getAddress();
            } else {
                line += customerList.get(i).getName() + "," +
                        customerList.get(i).getAge() + "," +
                        customerList.get(i).isGender() + "," +
                        customerList.get(i).getIdentity() + "," +
                        customerList.get(i).getPhoneNumber() + "," +
                        customerList.get(i).getEmail() + "," +
                        customerList.get(i).getCustomerID() + "," +
                        customerList.get(i).getCustomerType() + "," +
                        customerList.get(i).getAddress() + "\n";
            }
        }
        ReadAndWrite.writeTextFile(CUSTOMER_FILE_PATH, line);
        System.out.println("Add successful!");
    }

    @Override
    public void editCustomer() {
        list = ReadAndWrite.readTextFile(CUSTOMER_FILE_PATH);
        customerList.clear();
        for (String[] value : list) {
            Customer customer = new Customer(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8]);
            customerList.add(customer);
        }

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

            String line = "";
            for (int i = 0; i < customerList.size(); i++) {
                if (i == (customerList.size() - 1)) {
                    line += customerList.get(i).getName() + "," +
                            customerList.get(i).getAge() + "," +
                            customerList.get(i).isGender() + "," +
                            customerList.get(i).getIdentity() + "," +
                            customerList.get(i).getPhoneNumber() + "," +
                            customerList.get(i).getEmail() + "," +
                            customerList.get(i).getCustomerID() + "," +
                            customerList.get(i).getCustomerType() + "," +
                            customerList.get(i).getAddress();
                } else {
                    line += customerList.get(i).getName() + "," +
                            customerList.get(i).getAge() + "," +
                            customerList.get(i).isGender() + "," +
                            customerList.get(i).getIdentity() + "," +
                            customerList.get(i).getPhoneNumber() + "," +
                            customerList.get(i).getEmail() + "," +
                            customerList.get(i).getCustomerID() + "," +
                            customerList.get(i).getCustomerType() + "," +
                            customerList.get(i).getAddress() + "\n";
                }
            }
            ReadAndWrite.writeTextFile(CUSTOMER_FILE_PATH, line);
            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
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
                    System.out.println("This option is not available.");
                    addCustomerType();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
            addCustomerType();
        }
        return null;
    }
}