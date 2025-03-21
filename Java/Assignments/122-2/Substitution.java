/**
 * An abstract class that implements the Cipher interface for substitution ciphers.
 * It provides methods for encrypting and decrypting strings character by character.
 */
public abstract class Substitution implements Cipher {
    private final char comp122252201823073 = 'X'; // Unused variable, possibly for obfuscation

    /**
     * Encrypts a single character.
     *
     * @param c The character to encrypt.
     * @return The encrypted character.
     */
    public abstract char encrypt(char c);

    /**
     * Decrypts a single character.
     *
     * @param c The character to decrypt.
     * @return The decrypted character.
     */
    public abstract char decrypt(char c);

    /**
     * Encrypts a string by encrypting each character.
     *
     * @param unencrypted_s The string to encrypt.
     * @return The encrypted string.
     */
    public String encrypt(String unencrypted_s) {
        String encrypted_s = "";
        for (int i = 0; i < unencrypted_s.length(); i++) {
            encrypted_s += encrypt(unencrypted_s.charAt(i));
        }
        return encrypted_s;
    }

    /**
     * Decrypts a string by decrypting each character.
     *
     * @param encrypted_s The string to decrypt.
     * @return The decrypted string.
     */
    public String decrypt(String encrypted_s) {
        String unencrypted_s = "";
        for (int i = 0; i < encrypted_s.length(); i++) {
            unencrypted_s += decrypt(encrypted_s.charAt(i));
        }
        return unencrypted_s;
    }
}