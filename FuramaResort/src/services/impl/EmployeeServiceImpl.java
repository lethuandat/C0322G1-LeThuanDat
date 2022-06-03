package services.impl;

import models.Employee;
import services.EmployeeService;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String EMPLOYEE_FILE_PATH = "src\\data\\employee.csv";
    private static String choice;
    private static final Scanner scanner = new Scanner(System.in);
    private static List<String[]> list = new ArrayList<>();
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void display() {
        list = ReadAndWrite.readTextFile(EMPLOYEE_FILE_PATH);
        employeeList.clear();

        for (String[] value : list) {
            Employee employee = new Employee(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8],
                    Double.parseDouble(value[9]));
            employeeList.add(employee);
        }

        System.out.println("List employees: ");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println("List employees: " + employeeList.size() + " person.");
    }

    @Override
    public void addNewEmployee() {
        list = ReadAndWrite.readTextFile(EMPLOYEE_FILE_PATH);
        employeeList.clear();

        for (String[] value : list) {
            Employee employee = new Employee(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8],
                    Double.parseDouble(value[9]));
            employeeList.add(employee);
        }

        System.out.println("-----Add new employee:");

        int id = 0;
        int max = employeeList.get(0).getEmployeeID();
        if (employeeList.size() == 0) {
            id = 1;
        } else {
            for (int i = 1; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeID() > max) {
                    max = employeeList.get(i).getEmployeeID();
                }
            }
            id = max + 1;
        }

        System.out.println("Enter name employee:");
        String name = scanner.nextLine();

        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter gender:");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Enter identity:");
        long identity = Long.parseLong(scanner.nextLine());

        System.out.println("Enter phone number:");
        long phoneNumber = Long.parseLong(scanner.nextLine());

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter level:");
        String level = addEmployeeLevel();

        System.out.println("Enter rank:");
        String rank = addEmployeeRank();

        System.out.println("Enter salary:");
        double salary = Double.parseDouble(scanner.nextLine());

        Employee employee = new Employee(name, age, gender, identity, phoneNumber, email, id, level, rank, salary);
        employeeList.add(employee);
        String line = "";

        for (int i = 0; i < employeeList.size(); i++) {
            line += employeeList.get(i).getInfo();
        }

        ReadAndWrite.writeTextFile(EMPLOYEE_FILE_PATH, line);
        System.out.println("Add successful!");
    }

    @Override
    public void editEmployee() {
        list = ReadAndWrite.readTextFile(EMPLOYEE_FILE_PATH);
        employeeList.clear();

        for (String[] value : list) {
            Employee employee = new Employee(value[0],
                    Integer.parseInt(value[1]),
                    Boolean.parseBoolean(value[2]),
                    Long.parseLong(value[3]),
                    Long.parseLong(value[4]),
                    value[5],
                    Integer.parseInt(value[6]),
                    value[7],
                    value[8],
                    Double.parseDouble(value[9]));
            employeeList.add(employee);
        }

        System.out.println("Enter ID employee want update: ");
        int idUpdate = Integer.parseInt(scanner.nextLine());

        boolean check = false;
        int index = 0;

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID() == idUpdate) {
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
            long identity = Long.parseLong(scanner.nextLine());

            System.out.println("Enter phone number:");
            long phoneNumber = Long.parseLong(scanner.nextLine());

            System.out.println("Enter email:");
            String email = scanner.nextLine();

            System.out.println("Enter level:");
            String level = addEmployeeLevel();

            System.out.println("Enter rank:");
            String rank = addEmployeeRank();

            System.out.println("Enter salary:");
            double salary = Double.parseDouble(scanner.nextLine());

            employeeList.get(index).setName(name);
            employeeList.get(index).setAge(age);
            employeeList.get(index).setGender(gender);
            employeeList.get(index).setIdentity(identity);
            employeeList.get(index).setPhoneNumber(phoneNumber);
            employeeList.get(index).setEmail(email);
            employeeList.get(index).setLevel(level);
            employeeList.get(index).setRank(rank);
            employeeList.get(index).setSalary(salary);

            String line = "";
            for (int i = 0; i < employeeList.size(); i++) {
                line += employeeList.get(i).getInfo();
            }

            ReadAndWrite.writeTextFile(EMPLOYEE_FILE_PATH, line);
            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public String addEmployeeLevel() {
        System.out.println("-----Level-----");
        System.out.println("\t1. Intermediate");
        System.out.println("\t2. Colleges");
        System.out.println("\t3. University");
        System.out.println("\t4. After University");
        System.out.println("Enter your level, please!");

        try {
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "Intermediate";
                case "2":
                    return "Colleges";
                case "3":
                    return "University";
                case "4":
                    return "After University";
                default:
                    System.out.println("This option is not available.");
                    addEmployeeLevel();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
            addEmployeeLevel();
        }
        return null;
    }

    public String addEmployeeRank() {
        System.out.println("-----Rank-----");
        System.out.println("1. Receptionist");
        System.out.println("2. Servants");
        System.out.println("3. Expert");
        System.out.println("4. Supervisor");
        System.out.println("5. Manager");
        System.out.println("6. Director");
        System.out.println("Enter your rank, please!");

        try {
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return "Receptionist";
                case "2":
                    return "Servants";
                case "3":
                    return "Expert";
                case "4":
                    return "Supervisor";
                case "5":
                    return "Manager";
                case "6":
                    return "Director";
                default:
                    System.out.println("This option is not available.");
                    addEmployeeRank();
            }
        } catch (NumberFormatException e) {
            System.out.println("Cannot enter the character.");
            addEmployeeRank();
        }
        return null;
    }
}
