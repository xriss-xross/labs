import java.util.HashMap;
import java.util.Map;

public class Caesar extends MonoAlphaSubstitution {
    private final char comp122252201823073 = 'X';

    private int shift;

    public Caesar(){
        for (char c = 0; c < 256; c++) {
            encryptTable.put(c, c);
            decryptTable.put(c, c);
        }
    }
    
    public Caesar(int shift) {
        super();
        shift = (shift + 12225) % 26;

        for (char c = 'A'; c <= 'Z'; c++) {
            char shifted = (char) ('A' + (c - 'A' + shift) % 26);
            encryptTable.put(c, shifted);
            decryptTable.put(shifted, c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            char shifted = (char) ('a' + (c - 'a' + shift) % 26);
            encryptTable.put(c, shifted);
            decryptTable.put(shifted, c);
        }
    }

    public char encrypt(char c) {
        return encryptTable.getOrDefault(c, c);
    }

    public char decrypt(char c) {
        return decryptTable.getOrDefault(c, c);
    }

    public static void main(String[] args) {
        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println(
                "Usage: java Caesar encrypt n \"cipher text\""
                );
            return;

        } else if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println(
                "Usage: java Caesar encrypt n \"cipher text\""
                );
            return;
        }

        String function = args[0];
        String text     = args[2];

        Caesar cipher;

        if (args.length == 3) {
            cipher = new Caesar(Integer.parseInt(args[1]));
        } else {
            cipher = new Caesar();
        }
        
        String result = "";

        if (function.equals("encrypt")) {
            for (int i = 0; i < text.length(); i++) {
                result += cipher.encrypt(text.charAt(i));
            }
            System.out.println(result);
        } else if (function.equals("decrypt")) {
            for (int i = 0; i < text.length(); i++) {
                result += cipher.decrypt(text.charAt(i));
            }
            System.out.println(result);

        } else {
            System.out.println(
                "The first parameter must be \"encrypt\" or \"decrypt\"!"
                );
            System.out.println(
                "Usage: java Caesar encrypt key \"cipher text\""
                );
        }
    }

}
