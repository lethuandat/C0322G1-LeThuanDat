package services.impl;

import models.Customer;
import services.CustomerService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMER_FILE_PATH = "src\\data\\customer.csv";
    private static final Scanner scanner = new Scanner(System.in);
    public static final String REGEX_TIME = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    private static List<Customer> customerList = new LinkedList<>();
    private static List<String[]> list = new ArrayList<>();
    private static String choice;

    @Override
    public void display() {
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

        System.out.println("List customers: ");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("List customers: " + customerList.size() + " person.");
    }

    @Override
    public void add() {
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

        System.out.println("-----Add new customer:");

        int id = 0;
        int max = customerList.get(0).getCustomerID();

        if (customerList.size() == 0) {
            id = 1;
        } else {
            for (int i = 1; i < customerList.size(); i++) {
                if (customerList.get(i).getCustomerID() > max) {
                    max = customerList.get(i).getCustomerID();
                }
            }
            id = max + 1;
        }

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter age:");
        String age = RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date incorrect.");

        System.out.println("Enter gender:");
        String gender = chooseGender();

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

        Customer customer = new Customer(name, age, gender, identity, phoneNumber, email, id, customerType, address);
        customerList.add(customer);
        String line = "";

        for (int i = 0; i < customerList.size(); i++) {
           line += customerList.get(i).getInfo();
        }

        ReadAndWrite.writeTextFile(CUSTOMER_FILE_PATH, line);
        System.out.println("Add successful!");
    }

    @Override
    public void edit() {
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
            String age = RegexData.regexStr(scanner.nextLine(), REGEX_TIME, "Input date incorrect.");

            System.out.println("Enter gender:");
            String gender = chooseGender();

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
                line += customerList.get(i).getInfo();
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
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "Diamond";
                case "2":
                    return "Platinum";
                case "3":
                    return "Gold";
                case "4":
                    return "Silver";
                case "5":
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

    public String chooseGender() {
        System.out.println("--Gender--");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        System.out.println("Choose your gender:");

        try {
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "Nam";
                case "2":
                    return "Nữ";
                case "3":
                    return "Khác";
                default:
                    System.out.println("This option is not available.");
                    chooseGender();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
            chooseGender();
        }
        return null;
    }
}
