import java.util.Iterator;
import java.util.NoSuchElementException;
import stdlib.StdOut;
import stdlib.StdRandom;

// A data type to represent a double-ended queue (aka deque), implemented using a doubly-linked list as the underlying 
// data structure.
public class LinkedDeque<T> implements Iterable<T> {
    private Node first; // the first node in the linked list
    private Node last;  // the last node in the linked list
    private int n;      // the number of nodes in the linked list

    // Constructs an empty deque.
    public LinkedDeque() {
        // TODO
    }

    // Returns true if this deque is empty, and false otherwise.
    public boolean isEmpty() {
        // TODO
        return false;
    }

    // Returns the number of items in this deque.
    public int size() {
        // TODO
        return 0;
    }

    // Adds item to the front of this deque.
    public void addFirst(T item) {
        // TODO
    }

    // Adds item to the back of this deque.
    public void addLast(T item) {
        // TODO
    }

    // Returns the item at the front of this deque.
    public T peekFirst() {
        // TODO
        return null;
    }

    // Removes and returns the item at the front of this deque.
    public T removeFirst() {
        // TODO
        return null;
    }

    // Returns the item at the back of this deque.
    public T peekLast() {
        // TODO
        return null;
    }

    // Removes and returns the item at the back of this deque.
    public T removeLast() {
        // TODO
        return null;
    }

    // Returns an iterator to iterate over the items in this deque from front to back.
    public Iterator<T> iterator() {
        // TODO
        return null;
    }

    // Returns a string representation of this deque.
    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + ", ";
        }
        return isEmpty() ? s + "[]" : "[" + s.substring(0, s.length() - 2) + "]";
    }

    // A deque iterator.
    private class DequeIterator implements Iterator<T> {
        // TODO

        // Constructs an iterator.
        public DequeIterator() {
            // TODO
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            // TODO
            return false;
        }

        // Returns the next item.
        public T next() {
            // TODO
            return null;
        }
    }

    // A data type to represent a doubly-linked list. Each node in the list stores a generic item
    // and references to the next and previous nodes in the list.
    private class Node {
        private T item;  // the item
        private Node next;  // the next node
        private Node prev;  // the previous node
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its several powers, having " +
                "been originally breathed into a few forms or into one; and that, whilst this " +
                "planet has gone cycling on according to the fixed law of gravity, from so simple" +
                " a beginning endless forms most beautiful and most wonderful have been, and are " +
                "being, evolved. ~ Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        StdOut.println("Filling the deque...");
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.printf("The deque (%d characters): ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        StdOut.println("Emptying the deque...");
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }
        StdOut.println("deque.isEmpty()? " + deque.isEmpty());
    }
}
