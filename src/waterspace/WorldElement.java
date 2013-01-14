package waterspace;

//Tarek
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * <h1>WorldElement</h1>
 *
 * @author Tarek Amiri
 */
public abstract class WorldElement {

    private Position pos;
    private int speed;
    private String img;
    private ElementType type;
    private AbstractWorld world;
    private static int counter = 1;
    private int id;
    
    static private Random rand = new Random();
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    /**
     * This constructor is only used by sigleton classes !
     */
    public WorldElement() {
    }

    /**
     * Regular Constructor for IWorldElement
     *
     * @param pos Position of Element
     * @param speed Speed of Element
     * @param img Image to display for the Element
     * @param type Element Type
     */
    public WorldElement(Position pos, int speed, String img,
            ElementType type) {
        this.pos = pos;
        this.speed = speed;
        this.img = img;
        this.type = type;
        this.id = counter++;
       // WorldManager.listElement.add(this);
    }
    
    /**
     * Moves the World Element depending the speed 
     * E.g.: (speed = 1 -> moves every tick)
     *       (speed = 2 -> moves every second tick)
     *       etc..
     * @param tickNbr 
     */
    public void move(int tickNbr) {

        //Check if it's time to move
        if (speed != 0 && (tickNbr % speed) == 0) {

            int direction = rand.nextInt(4);

            switch (direction) {

                case LEFT:
                    pos.moveLeft();
                    break;
                case RIGHT:
                    pos.moveRight();
                    break;
                case UP:
                    pos.moveUp();
                    break;
                case DOWN:
                    pos.moveDown();
                    break;

            }

        }

    }

    public Position getPosition() {
        return pos;
    }

    public ElementType getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public String getImage() {
        return img;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setType(ElementType type) {
        this.type = type;
    }
    
    public int getId(){
        return id;
    }
    
}