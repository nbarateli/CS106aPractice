import stanford.karel.SuperKarel;

public class KarelFill extends SuperKarel {

	public void run() {
		fillWhenSingleColumn();
		fillWhenSeveralColumns();
	}
	
	private void fillWhenSingleColumn() {
		if (frontIsBlocked()) {
			turnLeft();
			fillLine();
		}		
	}
	
	private void fillWhenSeveralColumns() {
		while (frontIsClear()) {
			fillLine();
			goBack();
			goUp();
		}		
	}
	
	private void fillLine() {
		while (frontIsClear()) {
			clearAndPutBeeper();
			move();
		}
		clearAndPutBeeper();
	}
	
	private void clearAndPutBeeper() {
		while (beepersPresent()) {
			pickBeeper();
		}
		putBeeper();
	}
	
	private void goBack() {
		turnAround();
		while (frontIsClear()) {
			move();
		}		
	}
	
	private void goUp() {
		turnRight();
		if(frontIsClear()) {
			move();
		} else {
			turnLeft();
		}
		turnRight();
	}
}
