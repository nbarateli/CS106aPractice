package practice11;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/* Class: OurPaint */
/**
 * A program that adds a GOval on canvas each time the user clicks or drags the
 * mouse.
 */
@SuppressWarnings("serial")
public class OurPaint extends GraphicsProgram implements MouseListener {
	/** Radius of each circle that will be drawn upon dragging */
	private static final int CIRCLE_RADIUS = 10;

	/* Method: init() */
	/** calls addMouseListeners() for the program. */
	@Override
	public void init() {
		addMouseListeners();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		addCircle(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		addCircle(e.getX(), e.getY());
	}

	/* Method: addCircle(double x, double y) */
	/** Adds a filled circle, center of which will be the passed doubles */
	private void addCircle(double x, double y) {
		GOval cir = new GOval(x - CIRCLE_RADIUS, y - CIRCLE_RADIUS, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);
		cir.setFilled(true);
		cir.setFillColor(Color.black);
		add(cir);
	}
}
