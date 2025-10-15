
import java.util.Scanner;

// import stdlib.StdIn;
// import stdlib.StdOut;

public class EditDistance {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine().trim();
        String y = sc.nextLine().trim();
        sc.close();

        int m = x.length(), n = y.length();
        int[][] opt = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) opt[i][n] = 2 * (m - i);
        for (int j = 0; j <= n; j++) opt[m][j] = 2 * (n - j);

        // Fill bottom-up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int matchCost = (x.charAt(i) == y.charAt(j)) ? 0 : 1;
                opt[i][j] = Math.min(
                    Math.min(opt[i + 1][j + 1] + matchCost, opt[i + 1][j] + 2),
                    opt[i][j + 1] + 2
                );
            }
        }

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
}
