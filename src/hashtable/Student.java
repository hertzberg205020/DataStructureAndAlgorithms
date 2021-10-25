package hashtable;

public class Student {
    private int grade;
    private int clazz;
    private String firstName;
    private String lastName;

    public Student(int grade, int clazz, String firstName, String lastName) {
        this.grade = grade;
        this.clazz = clazz;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 32; // 以32進位制實作
        int hash = 0;
        hash = hash * B + ((Integer)grade).hashCode();
        hash = hash * B + ((Integer)clazz).hashCode();
        hash = hash * B + (firstName.toLowerCase().hashCode());
        hash = hash * B + (lastName.toLowerCase().hashCode());
        return hash;
    }
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(getClass() != o.getClass()) {
            return false;
        }
        if(this == o) {
            return true;
        }
        Student another = (Student) o;
        return this.grade == another.grade &&
                this.clazz == another.clazz &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
