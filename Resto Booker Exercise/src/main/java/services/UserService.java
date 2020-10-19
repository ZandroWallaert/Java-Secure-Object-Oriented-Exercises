package services;

import data.Repositories;
import domain.User;
import org.mindrot.jbcrypt.BCrypt;
import util.RestoException;

public class UserService {

    public User loginUser(String login, String password) {
        User user = Repositories.getUserRepository().getUser(login);

        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            throw new RestoException("Login and/or password incorrect.");
        } else {
            return user;
        }
    }

    public User registerUser(String login, String password, String passwordConfirmation) {
        if (password.trim().length() > 0 && password.equals(passwordConfirmation)) {
            try {
                User user = new User(login, BCrypt.hashpw(password, BCrypt.gensalt()));
                Repositories.getUserRepository().addUser(user);
                return user;
            } catch (RestoException ex) {
                throw new RestoException("Unable to add new user. Try another login.");
            }
        } else {
            throw new RestoException("Please specify a non-empty password and confirm it.");
        }
    }

}
