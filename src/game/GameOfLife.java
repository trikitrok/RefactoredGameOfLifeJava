package game;

public class GameOfLife {
    private Generation currentGeneration;

    public GameOfLife(Generation initialGeneration) {
        this.currentGeneration = initialGeneration;
    }

    public void run(int steps) {
        currentGeneration = evolve(steps, currentGeneration);
    }

    private Generation evolve(int steps, Generation currentGeneration) {
        if (isOver(steps)) {
            return currentGeneration;
        }
        return evolve(steps - 1, currentGeneration.produceNextGeneration());
    }

    private boolean isOver(int steps) {
        return steps == 0 || currentGeneration.extinct();
    }

    public Generation currentGeneration() {
        return currentGeneration;
    }
}
