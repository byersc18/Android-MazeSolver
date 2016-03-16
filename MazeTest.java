package cs2114.mazesolver;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  This is the test class for the class Maze.
 *  This class tests all the methods in the Maze class to see if they work.
 *
 *  @author Cameron Byers
 *  @version Oct 6, 2014
 */
public class MazeTest extends TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests the size method.
     */
    public void testSize()
    {
        Maze board = new Maze(6);
        assertEquals(6, board.size());
    }

    // ----------------------------------------------------------
    /**
     * Tests the getStartLocation method.
     */
    public void testGetStartLocation()
    {
        Maze board = new Maze(6);
        assertTrue(board.getStartLocation().equals(new Location(0, 0)));
        board.setStartLocation(new Location(3, 3));
        assertTrue(board.getStartLocation().equals(new Location(3, 3)));
    }

    // ----------------------------------------------------------
    /**
     * Tests the setStartLocation method.
     */
    public void testSetStartLocation()
    {
        Maze board = new Maze(6);
        board.setCell(new Location(3, 3), MazeCell.WALL);
        board.setStartLocation(new Location(3, 3));
        assertTrue(board.getStartLocation().equals(new Location(3, 3)));
        assertTrue(board.getCell(new Location(3, 3))
            .equals(MazeCell.UNEXPLORED));

        board.setStartLocation(new Location(4, 4));
        assertTrue(board.getStartLocation().equals(new Location(4, 4)));

        board.setStartLocation(new Location(-1, -1));
    }

    // ----------------------------------------------------------
    /**
     * Tests the getGoalLocation.
     */
    public void testGetGoalLocation()
    {
        Maze board = new Maze(6);
        assertTrue(board.getGoalLocation().equals(new Location(5, 5)));
        board.setGoalLocation(new Location(4, 4));
        assertTrue(board.getGoalLocation().equals(new Location(4, 4)));
    }

    // ----------------------------------------------------------
    /**
     * Tests the setGoalLocation method.
     */
    public void testSetGoalLocation()
    {
        Maze board = new Maze(6);
        board.setCell(new Location(4, 4), MazeCell.WALL);
        board.setGoalLocation(new Location(4, 4));
        assertTrue(board.getGoalLocation().equals(new Location(4, 4)));

        board.setGoalLocation(new Location(3, 3));
        assertTrue(board.getGoalLocation().equals(new Location(3, 3)));

        board.setGoalLocation(new Location(-1, -1));
    }

    // ----------------------------------------------------------
    /**
     * Tests the getCell method.
     */
    public void testGetCell()
    {
        Maze board = new Maze(6);
        assertEquals(board.getCell(new Location(3, 3)), MazeCell.UNEXPLORED);
        assertEquals(board.getCell(new Location(-1, 1)), MazeCell.INVALID_CELL);
        assertEquals(board.getCell(new Location(7, 1)), MazeCell.INVALID_CELL);
        assertEquals(board.getCell(new Location(1, -1)), MazeCell.INVALID_CELL);
        assertEquals(board.getCell(new Location(1, 7)), MazeCell.INVALID_CELL);
    }

    // ----------------------------------------------------------
    /**
     * Tests the setCell method.
     */
    public void testSetCell()
    {
        Maze board = new Maze(6);

        board.setCell(new Location(0, 0), MazeCell.CURRENT_PATH);
        assertEquals(board.getCell(new Location(0, 0)), MazeCell.CURRENT_PATH);
        board.setCell(new Location(0, 0), MazeCell.WALL);
        assertEquals(board.getCell(new Location(0, 0)), MazeCell.CURRENT_PATH);

        board.setCell(new Location(5, 5), MazeCell.CURRENT_PATH);
        assertEquals(board.getCell(new Location(5, 5)), MazeCell.CURRENT_PATH);
        board.setCell(new Location(5, 5), MazeCell.WALL);
        assertEquals(board.getCell(new Location(5, 5)), MazeCell.CURRENT_PATH);

        board.setCell(new Location(2, 2), MazeCell.CURRENT_PATH);
        assertEquals(board.getCell(new Location(2, 2)), MazeCell.CURRENT_PATH);

        board.setCell(new Location(3, 3), MazeCell.WALL);
        assertEquals(board.getCell(new Location(3, 3)), MazeCell.WALL);

        board.setCell(new Location(-1, -1), MazeCell.WALL);
    }

    // ----------------------------------------------------------
    /**
     * Tests the solve method.
     */
    public void testSolve()
    {
        Maze board = new Maze(5);
        board.setStartLocation(new Location(1, 0));
        board.setCell(new Location(0, 0), MazeCell.WALL);
        board.setCell(new Location(2, 1), MazeCell.WALL);
        board.setCell(new Location(3, 1), MazeCell.WALL);
        board.setCell(new Location(4, 1), MazeCell.WALL);
        board.setCell(new Location(1, 2), MazeCell.WALL);
        board.setCell(new Location(1, 3), MazeCell.WALL);
        board.setCell(new Location(3, 3), MazeCell.WALL);
        board.setCell(new Location(3, 4), MazeCell.WALL);
        assertEquals("(1, 0) (1, 1) (0, 1) (0, 2) (0, 3) (0, 4) (1, 4) (2, 4)"
            + " (2, 3) (2, 2) (3, 2) (4, 2) (4, 3) (4, 4) ", board.solve());

        board = new Maze(3);
        board.setCell(new Location(0, 1), MazeCell.WALL);
        board.setCell(new Location(1, 1), MazeCell.WALL);
        board.setCell(new Location(2, 1), MazeCell.WALL);
        board.setCell(new Location(0, 2), MazeCell.WALL);
        board.setCell(new Location(1, 2), MazeCell.WALL);
        assertEquals(null, board.solve());
    }
}
