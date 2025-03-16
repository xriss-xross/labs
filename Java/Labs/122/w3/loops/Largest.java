import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        System.out.print("Length of Array:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] myArray = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer:");
            myArray[i] = scanner.nextInt();
        }

        int largestValue = 0;
        for (int i = 0; i < n; i++) {
            if (myArray[i] > largestValue) {
                largestValue = myArray[i];
            }
        }

        System.out.println(largestValue);
    }
}
