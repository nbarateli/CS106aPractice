package practice08;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

        /* class practice08console */

/**
 * Contains solutions for ConsoleProgram problems from 8th practice seminar.
 * Topic: Generating random values.
 */
public class practice08console extends ConsoleProgram {
    /**
     * Random Generator that will be used throughout the program.
     */
    RandomGenerator rand = new RandomGenerator();
    /**
     * Amount of money that the player has when the game starts.
     */
    private static final int STARTING_MONEY = 1000;

    public void run() {
        // test methods here
    }

    /* Method: playRoulette(int startingMoney): */

    /**
     * Starts a roulette game with "startingMoney" as base amount of money.
     * Until user has any cash left, asks them to enter a bet, and a number
     * they're betting on. Prints every result.
     */
    private void playRoulette(int startingMoney) {
        int money = startingMoney;
        while (money > 0) {
            println("Your have $" + money + " on you!");// you have to tell them
            // how much they have or
            // they will spend
            // carelessly!
            int bet = getRouletteBet(money);
            money -= bet;// subtracting bet from total amount immediately after
            // getting it.
            int chosenNumber = getRouletteNumber();
            if (numberWasGuessed(chosenNumber)) {
                println("You won $" + bet * 36 + "!");
                money += bet * 36;
            } else {
                println("You lost your bet.");
            }
        }
        println("You don't have any money anymore.");
    }

    /* Method: getRouletteBet(int currentMoney): */

    /**
     * Asks user for an input, compares if the amount is not negative or exceed
     * current amount of money. Returns bet as result.
     */
    private int getRouletteBet(int currentMoney) {
        int bet = readInt("Place a bet!: ");
        while (bet < 0 || bet > currentMoney) {// this loop will ONLY START when
            // user enters unacceptable
            // amount of money.
            bet = readInt("You don't have that much money!: ");
        }
        return bet;
    }

    /* Method: getRouletteNumber(): */

    /**
     * Asks user to enter number, checks it's validity and returns the input as
     * result.
     */
    private int getRouletteNumber() {
        int chosenNumber = readInt("Select your number: ");
        while (chosenNumber < 0 || chosenNumber > 36) {// this loop will ONLY
            // START when user
            // enters a number that
            // is not on desk.
            chosenNumber = readInt("Please enter a number within 0-36: ");
        }
        return chosenNumber;
    }

    /* Method: numberWasGuessed(int n) */

    /**
     * Generates a random nuber between 0 and 36, compares it with passed int.
     * Returns true if the values are equal.
     */
    private boolean numberWasGuessed(int n) {
        int rouletteResult = rand.nextInt(0, 36);
        if (n == rouletteResult) {
            println("You've guessed right!");
            return true;
        }
        println("You've guessed wrong! The number is " + rouletteResult + ".");
        return false;
    }

    /* Method: simulateRoulette(): */

    /**
     * Simulates just one Roulette turn. Asks user for input and prints the
     * result.
     */
    private void simulateRoulette() {
        int chosenNumber = getRouletteNumber();
        if (numberWasGuessed(chosenNumber)) {
            println("You won!");
        } else {
            println("You lost.");
        }
    }

    /* Method: coinFlipping(): */

    /**
     * Flips a "coin" until the result is 0.
     */
    private void coinFlipping() {
        while (true) {
            int coin = rand.nextInt(0, 1);
            if (coin == 0) {
                println(coin + " (Heads!)");
                break;
            } else {
                println(coin + " (Tails!)");
            }
        }
    }
}
