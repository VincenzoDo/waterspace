package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Alien extends WorldElement {

    public Alien(Position pos, int speed, String img,
            ElementType type) {
        super(pos, speed, img, type);

    }
    public boolean placeElement() {
		return false;
	}
    
}