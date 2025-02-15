import java.util.Arrays;

public class Brutus {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(count("Hello world!")));
    }

    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    public static int[] count (String str) {
        int[] letterCounts = {
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,};

        for (int i = 0; i < str.length(); i++) {
            int ascii_chr = str.charAt(i);
            if (ascii_chr >= 65 && ascii_chr <= 90) {
                letterCounts[ascii_chr-65] += 1;
            // checks for both upper and lower case
            } else if (ascii_chr >= 97 && ascii_chr <= 122) {
                letterCounts[ascii_chr-97] += 1;
            }
        }
        
        return letterCounts;
    }
}

