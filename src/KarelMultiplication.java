import stanford.karel.SuperKarel;

public class KarelMultiplication extends SuperKarel {

	public void run() {
		goToFirstNumber();
		doMultiplication();
	}
	
	/**
	 * Pre 	- Karel is on first number looking right 
	 * Post	- On 1x4 point are n*m beepers
	 * 
	 */
	private void doMultiplication() {
		while (beepersPresent()) {
			pickBeeper();
			addSecondNumberToResult();
			goBackToFirstNumber();
		}
	}
	
	/**
	 * Pre 	- Karel is on first number looking right
	 * Post	- Karel is on reserve point looking left
	 * 
	 */
	private void addSecondNumberToResult() {
		move();
		while (beepersPresent()) {
			pickBeeper();
			move();
			putBeeper();
			move();
			putBeeper();
			goBackToSecondNumber();
		}
		
		restoreSecondNumber();
	}

	/**
	 * Pre 	- 
	 * Post	-
	 * 
	 */
	private void restoreSecondNumber() {
		goToReservePoint();
		while (beepersPresent()) {
			pickBeeper();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();
			turnAround();
		}
	}
	
	/**
	 * Pre 	- 
	 * Post	-
	 * 
	 */
	private void goToReservePoint() {
		move();
		move();
		turnAround();
	}
	
	/**
	 * Pre 	- 
	 * Post	-
	 * 
	 */
	private void goBackToFirstNumber() {
		move();
		move();
		move();
		turnAround();
	}
	
	/**
	 * Pre 	- 
	 * Post	-
	 * 
	 */
	private void goBackToSecondNumber() {
		turnAround();
		move();
		move();
		turnAround();
	}

	
	/**
	 * Pre 	- 
	 * Post	-
	 * 
	 */
	private void goToFirstNumber() {
		move();
	}
}
