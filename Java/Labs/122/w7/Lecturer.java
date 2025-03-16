public class Lecturer extends Person implements Payable{
    private String name;
    private String email;
    private String timetable;

    public void payAmount(int amount){
        System.out.println(amount);
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

    public void setTimeTable(String tt) {
        timetable = tt;
    }

    public String getTimeTable() {
        return timetable;
    }
}
