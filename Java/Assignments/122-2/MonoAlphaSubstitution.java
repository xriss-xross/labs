import java.util.HashMap;
import java.util.Map;

public class MonoAlphaSubstitution extends Substitution {
    private final char comp122252201823073 = 'X';

    private Map<Character, Character> encryptTable = new HashMap<>();
    private Map<Character, Character> decryptTable = new HashMap<>();

    // Identify table
    public MonoAlphaSubstitution() {
        for (char c = 0; c < 256; c++) {
            encryptTable.put(c, c);
            decryptTable.put(c, c);
        }
    }

    // Salted table
    public MonoAlphaSubstitution(String salt) {
        this();
        
        for (int i = 0; i < salt.length(); i += 2) {
            char original = salt.charAt(i);
            char encoded  = salt.charAt(i + 1);

            encryptTable.put(original, encoded);
            decryptTable.put(encoded, original);
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
                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\""
                );
            return;
        } else if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println(
                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\""
                );
            return;
        }

        String function = args[0];
        String text     = args[2];

        MonoAlphaSubstitution cipher;

        if (args.length == 3) {
            cipher = new MonoAlphaSubstitution(args[1]);
        } else {
            cipher = new MonoAlphaSubstitution();
        }
        
        String result = "";

        if (function.equals("encrypt")) {
            for (int i = 0; i < text.length(); i++) {
                result += (cipher.encrypt(text.charAt(i)));
            }
            System.out.println(result);
        } else if (function.equals("decrypt")) {
            for (int i = 0; i < text.length(); i++) {
                result += (cipher.decrypt(text.charAt(i)));
            }
            System.out.println(result);

        } else {
            System.out.println(
                "The first parameter must be \"encrypt\" or \"decrypt\"!"
                );
            System.out.println(
                "Usage: java MonoAlphaSubstitution encrypt key \"cipher text\""
                );
        }
    }
}
