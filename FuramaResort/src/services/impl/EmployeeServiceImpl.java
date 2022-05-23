package services.impl;

import models.Employee;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static int choice;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        Employee employee1 = new Employee("Nguyễn Văn Long", 30, true, 208349834, 986782374, "long@gmail.com", 1, "University", "Manager", 40000000);
        Employee employee2 = new Employee("Nguyễn Thị Linh", 29, false, 19343234, 904938424, "ntlinh@gmail.com", 2, "University", "Supervisor", 30000000);
        Employee employee3 = new Employee("Trần Văn Hùng", 31, true, 208779834, 902732445, "hungtv@gmail.com", 3, "University", "Expert", 20000000);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println("List employees: " + Employee.countEmployee + " person.");
    }

    @Override
    public void add() {
        System.out.println("-----Add new employee:");
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


        Employee employee = new Employee(name, age, gender, identity, phoneNumber, email, Employee.countEmployee + 1, level, rank, salary);
        employeeList.add(employee);
        System.out.println("Add successful!");
    }

    @Override
    public void edit() {
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

            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    @Override
    public void remove() {

    }

    public String addEmployeeLevel() {
        System.out.println("-----Level-----");
        System.out.println("\t1. Intermediate");
        System.out.println("\t2. Colleges");
        System.out.println("\t3. University");
        System.out.println("\t4. After University");
        System.out.println("Enter your level, please!");

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                return "Intermediate";
            case 2:
                return "Colleges";
            case 3:
                return "University";
            case 4:
                return "After University";
            default:
                System.out.println("Wrong choice");
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
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        switch (choice) {
            case 1:
                return "Receptionist";
            case 2:
                return "Servants";
            case 3:
                return "Expert";
            case 4:
                return "Supervisor";
            case 5:
                return "Manager";
            case 6:
                return "Director";
            default:
                System.out.println("Wrong choice");
                addEmployeeRank();
        }
        return null;
    }
}
