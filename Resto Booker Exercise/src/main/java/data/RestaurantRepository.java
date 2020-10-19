package data;

import domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> getRestaurants();
    Restaurant getRestaurant(int id);

}
