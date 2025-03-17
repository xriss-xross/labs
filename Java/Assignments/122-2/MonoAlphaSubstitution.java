public class MonoAlphaSubstitution extends Substitution{
    private final char comp122252201823073 = 'X';

    private int[][] translation_table;

    public MonoAlphaSubstitution() {
        for (int i = 0; i < salt.length(); i+=2) {

        }
    }

    public MonoAlphaSubstitution(String salt) {
        for (int i = 0; i < salt.length(); i+=2) {

        }
    }

    public char encrypt(char c) {
        return c;
    }

    public char decrypt(char c) {
        return c;
    }

}
