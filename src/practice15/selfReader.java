package practice15;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class selfReader extends ConsoleProgram {
    public void run() {
        readSelf();
    }

    private void readSelf() {
        /*
         * getClass().getSimpleName() returns the name of your class and since
         * this is a public class its filename must be the same, only ending
         * with ".java".
         */
        BufferedReader read;
        String myName = this.getClass().getSimpleName() + ".java";
        try {
            read = new BufferedReader(new FileReader("src/practice15/" + myName));
            printFile(read);
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printFile(BufferedReader read) throws IOException {
        String line;
        while (true) {
            line = read.readLine();
            if (line == null)
                break;
            println(line);
        }
    }

}
