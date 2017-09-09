package practice10;

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/* class: practice10 */
/**
 * Contains solutions for problems from 10th practice seminar. Topic: Creating
 * animations on canvas.
 */
@SuppressWarnings("serial")
public class practice10 extends GraphicsProgram {

	public void run() {
		addSuperMovingBall();
	}

	/* Method: addSuperMovingBall() */
	/**
	 * Adds a ball at the center of the canvas. Moves the ball until program
	 * coloses, changes the direction when it collides with vertical or
	 * horizontal borders.
	 */
	private void addSuperMovingBall() {
		GOval ball = getBall(BALL_RADIUS);
		add(ball, getWidth() * .5 - BALL_RADIUS, getHeight() * .5 - BALL_RADIUS);

		while (true) {
			ball.move(vx, vy);
			if (collidedHorizontally(ball)) {
				vx = -vx;// we change horizontal direction of the ball but not
							// its speed.
			} else if (collidedVertically(ball)) {
				changeVy();// when collided vertically, we change speed and
							// vertical direction of the ball.
			}
			pause(DELAY);
		}
	}

	/* Method: changeVy() */
	/** Changes vertical direction and speed of the ball. */
	private void changeVy() {
		int sign = getSign(vy);
		vy = rand.nextDouble(1, MAX_VY);
		vy *= -sign;
	}

	/* Method: getSign(double n) */
	/**
	 * Returns the sign of the number. -1 if negative, 1 if positive, 0 if none.
	 */
	private int getSign(double n) {
		if (n < 0)
			return -1;
		if (n > 0)
			return 1;
		return 0;
	}

	/* Method: collidedVertically(GOval ball) */
	/**
	 * Returns whether the passed ball collided with any of vertical borders.
	 */
	private boolean collidedVertically(GOval ball) {
		if (ball.getY() <= 0 || ball.getY() + ball.getHeight() >= getHeight())
			return true;
		return false;
	}

	/* Method: collidedVertically(GOval ball) */
	/**
	 * Adds a ball at the middle of the left border of the canvas and moves it
	 * to the right border.
	 */
	private void addMovingBall() {
		GOval ball = getBall(BALL_RADIUS);
		add(ball, 0, getHeight() * .5 - BALL_RADIUS);

		while (!collidedHorizontally(ball)) {
			ball.move(vx, 0);
			pause(DELAY);
		}
	}

	/* Method: collidedHorizontally(GOval ball) */
	/**
	 * Returns whether the passed ball collided with any of the horizontal
	 * borders.
	 */
	private boolean collidedHorizontally(GOval ball) {
		if (ball.getX() < 0 || ball.getX() + ball.getWidth() >= getWidth())
			return true;
		return false;
	}

	/* Method: getBall(double radius) */
	/** Returns a black filled ball with passed radius. */
	private GOval getBall(double radius) {
		GOval ball = new GOval(radius * 2, radius * 2);
		ball.setFillColor(Color.black);
		ball.setFilled(true);
		return ball;
	}

	/* Method: drawSmile() */
	/** Draws a smile at the center of the canvas. */
	private void drawSmile() {
		GArc mouth = new GArc(SMILE_WIDTH, SMILE_HEIGHT, 0, -180);
		add(mouth, (getWidth() - SMILE_WIDTH) * .5, (getHeight() - SMILE_HEIGHT) * .5);
		addEyes(mouth.getX(), mouth.getY());
	}

	/* Method: addEyes(double x, double y) */
	/**
	 * Draws eyes symmetrically at passed coordinates. The passed coordinates
	 * should be same of the "mouth" we're drawing.
	 */
	private void addEyes(double x, double y) {
		addEye(x + SMILE_WIDTH * .25, y);
		addEye(x + SMILE_WIDTH * .75, y);
	}

	/* Method: addEye(double x, double y) */
	/** Adds a small black GOval at passed coordinates. */
	private void addEye(double x, double y) {
		GOval eye = new GOval(SMILE_WIDTH * .05, SMILE_WIDTH * .05);
		eye.setFillColor(Color.black);
		eye.setFilled(true);
		add(eye, x, y);
	}

	/** Width of the smile the program will draw. */
	private static final int SMILE_WIDTH = 200;
	/** Height of the mouth of the smile. */
	private static final int SMILE_HEIGHT = 100;
	/** Radius of the ball */
	private final static double BALL_RADIUS = 15;

	/** Horizontal speed of the ball */
	private double vx = 5;
	/** Vertical speed of the ball */
	private double vy = 3;
	/** Maximum speed that VY can reach. */
	private final double MAX_VY = 4.0;
	/** Amount of milliseconds we pause for when method pause() is called. */
	private final double DELAY = 9;
	/** A RandomGenerator that will be used throughout the program. */
	RandomGenerator rand = RandomGenerator.getInstance();
}
