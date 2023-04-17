package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor1;


    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        visitor1 = new Visitor(10,100.00, 0);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void isVisitorAllowedInPlayground() {
        assertEquals(true, playground.isAllowedTo(visitor1));
    }

    @Test
    public void isVisitorNotAllowedInPlayground() {
        Visitor visitor2 = new Visitor(16, 200.00, 20);
        assertEquals(false, playground.isAllowedTo(visitor2));
    }


}
