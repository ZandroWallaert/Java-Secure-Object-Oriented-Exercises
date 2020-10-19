package data;

import data.util.MySqlConnection;
import domain.Restaurant;
import util.RestoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlRestaurantRepository implements RestaurantRepository {

    private static final String SQL_SELECT_ALL_RESTAURANTS = "select * from restaurants";
    private static final String SQL_SELECT_RESTAURANT = "select * from restaurant where id = ?";

    @Override
    public List<Restaurant> getRestaurants() {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL_RESTAURANTS);
             ResultSet rs = stmt.executeQuery()
        ) {
            List<Restaurant> restaurants = new ArrayList<>();

            while (rs.next()) {
                restaurants.add(resultSetToRestaurant(rs));
            }

            return restaurants;
        } catch (SQLException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Unable to get restaurants.", ex);
            throw new RestoException("Unable to get restaurants.");
        }
    }

    @Override
    public Restaurant getRestaurant(int id) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_SELECT_RESTAURANT)
        ) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return resultSetToRestaurant(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Unable to get restaurant.", ex);
            throw new RestoException("Unable to get restaurant.");
        }
    }

    private Restaurant resultSetToRestaurant(ResultSet rs) throws SQLException {
        return new Restaurant(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("rating"));
    }

}
