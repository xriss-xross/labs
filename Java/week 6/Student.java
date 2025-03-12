public class Student extends Person implements Degreeable{
    private String name;
    private String email;
    private int grade;

    public void awardDegree(){
        if (grade > 40) {
            System.out.println("You Passed Your Degree, hooray!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}  
