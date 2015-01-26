package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Cells implements Iterable<Cell> {
    List<Cell> cells;

    public Cells(Cell... cells) {
        this.cells = Arrays.asList(cells);
    }

    public Cells() {
        this.cells = new ArrayList<Cell>();
    }

    public Cells getNeighbors() {
        Cells neighbors = new Cells();

        for (Cell cell : this.cells) {
            for (Cell neighbor : cell.neighbors()) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    public boolean empty() {
        return cells.isEmpty();
    }

    public void add(Cell cell) {
        if (cells.contains(cell))
            return;
        cells.add(cell);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cells other = (Cells) obj;
        if (other.cells.size() != cells.size())
            return false;
        for (Cell cell : cells) {
            if (!other.cells.contains(cell))
                return false;
        }
        for (Cell cell : other.cells) {
            if (!cells.contains(cell))
                return false;
        }
        return true;
    }

    @Override
    public Iterator<Cell> iterator() {
        return cells.iterator();
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }
}
