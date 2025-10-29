
import java.util.Scanner;

// import stdlib.StdIn;
// import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    
    // provided helper methods
    public static char charAt(String s, int i) {
        return s.charAt(i);
    }

    public static int length(String s) {
        return s.length();
    }

    public static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

     // build the distance matrix
    public static int[][] buildDistance(String x, String y) {
        int m = length(x);
        int n = length(y);
        int[][] opt = new int[m + 1][n + 1];


        for (int i = 0; i <= m; i++) {
            opt[i][n] = 2 * (m - i);
        }

        for (int j = 0; j <= n; j++) {
            opt[m][j] = 2 * (n - j);
        }

        // fill the table
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int matchCost = (charAt(x, i) == charAt(y, j)) ? 0 : 1;
                opt[i][j] = min(
                    opt[i + 1][j + 1] + matchCost, 
                    opt[i + 1][j] + 2,             
                    opt[i][j + 1] + 2              
                );
            }
        }

        return opt;
    }

    // print the matrix
    public static void printDistanceMatrix(String x, String y, int[][] opt) {
        int m = length(x);
        int n = length(y);

        System.out.println(x);
        System.out.println(y);
        System.out.println((m + 1) + " " + (n + 1));

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < n)
                    System.out.printf("%3d ", opt[i][j]);
                else
                    System.out.printf("%3d\n", opt[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        // TODO
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        String y = scanner.nextLine();
        scanner.close();

        int[][] opt = buildDistance(x, y);
        printDistanceMatrix(x, y, opt);
    }
}
//. javac -d out src/EditDistance.java
//. java EditDistance < data/example10.txt