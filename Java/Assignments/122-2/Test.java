public class Test {

    public static void main(String[] args) {
        Substitution test = new MonoAlphaSubstitution("abcd");
        System.out.println(test.encrypt("a"));

    }
}