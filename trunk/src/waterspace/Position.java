package waterspace;

/**
 * <h1>Postion</h1> <p>Class to represent the position of an element on the
 * map with associated possible moves</p>
 *
 * @author Tarek Amiri
 */
public class Position {

    private int xCor; //x-coordinate
    private int yCor; //y-coordinate
    SimulParams params;

    /**
     * Constructor
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param params Simulation parameters
     */
    public Position(int x, int y, SimulParams params) {
        xCor = x;
        yCor = y;
        this.params = params;
    }

    public int getX() {
        return xCor;
    }

    public int getY() {
        return yCor;
    }

    /**
     * Sets new position of x-coordinate. If the new coordinate is
     * "out-of-bounds" it corrects it by the edge value of the map using the
     * simulation parameters
     *
     * @param x
     */
    public void setX(int x) {
        if (x < 0) {
            xCor = 0;
        } else if (x > params.getMapWidth()) {
            xCor = params.getMapWidth();
        }
    }

    /**
     * Sets new position of y-coordinate. If the new coordinate is
     * "out-of-bounds" it corrects it by the edge value of the map using the
     * simulation parameters
     *
     * @param y
     */
    public void setY(int y) {

        if (y < 0) {
            yCor = 0;
        } else if (y > params.getMapHeight()) {
            yCor = params.getMapHeight();
        }
    }

    /**
     * Set the new position with x and y coordinate
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void setNewPosition(int x, int y) {

        setX(x);
        setY(y);

    }

    /**
     * Moves left from current position
     */
    public void moveLeft() {

        int newX = xCor - 1;
        setX(newX);

    }

    /**
     * Moves right from current position
     */
    public void moveRight() {

        int newX = xCor + 1;
        setX(newX);

    }

    /**
     * Moves up from current position
     */
    public void moveUp() {

        int newY = yCor + 1;
        setY(newY);

    }

    /**
     * Moves down from current position
     */
    public void moveDown() {

        int newY = yCor - 1;
        setY(newY);

    }
}
