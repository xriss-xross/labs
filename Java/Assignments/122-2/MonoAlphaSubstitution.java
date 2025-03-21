import java.util.HashMap;
import java.util.Map;

/**
 * A class that implements a monoalphabetic substitution cipher.
 * It maps each character in the plaintext to a fixed character in the ciphertext.
 */
public class MonoAlphaSubstitution extends Substitution {
    private final char comp122252201823073 = 'X'; // Unused variable, possibly for obfuscation

    protected Map<Character, Character> encryptTable = new HashMap<>(); // Encryption mapping table
    protected Map<Character, Character> decryptTable = new HashMap<>(); // Decryption mapping table

    /**
     * Default constructor that initializes the encryption and decryption tables
     * to the identity mapping.
     */
    public MonoAlphaSubstitution() {
        for (char c = 0; c < 256; c++) {
            encryptTable.put(c, c);
            decryptTable.put(c, c);
        }
    }

    /**
     * Constructor that initializes the encryption and decryption tables
     * based on the specified salt string.
     *
     * @param salt A string used to create the substitution mapping.
     * I have called it salt in refrence to how hashing algorithms such as sha-xxx
     * refer to adding variety to a hash
     */
    public MonoAlphaSubstitution(String salt) {
        this();

        for (int i = 0; i < salt.length(); i += 2) {
            char original = salt.charAt(i);
            char encoded = salt.charAt(i + 1);

            encryptTable.put(original, encoded);
            decryptTable.put(encoded, original);
        }
    }

    /**
     * Encrypts a single character using the substitution cipher.
     *
     * @param c The character to encrypt.
     * @return The encrypted character.
     */
    public char encrypt(char c) {
        return encryptTable.getOrDefault(c, c);
    }

    /**
     * Decrypts a single character using the substitution cipher.
     *
     * @param c The character to decrypt.
     * @return The decrypted character.
     */
    public char decrypt(char c) {
        return decryptTable.getOrDefault(c, c);
    }

    /**
     * Main method to run the monoalphabetic substitution cipher from the command line.
     *
     * @param args Command line arguments: function (encrypt/decrypt), key, and text.
     */
    public static void main(String[] args) {
        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        } else if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }

        String function = args[0];
        String text = args[2];

        MonoAlphaSubstitution cipher;

        if (args.length == 3) {
            cipher = new MonoAlphaSubstitution(args[1]);
        } else {
            cipher = new MonoAlphaSubstitution();
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
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
    }
}
