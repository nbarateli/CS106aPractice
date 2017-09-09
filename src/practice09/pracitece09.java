package practice09;

import acm.program.ConsoleProgram;

/**
 * Contains solutions for problems from 9th practice. Topic: creating our own
 * classes.
 */
@SuppressWarnings("serial")
public class pracitece09 extends ConsoleProgram {
	public void run() {
		calculateDistance();
	}

	/* Method: calculateDistance() */
	/**
	 * Reads parameters of two points from the user and prints distance between.
	 */
	private void calculateDistance() {
		MyPoint p1 = readPoint("Enter point 1: ");

		MyPoint p2 = readPoint("Enter point 1: ");
		double distance = getDistance(p1, p2);
		println("The distance between " + p1 + " and " + p2 + " is: " + distance);

	}

	/* Method: readPoint(String message) */
	/**
	 * Reads coordinates of a point from console and returns MyPoint with those
	 * parameters.
	 */
	private MyPoint readPoint(String message) {
		println(message);
		double x = readDouble("x: ");
		double y = readDouble("y: ");
		MyPoint res = new MyPoint(x, y);
		return res;
	}

	/* Method: getDistance(Mypoint p1, MyPoint p2) */
	/**
	 * Calculates and returns distance between two MyPoints.
	 */
	private double getDistance(MyPoint p1, MyPoint p2) {
		double xDiff = p2.getX() - p1.getX();// differences between x-es and y-s
												// of passed points
		double yDiff = p2.getY() - p1.getY();
		double result = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

		return result;
	}
}
