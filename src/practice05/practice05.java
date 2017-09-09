package practice05;

import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/* class: practice05 */
/**
 * Contains solutions for problems from 5th practice seminar. Topic:
 * acm.graphics basics.
 */
@SuppressWarnings("serial")
public class practice05 extends GraphicsProgram {

	/* Method: addLineInMiddle() */
	/** Adds a horizontal line in the middle of the canvas. */
	private void addLineInMiddle() {
		double x0 = 0;
		double x1 = getWidth();
		double y0 = getHeight() * 0.5;
		double y1 = y0;
		GLine midLine = new GLine(x0, y0, x1, y1);
		add(midLine);
	}

	/* Method: drawChessBoard() */
	/** Draws 8 by 8 chessboard on canvas. */
	private void drawChessBoard() {
		int boardWidth = 8;
		int boardHeight = 8;// number of cells on board.
		double a = 55;
		double b = a;// width and height of single cell

		for (int column = 0; column < boardWidth; column++) {

			/*
			 * This loop adds a single column with boardHeight cells to the
			 * board
			 */
			for (int row = 0; row < boardHeight; row++) {

				GRect cell = new GRect(a, b);
				if ((row + column) % 2 != 0) {// the sum of cell's coordinates
												// is odd, that means we need to
												// fill with black color
					cell.setFillColor(Color.black);
					cell.setFilled(true);
				}
				add(cell, column * a, row * b);
			}
		}
	}

	/* Method: drawTriangleAndCircle() */
	/**
	 * Draws a right triangle using GLines and then draws a circle around it.
	 */
	private void drawTriangleAndCircle() {
		int radius = 160;// you can change this number to anything you want. It
							// would've been better if we created a private void
							// drawTriangleAndCircle(int radius); where the
							// radius of the circle would be passed by a caller
							// but let's save it for another day.
		double x0 = (getWidth() * 0.5) - radius;
		double y0 = getHeight() * 0.5;

		/*
		 * now that all the coordinates and measurements is done, we start
		 * drawing a right isosceles triangle
		 */

		// the first line is the hypotenuse of the triangle and it's length
		// willbe the diameter of our circle.
		GLine l1 = new GLine(x0, y0, x0 + 2 * radius, y0);

		/*
		 * this will be a cathetus, it starts excatly where previous line did
		 * but ends at a point from which you can draw a perpendicular line to
		 * our previous line's center and therefore the center of our circle
		 * (which hasn't been drawn yet) and most importantly, that endpoint
		 * will be on actual disk.
		 */
		GLine l2 = new GLine(x0, y0, x0 + radius, y0 - radius);

		// the coordinates of this line are just endpoints of previous two lines
		GLine l3 = new GLine(x0 + radius, y0 - radius, x0 + 2 * radius, y0);
		add(l1);
		add(l2);
		add(l3);
		GOval circle = new GOval(radius * 2, radius * 2);

		add(circle, x0, y0 - radius);
	}

	public void run() {
		drawChessBoard();
		// call any of the methods here to test them

	}
}
