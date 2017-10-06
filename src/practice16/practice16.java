package practice16;

import acm.program.ConsoleProgram;

        /* class: practice16 */

/**
 * Contains solutions for problems from 16th practice seminar. Topic: arrays.
 */

public class practice16 extends ConsoleProgram {

    @Override
    public void init() {

        setFont("consolas-24");
    }

    public void run() {
        read();
        // test methods here
    }

    /* Method: read() */

    /**
     * Reads an array of integers prints it and its biggest and next biggest
     * element.
     */
    private void read() {
        int[] ar = readIntArray();
        printArray(ar);
        printMaxAndNextBest(ar);
    }

    /* Method: printArray(int[] ar) */

    /**
     * Prints the elements of passed array on console.
     */
    private void printArray(int[] ar) {
        print("[");
        for (int i = 0; i < ar.length; i++) {
            print(ar[i]);
            if (i != ar.length - 1)
                print(", ");
        }
        println("]");
    }

    /* Method: readIntArray() */

    /**
     * Asks user for a size of array then aks to enter each element. Returns the
     * filled array as result.
     */
    private int[] readIntArray() {
        int size = readInt("Enter size of the array: ");
        println("Now enter the elements: ");

        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt("Enter next element: ");
        }
        return res;
    }

    /* Method: isSorted(int[] array) */

    /**
     * Retursn whether the passed array is sorted in ascending order.
     */
    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1])
                return false;
        }
        return true;
    }

    /* Method: printMaxAndNextBest(int[] array) */

    /**
     * Prints the biggest and next biggest element of the array on console .
     */
    private void printMaxAndNextBest(int[] array) {

        int max = array[0];
        int netxtBest = array.length > 1 ? array[1] : array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                netxtBest = max;
                max = array[i];
            } else if (array[i] > netxtBest && array[i] != max) {
                netxtBest = array[i];
            }
        }
        println("The biggest elemnet was: " + max);
        println("The next biggest was: " + netxtBest);
    }
}
