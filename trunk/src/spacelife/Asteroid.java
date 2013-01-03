package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Asteroid extends WorldElement {

    public Asteroid(Position pos, int speed, String img) {
        super(pos, speed, img, ElementType.SPACE_ASTEROID);
    }

}