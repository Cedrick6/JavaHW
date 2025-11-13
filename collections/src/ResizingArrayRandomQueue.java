import java.util.Iterator;
import java.util.NoSuchElementException;
import stdlib.StdOut;
import stdlib.StdRandom;

// A data type to represent a random queue, implemented using a resizing array as the underlying data structure.
public class ResizingArrayRandomQueue<T> implements Iterable<T> {
    private T[] q; // the array
    private int n; // number of items in the array

    // Constructs an empty random queue.
    @SuppressWarnings("unchecked")
    public ResizingArrayRandomQueue() {
        // TODO
        q = (T[]) new Object[2];
        n = 0;
    }

    // Returns true if this queue is empty, and false otherwise.
    public boolean isEmpty() {
        // TODO
        return n == 0;
    }

    // Returns the number of items in this queue.
    public int size() {
        // TODO
        return n;
    }

    // Adds item to the end of this queue.
    public void enqueue(T item) {
        // TODO
        if (item == null) {
            throw new NullPointerException("item is null");
        }
        if (n == q.length) {
            resize(2 * q.length);
        }
        q[n++] = item;
    }

    // Returns a random item from this queue.
    public T sample() {
        // TODO
       if (isEmpty()) {
            throw new NoSuchElementException("Random queue is empty");
        }
        int randomIndex = StdRandom.uniform(n);
        return q[randomIndex];
    }

    // Removes and returns a random item from this queue.
    public T dequeue() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException("Random queue is empty");
        }
        int randomIndex = StdRandom.uniform(n);
        T item = q[randomIndex];
        
        q[randomIndex] = q[n - 1];
        q[n - 1] = null;  // Avoid loitering
        n--;
        
        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        
        return item;    }

    // Returns an independent iterator to iterate over the items in this queue in random order.
    public Iterator<T> iterator() {
        // TODO
        return new RandomQueueIterator();    
    }

    // Returns a string representation of this queue.
    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + ", ";
        }
        return isEmpty() ? s + "[]" : "[" + s.substring(0, s.length() - 2) + "]";
    }

    // An iterator, doesn't implement remove() since it's optional.
    private class RandomQueueIterator implements Iterator<T> {
        // TODO
        private T[] items;
        private int current;

        // Constructs an iterator.
        @SuppressWarnings("unchecked")
        public RandomQueueIterator() {
            // TODO
            items = (T[]) new Object[n];
            for (int i = 0; i < n; i++) {
                items[i] = q[i];
            }

            StdRandom.shuffle(items);
            current = 0;
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            // TODO
            return current < items.length;        
        }

        // Returns the next item.
        public T next() {
            // TODO
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator is empty");
            }
            return items[current++];
        }
    }

    // Resizes the underlying array.
    @SuppressWarnings("unchecked")
    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            if (q[i] != null) {
                temp[i] = q[i];
            }
        }
        q = temp;
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        ResizingArrayRandomQueue<Integer> q = new ResizingArrayRandomQueue<Integer>();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int r = StdRandom.uniform(10000);
            q.enqueue(r);
            sum += r;
        }
        int iterSumQ = 0;
        for (int x : q) {
            iterSumQ += x;
        }
        int dequeSumQ = 0;
        while (q.size() > 0) {
            dequeSumQ += q.dequeue();
        }
        StdOut.println("sum       = " + sum);
        StdOut.println("iterSumQ  = " + iterSumQ);
        StdOut.println("dequeSumQ = " + dequeSumQ);
        StdOut.println("iterSumQ + dequeSumQ == 2 * sum? " + (iterSumQ + dequeSumQ == 2 * sum));
    }
}
