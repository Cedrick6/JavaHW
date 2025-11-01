import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    private int m; // number of percolation experiments
    private double[] x; // fraction of sites opened for each trial until percolation

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        // TODO
        if (n <= 0 || m <= 0){
            throw new IllegalArgumentException("Illegal n or m");
        } 
        this.m = m;
        x = new double[m];

        for (int t = 0; t < m; t++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int i = StdRandom.uniform(n);
                int j = StdRandom.uniform(n);
            if (!perc.isOpen(i,j)) {
                perc.open(i,j);
                }            
            }
            x[t] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        // TODO
        return StdStats.mean(x);
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        // TODO
        return StdStats.stddev(x);
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        // TODO
        return mean() - 1.96 * stddev() / Math.sqrt(m);
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        // TODO
        return mean() + 1.96 * stddev() / Math.sqrt(m);
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, m);
        StdOut.printf("Percolation threshold for a %d x %d system:\n", n, n);
        StdOut.printf("  Mean                = %.3f\n", stats.mean());
        StdOut.printf("  Standard deviation  = %.3f\n", stats.stddev());
        StdOut.printf("  Confidence interval = [%.3f, %.3f]\n", stats.confidenceLow(), stats.confidenceHigh());
    }
}
// javac -d out src/PercolationStats.java
// java PercolationStats 100 1000