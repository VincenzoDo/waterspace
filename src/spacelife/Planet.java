package spacelife;

import javax.swing.ImageIcon;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Planet extends WorldElement {
    
    private Alien population;
    
    private String imgPlanetM;
    private String imgPlanetK;
    private String imgPlaneteEmpty;

    public Planet(Position pos, int speed, String imgPlaneteEmpty, String imgPlanetM, String imgPlanetK) {
        super(pos, speed, imgPlaneteEmpty, ElementType.SPACE_PLANET);
        population = null;
        this.imgPlanetM = imgPlanetM;
        this.imgPlanetK = imgPlanetK;
        this.imgPlaneteEmpty = imgPlaneteEmpty;
    }
    
    @Override
    public String getImage() {
        if(!isOccupied()){
            return imgPlaneteEmpty;
        }
        else{
            if(population instanceof Martian){
                return imgPlanetM;
            }
            else{
                return imgPlanetK;
            }
        }
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