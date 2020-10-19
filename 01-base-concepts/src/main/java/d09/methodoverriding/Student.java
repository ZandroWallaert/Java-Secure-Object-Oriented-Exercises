package d09.methodoverriding;

public class Student extends Person {

    private int studentId;

    public Student(int studentId, String lastname, String firstname) {
        super(lastname, firstname);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return String.format("%s %s (#%d)",
                getLastname(), getFirstname(), studentId);
    }
}
