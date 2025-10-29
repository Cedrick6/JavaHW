// import stdlib.StdOut;

public class Pascal {
    // Entry point.

    // build pascal's triangle
    public static int[][] buildPascalTriangle(int n) {
        int[][] pascalTriangle = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            // the first and last element of each row
            pascalTriangle[i][0] = pascalTriangle[i][i] = 1;  
            for (int j = 1; j < i; j++) {
                // calculate as Pn(i−1, j−1) + Pn(i−1, j),
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]; 
            }
        }

        return pascalTriangle;
    }

    //print the triangle
    public static void printPascalTriangle(int[][] pascalTriangle, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalTriangle[i][j]);
                if (j < i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);

        int[][] pascalTriangle = buildPascalTriangle(n);
        printPascalTriangle(pascalTriangle, n);
    }
}
//. javac -d out src/Pascal.java
//. java Pascal