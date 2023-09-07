package sudoku;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.File;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Viewer {

    private final JFrame frame;
    private final Grid grid;

    public Viewer() {
        grid  = new Grid();
        frame = new JFrame("Sudoku");
        frame.getContentPane().add(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        frame.pack();
        frame.setResizable(false);
        centerDisplayOnScreen();
        frame.setVisible(true);
    }

    private void displayMenu() {
        JMenuBar bar   = new JMenuBar();
        JMenu fileMenu = new JMenu("Open");

        JMenuItem general  = new JMenuItem("Puzzle");
        JMenuItem test     = new JMenuItem("Test Puzzle");

        fileMenu.add(general);
        fileMenu.add(test);
        fileMenu.addSeparator();

        bar.add(fileMenu);

        general.addActionListener(e -> detectGeneralPuzzleFile());

        test.addActionListener(e -> detectTestPuzzleFile());

        frame.setJMenuBar(bar);
    }


    private void centerDisplayOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        frame.setLocation((screen.width - frameSize.width) >> 1,
                          (screen.height - frameSize.height) >> 1);
    }

    private void detectGeneralPuzzleFile(){
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(frame);

        if (status == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            grid.loadPuzzle(file);
        }
    }

    private void detectTestPuzzleFile(){
        String puzzleLocation = "." + File.separator + "data" + File.separator + "puzzle.txt";
        File file = new File(puzzleLocation);
        grid.loadPuzzle(file);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Viewer::new);
    }

}

