public class Student {
    public String name = new String();
    public String email = new String();
    public int yearOfBirth;
    public int enrolmentYear;
    public int studentId;
    public int grade;
    public boolean hasSubmitted;

    public Student() {
    }

    public Student(String givenName, String givenEmail, int givenYearOfBirth, int givenEnrolmentyear, int givenStudentId) {
        name = givenName;
        email = givenEmail;
        yearOfBirth = givenYearOfBirth;
        enrolmentYear = givenEnrolmentyear;
        studentId = givenStudentId;
    }

    public Student(String givenName, String givenEmail, int givenYearOfBirth) {
        name = givenName;
        email = givenEmail;
        yearOfBirth = givenYearOfBirth;
    }

    public Student(String givenName, String givenEmail, String givenYearOfBirth) {
        name = givenName;
        email = givenEmail;
        int convertedYOB = Integer.parseInt(givenYearOfBirth.split("/")[2]);
        yearOfBirth = convertedYOB;
    }
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
