package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 *  This class represents the cells of the maze.
 *  Its purpose is to remember the coordinates of each location in the maze.
 *
 *  @author Cameron Byers
 *  @version Oct 6, 2014
 */
public class Location
    implements ILocation
{
    private final int x;
    private final int y;

    // ----------------------------------------------------------
    /**
     * Create a new Location object.
     * @param xcoor x coordinate of the location
     * @param ycoor y coordinate of the location
     */
    public Location(int xcoor, int ycoor)
    {
        x = xcoor;
        y = ycoor;
    }

    /**
     * Gets the new location that is east of this location.
     * @return east location
     */
    @Override
    public ILocation east()
    {
        return new Location(x + 1, y);
    }


    /**
     * Gets the new location that is north of this location.
     * @return north location
     */
    @Override
    public ILocation north()
    {
        return new Location(x, y - 1);
    }


    /**
     * Gets the new location that is south of this location.
     * @return south location
     */
    @Override
    public ILocation south()
    {
        return new Location(x, y + 1);
    }


    /**
     * Gets the new location that is west of this location.
     * @return west location
     */
    @Override
    public ILocation west()
    {
        return new Location(x - 1, y);
    }

    /**
     * Gets the x coordinate of the location.
     * @return x coordinate
     */
    @Override
    public int x()
    {
        return x;
    }

    /**
     * Gets the y coordinate of the location.
     * @return y coordinate
     */
    @Override
    public int y()
    {
        return y;
    }

    // ----------------------------------------------------------
    /**
     * Compares two locations to see if there x and y coordinates are the same.
     * @param loc is other location being compared to this location.
     * @return true if equal false otherwise
     */
    @Override
    public boolean equals(Object loc)
    {
        if (loc instanceof Location)
        {
            return (this.x() == ((Location)loc).x()
                && this.y() == ((Location)loc).y());
        }
        return false;
    }

    /**
     * Turns the location's coordinates into a string.
     * @return string of coordinates
     */
    @Override
    public String toString()
    {
        return "(" + this.x() + ", " + this.y() + ")";
    }

}
