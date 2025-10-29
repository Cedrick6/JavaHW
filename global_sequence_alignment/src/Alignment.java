import java.util.Scanner;
// import stdlib.StdArrayIO;
// import stdlib.StdIn;
// import stdlib.StdOut;

public class Alignment {
    // Entry point.

    //provided helper methods
    public static char charAt(String s, int i) {
        return s.charAt(i);
    }

    public static int length(String s) {
        return s.length();
    }

    public static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    // Method to recover and print optimal alignment
    public static void recoverAlignment(String x, String y, int[][] opt) {
        int m = length(x);
        int n = length(y);
        int i = 0, j = 0;

        System.out.println(opt[0][0]); // edit distance

        while (i < m && j < n) {
            if (i < m && opt[i][j] == opt[i + 1][j] + 2) { 
                System.out.println(charAt(x, i) + " - 2");
                i++;
            } else if (j < n && opt[i][j] == opt[i][j + 1] + 2) { 
                System.out.println("- " + charAt(y, j) + " 2");
                j++;
            } else {
                int penalty = (charAt(x, i) == charAt(y, j)) ? 0 : 1;
                System.out.println(charAt(x, i) + " " + charAt(y, j) + " " + penalty);
                i++;
                j++;
            }
        }

        // the remaining char
        while (i < m) {
            System.out.println(charAt(x, i) + " - 2");
            i++;
        }
        while (j < n) {
            System.out.println("- " + charAt(y, j) + " 2");
            j++;
        }
    }


    public static void main(String[] args) {
        // TODO
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine().trim();
        String y = scanner.nextLine().trim();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] opt = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                opt[i][j] = scanner.nextInt();
        scanner.close();

        recoverAlignment(x, y, opt);
    }
}

//. javac -d out src/Alignment.java
//. java EditDistance < data/example10.txt | java Alignment
//  cat data/endgaps7.txt
//  cat data/endgaps7.mat