
import java.util.Scanner;

// import stdlib.StdIn;
// import stdlib.StdOut;

public class Transpose {
    // Entry point.

    // read the m×n matrix
    public static double[][] readMatrix(Scanner scanner, int m, int n) {
        double[][] a = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        return a;
    }

    // print the transpose
    public static void printTranspose(double[][] a, int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                 System.out.printf("%.6f", a[i][j]);
                if (i < m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        Scanner scanner = new Scanner(System.in);

        double[][] a = readMatrix(scanner, m, n);
        scanner.close();

        printTranspose(a, m, n);
    }
}
//. javac -d out src/Transpose.java
//. java Transpose