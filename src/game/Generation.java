package game;

public class Generation {

    private Rules rules;
    private Cells cells;

    public Generation(Rules rules, Cell... cells) {
        this(rules, new Cells(cells));
    }

    public Generation(Rules rules, Cells cells) {
        this.rules = rules;
        this.cells = cells;
    }

    public Generation produceNextGeneration() {
        Cells nextGeneration = new Cells();

        for (Cell neighbor : cells.getNeighbors()) {
            if (inNextGeneration(neighbor)) {
                nextGeneration.add(neighbor);
            }
        }
        return new Generation(rules, nextGeneration);
    }

    private boolean inNextGeneration(Cell neighbor) {
        return rules.inNextGeneration(isAlive(neighbor), aliveNeighborsNumberFor(neighbor));
    }

    private int aliveNeighborsNumberFor(Cell cell) {
        int res = 0;
        for (Cell neighbor : cell.neighbors()) {
            if (isAlive(neighbor))
                res++;
        }
        return res;
    }

    private boolean isAlive(Cell cell) {
        return cells.contains(cell);
    }

    public boolean extinct() {
        return cells.empty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Generation other = (Generation) obj;
        if (cells == null) {
            if (other.cells != null)
                return false;
        } else if (!cells.equals(other.cells))
            return false;
        return true;
    }
}
