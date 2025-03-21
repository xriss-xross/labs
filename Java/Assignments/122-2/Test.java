public class Test {
    public static void main(String[] args) {
        Substitution test = new Vigenere("COMPONETWOTWO");

        System.out.println(test.encrypt("fun fun fun"));
    }
}