package models;

public abstract class Person {
    private String name;
    private String age;
    private String gender;
    private long identity;
    private long phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String age, String gender, long identity, long phoneNumber, String email) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public abstract String getInfo();

    @Override
    public String toString() {
        return ", name: " + name +
                ", age: " + age +
                ", gender: " + gender +
                ", identity: " + identity +
                ", phoneNumber: " + phoneNumber +
                ", email: " + email;
    }
}
