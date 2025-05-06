public class Book {
	private String title;
	private String author;
	private String content;
	private int pages;
	private int edition;

	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public int getEdition() {
		return edition;
	}
	public int getPages() {
		return pages;
	}

	public Book(String t, String a, String c, int e) {
		title = t;
		author = a;
		content = c;
		pages = (int) Math.ceil(content.length()/666);
		edition = e;
	}
	
    public String toString() {
        return "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "Edition: " + edition + "\n";
    }

	public static void main(String[] args) {
	}
}