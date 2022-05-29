package utils;

import models.Booking;

import java.util.Comparator;

public class BookingComparatorID implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getBookingID() > o2.getBookingID()) {
            return 1;
        } else if (o1.getBookingID() < o2.getBookingID()) {
            return -1;
        } else {
            return 0;
        }
    }
}
