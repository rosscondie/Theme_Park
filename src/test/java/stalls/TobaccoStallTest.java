package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasRating() {
        assertEquals(10, tobaccoStall.getRating());
    }

    @Test
    public void visitorIsAllowed() {
        Visitor visitor = new Visitor(18, 200.00, 30.00);
        assertEquals(true, tobaccoStall.isAllowedTo(visitor));
    }

    @Test
    public void visitorIsNotAllowed() {
        Visitor visitor = new Visitor(17, 200.00, 30.00);
        assertEquals(false, tobaccoStall.isAllowedTo(visitor));
    }
}
