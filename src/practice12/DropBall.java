package practice12;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

        /* class: DropBall */

/**
 * Adds a ball on canvas and moves it towards bottom. Changes the location of
 * the ball each time user clicks anywhere on canvas to the point they click.
 */
public class DropBall extends GraphicsProgram implements MouseListener {

    /**
     * Radius of the ball
     */
    private static final double BALL_RADIUS = 20;
    /**
     * Vertical speed of the ball
     */
    private static final double VY          = 3.0;
    /**
     * Pause between loops
     */
    private static final double DELAY       = 6;

    @Override
    public void init() {
        addMouseListeners();
    }

    @Override
    public void run() {
        addBall();
        startMoving();
    }

    /* Method: startMoving() */

    /**
     * Starts moving a ball towards bottom with an infinite loop.
     */
    private void startMoving() {
        dropBall(getWidth() * .5, getHeight() * .5);
        while (true) {
            if (ball.getY() + BALL_RADIUS * 2 < getHeight())
                ball.move(0, VY);
            pause(DELAY);
        }
    }

    /* Method: addBall() */

    /**
     * Initializes the ball.
     */
    private void addBall() {
        ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        add(ball);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dropBall(e.getX(), e.getY());
    }

    /* Method: dropBall(double x, double y) */

    /**
     * Relocates the ball in a way that its center is located at passed
     * coordinates.
     */
    private void dropBall(double x, double y) {
        ball.setLocation(x - BALL_RADIUS, y - BALL_RADIUS);
    }

    /**
     * The ball that program's gonna drop.
     */
    private GOval ball;
}
