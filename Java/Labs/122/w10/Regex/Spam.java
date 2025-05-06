import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.SortedSet;
import java.util.TreeSet;

public class Spam {
    public static void main(String[] args) throws IOException {
        // First read in the file
        String spam = getSpam();

        Matcher matcher = null;

        // Part 6
        if (args[0].equals("0")) {
            // Define our pattern and matches
            matcher = matchFrom(spam);
            // Loop through our matches
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        // Part 7
        if (args[0].equals("1")) {
            // Define our pattern and matches
            matcher = matchEmails(spam);
            // Loop through our matches
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        // Part 8
        if (args[0].equals("2")) {
            matcher = matchSenders(spam);

            SortedSet<String> senders = new TreeSet<>();

            while (matcher.find()) {
                senders.add(matcher.group(1));
            }

            for (String sender : senders) {
                System.out.println(sender);
            }
        }
    }

    public static String getSpam() throws IOException {
        File file = new File("./Spam.txt");
        return Files.readString(file.toPath());
    }

    // Part 6
    public static Matcher matchFrom(String input) {
        Pattern pattern = Pattern.compile("From:.*"); // You can adjust this pattern as needed
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    // Part 7
    public static Matcher matchEmails(String input) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    // Part 8
    public static Matcher matchSenders(String input) {
        Pattern pattern = Pattern.compile("From:.*?<([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,})>.*");
        Pattern patternPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}");
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
}
