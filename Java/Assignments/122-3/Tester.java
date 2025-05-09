import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        testBookClass();
        testVendingMachineClass();
        testPressClass();
        testExceptionClasses();
        
        System.out.println("All tests completed.");
    }
    
    private static void testBookClass() {
        System.out.println("\n=== Testing Book Class ===");
        
        // Test constructor and getters
        Book book = new Book("Java Programming", "John Doe", "This is the content of the book...", 1);
        System.out.println("Book created: " + book);
        
        // Test page calculation (content length / 666)
        String longContent = new String(new char[1332]).replace('\0', 'x'); // 1332 characters
        Book longBook = new Book("Long Book", "Author", longContent, 2);
        System.out.println("Long book pages (expected 2): " + longBook.getPages());
        
        // Test toString output
        String toStringOutput = book.toString();
        System.out.println("toString output:\n" + toStringOutput);
    }
    
    private static void testVendingMachineClass() {
        System.out.println("\n=== Testing VendingMachine Class ===");
        
        // Create a vending machine
        VendingMachine vm = new VendingMachine(0.5, "admin123");
        
        // Test initial state
        System.out.println("Initial cassette (expected 0): " + vm.getCassette());
        System.out.println("Initial catalogue size (expected 0): " + vm.getCatalogue().size());
        
        // Create some books for testing
        Book book1 = new Book("Book 1", "Author 1", "Content 1", 1);
        Book book2 = new Book("Book 2", "Author 2", "Content 2", 1);
        
        // Test restocking
        vm.restock(Arrays.asList(book1, book2), "admin123");
        System.out.println("After restock, catalogue size (expected 2): " + vm.getCatalogue().size());
        
        // Test getPrice
        int price = vm.getPrice(0);
        System.out.println("Price of first book (pages=" + book1.getPages() + "): " + price);
        
        // Test coin operations
        vm.insertCoin(50);
        vm.insertCoin(20);
        System.out.println("After inserting coins, cassette (expected 70): " + vm.getCassette());
        
        // Test buying book
        try {
            Book purchased = vm.buyBook(0);
            System.out.println("Purchased book: " + purchased.getTitle());
            System.out.println("Cassette after purchase (expected " + (70 - price) + "): " + vm.getCassette());
        } catch (CassetteException e) {
            System.out.println("Failed to buy book: " + e.getMessage());
        }
        
        // Test cancel
        int refund = vm.cancel();
        System.out.println("Refund amount (expected " + (70 - price) + "): " + refund);
        System.out.println("Cassette after cancel (expected 0): " + vm.getCassette());
    }
    
    private static void testPressClass() {
        System.out.println("\n=== Testing Press Class ===");
        
        // This test assumes you have a "books" directory with some .txt files
        // For testing without actual files, we'll just check the constructor doesn't throw exceptions
        try {
            Press press = new Press("./books", 10);
            System.out.println("Press created successfully");
        } catch (Exception e) {
            System.out.println("Error creating Press: " + e.getMessage());
        }
    }
    
    private static void testExceptionClasses() {
        System.out.println("\n=== Testing Exception Classes ===");
        
        // Test CassetteException
        try {
            throw new CassetteException();
        } catch (CassetteException e) {
            System.out.println("Caught CassetteException: " + e.getMessage());
        }
        
        try {
            throw new CassetteException("Custom message");
        } catch (CassetteException e) {
            System.out.println("Caught CassetteException with custom message: " + e.getMessage());
        }
        
        // Test InvalidPasswordException
        try {
            throw new InvalidPasswordException();
        } catch (InvalidPasswordException e) {
            System.out.println("Caught InvalidPasswordException: " + e.getMessage());
        }
        
        try {
            throw new InvalidPasswordException("Custom message");
        } catch (InvalidPasswordException e) {
            System.out.println("Caught InvalidPasswordException with custom message: " + e.getMessage());
        }
        
        // Test VendingMachine's password protection
        VendingMachine vm = new VendingMachine(0.5, "admin123");
        try {
            vm.emptySafe("wrongpassword");
            System.out.println("Failed: Password check didn't work");
        } catch (InvalidPasswordException e) {
            System.out.println("Caught expected InvalidPasswordException for wrong password");
        }
    }
}