 
import stanford.karel.SuperKarel;

public class KarelDivide extends SuperKarel {

	/*
	 *          0 1 2 3 4 5
	 * World:  [K 6 2 0 0 0]
	 * Result: [0 0 0 3 0 K]
	 * Assumptions: number in cell 1 is divisible by number in cell 2
	 */
	public void run()   {
		move();
		divide();
		cleanUp();
	}
	
	/*
	 * Precondition: looking east, standing on a cell corresponding to dividend
	 * Postcondition: looking east, standing where started
	 */
	private void divide() {
		move();
		saveDivisor();
		goBackByOne();
		while (beepersPresent()) {
			subtract();
			copyDivisorBack();
			addOneToResult();
			goBackByOne();
		}
	}
	
	/*
	 * Makes a copy of divisor cell in the last cell (buffer)
	 * 
	 * Precondition: looking east, standing on a cell corresponding to divisor
	 * Postcondition: looking east, standing where started
	 */
	private void saveDivisor() {
		moveDivisorToBuffer();
		copyDivisorBack();
	}

	/*
	 * Relocated all beepers in divisor cell to the last cell (buffer)
	 * 
	 * Precondition: looking east, standing on a cell corresponding to divisor
	 * Postcondition: looking east, standing where started
	 */
	private void moveDivisorToBuffer() {
		while (beepersPresent()) {
			pickBeeper();
			moveThreeTimes();
			putBeeper();
			goBackByThree();
		}
	}
	
	/*
	 * Makes a copy of all beepers in buffer (last cell) to divisor cell
	 * 
	 * Precondition: looking east, standing on a cell corresponding to divisor
	 * Postcondition: looking east, standing where started
	 */
	private void copyDivisorBack() {
		moveThreeTimes();
		turnAround();
		// one duplicate is located into the next cell, the other one - into divisor cell 
		makeDuplicates();
		carryPileBack();
		moveThreeTimes();
		turnAround();
	}	
	
	/*
	 * Makes two copies of current pile of beepers
	 * 
	 * Precondition: standing on a pile of beepers to be duplicated
	 * Postcondition: standing on a cell where started and facing in the same direction as when started
	 */
	private void makeDuplicates() {
		while (beepersPresent()) {
			pickBeeper();
			move();
			putBeeper();
			move();
			move();
			putBeeper();
			goBackByThree();
		}
	}
	
	/*
	 * Carry a pile of beepers from the next cell to the current
	 * 
	 * Precondition: a pile of beepers to be carried here are right in front
	 * Postcondition: standing where started, facing in the same direction
	 */
	private void carryPileBack() {
		move();
		while (beepersPresent()) {
			pickBeeper();
			goBackByOne();
			putBeeper();
			move();
		}
		goBackByOne();
	}
	
	/* 
	 * Subtracts all beepers from the next cell from beepers in current cell, for example
	 * 
	 * Precondition:  [a 	 b 	  0], standing on 'a', facing east
	 * Postcondition: [(a-b) 0 	  0], standing on '(a-b)', facing east
	 */
	private void subtract() {
		move();
		while (beepersPresent()) {
			pickBeeper();
			goBackByOne();
			pickBeeper();
			move();
		}
	}
	
	/*
	 * Adds one beeper to the resulting pile (at cell indexed 3)
	 * 
	 * Precondition: facing east, standing on divisor cell
	 * Postcondition: facing east, standing where started
	 */
	private void addOneToResult() {
		move();
		putBeeper();
		goBackByOne();
	}
	
	/*
	 * Clean the board up after performing division
	 * 
	 * Precondition: facing east, standing on divident cell
	 * Postcondition: facing east, standing on the last cell
	 */
	private void cleanUp() {
		cleanUpDivisor();
		cleanUpBuffer();
	}
	
	private void cleanUpDivisor() {
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
	}
	
	private void cleanUpBuffer() {
		moveThreeTimes();
		while (beepersPresent()) {
			pickBeeper();
		}
	}
	
	private void moveThreeTimes() {
		move();
		move();
		move();
	}
	
	private void goBackByOne() {
		turnAround();
		move();
		turnAround();
	}

	private void goBackByThree() {
		turnAround();
		moveThreeTimes();
		turnAround();
	}
	
}
