package game;

import java.util.Iterator;

public class Neighbors implements Iterable<Cell> {

    private Cells cells;

    public Neighbors(Cells cells) {
        this.cells = new Cells();
        for (Cell cell : cells) {
            for (Cell neighbor : cell.neighbors()) {
                this.cells.add(neighbor);
            }
        }
    }

    @Override
    public Iterator<Cell> iterator() {
        return cells.iterator();
    }
}
