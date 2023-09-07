package sudoku;

/**
 * This class describes the individual unit square elements
 * of the Sudoku puzzle grid.
 */
public class Cell {
    private final boolean[] table;

    public Cell(int dimension) {
        table = new boolean[dimension];
    }

    public void add(int number) {
        table[number] = true;
    }

    public boolean contains(int number) {
        return table[number];
    }

    public void remove(int number) {
        table[number] = false;
    }

    public void clear() {
        for (int i = 0; i < table.length; ++i) {
            table[i] = false;
        }
    }
}
