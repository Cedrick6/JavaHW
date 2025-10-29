import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StdStats;

public class PercolationStats {
    private int m; // number of percolation experiments
    private double[] x; // fraction of sites opened for each trial until percolation

    // Performs m independent experiments on an n x n percolation system.
    public PercolationStats(int n, int m) {
        // TODO
    }

    // Returns sample mean of percolation threshold.
    public double mean() {
        // TODO
        return 0;
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        // TODO
        return 0;
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        // TODO
        return 0;
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        // TODO
        return 0;
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
