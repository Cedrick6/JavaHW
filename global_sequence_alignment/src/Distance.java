
import java.util.Scanner;

// import stdlib.StdIn;
// import stdlib.StdOut;

public class Distance {
    // Entry point.
    public static void main(String[] args) {
        // TODO

        int n = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) x[i] = scanner.nextDouble();
        for (int i = 0; i < n; i++) y[i] = scanner.nextDouble();
        scanner.close();

        double sum = 0;
        for (int i = 0; i < n; i++) {
            double diff = x[i] - y[i];
            sum += diff * diff;
        }
        System.out.println(Math.sqrt(sum));
    
    }
}
