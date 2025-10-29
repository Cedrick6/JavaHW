
import java.util.Scanner;
// import stdlib.StdIn;
// import stdlib.StdOut;

public class Reverse {
    // Entry point.

 public static String reverseInput() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        //turn the input array into one separated by a space
        while (scanner.hasNext()) {
            input.append(scanner.next()).append(" ");
        }
        scanner.close();

        String[] words = input.toString().trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        // reverse the words
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        // TODO
        //print the reverse input
        System.out.println(reverseInput());

    }
}

//. javac -d out src/Reverse.java
//. java Reverse