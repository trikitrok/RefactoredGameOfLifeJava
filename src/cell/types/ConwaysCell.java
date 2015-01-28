package cell.types;

import game.Cell;
import game.Cells;

public class ConwaysCell implements Cell {
    protected int i;
    protected int j;

    public ConwaysCell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Cells neighbors() {
        Cells neighbors = new Cells();
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0)
                    continue;
                neighbors.add(new ConwaysCell(i - k, j - l));
            }
        }
        return neighbors;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConwaysCell other = (ConwaysCell) obj;
        if (i != other.i)
            return false;
        if (j != other.j)
            return false;
        return true;
    }
}
