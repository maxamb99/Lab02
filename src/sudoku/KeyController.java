package sudoku;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * This class creates a key listener to detect keyboard typing
 * at individual sudoku cells
 */

public class KeyController implements KeyListener {

    private final Grid grid;

    KeyController(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        char key = event.getKeyChar();

        //This is an enhanced switch technique
        switch (key) {
            case 'a', 'A', 's', 'S', 'd', 'D', 'w', 'W' -> {
                event.consume();
                grid.moveCursor((JTextField) event.getSource(), key);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {}

    @Override
    public void keyReleased(KeyEvent event) {
        int keyCode = event.getExtendedKeyCode();

        if (keyCode == KeyEvent.VK_UP   || keyCode == KeyEvent.VK_RIGHT
                                        || keyCode == KeyEvent.VK_DOWN
                                        || keyCode == KeyEvent.VK_LEFT) {
            return;
        }

        JTextField field = (JTextField) event.getSource();

        if (!field.getText().isEmpty() && !Character.isSpaceChar(field.getText().charAt(0))) {
           field.setText(" " + field.getText());
        }
    }
}

