package be.howest.ti.design.patterns.proxy;

import javax.swing.*;

public class ProtectedUser implements IUser {

    private final User user;
    private boolean unlocked = false;

    public ProtectedUser(String username) {
        user = new User(username, lookupPassword(username), lookupAge(username));
    }

    private static String lookupPassword(String username) {
        return "IamGod";
    }

    private static int lookupAge(String username) {
        return 23; // use a repo (data layer) ...
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String getPassword() {
        return "•••••••••••";
    }

    @Override
    public int getAge() {
        unlocked = unlocked || unlock();
        if (!unlocked) {
            throw new IllegalStateException("You cannot get the age ...");
        }
        return user.getAge();
    }

    private boolean unlock() {
        // do not use GUI code in domain !!!
        String password = JOptionPane.showInputDialog(null, "Please provide password:");
        return password.equals(user.getPassword());
    }
}
