import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WC {
    public static void main(String[] args) {
        if (args[0].equals("-w")) {
            System.out.println(wordCount(args[1]));
        }

        if (args[0].equals("-m")) {
            System.out.println(charCount(args[1]));
        }

        if (args[0].equals("-l")) {
            System.out.println(lineCount(args[1]));
        }

        if (args[0].equals("-s")) {
            System.out.println(lexicalDiversity(args[1]));
        }

        if (args[0].equals("-b")) {
            System.out.println(bagOfWords(args[1]));
        }
        
        if (args[0].equals("-v")) {
            List<String> bag = twoBagsOfWords(args[1], args[2]);
            System.out.println(bagOfWords(args[1], bag));
            System.out.println(bagOfWords(args[2], bag));
        }
    }

    private static int wordCount(String input) {
        return input.split("\\s").length;
    }

    private static int charCount(String input) {
        return input.length();
    }

    private static int lineCount(String input) {
        return input.split("\\r?\\n").length;
    }

    private static double lexicalDiversity(String input) {
        String[] words = input.split("\\s");
        HashSet<String> distinctWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            distinctWords.add(words[i]);
        }
        return (double) distinctWords.size() / words.length;
    }

    private static List<Integer> bagOfWords(String input) {
        String[] words = input.split("\\s");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        List<String> sortedWords = new ArrayList<>(wordCounts.keySet());
        Collections.sort(sortedWords);

        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < sortedWords.size(); i++) {
            counts.add(wordCounts.get(sortedWords.get(i)));
        }
        return counts;
    }

    private static List<Integer> bagOfWords(String input, List<String> sortedWords) {
        String[] words = input.split("\\s");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            if (wordCounts.containsKey(word)) {
                counts.add(wordCounts.get(word));
            } else {
                counts.add(0);
            }
        }
        return counts;
    }

    private static List<String> twoBagsOfWords(String input1, String input2) {
        String[] bag1 = input1.split("\\s+");
        String[] bag2 = input2.split("\\s+");
        HashSet<String> bigBag = new HashSet<>();
        
        for (int i = 0; i < bag1.length; i++) {
            bigBag.add(bag1[i]);
        }

        for (int i = 0; i < bag2.length; i++) {
            bigBag.add(bag2[i]);
        }
        
        List<String> finalBag = new ArrayList<>(bigBag);
        Collections.sort(finalBag);
        return finalBag;
    }
}
