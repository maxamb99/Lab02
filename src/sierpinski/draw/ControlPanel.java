package sierpinski.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/*****************************************************************
 * This class uses inheritance to extend Java's JPanel class.
 * This allows us to interact with our computer
 * architecture seamlessly by re-using code from the library.
 ****************************************************************/
public class ControlPanel extends JPanel {
    public static final long serialVersionUID = 1L;
    public static final int WIDTH  = Viewer.WIDTH;
    public static final int HEIGHT = Viewer.HEIGHT - 80;

    private int 	level;		        //set beginning level
    public  JButton plusButton;
    public  JButton minusButton;
    public  JLabel 	label;
    public  JPanel 	subPanel;
    private Point 	p1, p2, p3;

    /*************************************************************
     * Constructor that initializes the parameters above and 
     * uses functional programming to set the actions on the 
     * display panel.
     *************************************************************/
    public ControlPanel() {

        level 		= 1;
        subPanel 	= new JPanel();
        plusButton 	= new JButton("+");
        minusButton = new JButton("-");
        label 		= new JLabel("n: " + level);

        subPanel.setBackground(Color.GRAY);

        
        //Example of Functional Programming (lambda expressions)
        plusButton.addActionListener(event -> {
            level++;
            label.setText("n: " + level);
        });

        //Example of Functional Programming (lambda expressions)
        minusButton.addActionListener(event -> {
            if (level != 1) {
                level--;
                label.setText("n: " + level);
            }
        });

        subPanel.add(plusButton);
        subPanel.add(minusButton);
        subPanel.add(label);
        setPoints();

    }


    /*************************************************************
     * draws triangles at new level.
     * @param graphic for display image on panel.
     * @param level of drawing triangles
     * @param p1 first point to make triangle
     * @param p2 second point to make triangle
     * @param p3 third point to make triangle
     *************************************************************/
    public void drawFigure(Graphics graphic, int level, Point p1, Point p2, Point p3) {

        //end case: triangle level 1
        if( level == 1) {

            Polygon triangle = new Polygon();
            triangle.addPoint(p1.x, p1.y);
            triangle.addPoint(p2.x, p2.y);
            triangle.addPoint(p3.x, p3.y);
            graphic.drawPolygon(triangle);

        }else {

            Point p4 = midPoint(p1, p2);
            Point p5 = midPoint(p2, p3);
            Point p6 = midPoint(p1, p3);

            //recursively draw the three triangles
            drawFigure(graphic, level - 1, p1, p4, p6);
            drawFigure(graphic, level - 1, p4, p2, p5);
            drawFigure(graphic, level - 1, p6, p5, p3);

        }

        repaint();
    }


    /*************************************************************
     * creates midpoint between two points on a line.
     * @param p1 first point of line
     * @param p2 second point of line
     *************************************************************/
    public Point midPoint(Point p1, Point p2) {
        return new Point( (p1.x + p2.x ) / 2 , (p1.y + p2.y) / 2 );
    }


    /*************************************************************
     * select three points in proportion to the pane size
     * some computers need the parent panel reset with
     * super.paintComponent(graphic);
     * @param graphic object set from paint component of JPanel
     *************************************************************/
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        graphic.setColor(Color.WHITE);
        drawFigure(graphic, level, p1, p2, p3);
    }


    /********************************************************
     * sets the three vertices of the first level of the
     * Triangle. This is a private helper method.
     ********************************************************/
    private void setPoints() {
        p1 = new Point( WIDTH / 2 , 10         );
        p2 = new Point( 25        , HEIGHT - 25);
        p3 = new Point( WIDTH - 25, HEIGHT - 25);
    }
}
