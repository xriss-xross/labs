import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Press {
    private Map<String, List<Book>> shelf;
    private int shelfSize;
    private Map<String, Integer> edition;

    public Press(String pathToBookDir, int shelfSize) {
        shelf = new HashMap<>();
        edition = new HashMap<>();

        try {
            File directoryPath = new File(pathToBookDir);
            File[] fileList = directoryPath.listFiles();
            
            if (fileList != null) {
                for (int i = 0; i < fileList.length; i++) {
                    File file = fileList[i];
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                        String bookId = file.getName();
                        shelf.put(bookId, new LinkedList<>());
                        edition.put(bookId, 0);
                    }
                }
            }
        } catch (Exception e) {
            shelf = new HashMap<>();
            edition = new HashMap<>();
        }
    }

    protected Book print(String bookID, int edition) {
        if (!shelf.containsKey(bookID)) {
            throw new IllegalArgumentException("404 book not found");
        }

        File file = new File(bookID);
        String title = null;
        String author = null;
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line).append("\n");  
                
                if (line.startsWith("Title:") && title == null) {
                    title = line.substring("Title: ".length()).trim();
                } 
                else if (line.startsWith("Author:") && author == null) {
                    author = line.substring("Author:".length()).trim();
                }
            }

            if (title == null || author == null) {
                throw new IOException("Couldn't find title / author");
            }

            if (content.length() > 0) {
                content.setLength(content.length() - 1);
            }

            return new Book(title, author, content.toString(), edition);

        } catch (IOException e) {
            throw new RuntimeException("Error reading book file");
        }
    }
}
