import stdlib.StdOut;

public class Rational {
    private long x; // numerator
    private long y; // denominator

    // Constructs a rational number whose numerator is x and denominator is 1.
    public Rational(long x) {
        // TODO
        this.x = x;
        this.y = 1;
    }

    // Constructs a rational number given its numerator x and denominator y.
    public Rational(long x, long y) {
        // TODO
        long g = gcd(Math.abs(x), Math.abs(y));
        x /= g;
        y /= g;
        
        this.x = x;
        this.y = y;
    }

    // Returns the sum of this rational number and other.
    public Rational add(Rational other) {
        // TODO
        long numerator = this.x * other.y + other.x * this.y;
        long denominator = this.y * other.y;
        return new Rational(numerator, denominator);  
    }

    // Returns the product of this rational number and other.
    public Rational multiply(Rational other) {
        // TODO
        long numerator = this.x * other.x;
        long denominator = this.y * other.y;
        return new Rational(numerator, denominator);  
    }

    // Returns true if this rational number is equal to other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // TODO
        Rational that = (Rational) other;
        return this.x == that.x && this.y == that.y;    
    }

    // Returns a string representation of this rational number.
    public String toString() {
        if (x == 0 || y == 1) {
            return x + "";
        }

        return x + "/" + y;
    }

    // Returns gcd(p, q), computed using Euclid's algorithm.
    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        Rational term = new Rational(1);
        for (int i = 1; i <= n; i++) {
            total = total.add(term);
            term = term.multiply(new Rational(1, 2));
        }
        StdOut.printf("1 + 1/2 + 1/4 + ... + 1/2^%d = %s\n", n, total);
    }
}
// javac -d out src/Rational.java
// java Rational 10