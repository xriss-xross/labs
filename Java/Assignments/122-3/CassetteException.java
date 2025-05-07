public class CassetteException extends RuntimeException {
    public CassetteException() {
        super("Not enough money, please check and try again");
    }
    
    public CassetteException(String message) {
        super(message);
    }
}