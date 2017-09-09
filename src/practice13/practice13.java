package practice13;

import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

/* class: practice13 */
/**
 * Contains solutions for problems from 13th practice seminar. Topics:
 * StringTokenizer, working with strings.
 */
@SuppressWarnings("serial")
public class practice13 extends ConsoleProgram {

	@Override
	public void run() {
		// test the methods here
	}

	/* Method: printAtbash() */
	/**
	 * Reads a string from user, applies Atbash cipher on it and prints the
	 * rsult.
	 */
	private void printAtbash() {
		String text = readLine("Enter text you want to cipher: ");
		String cipheredText = toAtbash(text);
		println("This is what your text ciphered with Atbash cipher looks like:");
		println(cipheredText);
	}

	/* Method: toAtbash(String text) */
	/**
	 * Applies Atbash cipher on a passed string, returns ciphered string as
	 * result.
	 */
	private String toAtbash(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (Character.isAlphabetic(ch)) {
				ch = cipherChar(ch, Character.isUpperCase(ch));
			}
			result += ch;
		}
		return result;
	}

	/* Method: cipherChar(char ch, boolean isUpperCase) */
	/** Returns a character that you'd get by applying Atbash cipher on it. */
	private char cipherChar(char ch, boolean isUpperCase) {
		if (isUpperCase) {
			return (char) ('Z' - (ch - 'A'));
		}
		return (char) ('z' - (ch - 'a'));
	}

	/* Method: printWords() */
	/**
	 * Asks user to enter a sentence and prints all the words that are in that
	 * sentece.
	 */
	private void printWords() {
		String text = readLine("Enter text: ");
		StringTokenizer tk = new StringTokenizer(text, " ,.;:?!");
		println("Here are the words in your sentence");
		for (int i = 1; tk.hasMoreTokens(); i++) {
			println(i + ") " + tk.nextToken());
		}
	}

	/* Method: subtractText() */
	/**
	 * Asks the user to enter two strings and prints the first string without
	 * any occurence of the second string.
	 */
	private void subtractText() {
		String text1 = readLine("Enter first text: ");
		String text2 = readLine("Enter second text: ");
		String result = removeText(text1, text2);
		println(result);
	}

	/* Method: removeText(String text1, String text2) */
	/** Returns the first string without any occurence of the second string */
	private String removeText(String text1, String text2) {

		while (true) {
			int i = text1.indexOf(text2);
			if (i == -1)
				break;
			text1 = text1.substring(0, i) + text1.substring(i + text2.length());
		}

		return removeExtraWhiteSpaces(text1);
	}

	/* Method: removeExtraWhiteSpaces(String s) */
	/** Returns passed string without any adjacent whitespaces. */
	private String removeExtraWhiteSpaces(String s) {
		String result = "";
		StringTokenizer tk = new StringTokenizer(s);
		while (tk.hasMoreTokens()) {
			result += tk.nextToken() + " ";
		}
		return result.substring(0, result.length() - 1);
	}

	/* Method: subtractCharacters() */
	/**
	 * Asks user to enter two Strings and prints the first string without any
	 * occurence of characters from the second string.
	 */
	private void subtractCharacters() {
		String text = readLine("Enter text: ");
		String charsToRemove = readLine("Enter characters that you want to remove: ");
		String result = removeCharacters(text, charsToRemove);
		println(result);
	}

	/* Method: removeCharacters(String text, String charsToRemove) */
	/**
	 * Returns a verion of first string without any occurence of characters from
	 * the second string.
	 */
	private String removeCharacters(String text, String charsToRemove) {
		String result = "";
		StringTokenizer tk = new StringTokenizer(text, charsToRemove);
		while (tk.hasMoreTokens()) {
			result += tk.nextToken();
		}
		return result;
	}

}
