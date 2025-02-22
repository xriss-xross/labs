/**
 * A bunch of utility functions for Strings.
 *
 * @author Patrick Totzke
 * @version 1.0
 */
public class StringTools {

  /**
   * Computes the length of a string.
   *
   * <p>This is done by first turning it into an Array of characters, then iteratively incrementing
   * an integer variable for every character.
   *
   * <p>This is of course are really silly solution because String.length or Array.size can be used
   * instead. In fact, the latter is implicitly used in the termination criterion of the for loop.
   *
   * @param str the string to consider
   * @return the length of the given string.
   */
  public static int length(String str) { 

    char[] len = str.toCharArray();
    int a = 0;
    for (char ch : len) {
      a++;
    }
    return a;
  }


/** 
 *
 * Swap
 *
 * @param s  the s. 
 * @return String
 */
  public static String swap(String s) { 

    String rev = "";

    for (int j = s.length(); j > 0; --j) {
      rev = rev + (s.charAt(j - 1));
    }
    return rev;
  }


/** 
 *
 * Main
 *
 * @param arg  the arg. 
 */
  public static void main(String[] arg) { 

    System.out.print("Enter a string: ");
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    String str = scanner.nextLine();
    System.out.println("It's length is " + length(str));
    System.out.println("It's swap is " + swap(str));
  }
}