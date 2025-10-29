import stdlib.StdOut;

public class Harmonic {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);
        Rational sum = new Rational(0);

        for (int i = 1; i <= n; i++) {
            sum = sum.add(new Rational(1, i));
        }

        StdOut.println(sum);
    }
}

// javac -d out src/Harmonic.java
// java Harmonic 10