package domain;

public class Item {

    private final String name;
    private final int age;
    private final Sex sex;

    public Item(String name, int age, Sex sex) {
        if (name.length()<=0) {
            throw new ItemException("screen.error.empty.name");
        }
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return String.format("%s (%d, %s)", name, age, sex);
    }
}
