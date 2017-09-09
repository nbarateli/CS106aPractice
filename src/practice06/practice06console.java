package practice06;

import acm.program.ConsoleProgram;

/* class: practice06console */
/**
 * Contains solutions for ConsoleProgram problems from 6th practice seminar.
 * Topic: Loops.
 */
@SuppressWarnings("serial")
public class practice06console extends ConsoleProgram {

	/** A constant up to which fibonacci numbers will be printed */
	private static final int MAX_FIBONACCI = 50;
	/** A constant that gives the user ability to let us know when to stop the loop. */
	private static final int SENTINEL = -1;

	/* Method: printFibonacci(): */
	/**
	 * Prints every Fibonacci number from 1 to MAX_FIBONACCI.
	 */
	private void printFibonacci() {
		int f = 1;// this will be our current fibonacci number
		int f1 = 1;// this is the 2nd fibonnaci number

		int f2 = f + f1;// this is the one that is calculated by adding 1st and
						// 2nd... you guessed it: the third one.

		while (f < MAX_FIBONACCI) {
			println(f);
			f = f1;
			f1 = f2;
			f2 = f + f1;
		}
	}

	/* Method: checkPrime(int n): */
	/**
	 * Checks if the passed number is prime. Prints the result.
	 */
	private void checkPrime(int n) {
		boolean isPrime = true;

		if (n != 2 && n % 2 == 0) {// first we check if the number is neither 2
									// nor divisable by 2
			isPrime = false;
		} else {
			for (int div = 3; div <= Math.sqrt(n); div += 2) {
				/*
				 * if we're past that, that means our number will only have odd
				 * divisors (if any at all), so we start checking if it can be
				 * divided by any odd number starting from 3 to the square root
				 * of our number.
				 */
				if (n % div == 0) {
					isPrime = false;
					break;
				}
			}
		}
		if (isPrime) {
			println(n + " is prime!");
		} else
			println(n + " is composite.");

	}

	/* Method: checkPrimes(): */
	/**
	 * Checks number that user enters for being prime, until they enter SENTINEL
	 * value.
	 */
	private void checkPrimes() {
		/*
		 * You've seen this one on lecture. come on... there's no need for me to
		 * explain this...
		 */
		while (true) {// so on each iteration
			// you ask the user to enter the number
			int n = readInt("Enter a number to check if it's prime: ");
			if (n == SENTINEL)// if it eqauls to your SENTINEL constant,
				break;// you break that cycle.
			checkPrime(n);// if not, you pass that number to your beloved method
			// and whoala, back to the start of loop.
		}

	}

	public void run() {
		// test the methods right here.
	}
}
