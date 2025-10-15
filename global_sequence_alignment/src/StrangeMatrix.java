// import stdlib.StdOut;

public class StrangeMatrix {
    public static void main(String[] args) {
        // TODO
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++)
            a[i][n - 1] = m - i - 1;
        for (int j = 0; j < n; j++)
            a[m - 1][j] = n - j - 1;

        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                a[i][j] = a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) System.out.printf("%5d ", a[i][j]);
                else System.out.printf("%5d\n", a[i][j]);
            }
        }
    }
}
