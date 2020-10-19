package data;

import domain.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> getBookings();
    void addBooking(Booking booking);

}
