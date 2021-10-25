package linearSearchImplement;

import java.util.Objects;

public class Student {
    private String studentID;
    private String name;
    private boolean gender;

    public Student() {

    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String name, boolean gender) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass() || o == null)
        //if(!(o instanceof Student) || o == null)
            return false;
        if (o == this)
            return true;
        Student student = (Student) o;
        return this.studentID.equals(student.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
