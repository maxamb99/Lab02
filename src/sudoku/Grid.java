package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * This class create the Grid Panel for a Sudoku Puzzle Game.
 * Can read a Sudoku puzzle from a file or from direct entry
 * from GUI Display.
 */
public class Grid extends JPanel {
    private static final Font FONT = new Font("Verdana", Font.BOLD, 25);

    // Outer Square Dimension : 9 x 9 Grid
    private static final int DIMENSION = 9;

    // Inner Square Dimension : 3 x 3 Grid
    private static final int SUBGRID_DIMENSION = 3;

    private final JTextField[][] grid;
    private final Map<JTextField, Point> mapNumberToCell;


    public Grid() {
        mapNumberToCell = new HashMap<>();
        grid = new JTextField[DIMENSION][DIMENSION];

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                JTextField field = new JTextField();
                field.addKeyListener(new KeyController(this));
                mapNumberToCell.put(field, new Point(row, col));
                grid[col][row] = field;
            }
        }

        JPanel gridPanel    = new JPanel();
        JPanel buttonPanel  = new JPanel();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Dimension fieldDIMENSION = new Dimension(50, 50);

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                JTextField field = grid[col][row];
                field.setBorder(border);
                field.setFont(FONT);
                field.setPreferredSize(fieldDIMENSION);
            }
        }

        gridPanel.setLayout(new GridLayout(SUBGRID_DIMENSION, SUBGRID_DIMENSION));

        JPanel[][] squarePanels = new JPanel[SUBGRID_DIMENSION][SUBGRID_DIMENSION];

        Border squareBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        for (int col = 0; col < SUBGRID_DIMENSION; ++col) {
            for (int row = 0; row < SUBGRID_DIMENSION; ++row) {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(SUBGRID_DIMENSION, SUBGRID_DIMENSION));
                panel.setBorder(squareBorder);
                squarePanels[col][row] = panel;
                gridPanel.add(panel);
            }
        }

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                int xLocation = row / SUBGRID_DIMENSION;
                int yLocation = col / SUBGRID_DIMENSION;

                squarePanels[yLocation][xLocation].add(grid[col][row]);
            }
        }

        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        JButton clearButton = new JButton("Clear");
        JButton solveButton = new JButton("Solve");

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(clearButton, BorderLayout.EAST);
        buttonPanel.add(solveButton, BorderLayout.WEST);

        setLayout(new BorderLayout());
        add(gridPanel,   BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        clearButton.addActionListener(e -> clearAll());

        solveButton.addActionListener(e -> solve());
    }

    private void addSpace(JTextField field) {
        if (field.getText().isEmpty()) {
            field.setText(" ");
        }
    }

    /**
     * clears all cells of the Sudoku puzzle when clear button is pressed.
     */
    void clearAll() {
        for (JTextField[] row : grid) {
            for (JTextField field : row) {
                field.setText("");
            }
        }
    }

    /**
     * move the cell cursor with keys w, W, a, A, s, S, d, D
     */
    void moveCursor(JTextField field, char key) {
        Point coordinates = mapNumberToCell.get(field);
        field.setBackground(Color.WHITE);

        //This is an enhanced switch technique
        switch (key) {
            case 'w', 'W' -> {
                if (coordinates.y > 0) {
                    grid[coordinates.y - 1][coordinates.x].requestFocus();
                    addSpace(grid[coordinates.y - 1][coordinates.x]);
                }
            }
            case 'd', 'D' -> {
                if (coordinates.x < DIMENSION - 1) {
                    grid[coordinates.y][coordinates.x + 1].requestFocus();
                    addSpace(grid[coordinates.y][coordinates.x + 1]);
                }
            }
            case 's', 'S' -> {
                if (coordinates.y < DIMENSION - 1) {
                    grid[coordinates.y + 1][coordinates.x].requestFocus();
                    addSpace(grid[coordinates.y + 1][coordinates.x]);
                }
            }
            case 'a', 'A' -> {
                if (coordinates.x > 0) {
                    grid[coordinates.y][coordinates.x - 1].requestFocus();
                    addSpace(grid[coordinates.y][coordinates.x - 1]);
                }
            }
        }
    }


    /**
     * opens puzzle from file location
     * @param file to open with Sudoku puzzle.
     */
    public void loadPuzzle(File file) {

        try {
            Scanner scanner = new Scanner(file);
            clearAll();

            int cells = DIMENSION * DIMENSION;
            int y = 0;
            int x = 0;

            while (cells > 0) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] cellValues = line.split(" ");
                    int cellValue;

                    try {

                        for (int col = 0; col < DIMENSION; col++) {
                            //Ternary Operator to convert values
                            cellValue = cellValues[col].equals("-") ? 0 : Integer.parseInt(cellValues[col]);
                            if (cellValue > 0 && cellValue <= DIMENSION) {
                                grid[x][col].setForeground(Color.BLUE);
                                grid[x][col].setText(" " + cellValue);
                            }else{
                                grid[x][col].setText(" ");
                            }
                        }

                    } catch (NumberFormatException ignored) {}

                    ++x;        // increment row

                    if (x == DIMENSION) {
                        x = 0;  // go back to first
                        ++y;    // increment column
                    }
                } else {
                    return;
                }

                --cells;
            }
        } catch (FileNotFoundException ignored) {}
    }


    /**
     * solves the current loaded Sudoku puzzle when solve button is pressed.
     */
    void solve() {

        Sudoku sudoku = new Sudoku();

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                String text = grid[col][row].getText();

                int cellNumber = -1;

                try {
                    cellNumber = Integer.parseInt(text.trim());
                } catch (NumberFormatException ignored) {}

                sudoku.set(row, col, cellNumber);
            }
        }

        try {
            Sudoku solution = new SudokuSolver().solve(sudoku);
            String skip     = DIMENSION < 10 ? " " : "";

            for (int col = 0; col < DIMENSION; ++col) {
                for (int row = 0; row < DIMENSION; ++row) {
                   grid[col][row].setText(skip + solution.get(row, col));
                }
            }

            if (!solution.isValid()) {
                throw new RuntimeException("Invalid Input.");
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this,
                                          exception.getMessage(),
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }
}
