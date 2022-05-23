package services.impl;

import models.Booking;
import models.Contract;
import services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
        System.out.println("List contracts: " + Contract.countContract + " contract.");
    }

    @Override
    public void add() {
        Set<Booking> bookingSet = new BookingServiceImpl().getBookingSet();
        Queue<Booking> bookingQueue = new LinkedList<>(bookingSet);

        while (!bookingQueue.isEmpty()) {
            assert bookingQueue.peek() != null;
            int booking = bookingQueue.peek().getBookingID();
            assert bookingQueue.peek() != null;
            int customerID = bookingQueue.peek().getCustomerID();

            System.out.println("Create contract for booking: " + bookingQueue.poll());

            System.out.println("Enter deposit money:");
            double deposit = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter total money:");
            double totalMoney = Double.parseDouble(scanner.nextLine());

            Contract contract = new Contract(Contract.countContract + 1, booking, customerID, deposit, totalMoney);
            contractList.add(contract);
            System.out.println("Create contract successful!");
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter ID contract want edit: ");
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
            System.out.println("Update successful!");
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    @Override
    public void remove() {

    }
}
