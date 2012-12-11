package waterworld;

import waterspace.ElementType;
import waterspace.IWorldElement;

public class Shark extends IWorldElement {
    
    private WaterWorld world;
    private boolean sex;
    private int sexCounter;
    private int eatCounter;

    public Shark(boolean sex, WaterWorld world) {
        this.sex = sex;
        this.world=world;
    }

    public void breed() {
        throw new UnsupportedOperationException();
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }

    public void move() {
        throw new UnsupportedOperationException();
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getSexCounter() {
        return sexCounter;
    }

    public void setSexCounter(int sexCounter) {
        this.sexCounter = sexCounter;
    }

    public int getEatCounter() {
        return eatCounter;
    }

    public void setEatCounter(int eatCounter) {
        this.eatCounter = eatCounter;
    }
    
    @Override
    public void placeElement(){
        
    }
    
    
    @Override
    public void updateCounters(){
        this.sexCounter++;
        this.eatCounter++;
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_SHARK;
    }
}