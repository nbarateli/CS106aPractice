package practice06;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/* class: practice06graphics */
/**
 * Contains solutions for GraphicsProgram problems from 6th practice seminar.
 * Topic: Loops.
 */
public class practice06graphics extends GraphicsProgram {
	/** Number of cells in tic-tac-toe board. */
	private static final int NUM_CELLS = 3;
	/** Size of a side of each cell. */
	private static final int CELL_SIZE = 70;

	/* Method: drawColumn(int numCells, int cellSize, double x, double y): */
	/**
	 * Draws a column thet consists of numCells square cells with cellSize size
	 * of sides on (x, y) point of canvas.
	 */
	private void drawColumn(int numCells, int cellSize, double x, double y) {
		for (int i = 0; i < numCells; i++) {
			GRect cell = new GRect(cellSize, cellSize);
			add(cell, x, y + i * cellSize);// the y coordinate of the cell grows
											// by cellSize after each iteration,
											// the x stays the same
		}
	}

	/*
	 * Method:drawTicTacToeBoard(int numCells,int cellSize, double x, double y):
	 */
	/**
	 * Draws a numCells by numCells tic-tac-toe board with the cell size of
	 * cellSize on the (x, y) point of canvas.
	 */
	private void drawTicTacToeBoard(int numCells, int cellSize, double x, double y) {
		for (int i = 0; i < numCells; i++) {
			drawColumn(numCells, cellSize, x + i * cellSize, y);
		}
	}

	public void run() {
		drawTicTacToeBoard(NUM_CELLS, CELL_SIZE, (getWidth() * .5 - (NUM_CELLS * CELL_SIZE) * .5),
				/*
				 * NUM_CELLS * CELL_SIZE will be the total size of a side of our
				 * board
				 */
				(getHeight() * 0.5 - (NUM_CELLS * CELL_SIZE) * .5));
	}
}
