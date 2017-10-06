package practice07;

import acm.program.ConsoleProgram;

        /* class: practice07 */

/**
 * Contains solutions for problems from 7th practice seminar. Topic: Loops,
 * "half-loops".
 */
public class practice07 extends ConsoleProgram {
    /**
     * A constant that gives the user ability to let us know when to stop the
     * loop.
     */
    private static final int SENTINEL = -1;

    public void run() {
        // test the methods here.
    }

    /* Method: fibonacciLoop(): */

    /**
     * Until they enter SENTINEL value, asks user to enter integer and prints
     * corresponding fibonacci number.
     */
    private void fibonacciLoop() {
        while (true) {
            int n = readInt("Enter n: ");
            if (n == SENTINEL)
                break;
            printFibonacci(n);
        }
    }

    /* Method: nthFibonacci(int n): */

    /**
     * Returns the n-th Fibonacci number.
     */
    private int nthFibonacci(int n) {
        int f0 = 0;// the base value. this is the value we'll operate on n
        // times.
        int f1 = 1;
        int f2 = 0;
        for (int i = 0; i < n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f0;
    }

    /* Method: printFibonacci(int n): */

    /**
     * Checks if number n is positive, then prints the n-th fibonacci number.
     */
    private void printFibonacci(int n) {
        if (n <= 0) { // There is no -42th fibonacci number. Get over it.
            println("Error: n should be positive.");
        } else {
            println(nthFibonacci(n));
        }
    }

    /* Method: printFirstNthFibonacci(int n): */

    /**
     * Checks if number n is positive, then prints the n-th fibonacci number.
     */
    private void printFirstNthFibonnaci(int n) {
        if (n <= 0) {
            println("Error: n should be positive.");
            return;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        for (int i = 0; i < n; i++) {// Instead of calling the nthFibonacci or
            // printFibonacci methods we make our
            // own loop. Because doing otherwise
            // would result n separate loops and we
            // can't afford that much time.
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
            println(f0);
        }

    }

    /* Method: printReverse(int n): */

    /**
     * Prints the reverse of decimalrepresentation of n.
     */
    private void printReverse(int n) {
        if (n <= 0) {// It's not really gonna do anything if number is not
            // greater than zero but you gotta warn the guy.
            println("Number should be positive");
        }
        print("The reverse is: ");
        while (n > 0) {
            print(n % 10);// n mod 10 gives us the most right digit of n so we
            // print that first
            n /= 10;// by dividing n with 10 we're left with everything left of
            // that digit we just printed
        }
        println();
    }

    /* Method: printBinaryReverse(int n): */

    /**
     * Prints the reverse of binary representation of n.
     */
    private void printBinaryReverse(int n) {
        // it works exactly with the same logic of printReverse.
        if (n <= 0) {
            println("Number should be positive");
            return;
        }
        print("The binary reverse is: ");
        while (n > 0) {
            print(n % 2);
            n /= 2;
        }
        println();
    }

    /* Method: printAnyBaseReverse(int n, int k): */

    /**
     * Prints the reverse of k-base numeric system representation of n.
     */
    private void printAnyBaseReverse(int n, int k) {
        if (n <= 0) {
            println("Number should be positive");
            return;
        }
        if (k < 2 || k > 10) {// since we only have 10 digits, we can't afford
            // more than base 10 numeric system.
            println("Can't calculate from this base.");
            return;
        }
        print("The reverse in numeric system with " + k + " as base is: ");
        while (n > 0) {
            print(n % k);
            n /= k;
        }
        println();
    }

}
