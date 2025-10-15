
import java.util.Scanner;

// import stdlib.StdIn;
// import stdlib.StdOut;

public class Transpose {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        Scanner sc = new Scanner(System.in);
        double[][] a = new double[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextDouble();
        sc.close();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i < m - 1)
                    System.out.printf("%.1f ", a[i][j]);
                else
                    System.out.printf("%.1f\n", a[i][j]);
            }
        }
    }
}
