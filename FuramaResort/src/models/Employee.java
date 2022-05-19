package models;

import java.util.Scanner;

public class Employee extends Person{
    private int employeeID;
    private String level;
    private String rank;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int date, boolean gender, int identity, int phoneNumber, String email, int employeeID, String level, String rank, double salary) {
        super(name, date, gender, identity, phoneNumber, email);
        this.employeeID = employeeID;
        this.level = level;
        this.rank = rank;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLevel() {
        System.out.println("-----Level-----");
        System.out.println("1. Intermediate");
        System.out.println("2. Colleges");
        System.out.println("3. University");
        System.out.println("4. After University");
        System.out.println("Enter your level, please!");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                level = "Intermediate";
                break;
            case 2:
                level = "Colleges";
                break;
            case 3:
                level = "University";
                break;
            case 4:
                level = "After University";
                break;
            default:
                System.out.println("Wrong choice");
                getLevel();
        }
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRank() {
        System.out.println("-----Rank-----");
        System.out.println("1. Receptionist");
        System.out.println("2. Servants");
        System.out.println("3. Expert");
        System.out.println("4. Supervisor");
        System.out.println("5. Manager");
        System.out.println("6. Director");
        System.out.println("Enter your rank, please!");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                rank = "Receptionist";
                break;
            case 2:
                rank = "Servants";
                break;
            case 3:
                rank = "Expert";
                break;
            case 4:
                rank = "Supervisor";
                break;
            case 5:
                rank = "Manager";
                break;
            case 6:
                rank = "Director";
                break;
            default:
                System.out.println("Wrong choice");
                getRank();
        }
        return rank;

    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "employeeID=" + employeeID +
                ", level='" + level + '\'' +
                ", rank='" + rank + '\'' +
                ", salary=" + salary +
                '}';
    }
}
