import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private List<Book> shelf;
    private double locationFactor;
    private int cassette;
    private int safe;
    private String password;
    private List<Integer> acceptableDenomination = Arrays.asList(
            1, 2, 5, 10, 20, 50, 100, 200
        );

    public int getCassette() {
        return cassette;
    }

    public void insertCoin(int coin) throws IllegalArgumentException {
        if (acceptableDenomination.contains(coin)) {
            cassette += coin;
        } else {
            throw new IllegalArgumentException("Invalid coin denomination");
        }
        
    }

    public int cancel() {
        int original = cassette;
        cassette = 0;

        return original;
    }

    public void restock(List<Book> books, String p) {
        if (!password.equals(p)) {
            throw new InvalidPasswordException();
        }
        shelf.addAll(books);
    }

    public int emptySafe(String p) {
        if (!password.equals(p)) {
            throw new InvalidPasswordException();
        }
        int original = safe;
        safe = 0;

        return original;
    }

    public List<String> getCatalogue() {
        List<String> catalogue = new ArrayList<>();
        for (int i = 0; i < shelf.size(); i++) {
            catalogue.add(shelf.get(i).toString());
        }

        return catalogue;
    }

    public int getPrice(int index) {
        if (index < 0 || index >= shelf.size()) {
            throw new IndexOutOfBoundsException("Invalid book index");
        }
        double price = shelf.get(index).getPages() * locationFactor;

        return (int) Math.ceil(price);
    }

    public Book buyBook(int index) {
        int p = getPrice(index);
        if (cassette < p) {
            throw new CassetteException();
        }

        cassette -= p;
        safe += p;

        return shelf.remove(index);
    }

    public VendingMachine(double l, String p) {
        shelf = new ArrayList<>();
        locationFactor = l;
        cassette = 0;
        safe = 0;
        password = p;
    }
}
