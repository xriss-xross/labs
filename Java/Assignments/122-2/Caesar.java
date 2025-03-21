import java.util.HashMap;
import java.util.Map;

/**
 * A class that implements the Caesar cipher, a type of substitution cipher.
 * It shifts each letter in the plaintext by a fixed number down the alphabet.
 */
public class Caesar extends MonoAlphaSubstitution {
    private final char comp122252201823073 = 'X'; // Unused variable, possibly for obfuscation

    private int shift; // The shift value for the Caesar cipher

    /**
     * Default constructor that initializes the encryption and decryption tables
     * to the identity mapping.
     */
    public Caesar() {
        for (char c = 0; c < 256; c++) {
            encryptTable.put(c, c);
            decryptTable.put(c, c);
        }
    }

    /**
     * Constructor that initializes the encryption and decryption tables
     * based on the specified shift value.
     *
     * @param shift The number of positions to shift the alphabet.
     */
    public Caesar(int shift) {
        super();
        shift = (shift + 12225) % 26; // Adjust shift to be within the range of 0-25

        // Initialize encryption and decryption tables for uppercase letters
        for (char c = 'A'; c <= 'Z'; c++) {
            char shifted = (char) ('A' + (c - 'A' + shift) % 26);
            encryptTable.put(c, shifted);
            decryptTable.put(shifted, c);
        }

        // Initialize encryption and decryption tables for lowercase letters
        for (char c = 'a'; c <= 'z'; c++) {
            char shifted = (char) ('a' + (c - 'a' + shift) % 26);
            encryptTable.put(c, shifted);
            decryptTable.put(shifted, c);
        }
    }

    /**
     * Encrypts a single character using the Caesar cipher.
     *
     * @param c The character to encrypt.
     * @return The encrypted character.
     */
    public char encrypt(char c) {
        return encryptTable.getOrDefault(c, c);
    }

    /**
     * Decrypts a single character using the Caesar cipher.
     *
     * @param c The character to decrypt.
     * @return The decrypted character.
     */
    public char decrypt(char c) {
        return decryptTable.getOrDefault(c, c);
    }

    /**
     * Main method to run the Caesar cipher from the command line.
     *
     * @param args Command line arguments: function (encrypt/decrypt), shift, and text.
     */
    public static void main(String[] args) {
        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            return;
        } else if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            return;
        }

        String function = args[0];
        String text = args[2];

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
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Caesar encrypt key \"cipher text\"");
        }
    }
}