package practice18;

import acm.program.ConsoleProgram;

import java.util.Arrays;
import java.util.StringTokenizer;

        /* class: practice18*/

/**
 * Contains solutions for problems from 18th practice seminar. Topic: arrays and
 * two-dimensional arrays.
 */
public class practice18 extends ConsoleProgram {

    public void run() {
        // TODO: test methods here.
    }

    /* Method: generateMatrix() */

    /**
     * Reads dimensions of a matrix from user and generates it.
     */
    private int[][] generateMatrix() {
        int n = readInt("n: ");
        int m = readInt("m: ");
        int[][] res = new int[n][m];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = cur;
                cur++;
            }
        }

        return res;
    }

    /* Method: printMatrix(int[][] mat) */

    /**
     * Prints passed matrix on console.
     */
    private void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {

            println(Arrays.toString(mat[i]));
        }
    }

    /* Method: readMatrix() */

    /**
     * Reads dimensions and every element of a matrix from the user and returns
     * it as result.
     */
    private int[][] readMatrix() {
        int n = readInt("n: ");
        int m = readInt("m: ");
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = readLine("Enter row " + i + ": ");
            res[i] = toIntArray(line, m);
        }
        return res;
    }

    /* Method: toIntArray(String line, int l) */

    /**
     * Converts the string that consists of l integers to a array of l length.
     */
    private int[] toIntArray(String line, int l) {
        int[] res = new int[l];
        StringTokenizer tk = new StringTokenizer(line);
        for (int i = 0; i < l && tk.hasMoreTokens(); i++) {
            res[i] = Integer.valueOf(tk.nextToken());
        }
        return res;
    }

    /* Method: checkAnagrams() */

    /**
     * Reads two strings from user, then checks if they're anagrams.
     */
    private void checkAnagrams() {
        String a = readLine("Enter String a: ");
        String b = readLine("Enter String b: ");
        if (areAnagrams(a, b)) {
            println("Those strings are anagrams!\n");
        } else {
            println("Those strings are not anagrams!\n");
        }

    }

    /* Method: areAnagrams(String a, String b) */

    /**
     * Returns whether the passed two strings are anagrams.
     */
    private boolean areAnagrams(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] charCounter = getCharCountDifferences(a, b);

        for (int i = 0; i < charCounter.length; i++) {
            if (charCounter[i] != 0)
                return false;
        }
        return true;
    }

    /* Method: getCharCountDifferences(String a, String b) */

    /**
     * Returns the array of length 26 that contains differences between how many
     * times a specific char occurs in string a and how many times that char
     * occurs in string b.
     */
    private int[] getCharCountDifferences(String a, String b) {
        int[] charCounter = new int[26];
        for (int i = 0; i < a.length(); i++) {
            charCounter[a.charAt(i) % 'a']++;
            charCounter[b.charAt(i) % 'a']--;
        }
        return charCounter;
    }

}
