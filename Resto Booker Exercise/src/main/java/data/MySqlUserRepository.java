package data;

import data.util.MySqlConnection;
import domain.User;
import util.RestoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlUserRepository implements UserRepository {

    private static final String SQL_SELECT_USER = "select * from users where login = ?";
    private static final String SQL_INSERT_USER = "insert into users(login, password) values(?, ?)";

    @Override
    public User getUser(String login) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_SELECT_USER)
        ) {
            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("login"),
                            rs.getString("password"));
                } else {
                    return null;
                }
            }

        } catch (SQLException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Cannot get user.", ex);
            throw new RestoException("Cannot get user.");
        }
    }

    @Override
    public void addUser(User user) {
        try (Connection con = MySqlConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_INSERT_USER)
        ) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Cannot add user.", ex);
            throw new RestoException("Cannot add user.");
        }
    }

}
