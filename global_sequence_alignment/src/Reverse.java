// import stdlib.StdIn;
// import stdlib.StdOut;

public class Reverse {
    // Entry point.
    public static void main(String[] args) {
        // TODO

        StringBuilder input = new StringBuilder();
        for (String arg : args) {
            input.append(arg).append(" ");
        }
        input.setLength(input.length() - 1);
        input.reverse();

        System.out.println(input.toString());
    }
}
