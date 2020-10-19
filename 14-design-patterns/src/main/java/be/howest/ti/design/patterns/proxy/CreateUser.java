package be.howest.ti.design.patterns.proxy;

public class CreateUser {

    public static void main(String[] args) {
        IUser user = new ProtectedUser("Alice");

        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());

    }

}
