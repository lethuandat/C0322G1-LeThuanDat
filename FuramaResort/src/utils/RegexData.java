package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner input = new Scanner(System.in);

    public static String regexVillaID(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdVillaException("Nhập sai, ID có dạng SVVL-XXXX");
                }
            } catch (InvalidIdVillaException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexHouseID(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdHouseException("Nhập sai, ID có dạng SVHO-XXXX");
                }
            } catch (InvalidIdHouseException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexRoomID(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdRoomException("Nhập sai, ID có dạng SVRO-XXXX");
                }
            } catch (InvalidIdRoomException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexUpperCaseFirstLetter(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidUpperCaseFirstLetterException("Nhập sai, tên phải bắt đầu bằng kí tự viết hoa");
                }
            } catch (InvalidUpperCaseFirstLetterException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexArea(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidAreException("Nhập sai, diện tích phải lớn hơn 30m2");
                }
            } catch (InvalidAreException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexRentPrice(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidRentPriceException("Nhập sai, giá phải là số thực lớn hơn 0");
                }
            } catch (InvalidRentPriceException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexNumberCustomer(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidNumberCustomerException("Nhập sai, số lượng người phải > 0 và < 20");
                }
            } catch (InvalidNumberCustomerException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexPoolArea(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidPoolAreaException("Nhập sai, diện tích phải lớn hơn 30m2");
                }
            } catch (InvalidPoolAreaException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexFloor(String temp, String regex) {
        boolean check = true;
        do {
            check = false;
            temp = input.nextLine();
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidFloorException("Nhập sai, số tầng phải > 0");
                }
            } catch (InvalidFloorException e) {
                System.err.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    //Hàm đọc tổng quát
    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = input.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current > 18 && current < 100) {
                        check = false;
                    } else {
                        throw new AgeException("Age must > 18 and < 100.");
                    }
                } else {
                    throw new AgeException("Incorrect format.");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                temp = input.nextLine();
            }
        }
        return temp;
    }
}
