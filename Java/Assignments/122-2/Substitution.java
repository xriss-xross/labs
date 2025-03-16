public abstract class Substitution implements Cipher{
    private final char comp122252201823073 = 'X';

    public abstract char encrypt(char c);
    public abstract char decrypt(char c);

    public String encrypt(String plaintext){
        String encrypted_s = "";
        for (int i = 0; i < plaintext.length(); i++) {
            encrypted_s += encrypt(plaintext.charAt(i));
        }
        return encrypted_s;
    };
    public String decrypt(String cryptotext){
        String decrypted_s = "";
        for (int i = 0; i < cryptotext.length(); i++) {
            decrypted_s += encrypt(cryptotext.charAt(i));
        }
        return decrypted_s;
    };
}
