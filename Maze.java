package cs2114.mazesolver;

import java.util.Stack;

// -------------------------------------------------------------------------
/**
 *  This class represents the whole maze.
 *  The maze is made up of a 2 dimensional grid of locations and finds a way
 *  to solve itself.
 *
 *  @author Cameron Byers
 *  @version Oct 6, 2014
 */
public class Maze
    implements IMaze
{
    private final int size;
    private final MazeCell[][] board;
    private Location start;
    private Location end;

    // ----------------------------------------------------------
    /**
     * Create a new Maze object.
     * @param boardSize size of the board
     */
    public Maze(int boardSize)
    {
        size = boardSize;
        board = new MazeCell[size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                board[i][j] = MazeCell.UNEXPLORED;
            }
        }
        start = new Location(0, 0);
        end = new Location(size - 1, size - 1);
    }

    /**
     * gets the enumerated value of the location
     * @param loc is the location that your getting the value of
     * @return the MazeCell at the location
     */
    @Override
    public MazeCell getCell(ILocation loc)
    {
        if (loc.x() < 0 || loc.x() > size - 1 || loc.y() < 0
            || loc.y() > size - 1)
        {
            return MazeCell.INVALID_CELL;
        }
        else
        {
            return board[loc.x()][loc.y()];
        }
    }

    /**
     * gets the end location
     * @return the end location
     */
    @Override
    public ILocation getGoalLocation()
    {
        return end;
    }

    /**
     * gets the start location
     * @return the start location
     */
    @Override
    public ILocation getStartLocation()
    {
        return start;
    }

    /**
     * sets the cell to be a different MazeCell enumerated type
     * @param loc location that we want to change the enumerated type
     * @param cellType the enumerated type we want the location to be
     */
    @Override
    public void setCell(ILocation loc, MazeCell cellType)
    {
        if (cellType != MazeCell.WALL && loc.equals(getStartLocation()))
        {
            board[loc.x()][loc.y()] = cellType;
        }
        else if (cellType != MazeCell.WALL && loc.equals(getGoalLocation()))
        {
            board[loc.x()][loc.y()] = cellType;
        }
        else if (getCell(loc) != MazeCell.INVALID_CELL
            && !loc.equals(getStartLocation())
            && !loc.equals(getGoalLocation()))
        {
            board[loc.x()][loc.y()] = cellType;
        }
    }

    /**
     * sets the end location to the location parameter
     * @param loc is the location of the goal
     */
    @Override
    public void setGoalLocation(ILocation loc)
    {
        if (getCell(loc) != MazeCell.INVALID_CELL)
        {
            if (getCell(loc) == MazeCell.WALL)
            {
                board[loc.x()][loc.y()] = MazeCell.UNEXPLORED;
                end = new Location(loc.x(), loc.y());
            }
            else
            {
                end = new Location(loc.x(), loc.y());
            }
        }
    }

    /**
     * sets the start location to be the location of the parameter
     * @param loc the location of the start
     */
    @Override
    public void setStartLocation(ILocation loc)
    {
        if (getCell(loc) != MazeCell.INVALID_CELL)
        {
            if (getCell(loc) == MazeCell.WALL)
            {
                board[loc.x()][loc.y()] = MazeCell.UNEXPLORED;
                start = new Location(loc.x(), loc.y());
            }
            else
            {
                start = new Location(loc.x(), loc.y());
            }
        }
    }

    /**
     * gets the size of the board
     * @return the size of the board
     */
    @Override
    public int size()
    {
        return size;
    }


    @Override
    public String solve()
    {
        Stack<Location> route = new Stack<Location>();
        route.push(start);

        while (!route.empty())
        {
            Location cLoc = route.peek();
            board[cLoc.x()][cLoc.y()] = MazeCell.CURRENT_PATH;

            if (cLoc.equals(end))
            {
                String finalRoute = "";
                while (!route.empty())
                {
                    finalRoute = route.peek().toString() + " " + finalRoute;
                    route.pop();
                }
                return finalRoute;
            }
            else if (getCell(cLoc.east()) == MazeCell.UNEXPLORED)
            {
                route.push((Location)cLoc.east());
            }
            else if (getCell(cLoc.north()) == MazeCell.UNEXPLORED)
            {
                route.push((Location)cLoc.north());
            }
            else if (getCell(cLoc.west()) == MazeCell.UNEXPLORED)
            {
                route.push((Location)cLoc.west());
            }
            else if (getCell(cLoc.south()) == MazeCell.UNEXPLORED)
            {
                route.push((Location)cLoc.south());
            }
            else
            {
                board[cLoc.x()][cLoc.y()] = MazeCell.FAILED_PATH;
                route.pop();
            }
        }
        return null;
    }

}
