package data;

public class Repositories {

    private static final RestaurantRepository RESTAURANT_REPOSITORY
            = new MySqlRestaurantRepository();
    private static final BookingRepository BOOKING_REPOSITORY
            = new SerializedBookingRepository();
    private static final UserRepository USER_REPOSITORY
            = new MySqlUserRepository();

    private Repositories() {
    }

    public static RestaurantRepository getRestaurantRepository() {
        return RESTAURANT_REPOSITORY;
    }

    public static BookingRepository getBookingRepository() {
        return BOOKING_REPOSITORY;
    }

    public static UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }

}
