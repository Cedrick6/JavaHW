import stdlib.StdOut;
import stdlib.StdRandom;

public class Die {
    private int value; // the face value

    // Constructs a die.
    public Die() {
        // TODO
        this.value = -1;
    }
    
    // Rolls this die.
    public void roll() {
        // TODO
        this.value = StdRandom.uniform(1, 7); 
    }

    // Returns the face value of this die.
    public int value() {
        // TODO
        return this.value;
    }

    // Returns true if this die is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // TODO
        Die that = (Die) other;
        return this.value == that.value;
    }

    // Returns a string representation of this die.
    public String toString() {
        // TODO
        StringBuilder sb = new StringBuilder();
        switch (value) {
            case 1:
                sb.append("     \n");
                sb.append("  *  \n");
                sb.append("     ");
                break;
            case 2:
                sb.append("*    \n");
                sb.append("     \n");
                sb.append("    *");
                break;
            case 3:
                sb.append("*    \n");
                sb.append("  *  \n");
                sb.append("    *");
                break;
            case 4:
                sb.append("*   *\n");
                sb.append("     \n");
                sb.append("*   *");                
                break;
            case 5:
                sb.append("*   *\n");
                sb.append("  *  \n");
                sb.append("*   *"); 
                break;
            case 6:
                sb.append("* * *\n");
                sb.append("     \n");
                sb.append("* * *"); 
                break;
            default:
                sb.append("(unrolled)");
        }
        return sb.toString();
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        StdOut.println(die);
    }
}
// javac -d out src/Die.java
// java Die