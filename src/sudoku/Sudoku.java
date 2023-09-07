package sudoku;

public class Sudoku {

    // Outer Square Dimension : 9 x 9 Grid
    private static final int DIMENSION = 9;

    // Inner Square Dimension : 3 x 3 Grid
    private static final int SUBGRID_DIMENSION = 3;

    // Individual Unit Squares in Grid
    private final int[][] cell;

    public Sudoku() {
        cell = new int[DIMENSION][DIMENSION];
    }

    public Sudoku(Sudoku sudoku) {
        cell      = sudoku.cell;

        for (int col = 0; col < sudoku.cell.length; ++col)
            cell[col] = sudoku.cell[col].clone();
    }

    /**
     * get the value in cell at grid location (x, y)
     * @param x row location of cell in grid
     * @param y column location of cell in grid
     * @return value at cell location
     */
    public int get(int x, int y) {
        return cell[y][x];
    }


    /**
     * checks whether the new digit entry does not already appear in the given 
     * row, column or subgrid.
     * @return if value is valid
     */
    public boolean isValid() {
        
        Cell[] rowArray       = new Cell[DIMENSION];
        Cell[] columnArray    = new Cell[DIMENSION];
        Cell[][] subgridCell  = new Cell[SUBGRID_DIMENSION][SUBGRID_DIMENSION];

        for (int i = 0; i < DIMENSION; ++i) {
            rowArray[i]    = new Cell(DIMENSION + 1);
            columnArray[i] = new Cell(DIMENSION + 1);
        }

        for (int cellY = 0; cellY < SUBGRID_DIMENSION; ++cellY) {
            for (int cellX = 0; cellX < SUBGRID_DIMENSION; ++cellX) {
                subgridCell[cellY][cellX] = new Cell(DIMENSION + 1);
            }
        }

        for (int col = 0; col < DIMENSION; ++col) {
            for (int row = 0; row < DIMENSION; ++row) {
                int currentValue = get(row, col);

                if (rowArray[col].contains(currentValue) || columnArray[row].contains(currentValue)) {
                    return false;
                }

                int cellX = row / SUBGRID_DIMENSION;
                int cellY = col / SUBGRID_DIMENSION;

                if (subgridCell[cellY][cellX].contains(currentValue)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * sets the value in cell grid with coordinates (x, y)
     * @param x, row value of cell in grid
     * @param y, column value of cell in grid
     * @param value to be placed in cell
     */
    public void set(int x, int y, int value) {
        cell[y][x] = value;
    }

}
