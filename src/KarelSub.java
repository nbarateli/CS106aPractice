import stanford.karel.SuperKarel;

public class KarelSub extends SuperKarel {
	
	public void run() {
		goToSecondNumber();
		throwAwayExtra();
		takeAnswerToDest();
	}
	
	private void goToSecondNumber() {
		move();
		move();
	}
	
	private void throwAwayExtra() {
		turnAround();
		while (beepersPresent()) {
			pickSingleBeeperFromBothNumber();
			goBackToSecondNumber();
		}
	}
	
	private void pickSingleBeeperFromBothNumber() {
		pickBeeper();
		move();
		pickBeeper();
	}
	
	private void goBackToSecondNumber() {
		turnAround();
		move();
		turnAround();
	}
	
	private void takeAnswerToDest() {
		move();
		turnAround();
		while (beepersPresent()) {
			moveSingleBeeperToResult();
			goBackToFirstNumber();
		}
	}

	private void moveSingleBeeperToResult() {
		pickBeeper();
		move();
		move();
		putBeeper();		
	}
	
	private void goBackToFirstNumber() {
		turnAround();
		move();
		move();
		turnAround();
	}
}
