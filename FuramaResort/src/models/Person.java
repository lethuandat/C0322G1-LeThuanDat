package models;

public abstract class Person {
    private String name;
    private int age;
    private boolean gender;
    private long identity;
    private long phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, int age, boolean gender, long identity, long phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.identity = identity;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getIdentity() {
        return identity;
    }

    public void setIdentity(long identity) {
        this.identity = identity;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ", name: " + name +
                ", age: " + age +
                ", gender: " + (gender ? "Nam" : "Nữ") +
                ", identity: " + identity +
                ", phoneNumber: " + phoneNumber +
                ", email: " + email;
    }
}
