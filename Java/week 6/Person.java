public abstract class Person implements Emailable{
    private String name;
    private String email;

    public String greet() {
        return "sendto: " + email + "Hi " + name + ",\n";
    }

    public void sendEmail(){
        System.out.println(greet());
    }

    public abstract void setName(String name);

    public abstract String getName();

    public abstract void setEmail(String email);

    public abstract String getEmail();
}
