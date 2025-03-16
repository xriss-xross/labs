public class Credit {
    public static void main(String[] args) {
        System.out.print("Number:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long number = scanner.nextLong();
        scanner.close();

        System.out.println(provider(String.valueOf(number)));
    }

    public static String reverse(long number) {
        String numberString = String.valueOf(number);
        String reversedString  = new StringBuilder(numberString).reverse().toString();

        return reversedString;
    }

    public static String provider(String number) {
        /* I could also do some helper functions here
         * But I was so close to the end that I just 
         * did these ugly or/and chains sorry
         */
        if (
            number.startsWith("34") ||
            number.startsWith("37")
            ) {
                if (
                    number.length() == 15 &&
                    luhn(Long.parseLong(number))
                    ) {
                        return "AMEX";
                }
                
        } else if (
            number.startsWith("51") ||
            number.startsWith("52") ||
            number.startsWith("53") ||
            number.startsWith("54") ||
            number.startsWith("55")
            ) {
                if (
                    number.length() == 16 &&
                    luhn(Long.parseLong(number))
                    ) {
                        return "MASTERCARD";
                }
        } else if (
            number.startsWith("4")
            ) {
                if (
                    number.length() == 13 ||
                    number.length() == 16 &&
                    luhn(Long.parseLong(number))
                    ) {
                        return "VISA";
                }
        } return "INVALID";
    }

    public static boolean luhn(long number) {
        String reversedString = reverse(number);
        String firstStrSums = "";
        int firstIntSums = 0;
        /*
         * If I cared even more than this I would get rid of the nested loops and instead subtract
         * 9 everytime the digit was more than 9 because doing -9 effectively adds the digits 
         * together and doing this recursively wouldn't cause stack overflow because adding a small
         * sequence of numbers together won't take up much space
         */
        for (int i = 1; i < reversedString.length(); i += 2) {
            firstStrSums = String.valueOf(Character.getNumericValue(reversedString.charAt(i)) * 2);
            for (int j = 0; j < firstStrSums.length(); j++) {
                firstIntSums += Character.getNumericValue(firstStrSums.charAt(j));
            }
        }
        
        int secondIntSums = 0;
        for (int i = 0; i < reversedString.length(); i += 2) {
            secondIntSums += Character.getNumericValue(reversedString.charAt(i));
        }

        String thirdSum = String.valueOf(firstIntSums + secondIntSums);
        if (thirdSum.charAt(thirdSum.length() - 1) == '0') {
            return true;
        }
        return false;
    }
}
