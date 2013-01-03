package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;

public class Martian extends Alien {

    public Martian(Position pos, int speed, String img) {
        super(pos, speed, img, ElementType.SPACE_MARTIAN);
    }
}