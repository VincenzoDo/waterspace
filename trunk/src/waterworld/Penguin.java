package waterworld;
/*
 * Vincenzo Do, Romain Monnard
 * Penguin, a class to rapresent a penguin
 * 
 * Version 1
 */

import waterspace.IWorldElement;

public class Penguin extends IWorldElement {

    private WaterWorld world;
    //true male, false female
    private boolean sex;
    private int sexCounter;
    
    
    public Penguin(boolean sex, WaterWorld world) {
        this.world= world;
        this.sex = sex;
        this.sexCounter = 0;

    }

    public void breed() {
        throw new UnsupportedOperationException();
    }

    public void move() {
        throw new UnsupportedOperationException();
    }

    public boolean getSex() {
        return sex;
    }

    public int getSexCounter() {
        return sexCounter;
    }
    
    @Override
    public void placeElement(){
        
    }
}