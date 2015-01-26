import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Generation;

import org.junit.Test;

import rules.types.ConwaysRules;
import cell.types.ConwaysCell;

public class ProducingNextGenerationTest {

    @Test
    public void extintGenerationsProducesExtintGeneration() {
        Generation cells = new Generation(new ConwaysRules());

        assertTrue(cells.extinct());

        Generation next = cells.produceNextGeneration();

        assertTrue(next.extinct());
    }

    @Test
    public void aBlockRemainsTheSame() {
        Generation cells = new Generation(new ConwaysRules(), new ConwaysCell(0, 0),
                new ConwaysCell(0, 1), new ConwaysCell(1, 1), new ConwaysCell(1, 0));

        Generation next = cells.produceNextGeneration();

        assertFalse(next.extinct());
        assertEquals(new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(0,
                1), new ConwaysCell(1, 1), new ConwaysCell(1, 0)), next);
    }

    @Test
    public void aCellIsBornAndOnlyItRemains() {
        Generation cells = new Generation(new ConwaysRules(), new ConwaysCell(-1, -1),
                new ConwaysCell(1, 1), new ConwaysCell(-1, 1));

        Generation next = cells.produceNextGeneration();

        assertFalse(next.extinct());
        assertEquals(new Generation(new ConwaysRules(), new ConwaysCell(0, 0)), next);
    }

    @Test
    public void OnlyOneCellRemainsAndTwoAreBorn() {
        Generation cells = new Generation(new ConwaysRules(), new ConwaysCell(0, 0),
                new ConwaysCell(-1, -1), new ConwaysCell(1, 1), new ConwaysCell(-1, 1));

        Generation next = cells.produceNextGeneration();

        assertFalse(next.extinct());
        assertEquals(new Generation(new ConwaysRules(), new ConwaysCell(0, 0), new ConwaysCell(0,
                1), new ConwaysCell(-1, 0)), next);
    }
}
