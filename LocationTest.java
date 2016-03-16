package cs2114.mazesolver;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test class for the Location class.
 *  Tests the methods of the Location class to see if they work properly.
 *
 *  @author Cameron Byers
 *  @version Oct 6, 2014
 */
public class LocationTest extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests the equals method.
     */
    public void testEquals()
    {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(1, 1);
        Location loc3 = new Location(2, 2);
        Location loc4 = new Location(1, 2);
        Location loc5 = new Location(2, 1);
        int x = 5;
        assertTrue(loc1.equals(loc2));
        assertFalse(loc1.equals(loc3));
        assertFalse(loc1.equals(loc4));
        assertFalse(loc1.equals(loc5));
        assertFalse(loc1.equals(x));
    }

    // ----------------------------------------------------------
    /**
     * Tests the toString method.
     */
    public void testToString()
    {
        Location loc1 = new Location(1, 1);
        assertEquals("(1, 1)", loc1.toString());
    }

    // ----------------------------------------------------------
    /**
     * Tests the x method.
     */
    public void testX()
    {
        Location loc1 = new Location(1, 1);
        assertEquals(1, loc1.x());
    }

    // ----------------------------------------------------------
    /**
     * Tests the y method.
     */
    public void testY()
    {
        Location loc1 = new Location(1, 1);
        assertEquals(1, loc1.y());
    }

    // ----------------------------------------------------------
    /**
     * Test the east method.
     */
    public void testEast()
    {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(2, 1);
        assertTrue(loc1.east().equals(loc2));
    }

    // ----------------------------------------------------------
    /**
     * Test the north method.
     */
    public void testNorth()
    {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(1, 0);
        assertTrue(loc1.north().equals(loc2));
    }

    // ----------------------------------------------------------
    /**
     * Tests the south method.
     */
    public void testSouth()
    {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(1, 2);
        assertTrue(loc1.south().equals(loc2));
    }

    // ----------------------------------------------------------
    /**
     * Tests the west method.
     */
    public void testWest()
    {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(0, 1);
        assertTrue(loc1.west().equals(loc2));
    }

}
