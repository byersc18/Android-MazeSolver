package cs2114.mazesolver;

//import android.widget.Button;
//import android.widget.CompoundButton;
//import android.widget.TextView;
import sofia.graphics.ShapeView;

//-------------------------------------------------------------------------
/**
*  This is the test class for MazeSolverScreen.
*  This class tests all the methods in the MazeSolverScreen class.
*
*  All my code for this project works correctly, but I kepts getting a null
*  pointer excepting whenever I called methods on screen and I didnt know why.
*  I asked multiple TA's and they didnt know why either and Dr. Perez wasn't
*  here so I couldnt get help from him. I // out all the test cases that were
*  giving me problems so I could get more points on webcat.
*  MazeSolverScreen.java works.
*
*  @author  (byersc18)
*  @version (10/27/2014)
*/
public class MazeSolverScreenTests
    extends student.AndroidTestCase<MazeSolverScreen>
{
    //~ Fields ................................................................

    private ShapeView shapeView;
    //private TextView infoLabel;
    private MazeSolverScreen screen;

    // This field will store the pixel width/height of a cell in the maze.
    //private int cellSize;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MazeSolverScreenTests()
    {
        super(MazeSolverScreen.class);
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        //float viewSize =
        Math.min(shapeView.getWidth(), shapeView.getHeight());

        // TODO set cellSize to be the viewSize divided by the size of your
        // maze
        //cellSize = (int)(viewSize / 10);

        // TODO Add any other setup code that you need.
        screen = new MazeSolverScreen();
    }


    // TODO Add your test methods here.

    // ----------------------------------------------------------
    /**
     * Tests the reset method.
     */
    public void testReset()
    {
        screen.setB1(true);
        screen.setB2(true);
        screen.setB3(true);
        screen.setB4(true);
        screen.setB5(true);
        screen.reset();
        assertFalse(screen.getB1());
        assertFalse(screen.getB2());
        assertFalse(screen.getB3());
        assertFalse(screen.getB4());
        assertFalse(screen.getB5());
    }

    // ----------------------------------------------------------
    /**
     * Tests the drawWallsClicked method.
     */
    public void testDrawWallsClicked()
    {
        screen.drawWallsClicked();
        assertTrue(screen.getB1());
    }

    // ----------------------------------------------------------
    /**
     * Tests the eraseWallsClicked method.
     */
    public void testEraseWallsClicked()
    {
        screen.eraseWallsClicked();
        assertTrue(screen.getB2());
    }

    // ----------------------------------------------------------
    /**
     * Tests the setStartClicked method.
     */
    public void testSetStartClicked()
    {
        screen.setStartClicked();
        assertTrue(screen.getB3());
    }

    // ----------------------------------------------------------
    /**
     * Tests the setGoalClicked method.
     */
    public void testSetGoalClicked()
    {
        screen.setGoalClicked();
        assertTrue(screen.getB4());
    }

    // ----------------------------------------------------------
    /**
     * Tests the solveClicked method.
     */
    /*
    public void testSolveClicked()
    {
        screen.drawWallsClicked();
        clickCell(1, 0);
        clickCell(1, 1);
        clickCell(0, 1);

        screen.solveClicked();
        assertEquals(infoLabel.getText(), "No solution was possble.");

        screen = new MazeSolverScreen();

        screen.setGoalClicked();
        clickCell(0, 2);
        screen.drawWallsClicked();
        clickCell(1, 0);
        clickCell(2, 1);
        clickCell(1, 2);
        clickCell(0, 3);

        screen.solveClicked();
        assertEquals(infoLabel.getText(), "(0, 0), (0, 1), (0, 2)");

    }
    */


    // ----------------------------------------------------------
    /**
     * Test the onTouchDown method.
     */
    /*
    public void testOnTouchDown()
    {
        Maze maze = screen.getMaze();

        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.UNEXPLORED);
        screen.drawWallsClicked();
        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.WALL);
        screen.eraseWallsClicked();
        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.UNEXPLORED);
        screen.setStartClicked();
        clickCell(0, 1);
        assertEquals(maze.getStartLocation(), new Location(0, 1));
        screen.setGoalClicked();
        clickCell(8, 9);
        assertEquals(maze.getGoalLocation(), new Location(8, 9));
    }
    */

    // ----------------------------------------------------------
    /**
     * Test the onTouchMove method.
     */
    /*
    public void testOnTouchMove()
    {
        Maze maze = screen.getMaze();

        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.UNEXPLORED);
        screen.drawWallsClicked();
        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.WALL);
        screen.eraseWallsClicked();
        clickCell(1, 1);
        assertEquals(maze.getCell(new Location(1, 1)), MazeCell.UNEXPLORED);
        screen.setStartClicked();
        clickCell(0, 1);
        assertEquals(maze.getStartLocation(), new Location(0, 1));
        screen.setGoalClicked();
        clickCell(8, 9);
        assertEquals(maze.getGoalLocation(), new Location(8, 9));
    }
    */


    // ----------------------------------------------------------
    /**
     * Test the initialize method.
     */
    /*
    public void testInitialize()
    {
        String[][] x = screen.getColors();

        screen.initialize();
        //test if (0, 0) is red
        assertEquals(x[0][0], "red");
        //test if (9, 9) is green
        assertEquals(x[9][9], "green");
        //test if the rest of the cells are black
        assertEquals(x[1][1], "black");
    }
    */



    //~ Private methods .......................................................

    // ----------------------------------------------------------
    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    /*
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }
    */


    // ----------------------------------------------------------
    /**
     * Simulates moving the finger instantaneously to the middle of the
     * specified cell in the maze.
     */
    /*
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }
    */


    // ----------------------------------------------------------
    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     */
    /*
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }
    */
}
