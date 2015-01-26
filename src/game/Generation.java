package game;

public class Generation {

    private Rules rules;
    private Cells aliveCells;

    public Generation(Rules rules, Cell... aliveCells) {
        this(rules, new Cells(aliveCells));
    }

    public Generation(Rules rules, Cells aliveCells) {
        this.rules = rules;
        this.aliveCells = aliveCells;
    }

    public Generation produceNextGeneration() {
        Cells nextGeneration = new Cells();

        for (Cell neighbor : aliveCells.getNeighbors()) {
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
            if (isAlive(neighbor)) {
                res++;
            }
        }
        return res;
    }

    private boolean isAlive(Cell cell) {
        return aliveCells.contains(cell);
    }

    public boolean extinct() {
        return aliveCells.empty();
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
        if (aliveCells == null) {
            if (other.aliveCells != null)
                return false;
        } else if (!aliveCells.equals(other.aliveCells))
            return false;
        return true;
    }
}
