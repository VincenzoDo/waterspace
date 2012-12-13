package waterspace;

public class Position {

    private int xCor;
    private int yCor;
    SimulParams params;

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

    public void setX(int x) {
        if (x < 0) {
            xCor = 0;
        } else if (x > params.getMapWidth()) {
            xCor = params.getMapWidth();
        }
    }

    public void setY(int y) {

        if (y < 0) {
            yCor = 0;
        } else if (y > params.getMapHeight()) {
            yCor = params.getMapHeight();
        }
    }

    public void setNewPosition(int x, int y) {

        setX(x);
        setY(y);

    }

    public void moveLeft() {
        
        int newX = xCor - 1;
        setX(newX);
        
    }
    
    public void moveRight() {
        
        int newX = xCor + 1;
        setX(newX);
        
    }
    
    public void moveUp() {
        
        int newY = yCor + 1;
        setY(newY);
        
    }
    
    public void moveDown() {
        
        int newY = yCor - 1;
        setY(newY);
        
    }
    
    
}
