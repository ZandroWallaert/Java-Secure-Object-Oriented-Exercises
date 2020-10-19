package data;

import domain.Booking;
import util.Config;
import util.RestoException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializedBookingRepository implements BookingRepository {

    private final File file = new File(Config.getInstance().readSetting(Config.KEY_BOOKINGS_FILE));

    @Override
    public List<Booking> getBookings() {
        return Collections.unmodifiableList(loadBookingsFromFile());
    }

    @Override
    public void addBooking(Booking booking) {
        /* Note: Internally, in this class, we use ArrayList all the way!
         * This is a rare case where we DO care about the implementation:
         * List is not serializable hence we CANNOT write it to file.
         * ArrayList is serializable hence we CAN write it to file.
         *
         * Note, however, how the public method 'getBookings()' returns the List interface
         * and not the concrete type ArrayList! The outside, still does not care about the implementation.
         *
         */
        ArrayList<Booking> bookings = loadBookingsFromFile();
        booking.setId(bookings.size());
        bookings.add(booking);
        saveBookingsToFile(bookings);
    }

    private ArrayList<Booking> loadBookingsFromFile() {
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(file))) {
                @SuppressWarnings("unchecked") // we know it has to an ArrayList
                ArrayList<Booking> res = (ArrayList<Booking>) ois.readObject();
                return res;

            } catch (ClassNotFoundException | IOException ex) {
                Logger.getAnonymousLogger().log(Level.SEVERE, "Could not load existing bookings.", ex);
                throw new RestoException("Could not load existing bookings.");
            }
        } else {
            return new ArrayList<>();
        }
    }

    private void saveBookingsToFile(ArrayList<Booking> bookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file, false))) {
            oos.writeObject(bookings);
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Could not add booking.", ex);
            throw new RestoException("Could not add booking.");
        }
    }

}
