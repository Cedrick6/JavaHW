import dsa.WeightedQuickUnionPathCompressionUF;
import stdlib.In;
import stdlib.StdOut;

public class Percolation {
    private int n; // size of the percolation system
    private boolean[][] grid; // representation of the system (true = open site, false = blocked site)
    private int openSites; // number of sites opened
    private WeightedQuickUnionPathCompressionUF uf1; // for testing percolation
    private WeightedQuickUnionPathCompressionUF uf2; // for preventing backwash
    private int source; // source site (id = 0)
    private int sink; // sink site (id = n * n + 1)

    // Constructs an n x n percolation system, with all sites blocked.
    public Percolation(int n) {
        // TODO
    }

    // Opens site (i, j) if it is not already open.
    public void open(int i, int j) {
        // TODO
    }

    // Returns true if site (i, j) is open, and false otherwise.
    public boolean isOpen(int i, int j) {
        // TODO
        return false;
    }

    // Returns true if site (i, j) is full, and false otherwise.
    public boolean isFull(int i, int j) {
        // TODO
        return false;
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        // TODO
        return 0;
    }

    // Returns true if this system percolates, and false otherwise.
    public boolean percolates() {
        // TODO
        return false;
    }

    // Returns an integer ID (1...n) for site (i, j).
    private int encode(int i, int j) {
        // TODO
        return 0;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.printf("%d x %d system:\n", n, n);
        StdOut.printf("  Open sites = %d\n", perc.numberOfOpenSites());
        StdOut.printf("  Percolates = %b\n", perc.percolates());
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.printf("  isFull(%d, %d) = %b\n", i, j, perc.isFull(i, j));
        }
    }
}
