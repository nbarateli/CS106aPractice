package practice19;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

/* class: UniqueStringsChecker */
/** Reads multiple strings from user, then prints the unique ones. */
@SuppressWarnings("serial")
public class UniqueStringsChecker extends ConsoleProgram {

	public void run() {
		checkUniques();
	}

	/* Method: checkUniques() */
	/** Reads input from user and prints unique strings */
	private void checkUniques() {
		ArrayList<String> lines = readUniqueStrings();
		printUniqueStrings(lines);
	}

	/* Method: printUniqueStrings(ArrayList<String> lines) */
	/** Prints passed arraylist on console. */
	private void printUniqueStrings(ArrayList<String> lines) {
		println("Here are unique strings from your list: ");
		println(lines.toString());
	}

	/* Method: readUniqueStrings() */
	/**
	 * Reads strings from user and stores them in ArrayList in a way that each
	 * string will occur only one time.
	 */
	private ArrayList<String> readUniqueStrings() {
		ArrayList<String> res = new ArrayList<String>();
		while (true) {
			String line = readLine("? ");
			if (line.length() == 0)
				break;
			if (!res.contains(line))
				res.add(line);
		}

		return res;
	}
}
