package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.WorldElement;
import waterspace.Position;

public class Asteroid extends WorldElement {

    public Asteroid(Position pos, int speed, ImageIcon img) {
        super(pos, speed, img, ElementType.SPACE_ASTEROID);
    }

}