import java.util.Scanner;
// import stdlib.StdArrayIO;
// import stdlib.StdIn;
// import stdlib.StdOut;

public class Alignment {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine().trim();
        String y = sc.nextLine().trim();
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] opt = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                opt[i][j] = sc.nextInt();
        sc.close();

        int i = 0, j = 0;
        System.out.println(opt[0][0]); // edit distance

        while (i < m - 1 || j < n - 1) {
            if (i < m - 1 && opt[i][j] == opt[i + 1][j] + 2) {
                System.out.println(x.charAt(i) + " - 2");
                i++;
            } else if (j < n - 1 && opt[i][j] == opt[i][j + 1] + 2) {
                System.out.println("- " + y.charAt(j) + " 2");
                j++;
            } else {
                int penalty = (x.charAt(i) == y.charAt(j)) ? 0 : 1;
                System.out.println(x.charAt(i) + " " + y.charAt(j) + " " + penalty);
                i++; j++;
            }
        }
    }
}
