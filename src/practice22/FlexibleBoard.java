package practice22;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class FlexibleBoard extends GraphicsProgram implements ComponentListener {

	private static final int	N_ROWS	= 8;
	private static final int	N_COLS	= 8;

	@Override
	public void init() {
		drawBoard(N_ROWS, N_COLS);
		addComponentListener(this);
	}

	/* Method: drawBoard(nRows, nCols) */
	/** Draws a nRows x nCols board on canvas. */
	private void drawBoard(int nRows, int nCols) {
		double a = (double) getWidth() / nCols;
		double b = (double) getHeight() / nRows;
		drawChessBoard(a, b, nRows, nCols);
	}

	/* Method: drawChessBoard(a, b, nRows, nCols) { */
	/** Draws nrows x ncols chessboard on canvas. */
	private void drawChessBoard(double a, double b, int nRows, int nCols) {
		for (int row = 0; row < nRows; row++) {
			drawChessRow(a, b, row, nCols);
		}
	}

	/* Method: drawChessRow(a, b, row, nCols) */
	/** Draws a single chess-pattern row. */
	private void drawChessRow(double a, double b, int row, int nCols) {
		double y = row * b;
		for (int col = 0; col < nCols; col++) {
			GRect cell = new GRect(a, b);
			if ((row + col) % 2 == 0)
				cell.setFilled(true);
			add(cell, col * a, y);
		}
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		reset();
	}

	private void reset() {
		removeAll();
		drawBoard(N_ROWS, N_COLS);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
