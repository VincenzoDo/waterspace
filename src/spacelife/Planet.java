package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Planet extends WorldElement {
    
    private Alien population;

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
}