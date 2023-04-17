package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorIsAllowedOnRollerCoaster() {
        Visitor visitor = new Visitor(19, 200.00, 30);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    // this tests that the visitor is under the age limit but over the height restrictions
    @Test
    public void visitorIsNotAllowedOnRollerCoaster() {
        Visitor visitor = new Visitor(11, 146.00, 30.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void visitorIsNotTooTallFee() {
        Visitor visitor = new Visitor(18, 197.00, 30.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void visitorIsTooTallFee() {
        Visitor visitor = new Visitor(18, 203.00, 30.00);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

}
