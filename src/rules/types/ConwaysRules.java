package rules.types;

import game.Rules;

public class ConwaysRules implements Rules {
    public boolean inNextGeneration(boolean alive, int numberOfNeighbors) {
        return numberOfNeighbors == 3 || (alive && numberOfNeighbors == 2);
    }
}
