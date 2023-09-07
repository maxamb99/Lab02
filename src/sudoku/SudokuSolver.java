package sudoku;

import java.awt.Point;
import java.util.Objects;

/**
 * solves a Sudoku puzzle using recursive backtracking.
 */

public class SudokuSolver {
    
    // Outer Square Dimension : 9 x 9 Grid
    private static final int DIMENSION = 9;
    
    // Inner Square Dimension : 3 x 3 Grid 
    private static final int SUBGRID_DIMENSION = 3;
    
    private static final int UNOCCUPIED = 0;

    private final Cell[] gridRowArray;
    private final Cell[] gridColumnArray;
    private final Cell[][] subgrid;
    private final Point point;
    
    //initial Sudoku puzzle values
    private Sudoku puzzle;
    
    //solution for initial Sudoku puzzle
    private Sudoku solution;

    public SudokuSolver() {
        
        gridRowArray     = new Cell[DIMENSION];
        gridColumnArray  = new Cell[DIMENSION];

        point   = new Point();
        subgrid = new Cell[SUBGRID_DIMENSION][SUBGRID_DIMENSION];

        for (int i = 0; i < DIMENSION; ++i) {
            gridRowArray   [i] = new Cell(DIMENSION + 1);
            gridColumnArray[i] = new Cell(DIMENSION + 1);
        }

        for (int y = 0; y < SUBGRID_DIMENSION; ++y) {
            for (int x = 0; x < SUBGRID_DIMENSION; ++x) {
                subgrid[y][x] = new Cell(DIMENSION + 1);
            }
        }
    }

    /**
     * load puzzle and find a solution
     * @param inputPuzzle from loaded Sudoku puzzle
     * @return solved puzzle
     */
    public Sudoku solve(Sudoku inputPuzzle) {
        Objects.requireNonNull(inputPuzzle, "Input Puzzle is null.");

        puzzle = new Sudoku(inputPuzzle);

        //TODO: Set Unoccupied Locations

        //TODO : clear the grid cells of previous entries

        //TODO : initialize the grid cells

        //TODO: Create a Sudoku solution set with a constructor

        //TODO : Search each cell and backtrack to solve puzzle

        //TODO: return solved Sudoku puzzle
        return null;
    }


     /**
      * get location of free/unassigned cells and set
      * as UNOCCUPIED
      * */
    private void setUnoccupiedLocations() {

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                int currentValue = puzzle.get(row, col);

                if (currentValue < 1 || currentValue > DIMENSION) {
                    puzzle.set(row, col, UNOCCUPIED);
                }
            }
        }
    }


    /**
     * clear grid cells of any previous entries
     */
    private void clearCells() {
        for (int i = 0; i < DIMENSION; ++i) {
            gridRowArray[i].clear();
            gridColumnArray[i].clear();
        }

        for (int y = 0; y < SUBGRID_DIMENSION; ++y) {
            for (int x = 0; x < SUBGRID_DIMENSION; ++x) {
                subgrid[y][x].clear();
            }
        }
    }

    /**
     * checks if there are any duplicates, in row, column or subgrid
     */
    private void initializeCells() {
        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {

                int currentValue = puzzle.get(row, col);

                if (gridRowArray[col].contains(currentValue)) {
                    String message = String.format("The cell (%d, %d) with value %d is already in row."
                                                    ,row, col, currentValue);
                    throw new IllegalArgumentException(message);
                }

                if (gridColumnArray[row].contains(currentValue)) {
                    String message = String.format("The cell (%d, %d) with value %d is already in column."
                                                    ,row, col, currentValue);
                    throw new IllegalArgumentException(message);
                }

                loadSubGridCoordinates(row, col);

                if (subgrid[point.y][point.x].contains(currentValue)) {
                    String message = String.format("The cell (%d, %d) with value %d is already in inner square."
                                                    ,row, col, currentValue);
                    throw new IllegalArgumentException(message);
                }

                //adds value to row, column arrays and subgrid
                if (isValidCellValue(currentValue)) {
                    gridRowArray[col].add(currentValue);
                    gridColumnArray[row].add(currentValue);
                    
                    // adds value to subgrid, with coordinates of 'point'.
                    subgrid[point.y][point.x].add(currentValue);
                }
            }
        }
    }

    /**
     * returns if entry is a valid number for grid dimension.
     * @param value entered
     * @return boolean value
     */
    private boolean isValidCellValue(int value) {
        return 0 < value && value <= DIMENSION;
    }

    /**
     * loads coordinates for current subgrid
     * @param x cell row location
     * @param y cell column location
     */
    private void loadSubGridCoordinates(int x, int y) {
        point.x = x / SUBGRID_DIMENSION;
        point.y = y / SUBGRID_DIMENSION;
    }

    /**
     * Find a solution to the loaded Sudoku puzzle, by searching for
     * valid numbers to fill each free cell.
     */
    private void search() {
        //TODO: create starting location for solution
    }

    /**
     * explores all possibilities for solving Sudoku puzzle either by reporting
     * the first solution it finds or reporting that no solution could be found
     * @param x, row
     * @param y, column
     * @return boolean value
     */
    private boolean search(int x, int y) {
        
        //TODO: if row coordinate is at maximum dimension then we are done with row,
        //      move to next row, then update column coordinate

        //TODO: if column coordinate is at maximum dimension
        //      then solution is FOUND return 'true'.

        // load values from the input puzzle into solution puzzle
        if (puzzle.get(x, y) != UNOCCUPIED) {

            //TODO : set value from the input puzzle into solution puzzle

            //TODO : search for unassigned locations and place solution there
            return false;
        } 

        // Start with the lowest number to fit in a free cell (x, y) and increase
        // to a larger value, if there is a conflict at that cell.
        for (int number = 1; number <= DIMENSION; ++number) {
            
            if (!gridColumnArray[x].contains(number) && !gridRowArray[y].contains(number)) {
                loadSubGridCoordinates(x, y);

                if (!subgrid[point.y][point.x].contains(number)) {
                    solution.set(x, y, number);
                    gridRowArray[y].add(number);
                    gridColumnArray[x].add(number);
                    subgrid[point.y][point.x].add(number);

                    //TODO : If solution FOUND, stop backtracking and return at each recursion level.

                    // If number in current cell (x, y) does not lead towards a solution
                    // 'undo' number from cell and increase to a larger value (at loop)
                    gridRowArray[y].remove(number);
                    gridColumnArray[x].remove(number);

                    // Reload the subgrid coordinates since they may be invalid due to recursion.
                    loadSubGridCoordinates(x, y);
                    subgrid[point.y][point.x].remove(number);
                }
            }
        }

        //TODO : check case to see if a number fits, otherwise backtrack
        // If No number fits at cell coordinates (x, y), backtrack a little.
        return false;
    }
    
}
