public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Invalid password, please try again");
    }
    
    public InvalidPasswordException(String message) {
        super(message);
    }
}