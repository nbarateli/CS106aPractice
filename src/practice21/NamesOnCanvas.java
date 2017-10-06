package practice21;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class NamesOnCanvas extends GraphicsProgram {
    private static final int FIELD_WIDTH = 10;
    Map<String, GObject> names;
    JTextField           nameField;
    JButton              addButton, removeButton, clearButton;
    RandomGenerator rgen = RandomGenerator.getInstance();


    public void init() {
        names = new HashMap<String, GObject>();
        addButtonsAndFields();
        addActionListeners();
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

    private void addLabel(GLabel nameLabel) {
        double x, y;
        while (true) {
            x = rgen.nextDouble(0, getWidth() - nameLabel.getWidth() - 1);
            y = rgen.nextDouble(0, getHeight() - nameLabel.getHeight() - 1);
            if (!overlapsAnything(nameLabel, x, y))
                break;
        }
        nameLabel.setLocation(x, y);
        add(nameLabel);
        names.put(nameLabel.getLabel(), nameLabel);
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
        GLabel nameLabel = new GLabel(name);
        nameLabel.setFont("sylfaen-17");
        if (!names.containsKey(name)) {
            addLabel(nameLabel);
        }
        nameField.setText("");
    }
}
