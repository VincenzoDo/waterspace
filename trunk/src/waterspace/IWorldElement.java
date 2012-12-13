package waterspace;

//Tarek
import javax.swing.ImageIcon;

public class IWorldElement {

    private Position pos;
    private int speed;
    private ImageIcon img;
    private ElementType type;
    public AbstractWorld world;

    /**
     * This constructor is only used by sigleton classes !
     */
    public IWorldElement() {
    }

    /**
     * Regular Constructor for IWorldElement
     *
     * @param pos Position of Element
     * @param speed Speed of Element
     * @param img Image to display for the Element
     * @param type Element Type
     */
    public IWorldElement(Position pos, int speed, ImageIcon img,
            ElementType type) {
        this.pos = pos;
        this.speed = speed;
        this.img = img;
        this.type = type;
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

    public ImageIcon getImage() {
        return img;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public void setType(ElementType type) {
        this.type = type;
    }
}