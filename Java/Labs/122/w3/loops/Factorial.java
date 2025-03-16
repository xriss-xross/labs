public class Factorial {
    public static void main(String[] args) {
        System.out.print("Enter an integer:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long n = scanner.nextInt();
        scanner.close();
        long factorial = 1;

        for(int i = 0; i < n ; i++) {
            factorial *= i + 1;
        }

        System.out.println(factorial);
    }
}