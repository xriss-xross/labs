public class Caesar {
    public static void main(String[] args){
        int shift_inp = Integer.parseInt(args[0]);
        System.out.println(rotate(shift_inp,args[1]));
    }


    public static char rotate(int shift, char target) {
        shift %= 26;  // remove surplus shifts
        int target_ascii = target;
        if ( (target_ascii >= 65 && target_ascii <= 90 ) ||
             (target_ascii >= 97 && target_ascii <= 122)
        ) {
            // is an alphabetic character
            int shifted_ascii = handle_shift(target_ascii, target_ascii + shift);
            char rotated_char = (char) shifted_ascii;
            return rotated_char;
        } else {
            // misc character
            return target;
        }
    }

    public static String rotate(int shift, String target) {
        String rotated_string = "";
        for (int i = 0; i < target.length(); i++) {
            rotated_string += rotate(shift, target.charAt(i));
        }
        return rotated_string;
    }


    // acutal shift method
    public static int handle_shift(int ascii, int shifted_ascii) {
        // upper case
        if (ascii >= 65 && ascii <= 90) {
            if (shifted_ascii < 65) {
                shifted_ascii += 26;
            } else if (shifted_ascii > 90) {
                shifted_ascii -= 26;
            }
        // lower case
        } else if (ascii >= 97 && ascii <= 122) {
            if (shifted_ascii < 97) {
                shifted_ascii += 26;
            } else if (shifted_ascii > 122) {
                shifted_ascii -= 26;
            }
        }
        return shifted_ascii;
    }

}
