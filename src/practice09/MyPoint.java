package practice09;

/* class: MyPoint */
/**
 * A class for a two-dimensional point. It stores its x and y as doubles, can
 * move itself, return values of x and y and its own string representation
 * formatted as "(x, y)".
 */
public class MyPoint {
	/** MyPoint constructor */
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/* Method: translation(double dx, double dy): */
	/**
	 * Moves x of point by dx and y by dy units.
	 */
	public void translation(double dx, double dy) {
		x += dx;
		y += dy;
	}

	/* Method: toString(): */
	/**
	 * Converts object information into a printable String representation.
	 */
	public String toString() {
		String result = "(" + x + ", " + y + ")";

		return result;
	}

	/* Method: getX(): */
	/**
	 * Returns the x coordinate of the point.
	 */
	public double getX() {

		return x;
	}

	/* Method: getY(): */
	/**
	 * Returns the y coordinate of the point.
	 */
	public double getY() {

		return y;
	}

	/** x coordinate of the point */
	private double x;
	/** y coordinate of the point */
	private double y;

}
