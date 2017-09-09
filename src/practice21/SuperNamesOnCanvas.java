package practice21;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class SuperNamesOnCanvas extends GraphicsProgram {
	private static final int	FIELD_WIDTH	= 10;
	private static final int	BOX_WIDTH	= 150;
	private static final int	BOX_HEIGHT	= 40;
	Map<String, GObject>		names;
	JTextField					nameField;
	JButton						addButton, removeButton, clearButton;
	RandomGenerator				rgen		= RandomGenerator.getInstance();
	private boolean				wasPressed	= false;

	public void init() {
		names = new HashMap<String, GObject>();
		addButtonsAndFields();
		addActionListeners();
		addMouseListeners();
	}

	private void addButtonsAndFields() {
		add(new JLabel("Name "), SOUTH);
		nameField = new JTextField(FIELD_WIDTH);
		add(nameField, SOUTH);
		addButtons();
	}

	private void addButtons() {
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
	}

	public void run() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			addName();
		}
		if (e.getSource() == removeButton)
			removeName();
		if (e.getSource() == clearButton)
			clear();
	}

	private void clear() {
		removeAll();
		names.clear();
	}

	private void removeName() {
		String name = getNameFromTexfield();
		if (name == null)
			return;
		if (names.containsKey(name)) {
			remove(names.get(name));
			names.remove(name);
		}
		nameField.setText("");
	}

	private void addCompound(GCompound nameComp, String name) {
		double x, y;
		while (true) {
			x = rgen.nextDouble(0, getWidth() - nameComp.getWidth() - 1);
			y = rgen.nextDouble(0, getHeight() - nameComp.getHeight() - 1);
			if (!overlapsAnything(nameComp, x, y))
				break;
		}
		nameComp.setLocation(x, y);
		add(nameComp);
		names.put(name, nameComp);
	}

	private boolean overlapsAnything(GObject o, double x, double y) {
		double width = o.getWidth(), height = o.getHeight();

		GObject overLap = getElementAt(x, y);
		if (overLap != null)
			return true;
		overLap = getElementAt(x + width, y);
		if (overLap != null)
			return true;
		overLap = getElementAt(x + width, y + height);
		if (overLap != null)
			return true;
		overLap = getElementAt(x, y + height);

		return overLap != null;
	}

	private String getNameFromTexfield() {
		String name = nameField.getText();
		if (name == null || name.length() < 1)
			return null;
		return name;
	}

	private void addName() {
		String name = getNameFromTexfield();
		if (name == null)
			return;

		GCompound nameLabel = getNameBox(name);
		if (!names.containsKey(name)) {
			addCompound(nameLabel, name);
		}
		nameField.setText("");
	}

	private GCompound getNameBox(String name) {
		GCompound res = new GCompound();
		GRect box = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel nameLabel = new GLabel(name);
		res.add(box);
		res.add(nameLabel, (BOX_WIDTH - nameLabel.getWidth()) * .5, BOX_HEIGHT * .5 + nameLabel.getAscent() * .5);
		return res;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (wasPressed) {
			lastPressed.setLocation(e.getX() - BOX_WIDTH * .5, e.getY() - BOX_HEIGHT * .5);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		wasPressed = false;
	}

	public void mousePressed(MouseEvent e) {
		GObject o = getElementAt(new GPoint(e.getPoint()));
		if (o instanceof GCompound) {
			wasPressed = true;
			lastPressed = (GCompound) o;
		}
	}

	GCompound lastPressed = null;
}
