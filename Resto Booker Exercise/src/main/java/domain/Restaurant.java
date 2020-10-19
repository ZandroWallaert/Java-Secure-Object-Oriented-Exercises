package domain;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private final int id;
    private final String name;
    private final int rating;

    public Restaurant(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        String stars = "*".repeat(rating);
        return String.format("%s (%s)", name, stars);
    }

    // Factory method
    public Booking makeBooking(String dateAndTime, String clientLogin, int numPersons) {
        return new Booking(dateAndTime, clientLogin,
                this, numPersons);
    }
}
