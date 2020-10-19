package data;

import domain.User;
import util.PwdException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getLogin(), user);
    }

    @Override
    public User getUser(String login) {
        return users.getOrDefault(login, null);
    }
}
