import dsa.LinkedQueue;
import stdlib.StdOut;

public class Josephus {
    // Entry point.
    public static void main(String[] args) {
        // TODO
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 1; i < m; i++) {
                queue.enqueue(queue.dequeue());
            }
            
            StdOut.println(queue.dequeue());
        }
    }
}
