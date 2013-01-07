package spacelife;

import waterspace.SimulParams;

public class SpaceParams extends SimulParams {
    
    public SpaceParams(int mapWidth, int mapHeight) {
        super(mapWidth, mapHeight);
    }
    
    public SpaceParams(int world_width, int world_height, int nbOfPlanet, int nbOfAsteroid, int nbOfKryptonian, int nbOfMartian){
        super(world_width, world_height);
        
        this.nbOfPlanet = nbOfPlanet;
        this.nbOfAsteroid = nbOfAsteroid;
        this.nbOfKryptonian = nbOfKryptonian;
        this.nbOfMartian = nbOfMartian;
        this.world_width = world_width;
        this.world_height = world_height;
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
    public int getNbOfKryptonian() {
        return nbOfKryptonian;
    }
    public void setNbOfKryptonian(int nbOfKryptonian) {
        this.nbOfKryptonian = nbOfKryptonian;
    }
    public int getNbOfMartian() {
        return nbOfMartian;
    }
    public void setNbOfMartian(int nbOfMartian) {
        this.nbOfMartian = nbOfMartian;
    }
    public int getWorld_height() {
        return world_height;
    }
    public void setWorld_height(int world_height) {
        this.world_height = world_height;
    }
    public int getWorld_width() {
        return world_width;
    }
    public void setWorld_width(int world_width) {
        this.world_width = world_width;
    }
    private int nbOfPlanet = 3;
    private int nbOfAsteroid = 1;
    private int nbOfKryptonian = 1;
    private int nbOfMartian = 1;
    private int world_height = 1;
    private int world_width = 1;
}