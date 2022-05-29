package models;

public class Employee extends Person {
    private int employeeID;
    private String level;
    private String rank;
    private double salary;

    public Employee() {
    }

    public Employee(String name,
                    int age,
                    boolean gender,
                    long identity,
                    long phoneNumber,
                    String email,
                    int employeeID,
                    String level,
                    String rank,
                    double salary) {
        super(name, age, gender, identity, phoneNumber, email);
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
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRank() {
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
        return "ID: " + employeeID +
                super.toString() +
                ", level: " + level +
                ", rank: " + rank +
                ", salary: " + salary;
    }
}