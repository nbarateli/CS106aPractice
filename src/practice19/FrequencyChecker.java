package practice19;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

        /* class: FrequencyChecker */

/**
 * A program that lets user to enter multiple strings, then prints how many
 * times each string was entered.
 */
@SuppressWarnings("serial")
public class FrequencyChecker extends ConsoleProgram {
    public void run() {
        checkFrequencies();
    }

    /* Method: checkFrequencies() */

    /**
     * Reads strings from user then prints out how many times each string was
     * entered.
     */
    private void checkFrequencies() {
        ArrayList<String> lines = readList();
        Map<String, Integer> frequencies = getFrequencies(lines);

        println("Here are frequencies of your strings: ");
        println(frequencies.toString());
    }

    /* Method: getFrequencies(ArrayList<String> lines) */

    /**
     * Returns a string-integer map that as values has amount of times each
     * string occures in passed ArrayList.
     */
    private Map<String, Integer> getFrequencies(ArrayList<String> lines) {
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        for (int i = 0; i < lines.size(); i++) {
            String next = lines.get(i);
            int count = res.containsKey(next) ? res.get(next) + 1 : 1;
            res.put(next, count);
        }
        return res;
    }

    /* Method: readList() */

    /**
     * Reads strings from user, puts it in ArrayList and returns that list as
     * result.
     */
    private ArrayList<String> readList() {
        ArrayList<String> lines = new ArrayList<String>();
        while (true) {
            String line = readLine("? ");
            if (line.length() == 0)
                break;
            lines.add(line);
        }
        return lines;
    }

}
