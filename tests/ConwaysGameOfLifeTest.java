import static org.junit.Assert.assertEquals;
import game.Cells;
import game.GameOfLife;
import game.Generation;

import org.junit.Before;
import org.junit.Test;

import rules.types.ConwaysRules;
import cell.types.ConwaysCell;

public class ConwaysGameOfLifeTest {

    private ConwaysRules conwayRules;

    @Before
    public void setUp() {
        conwayRules = new ConwaysRules();
    }

    @Test
    public void aExtinctGameRemainsExtinct() {
        GameOfLife game = new GameOfLife(aExtinctGeneration());

        game.run(15);

        assertEquals(aExtinctGeneration(), game.currentGeneration());
    }

    private Generation aExtinctGeneration() {
        return new Generation(new ConwaysRules(), new Cells());
    }

    @Test
    public void aBlockIsStillLife() {
        GameOfLife game = new GameOfLife(aBlock());

        game.run(15);

        assertEquals(expectedForBlock(), game.currentGeneration());
    }

    @Test
    public void aBeehiveIsStillLife() throws Exception {
        GameOfLife game = new GameOfLife(aBeehive());

        game.run(15);

        assertEquals(expectedForBeehive(), game.currentGeneration());
    }

    @Test
    public void aLoafIsStillLife() throws Exception {
        GameOfLife game = new GameOfLife(aLoaf());

        game.run(15);

        assertEquals(expectedForLoaf(), game.currentGeneration());
    }

    @Test
    public void aBoatIsStillLife() throws Exception {
        GameOfLife game = new GameOfLife(aBoat());

        game.run(15);

        assertEquals(expectedForBoat(), game.currentGeneration());
    }

    @Test
    public void aBlinkerOscillatesWithPeriodTwo() throws Exception {
        GameOfLife game = new GameOfLife(aBlinker());

        game.run(1);
        assertEquals(expectedForBlinker1(), game.currentGeneration());

        game.run(1);
        assertEquals(expectedForBlinker2(), game.currentGeneration());
    }

    @Test
    public void aToadOscillatesWithPeriodTwo() throws Exception {
        GameOfLife game = new GameOfLife(aToad());

        game.run(1);
        assertEquals(expectedForToad1(), game.currentGeneration());

        game.run(1);
        assertEquals(expectedForToad2(), game.currentGeneration());
    }

    @Test
    public void aGliderMovesDiagonallyWithPeriod4() throws Exception {
        GameOfLife game = new GameOfLife(aGlider());

        game.run(1);
        assertEquals(expectedForGlider1(), game.currentGeneration());

        game.run(1);
        assertEquals(expectedForGlider2(), game.currentGeneration());

        game.run(1);
        assertEquals(expectedForGlider3(), game.currentGeneration());

        game.run(1);
        assertEquals(expectedForGlider4(), game.currentGeneration());
    }

    // http://www.conwaylife.com/wiki/Beehive
    private Generation aBeehive() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 1),
                new ConwaysCell(0, 2), new ConwaysCell(1, 0), new ConwaysCell(1, 3),
                new ConwaysCell(2, 1), new ConwaysCell(2, 2));
        return cells;
    }

    private Generation expectedForBeehive() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 1), new ConwaysCell(0, 2),
                new ConwaysCell(1, 0), new ConwaysCell(1, 3), new ConwaysCell(2, 1),
                new ConwaysCell(2, 2));
    }

    // http://en.wikipedia.org/wiki/Still_life_%28cellular_automaton%29#Loaves
    private Generation aLoaf() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 1),
                new ConwaysCell(0, 2), new ConwaysCell(1, 0), new ConwaysCell(1, 3),
                new ConwaysCell(2, 1), new ConwaysCell(2, 3), new ConwaysCell(3, 2));
        return cells;
    }

    private Generation expectedForLoaf() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 1), new ConwaysCell(0, 2),
                new ConwaysCell(1, 0), new ConwaysCell(1, 3), new ConwaysCell(2, 1),
                new ConwaysCell(2, 3), new ConwaysCell(3, 2));
    }

    // http://en.wikipedia.org/wiki/Still_life_%28cellular_automaton%29#Blocks
    private Generation aBlock() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 0),
                new ConwaysCell(0, 1), new ConwaysCell(1, 1), new ConwaysCell(1, 0));
        return cells;
    }

    private Generation expectedForBlock() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(0, 1),
                new ConwaysCell(1, 1), new ConwaysCell(1, 0));
    }

    // http://commons.wikimedia.org/wiki/File:Game_of_life_boat.svg
    private Generation aBoat() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 0),
                new ConwaysCell(0, 1), new ConwaysCell(1, 0), new ConwaysCell(1, 2),
                new ConwaysCell(2, 1));
        return cells;
    }

    private Generation expectedForBoat() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(0, 1),
                new ConwaysCell(1, 0), new ConwaysCell(1, 2), new ConwaysCell(2, 1));
    }

    // http://en.wikipedia.org/wiki/File:Game_of_life_blinker.gif
    private Generation aBlinker() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 0),
                new ConwaysCell(0, 1), new ConwaysCell(0, 2));
        return cells;
    }

    private Generation expectedForBlinker2() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 1), new ConwaysCell(0, 2),
                new ConwaysCell(0, 0));
    }

    private Generation expectedForBlinker1() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 1), new ConwaysCell(1, 1),
                new ConwaysCell(-1, 1));
    }

    // http://en.wikipedia.org/wiki/File:Game_of_life_toad.gif
    private Generation aToad() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 1),
                new ConwaysCell(0, 2), new ConwaysCell(0, 3), new ConwaysCell(1, 0),
                new ConwaysCell(1, 1), new ConwaysCell(1, 2));
        return cells;
    }

    private Generation expectedForToad2() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 3), new ConwaysCell(1, 0),
                new ConwaysCell(1, 2), new ConwaysCell(0, 2), new ConwaysCell(1, 1),
                new ConwaysCell(0, 1));
    }

    private Generation expectedForToad1() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 3), new ConwaysCell(1, 0),
                new ConwaysCell(0, 0), new ConwaysCell(-1, 2), new ConwaysCell(1, 3),
                new ConwaysCell(2, 1));
    }

    // http://en.wikipedia.org/wiki/File:Game_of_life_animated_glider.gif
    private Generation aGlider() {
        Generation cells = new Generation(conwayRules, new ConwaysCell(0, 0),
                new ConwaysCell(0, 1), new ConwaysCell(0, 2), new ConwaysCell(1, 0),
                new ConwaysCell(2, 1));
        return cells;
    }

    private Generation expectedForGlider4() {
        return new Generation(new ConwaysRules(), new ConwaysCell(-1, 1), new ConwaysCell(-1, 0),
                new ConwaysCell(0, -1), new ConwaysCell(1, 0), new ConwaysCell(-1, -1));
    }

    private Generation expectedForGlider3() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(-1, 1),
                new ConwaysCell(-1, 0), new ConwaysCell(1, 1), new ConwaysCell(0, -1));
    }

    private Generation expectedForGlider2() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(1, 0),
                new ConwaysCell(-1, 1), new ConwaysCell(-1, 0), new ConwaysCell(0, 2));
    }

    private Generation expectedForGlider1() {
        return new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(0, 1),
                new ConwaysCell(1, 0), new ConwaysCell(-1, 1), new ConwaysCell(1, 2));
    }
}
