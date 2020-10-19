package services;

import data.Repositories;
import domain.User;
import org.mindrot.jbcrypt.BCrypt;
import util.PwdException;

public class UserService {

    public User registerUser(String login, String password) {
        if (login == null || password == null || login.trim().length() == 0
            || password.trim().length() == 0) {
            throw new PwdException("Login and password are mandatory.");
        }

        if (Repositories.getUserRepository().getUser(login) != null) {
            throw new PwdException("Login already exists.");
        }

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(login, hash);
        Repositories.getUserRepository().addUser(user);

        return user;
    }

    public User loginUser(String login, String password) {
        User user = Repositories.getUserRepository().getUser(login);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        } else {
            throw new PwdException("Invalid login and/or password.");
        }
    }

}
