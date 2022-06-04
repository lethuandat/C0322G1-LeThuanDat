package services.impl;

import models.Booking;
import services.PromotionService;
import utils.BookingComparatorID;
import utils.MyException;
import utils.NegativeNumberException;
import utils.ReadAndWrite;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private static final String BOOKING_FILE_PATH = "src\\data\\booking.csv";
    private static List<String[]> list = new ArrayList<>();

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparatorID());
    static Stack<Booking> bookingStack = new Stack<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomerUseService() {
        list = ReadAndWrite.readTextFile(BOOKING_FILE_PATH);
        bookingSet.clear();
        for (String[] item : list) {
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    Integer.parseInt(item[3]),
                    item[4],
                    item[5]);
            bookingSet.add(booking);
        }

        int year = 0;
        boolean check;

        do {
            check = false;
            try {
                System.out.println("Enter year: ");
                year = Integer.parseInt(scanner.nextLine());
                MyException.checkNegativeNumber(year);
            } catch (NegativeNumberException e) {
                check = true;
            }
        } while (check);

        int count = 0;
        System.out.println("Lists of customer in " + year + " :");

        for (Booking booking : bookingSet) {
            String[] arrDayStart = booking.getDayStart().split("/");
            String[] arrDayEnd = booking.getDayEnd().split("/");

            if (year == Integer.parseInt(arrDayStart[2]) || year == Integer.parseInt(arrDayEnd[2])) {
                System.out.println(booking);
                count++;
            }
        }

        System.out.println("Having: " + count + " customer");
    }

    @Override
    public void displayCustomerGetVoucher() {
        int tenPercentVoucher = 0;

        int twentyPercentVoucher = 0;

        int fiftyPercentVoucher = 0;

        boolean check;

        do {
            check = false;
            try {
                System.out.println("Enter number of voucher 10%: ");
                tenPercentVoucher = Integer.parseInt(scanner.nextLine());
                MyException.checkNegativeNumber(tenPercentVoucher);

                System.out.println("Enter number of voucher 20%: ");
                twentyPercentVoucher = Integer.parseInt(scanner.nextLine());
                MyException.checkNegativeNumber(twentyPercentVoucher);

                System.out.println("Enter number of voucher 50%: ");
                fiftyPercentVoucher = Integer.parseInt(scanner.nextLine());
                MyException.checkNegativeNumber(fiftyPercentVoucher);
            } catch (NegativeNumberException e) {
                check = true;
            }
        } while (check);

        int totalVoucher = tenPercentVoucher + twentyPercentVoucher + fiftyPercentVoucher;

        list = ReadAndWrite.readTextFile(BOOKING_FILE_PATH);
        bookingSet.clear();

        for (String[] item : list) {
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    Integer.parseInt(item[3]),
                    item[4],
                    item[5]);
            bookingSet.add(booking);
        }

        bookingStack.clear();
        int i = 1;

        for (Booking booking : bookingSet) {
            if (i <= totalVoucher && i <= bookingSet.size()) {
                bookingStack.push(booking);
            }
            i++;
        }

        while (tenPercentVoucher > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.peek() + ", be received voucher 10%");
            bookingStack.pop();
            tenPercentVoucher--;
        }

        while (twentyPercentVoucher > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.peek() + ", be received voucher 20%");
            bookingStack.pop();
            twentyPercentVoucher--;
        }

        while (fiftyPercentVoucher > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.peek() + ", be received voucher 50%");
            bookingStack.pop();
            fiftyPercentVoucher--;
        }
    }
}
