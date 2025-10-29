import java.util.Scanner;
// import stdlib.StdIn;
// import stdlib.StdOut;

public class Distance {
    // Entry point.

     // reads n double from standard input
    public static double[] readArray(Scanner scanner, int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
        }
        return arr;
    }

    // calculate the Euclidean distanceds
    public static double euclideanDistance(double[] x, double[] y) {
        double sum = 0.0;
        for (int i = 0; i < x.length; i++) {
            double diff = x[i] - y[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);

        double[] x = readArray(scanner, n);
        double[] y = readArray(scanner, n);

        scanner.close();

        System.out.println(euclideanDistance(x, y));
    
    }
}
//. javac -d out src/Distance.java
//. java Distance