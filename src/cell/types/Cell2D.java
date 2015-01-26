package cell.types;

import game.Cell;

abstract public class Cell2D implements Cell {
    protected int i;
    protected int j;

    public Cell2D(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell2D other = (Cell2D) obj;
        if (i != other.i)
            return false;
        if (j != other.j)
            return false;
        return true;
    }
}
