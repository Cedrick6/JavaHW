// import stdlib.StdOut;

public class Pascal {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);
        int[][] P = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            P[i][0] = P[i][i] = 1;
            for (int j = 1; j < i; j++)
                P[i][j] = P[i - 1][j - 1] + P[i - 1][j];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(P[i][j] + " ");
            System.out.println();
        }
    }
}
