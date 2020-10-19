package d13.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        populateStudentSet();
        populateStudentArrayList();
    }

    private void populateStudentSet() {
        Set<Student> students = new HashSet<>();

        Student s1 = new Student(1, "De Wael", "Mattias");
        Student s2 = new Student(2, "Vlummens", "Frédéric");
        Student s3 = new Student(2, "Doppelganger", "Frédéric");

        students.add(s1); // students.size() == 1
        students.add(s2); // students.size() == 2
        students.add(s3); // students.size() == 2 (s3 not added -> objects considered equal due to same number, see equals and hashcode method)

        System.out.printf("Set : %d elements%n", students.size());
    }

    private void populateStudentArrayList() {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1, "De Wael", "Mattias");
        Student s2 = new Student(2, "Vlummens", "Frédéric");
        Student s3 = new Student(2, "Doppelganger", "Frédéric");

        students.add(s1); // students.size() == 1
        students.add(s2); // students.size() == 2
        students.add(s3); // students.size() == 3

        System.out.printf("List: %d elements%n", students.size());
    }

}
