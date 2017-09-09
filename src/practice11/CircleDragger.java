package practice11;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/* class: CircleDragger */
/**
 * A program that lets the user drag an oval on the screen and changes its color
 * every time they do it.
 */
@SuppressWarnings("serial")
public class CircleDragger extends GraphicsProgram implements Runnable {
	/** Radius of the circle */
	private final int	CIRCLE_RADIUS	= 50;
	/** The main circle. */
	private GOval		circle;
	/** A RandomGenerator that will be used throughout the program. */
	RandomGenerator		rand			= RandomGenerator.getInstance();

	public void init() {
		addMouseListeners();
	}

	/* Method: run() */
	/** Adds the main circle on canvas. */
	public void run() {
		addCircle();
	}

	/* Method: addCircle() */
	/** Initializes and adds main circle. */
	private void addCircle() {
		circle = new GOval(CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);
		add(circle, getWidth() * .5 - CIRCLE_RADIUS, getHeight() * .5 - CIRCLE_RADIUS);
		colorizeOval(circle, rand.nextColor());
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

	/* Method: mouseReleased(MouseEvent e) */
	/** Takes care of coloring the circle after the dragging is done. */
	@Override
	public void mouseReleased(MouseEvent e) {

		if (wasPressed) {
			colorizeOval(circle, rand.nextColor());
		}
		wasPressed = false;
	}

	/* Method: mouseDragged(MouseEvent e) */
	/** Drags the circle. */
	public void mouseDragged(MouseEvent e) {
		if (wasPressed) {
			moveCircle(e.getX(), e.getY());
		}
	}

	private boolean wasPressed = false;

	/* Method: mousePressed(MouseEvent e) */
	/**
	 * Makes sure that mouseDragged and mouseReleased don't do anything unless
	 * the pressed object was the main circle.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (getElementAt(new GPoint(e.getPoint())) == circle) {
			wasPressed = true;
		}
	}

	/* Method: moveCircle(double x, double y) */
	/** Moves the center of the main circle at given coordinates */
	private void moveCircle(double x, double y) {
		circle.setLocation(x - CIRCLE_RADIUS, y - CIRCLE_RADIUS);
	}
}
