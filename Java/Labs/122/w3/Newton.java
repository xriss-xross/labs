
public class Newton {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println(
                "Incorrect Number of Parameters\nUsage: java Newton number guess epsilon"
                );
            return;
        }

        double n = Double.parseDouble(args[0]);
        double guess = Double.parseDouble(args[1]);
        double epsilon = (args.length == 3) ? Double.parseDouble(args[2]) : 0.0000001;
        
        sqRoot(n, guess, epsilon);
    }

    public static void sqRoot(Double n, Double guess, Double epsilon) {
        double newGuess = ((n / guess) + guess) / 2;

        if (Math.abs(guess - newGuess) < epsilon) {
            System.out.println(newGuess);
        } else {
            sqRoot(n, newGuess, epsilon);
        }
    }
}
