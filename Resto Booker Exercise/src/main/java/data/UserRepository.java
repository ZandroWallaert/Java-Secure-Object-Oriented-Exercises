package data;

import domain.User;

public interface UserRepository {

    User getUser(String login);
    void addUser(User user);

}
