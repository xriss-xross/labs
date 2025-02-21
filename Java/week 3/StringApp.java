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
    int i = a.indexOf(f);
    int count = 0;
    while (i != -1) {
      count ++;
      a = a.substring(i + f.length());
      i = a.indexOf(f);
    }
    return count;
  }

  public static int factorCount(String a, String f, boolean caseSensitive) {
    if (!caseSensitive) {
      return factorCount(a.toLowerCase(), f.toLowerCase());
    } else {
      return factorCount(a, f);
    }
  }

  // Part 3
  public static void main(String[] args) {
    String input = args[0];
    System.out.println(factorCount("Hello Hello World!", input, false));

    for (char letter = 'a'; letter <= 'z'; letter++) {
      System.out.println(letter + ": " + 0);
    }
  }
}
