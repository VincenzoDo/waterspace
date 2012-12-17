package spacelife;

import java.util.Random;
import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.WorldElement;
import waterspace.Position;

public class Planet extends WorldElement {
    
    private Alien population;
    Random r;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public Planet(Position pos, int speed, ImageIcon img) {
        super(pos, speed, img, ElementType.SPACE_PLANET);
        population = null;
    }
    
    /**
     * Tells if a planet is already occupied
     * @return true if occupied false if not
     */
    public boolean isOccupied(){
        return population != null;
    }
    
    /**
     * Occupies a planet with a Alien
     * @param race
     * @return true when occupation successful false if not
     */
    public boolean occupy(Alien race){
    
        boolean result = false;
        
        if(!isOccupied()){
            population = race;
            result = true;
        }
        
        return result;
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