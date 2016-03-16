package cs2114.mazesolver;

import android.widget.TextView;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 *  This class represents the screen of the application.
 *  This class handles all the GUI actions of the MazeSolver game.
 *
 *  @author  (byersc18)
 *  @version (10/27/14)
 */
public class MazeSolverScreen extends ShapeScreen
{
    //~ Fields ................................................................
    /**
     * The maze of the application.
     */
    private Maze maze;
    /**
     * The TextView that shows the solution.
     */
    private TextView infoLabel;
    /**
     * The first button which is the draw button.
     */
    private Boolean b1 = false;
    /**
     * The second button which is the erase button.
     */
    private Boolean b2 = false;
    /**
     * The third button which is the start button.
     */
    private Boolean b3 = false;
    /**
     * The fourth button which is the goal button.
     */
    private Boolean b4 = false;
    /**
     * The fifth button which is the solve button.
     */
    private Boolean b5 = false;

    private String[][] colors = new String[10][10];

    // ----------------------------------------------------------
    /**
     * This is the getter method for maze.
     * @return maze
     */
    // ----------------------------------------------------------
    public Maze getMaze()
    {
        return maze;
    }

    // ----------------------------------------------------------
    /**
     * Getter method for the double array colors.
     * @return colors
     */
    public String[][] getColors()
    {
        return colors;
    }

    // ----------------------------------------------------------
    /**
     * Getter for b1.
     * @return b1
     */
    public boolean getB1()
    {
        return b1;
    }
    // ----------------------------------------------------------
    /**
     * This is the setter method for b1.
     * @param x the boolean value you want b1 to be.
     */
    public void setB1(boolean x)
    {
        b1 = x;
    }
    // ----------------------------------------------------------
    /**
     * Getter for b2.
     * @return b2
     */
    public boolean getB2()
    {
        return b2;
    }
    // ----------------------------------------------------------
    /**
     * This is the setter method for b2.
     * @param x the boolean value you want b2 to be.
     */
    public void setB2(boolean x)
    {
        b2 = x;
    }
    // ----------------------------------------------------------
    /**
     * Getter for b3.
     * @return b3
     */
    public boolean getB3()
    {
        return b3;
    }
    // ----------------------------------------------------------
    /**
     * This is the setter method for b3.
     * @param x the boolean value you want b3 to be.
     */
    public void setB3(boolean x)
    {
        b3 = x;
    }
    // ----------------------------------------------------------
    /**
     * Getter for b4.
     * @return b4
     */
    public boolean getB4()
    {
        return b4;
    }
    // ----------------------------------------------------------
    /**
     * This is the setter method for b4.
     * @param x the boolean value you want b4 to be.
     */
    public void setB4(boolean x)
    {
        b4 = x;
    }
    // ----------------------------------------------------------
    /**
     * Getter for b5.
     * @return b5
     */
    public boolean getB5()
    {
        return b5;
    }
    // ----------------------------------------------------------
    /**
     * This is the setter method for b5.
     * @param x the boolean value you want b5 to be.
     */
    public void setB5(boolean x)
    {
        b5 = x;
    }
    /**
     * Resets all button values to be false.
     */
    public void reset()
    {
        setB1(false);
        setB2(false);
        setB3(false);
        setB4(false);
        setB5(false);
    }

    // ----------------------------------------------------------
    /**
     * Resets all button values to false then
     * sets b1 to be true if the draw button was clicked.
     */
    public void drawWallsClicked()
    {
        reset();
        setB1(true);
    }

    // ----------------------------------------------------------
    /**
     * Resets all button values to false then
     * sets b2 to true if the erase button was clicked.
     */
    public void eraseWallsClicked()
    {
        reset();
        setB2(true);
    }

    // ----------------------------------------------------------
    /**
     * Resets all button values to false then sets b3 to true if the start
     * button was clicked.
     */
    public void setStartClicked()
    {
        reset();
        setB3(true);
    }

    // ----------------------------------------------------------
    /**
     * Resets all button values to false then sets b4 to true if the goal
     * button was pressed.
     */
    public void setGoalClicked()
    {
        reset();
        setB4(true);
    }

    // ----------------------------------------------------------
    /**
     * Solves the maze and changes the colors of the cells to be green if that
     * cell is apart of the final solution and blue if the maze went through
     * those cells but they weren't apart of the solution. Then it displays the
     * final solution in the TextView if there was one or says that there wasn't
     * a solution.
     */
    public void solveClicked()
    {
        String solution = maze.solve();

        if (solution == null)
        {
            infoLabel.setText("No solution was possble.");
        }
        else
        {
            infoLabel.setText(solution);
        }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (maze.getStartLocation().x() == i &&
                    maze.getStartLocation().y() == j)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.red);
                    colors[i][j] = "red";
                }

                else if (maze.getGoalLocation().x() == i &&
                    maze.getGoalLocation().y() == j)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.green);
                    colors[i][j] = "green";
                }

                else if (maze.getCell(new Location(i, j)) ==
                    MazeCell.UNEXPLORED)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.black);
                    colors[i][j] = "black";
                }

                else if (maze.getCell(new Location(i, j)) == MazeCell.WALL)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.white);
                    colors[i][j] = "white";
                }

                else if (maze.getCell(new Location(i, j)) ==
                    MazeCell.CURRENT_PATH)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.green);
                    colors[i][j] = "green";
                }

                else if (maze.getCell(new Location(i, j)) ==
                    MazeCell.FAILED_PATH)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.blue);
                    colors[i][j] = "blue";
                }
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Changes the colors of the cell that was touched depending on the button
     * that is active.
     * @param x x coordinate of the touch
     * @param y y coordinate of the touch
     */
    public void onTouchDown(float x, float y)
    {
        int xCoor = (int)(x / (getWidth() / 10));
        int yCoor = (int)(y / (getHeight() / 10));
        colors = new String[10][10];

        RectangleShape tile = getShapes().locatedAt(x, y)
            .withClass(RectangleShape.class).front();

        if (b1)
        {
            maze.setCell(new Location(xCoor, yCoor), MazeCell.WALL);
            tile.setFillColor(Color.white);
            colors[xCoor][yCoor] = "white";
        }

        else if (b2)
        {
            maze.setCell(new Location(xCoor, yCoor), MazeCell.UNEXPLORED);
            tile.setFillColor(Color.black);
            colors[xCoor][yCoor] = "black";
        }

        else if (b3)
        {
            RectangleShape originalStart = getShapes()
                .locatedAt(maze.getStartLocation().x(),
                    maze.getStartLocation().y())
                    .withClass(RectangleShape.class).front();
            originalStart.setFillColor(Color.black);
            maze.setStartLocation(new Location(xCoor, yCoor));
            tile.setFillColor(Color.red);
            colors[xCoor][yCoor] = "red";
        }
        else if (b4)
        {
            RectangleShape originalGoal = getShapes()
                .locatedAt(maze.getGoalLocation().x(),
                    maze.getGoalLocation().y())
                    .withClass(RectangleShape.class).front();
            originalGoal.setFillColor(Color.black);
            maze.setGoalLocation(new Location(xCoor, yCoor));
            tile.setFillColor(Color.green);
            colors[xCoor][yCoor] = "green";
        }
    }

    // ----------------------------------------------------------
    /**
     * Changes the colors of the cells that were moved over depending on what
     * button is active.
     * @param x x coordinate of the touch
     * @param y y coordinate of the touch
     */
    public void onTouchMove(float x, float y)
    {
        int xCoor = (int)(x / (getWidth() / 10));
        int yCoor = (int)(y / (getHeight() / 10));

        RectangleShape tile = getShapes().locatedAt(x, y)
            .withClass(RectangleShape.class).front();

        if (b1)
        {
            maze.setCell(new Location(xCoor, yCoor), MazeCell.WALL);
            tile.setFillColor(Color.white);
            colors[xCoor][yCoor] = "white";
        }

        else if (b2)
        {
            maze.setCell(new Location(xCoor, yCoor), MazeCell.UNEXPLORED);
            tile.setFillColor(Color.black);
            colors[xCoor][yCoor] = "black";
        }

        else if (b3)
        {
            RectangleShape originalStart = getShapes()
                .locatedAt(maze.getStartLocation().x(),
                    maze.getStartLocation().y())
                    .withClass(RectangleShape.class).front();
            originalStart.setFillColor(Color.black);
            maze.setStartLocation(new Location(xCoor, yCoor));
            tile.setFillColor(Color.red);
            colors[xCoor][yCoor] = "red";
        }
        else if (b4)
        {
            RectangleShape originalGoal = getShapes()
                .locatedAt(maze.getGoalLocation().x(),
                    maze.getGoalLocation().y())
                    .withClass(RectangleShape.class).front();
            originalGoal.setFillColor(Color.black);
            maze.setGoalLocation(new Location(xCoor, yCoor));
            tile.setFillColor(Color.green);
            colors[xCoor][yCoor] = "green";
        }
    }

    // ----------------------------------------------------------
    /**
     * Initializes the starting maze and sets the color of the cells
     * accordingly.
     */
    public void initialize()
    {
        maze = new Maze(10);

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (maze.getStartLocation().x() == i &&
                    maze.getStartLocation().y() == j)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.red);
                    colors[i][j] = "red";
                }

                else if (maze.getGoalLocation().x() == i &&
                    maze.getGoalLocation().y() == j)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.green);
                    colors[i][j] = "green";
                }

                else if (maze.getCell(new Location(i, j)) ==
                    MazeCell.UNEXPLORED)
                {
                    RectangleShape tile = new RectangleShape(getWidth() / 10 * i
                        , getHeight() / 10 * j, getWidth() / 10 * (i + 1),
                        getHeight() / 10 * (j + 1));
                    add(tile);
                    tile.setFillColor(Color.black);
                    colors[i][j] = "black";
                }
            }
        }
    }
}
