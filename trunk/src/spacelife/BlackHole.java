package spacelife;
/**
 * BlackHole
 * WorldElement inheriting form IWorldElement Class
 * 
 * Implementing Singleton Pattern:
 *  - To set the propreties of the object, you must use the initObject(...)
 *    Method
 * 
 * @author Raiden
 */
import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.IWorldElement;
import waterspace.Position;

public class BlackHole extends IWorldElement {

    private static BlackHole uniqueInstance;

    private BlackHole() {

    }

    public static BlackHole getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BlackHole();
        }
        return uniqueInstance;
    }
    
    /**
     * Convenience method to set the proprieties of object
     * @param pos
     * @param speed
     * @param img 
     */
    public void initObject(Position pos, int speed, ImageIcon img){
        this.setPos(pos);
        this.setSpeed(speed);
        this.setImg(img);
        this.setType(ElementType.SPACE_BLACKHOLE);
    }

}