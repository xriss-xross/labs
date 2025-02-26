public class Student {
    public String name = new String();
    public String email = new String();
    public int yearOfBirth;
    public int enrolmentYear;
    public int studentId;
    public int grade = 0;
    public boolean hasSubmitted = false;


    public void submitCoursework() {
        hasSubmitted = true;
    }

    public void updateGrade(int mark) {
        grade = mark;
    }

    public int getGrade() {
        return grade;
    }
}
