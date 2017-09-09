package practice12;

import acm.program.ConsoleProgram;

/*class: practice12 */
/**
 * Contains solutions for problems from 12th practice seminar. Topic: Java
 * String basics.
 */
public class practice12 extends ConsoleProgram {
	public void run() {
		// test methods here
	}

	/* Method: textStatistics() */
	/**
	 * Asks user for input and then calls getStatistics methods on entered
	 * string.
	 */
	private void textStatistics() {
		String s = readLine("Enter text: ");
		getStatistics(s);
	}

	/* Method: getStatistics(String s) */
	/**
	 * Prints how many times each lowercase character of english alphabet occurs
	 * in passed string.
	 */
	private void getStatistics(String s) {
		for (char c = 'a'; c <= 'z'; c++) {
			int count = getCharCount(s, c);
			if (count > 0) {// we skip all characters that don't occur in passed
							// string.
				println(c + ": " + count);
			}
		}
	}

	/* Method: getCharCount(String s, char c) */
	/** Returns number of occurences of passed character in passed string. */
	private int getCharCount(String s, char c) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				res++;
			}
		}
		return res;
	}

	/* Method: checkPalindrome(String s) */
	/** Checks whether passed string is a palindrome and prints the result. */
	private void checkPalindrome(String s) {

		if (isPalindrome(s)) {
			println("That's a palindrome!");
		} else {
			println("Sorry! That's not a palindrome. Try again later.");
		}

	}

	/* Method: checkPalindromes() */
	/**
	 * Asks user for input, then calls checkPalindrome() method on entered
	 * string.
	 */
	private void checkPalindromes() {
		String s = readLine("Enter your string: ");
		checkPalindrome(s);

	}

	/* Method: isPalindrome(String s) */
	/** Returns whether the passed string is a palindrome. */
	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
}
