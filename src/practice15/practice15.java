package practice15;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class practice15 extends ConsoleProgram {
    public void run() {

    }

    private void analyze() {

    }

    private void analyzeReader(BufferedReader read) throws IOException {
        int longestSentenceLength = 0;
        int longestWordLength = 0;
        int wordCount = 0;
        int lineCount = 0;

        String longestSentence = "";
        String longestWord = "";

        String line;
        StringTokenizer tk;
        while (true) {
            line = read.readLine();
            if (line == null)
                break;
            tk = new StringTokenizer(line);
            int currentWordCount = 0;
            while (tk.hasMoreTokens()) {
                currentWordCount++;
                wordCount++;
                String token = tk.nextToken();
                if (token.length() > longestWordLength) {
                    longestWord = token;
                    longestWordLength = token.length();
                }
            }
        }
        printResults(longestWord, wordCount, longestSentence, lineCount);
    }

    private void printResults(String longestWord, int wordCount, String longestSentence, int lineCount) {
        println("There were " + wordCount + " words in this file.");
        println("The longest word was " + longestWord);
        println("There were " + lineCount + " lines");
        println("The line containing most words was:\n" + longestSentence);

    }
}
