public class Student {
    private String name = new String();
    private String email = new String();
    private int yearOfBirth;
    private int enrolmentYear;
    private int studentId;
    private int grade;
    private boolean hasSubmitted;

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
        if (grade != mark) {
            if (mark >= 1 && mark <= 100) {
                grade = mark;
            } else {
                System.out.println("Enter a grade from 0-100.");
                return;
            }
        }

    }
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getEnrolmentYear() {
        return enrolmentYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGrade() {
        return grade;
    }

    public boolean getHasSubmitted() {
        return hasSubmitted;
    }

}
