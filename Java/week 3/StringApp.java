import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StringApp {

  /**
   * Reads the contents of a file and returns it as a String.
   *
   * @param path the path to the file
   * @return the contents of the file as a String, or "file not found!" if an IOException occurs
   */
  public static String readFileAsString(String path) {
    try {
      return Files.readString(Path.of(path));
    } catch (IOException e) {
      return "file not found!";
    }
  }


  // Part 1
  public static String pow(String s, int n) {
    String nRepeat = new String(new char[n-1])
      .replace("\0", s);
    return nRepeat;
  }

  // Part 2
  public static int factorCount(String a, String f) {
    // your code here
    return 0;
  }

  public static int factorCount(String a, String f, boolean caseSensitive) {
    // your code here
    return 0;
  }

  // Part 3
  public static void main(String[] args) {
    String input = args[0];

    for (char letter = 'a'; letter <= 'z'; letter++) {
      System.out.println(letter + ": " + 0);
    }
  }
}
