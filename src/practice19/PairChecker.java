package practice19;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

        /* class: PairChecker */

/**
 * A runnable console program that reads number m followed by another numbers
 * and prints every pair of number in given list sum of which equals to m.
 */
@SuppressWarnings("serial")
public class PairChecker extends ConsoleProgram {

    private static final int SENTINEL = -1;

    public void run() {
        setFont("consolas-22");
        checkPairs();

    }

    /* Method: checkPairs() */

    /**
     * Reads the number based on which we're gonna search for pairs, then reads
     * the actual list of numbers and prints result.
     */
    private void checkPairs() {
        int m = readInt("Enter m: ");

        ArrayList<Integer> nums = readNumbers(SENTINEL);
        ArrayList<String> pairs = getPairs(nums, m);

        println("Here are pairs of numbers that give " + m + " as their sum.");
        println(pairs.toString());
    }

    /* Method: getPairs(ArrayList<Integer> nums, int m) */

    /**
     * Returns list of pairs of every number in passed ArrayList sum of which is
     * m.
     */
    private ArrayList<String> getPairs(ArrayList<Integer> nums, int m) {
        ArrayList<String> pairs = new ArrayList<String>();
        Map<Integer, Integer> counts = getNumCounts(nums);
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);

            if ((m == n) && counts.get(n) > 1)
                pairs.add(n + " & " + (m - n));
            else if (nums.contains(m - n)) {
                if (!pairs.contains((m - n) + " & " + n))
                    pairs.add(n + " & " + (m - n));
            }
        }
        return pairs;
    }

    /* Method: getNumCounts(ArrayList<Integer> nums) */

    /**
     * Returns a map that contains each unique integer in "nums" as keys and how
     * many times they occur as values.
     */
    private Map<Integer, Integer> getNumCounts(ArrayList<Integer> nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            int count = counts.containsKey(n) ? counts.get(n) + 1 : 1;
            counts.put(n, count);
        }
        return counts;
    }

    /* Method: readNumbers(int sentinel) */

    /**
     * Reads numbers from user until they enter sentinel value, puts them in
     * ArrayList and returns it as result.
     */
    private ArrayList<Integer> readNumbers(int sentinel) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (true) {
            int n = readInt("? ");
            if (n == sentinel)
                break;
            res.add(n);
        }
        return res;
    }

}
