package waterworld;
/*
 * Vincenzo Do, Romain Monnard
 * Penguin, a class to rapresent a penguin
 * 
 * Version 1
 */

import waterspace.ElementType;
import waterspace.WorldElement;

public class Penguin extends WaterElement {

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

    @Override
    public void move() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void kill(){
        
    }

    public boolean getSex() {
        return sex;
    }

    public int getSexCounter() {
        return sexCounter;
    }
    
    public void updateCounters(){
        this.sexCounter++;
    }
    
    public ElementType getElementType(){
        return ElementType.WATER_PENGUIN;
    }
}