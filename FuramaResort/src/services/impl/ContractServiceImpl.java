package services.impl;

import models.Booking;
import models.Contract;
import services.ContractService;
import utils.BookingComparator;
import utils.ReadAndWrite;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    private static final String CONTRACT_FILE_PATH = "src\\data\\contract.csv";
    private static final String BOOKING_FILE_PATH = "src\\data\\booking.csv";
    private static List<String[]> list = new ArrayList<>();
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    @Override
    public void display() {
        list.clear();
        list = ReadAndWrite.readTextFile(CONTRACT_FILE_PATH);
        contractList.clear();

        for (String[] item : list) {
            Contract contract = new Contract(Integer.parseInt(item[0]),
                    Integer.parseInt(item[1]),
                    Integer.parseInt(item[2]),
                    Double.parseDouble(item[3]),
                    Double.parseDouble(item[4]));
            contractList.add(contract);
        }

        System.out.println("Lists of contract: ");
        for (Contract contract : contractList) {
            System.out.println(contract);
        }

        System.out.println("Number: " + contractList.size() + " contract.");
    }

    @Override
    public void createNewContract() {
        list.clear();
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

        Queue<Booking> bookingQueue = new LinkedList<>(bookingSet);
        while (!bookingQueue.isEmpty()) {
            assert bookingQueue.peek() != null;
            int bookingID = bookingQueue.peek().getBookingID();
            assert bookingQueue.peek() != null;
            int customerID = bookingQueue.peek().getCustomerID();

            System.out.println("Create contract for booking: " + bookingQueue.poll());

            System.out.println("Enter deposit money:");
            double deposit = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter total money:");
            double totalMoney = Double.parseDouble(scanner.nextLine());

            Contract contract = new Contract(contractList.size() + 1, bookingID, customerID, deposit, totalMoney);
            contractList.add(contract);
            String line = "";

            for (Contract value : contractList) {
                line += value.getInfo();
            }

            ReadAndWrite.writeTextFile(CONTRACT_FILE_PATH, line);
            System.out.println("Create contract successful!");
        }
    }

    @Override
    public void editContract() {
        list.clear();
        list = ReadAndWrite.readTextFile(CONTRACT_FILE_PATH);
        contractList.clear();

        for (String[] item : list) {
            Contract contract = new Contract(Integer.parseInt(item[0]),
                    Integer.parseInt(item[1]),
                    Integer.parseInt(item[2]),
                    Double.parseDouble(item[3]),
                    Double.parseDouble(item[4]));
            contractList.add(contract);
        }

        System.out.println("Enter ID contract want to edit: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean check = false;
        int index = 0;

        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getContractID() == id) {
                check = true;
                index = i;
                break;
            }
        }

        if (check) {
            System.out.println("Enter deposit money:");
            double deposit = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter total money:");
            double totalMoney = Double.parseDouble(scanner.nextLine());

            contractList.get(index).setDeposit(deposit);
            contractList.get(index).setTotalMoney(totalMoney);

            String line = "";
            for (Contract value : contractList) {
               line += value.getInfo();
            }
            ReadAndWrite.writeTextFile(CONTRACT_FILE_PATH, line);
            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
    }
}
