package sierpinski.draw;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;


/*****************************************************************
 * This class creates the display window for
 * the Sierpinski Triangles.
 ****************************************************************/
public class Viewer {

    public static final int WIDTH  = 500;
    public static final int HEIGHT = 500;
    public static final int LEFT_X = 500;
    public static final int TOP_Y  = 100;

    public static void main(String[] args) {
        ControlPanel panel = new ControlPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.WHITE));
        panel.subPanel.setBorder(BorderFactory.createTitledBorder("Level"));

        JFrame frame  = new JFrame("Sierpinski Triangle Viewer");
        frame.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel.subPanel, BorderLayout.SOUTH);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(LEFT_X, TOP_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
