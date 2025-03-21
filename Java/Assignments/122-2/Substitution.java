public abstract class Substitution implements Cipher{
    private final char comp122252201823073 = 'X';

    public abstract char encrypt(char c);
    public abstract char decrypt(char c);

    
    /** 
     * @param unencrypted_s
     * @return String
     */
    // concrete
    public String encrypt(String unencrypted_s){
        String encrypted_s = "";
        for (int i = 0; i < unencrypted_s.length(); i++) {
            encrypted_s += encrypt(unencrypted_s.charAt(i));
        }
        return encrypted_s;
    };
    public String decrypt(String encrypted_s){
        String unencrypted_s = "";
        for (int i = 0; i < encrypted_s.length(); i++) {
            unencrypted_s += decrypt(encrypted_s.charAt(i));
        }
        return unencrypted_s;
    };
}
