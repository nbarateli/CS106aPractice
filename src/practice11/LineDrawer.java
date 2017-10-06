package practice11;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

        /* class: LineDrawer */

/**
 * A program that draws a line on Canvas using MouseListeners
 */
@SuppressWarnings("serial")
public class LineDrawer extends GraphicsProgram implements MouseListener {

    /**
     * The line that will be drawn.
     */
    private GLine line;

    /* Method: init() */

    /**
     * Calls addMouseListeners() for program.
     */
    public void init() {
        addMouseListeners();
    }

    /* Method: mousePressed(MouseEvent e) */

    /**
     * Starts creating the line and adds it's startpoint on the coordinates of
     * the Event.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
        add(line);
    }

    /* Method: mouseDragged(MouseEvent e) */

    /**
     * Changes the endpoint of the line each time user moves pressed mouse.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        line.setEndPoint(e.getX(), e.getY());
    }

}
