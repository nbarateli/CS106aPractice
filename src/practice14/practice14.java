package practice14;

import acm.graphics.GOval;
import acm.program.ConsoleProgram;

        /* class: practice14 */

/**
 * Contains solutions for problems from 14th practice seminar. Topics: Memory
 * basics and immutable classes.
 */
public class practice14 extends ConsoleProgram {
    @Override
    public void run() {

        // test the methods here
    }

    /* Method: testOperations() */

    /**
     * Passes two Objects of different classes (String and GOval) in separate
     * methods to test their behaviour afterwards.
     */
    private void testOperations() {
        String s = "abc";
        GOval o = new GOval(1, 1);

        println(s);
        changeString(s);
        println(s);

        println("Width: " + o.getWidth() + " Height: " + o.getHeight());
        changeOval(o);
        println("Width: " + o.getWidth() + " Height: " + o.getHeight());
    }

    /* Method: changeOval(GOval o) */

    /**
     * Changes the size of passed GOval to 2, 2.
     */
    private void changeOval(GOval o) {
        o.setSize(2, 2);
    }

    /* Method: changeString(String s) */

    /**
     * Changes the value of the passed string to "aaa"
     */
    private void changeString(String s) {
        s = "aaa";
    }

}
