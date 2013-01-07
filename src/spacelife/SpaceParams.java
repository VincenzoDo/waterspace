package spacelife;

import waterspace.ElementType;
import waterspace.SimulParams;

public class SpaceParams extends SimulParams{
	private int nbOfPlanet;
	private int nbOfAsteroid;
	private int nbOfKryptonian;
	private int nbOfMartian;
	
	public SpaceParams(int world_width,int world_height, int nbPlanet, int nbMartian, int nbKryptonian, int nbAsteroid){
		 super(world_height,world_width);
		 this.setMapHeight(world_height);
	     this.setMapWidth(world_width);
	     this.nbOfAsteroid= nbAsteroid;
	     this.nbOfKryptonian = nbKryptonian;
	     this.nbOfMartian = nbMartian;
	     this.nbOfPlanet = nbPlanet;
	}
	
    public SpaceParams(int world_width,int world_height){
        super(world_width, world_height);
        
    }
    
    
    public int getNbOfElement(ElementType type){
        switch(type){
            case SPACE_ASTEROID : return getNbOfAsteroid();
            case SPACE_BLACKHOLE : return 1;
            case SPACE_PLANET : return getNbOfPlanet();
            case SPACE_MARTIAN : return getNbOfMartian();
            case SPACE_KRYPTONIAN : return getNbOfKryptonian();
            default: return -1;
        }
    }
    
	public int getNbOfPlanet() {
		return nbOfPlanet;
	}
	public void setNbOfPlanet(int nbOfPlanet) {
		this.nbOfPlanet = nbOfPlanet;
	}
	public int getNbOfAsteroid() {
		return nbOfAsteroid;
	}
	public void setNbOfAsteroid(int nbOfAsteroid) {
		this.nbOfAsteroid = nbOfAsteroid;
	}
	public int getNbOfMartian() {
		return nbOfMartian;
	}
	public void setNbOfMartian(int nbOfMartian) {
		this.nbOfMartian = nbOfMartian;
	}
	public int getNbOfKryptonian() {
		return nbOfKryptonian;
	}
	public void setNbOfKryptonian(int nbOfKryptonian) {
		this.nbOfKryptonian = nbOfKryptonian;
	}
	
	
    public int getWorld_height() {
        return getMapHeight();
    }

    public int getWorld_width() {
        return getMapWidth();
    }
	
    public void setWorld_height(int world_height) {
        this.setMapHeight(world_height);
    }

    public void setWorld_width(int world_width) {
        this.setMapWidth(world_width);
        
    }
	
	
}