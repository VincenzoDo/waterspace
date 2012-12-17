package spacelife;

import java.util.Random;
import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.WorldElement;
import waterspace.Position;

public class Alien extends WorldElement {

    Random r;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public Alien(Position pos, int speed, ImageIcon img,
            ElementType type) {

        super(pos, speed, img, type);

    }

    /**
     * Moves the Alien depending the speed 
     * E.g.: (speed = 1 -> moves every tick)
     *       (speed = 2 -> moves every second tick)
     * @param tickNbr 
     */
    public void move(int tickNbr) {

        //Check if it's time to move
        if (super.getSpeed() != 0 && (tickNbr % super.getSpeed()) == 0) {

            int direction = r.nextInt(4);

            switch (direction) {

                case LEFT:
                    super.getPosition().moveLeft();
                    break;
                case RIGHT:
                    super.getPosition().moveRight();
                    break;
                case UP:
                    super.getPosition().moveUp();
                    break;
                case DOWN:
                    super.getPosition().moveDown();
                    break;

            }

        }

    }
}