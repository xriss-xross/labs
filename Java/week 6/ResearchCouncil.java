public class ResearchCouncil implements Billable, Emailable{
    private String name;
    private String email;

    public String greet() {
        return "sendto: " + email + "Hi " + name + ",\n";
    }
    
    public void payBill(int amount){
        System.out.println(amount);
    }
    
    public void sendEmail(){
    }
}
