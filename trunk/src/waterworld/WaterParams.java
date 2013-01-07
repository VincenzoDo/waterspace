package waterworld;

import waterspace.ElementType;
import waterspace.SimulParams;

public class WaterParams extends SimulParams {
	private int nbOfShark;
	private int nbOfPenguin;
	private int nbOfIce;
	private int starving_each;
        private int sexCounter;

    public WaterParams(int world_width,int world_height, int nbOfShark, int nbOfPenguin, int nbOfIce, int starving_each, int sexCounter) {
        super(world_height,world_width);
        this.setMapHeight(world_height);
        this.setMapWidth(world_width);
        this.nbOfShark = nbOfShark;
        this.nbOfPenguin = nbOfPenguin;
        this.nbOfIce = nbOfIce;
        this.starving_each = starving_each;
        this.setMapHeight(world_height);
        this.setMapWidth(world_width);
        this.sexCounter = sexCounter;
        
    }
    
     public WaterParams(int world_width,int world_height){
         super(world_width, world_height);
         
     }
    
    public int getNbOfElement(ElementType type){
        switch(type){
            case WATER_ICE : return getNbOfIce();
            case WATER_PENGUIN : return getNbOfPenguin();
            case WATER_SHARK : return getNbOfShark();
            case WATER_WHALE : return 1;
            default: return -1;
        }
    }
    
    public int getNbOfShark() {
        return nbOfShark;
    }

    public int getNbOfPenguin() {
        return nbOfPenguin;
    }

    public int getNbOfIce() {
        return nbOfIce;
    }

    public int getStarving_each() {
        return starving_each;
    }

    public int getWorld_height() {
        return getMapHeight();
    }

    public int getWorld_width() {
        return getMapWidth();
    }
        
    
    public int getSexCounter(){
        return sexCounter;
    }

    public void setNbOfShark(int nbOfShark) {
        this.nbOfShark = nbOfShark;
    }

    public void setNbOfPenguin(int nbOfPenguin) {
        this.nbOfPenguin = nbOfPenguin;
    }

    public void setNbOfIce(int nbOfIce) {
        this.nbOfIce = nbOfIce;
    }

    public void setStarving_each(int starving_each) {
        this.starving_each = starving_each;
    }

    public void setWorld_height(int world_height) {
        this.setMapHeight(world_height);
    }

    public void setWorld_width(int world_width) {
        this.setMapWidth(world_width);
        
    }

    public void setSexCounter(int sexCounter) {
        this.sexCounter = sexCounter;
    }
        
    
}
