package practice08;

import java.awt.Color;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/* class: practice08graphics */
/**
 * Contains solutions for GraphicsProgram problems from 8th practice seminar.
 * Topic: Generating random values.
 */
public class practice08graphics extends GraphicsProgram {
	RandomGenerator rand = RandomGenerator.getInstance();
	private final static double RADIUS_LOW = 10;
	private final static double RADIUS_HIGH = 100;
	private static final int CIRCLE_COUNT = 10000;

	public void run() {
		// test the methods here.
	}

	/* Method: drawRandomCircle(): */
	/**
	 * Draws a circle with random color and radius at random point on canvas.
	 */
	private void drawRandomCircle() {
		double radius = getRandomRadius(RADIUS_LOW, RADIUS_HIGH);
		GOval o = new GOval(radius * 2, radius * 2);
		colorizeOvalRandom(o);
		double x = rand.nextDouble(0, getWidth() - radius * 2);
		double y = rand.nextDouble(0, getHeight() - radius * 2);
		add(o, x, y);
	}

	/* Method: drawManyRandomCircles() : */
	/**
	 * Draws CIRCLE_COUNT amount of random circles on canvas.
	 */
	private void drawManyRandomCircles() {

		for (int i = 0; i < CIRCLE_COUNT; i++) {
			drawRandomCircle();
		}
	}

	/* Method: getRandomRadius(double lowerBound, double upperBound): */
	/**
	 * Generates a double between lowerBound and upperBound. Returns absolute of
	 * generated number.
	 */
	private double getRandomRadius(double lowerBound, double upperBound) {
		double result = rand.nextDouble(lowerBound, upperBound);
		return Math.abs(result);
	}

	/* Method: colorizeOval(GOval o, Color c): */
	/**
	 * Paints the passed GOval in passed color.
	 */
	private void colorizeOval(GOval o, Color c) {
		o.setColor(c);
		o.setFilled(true);
		o.setFillColor(c);
	}

	/* Method: colorizeOvalRandom(GOval o) */
	/**
	 * Paints the passed GOval in random color.
	 **/
	private void colorizeOvalRandom(GOval o) {
		Color c = rand.nextColor();
		colorizeOval(o, c);
	}

	/* Method: drawRandomCircleInCenter() */
	/**
	 * Draws a circle with random radius and color in the center of the canvas.
	 **/
	private void drawRandomCircleInCenter() {
		double radius = getRandomRadius(RADIUS_LOW, RADIUS_HIGH);
		GOval o = new GOval(radius * 2, radius * 2);
		colorizeOvalRandom(o);
		add(o, getWidth() * .5 - radius, getHeight() * .5 - radius);
	}

}
