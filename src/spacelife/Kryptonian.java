package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;

public class Kryptonian extends Alien {

    public Kryptonian(Position pos, int speed, String img) {
        super(pos, speed, img, ElementType.SPACE_KRYPTONIAN);
    }
    
    public boolean placeElement() {
		return false;
	}
}