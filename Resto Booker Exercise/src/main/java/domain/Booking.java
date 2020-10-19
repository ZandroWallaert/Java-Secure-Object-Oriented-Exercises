package domain;

import java.io.Serializable;

public class Booking implements Serializable {

    private static final int UNSET_ID = 0;
    private int id;

    // Only the id can change, hence all other can be final.
    private final String datetime;
    private final String name;
    private final Restaurant restaurant;
    private final int numPersons;

    private Booking(int id, String datetime, String name, Restaurant restaurant, int numPersons) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.restaurant = restaurant;
        this.numPersons = numPersons;
    }

    Booking(String datetime, String name, Restaurant restaurant, int numPersons) {
        this(UNSET_ID, datetime, name, restaurant, numPersons);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getName() {
        return name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getNumPersons() {
        return numPersons;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %d persons - %s",
                restaurant.toString(),
                name, numPersons, datetime);
    }
}
