package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.WorldElement;
import waterspace.Position;

public class Shark extends WaterElement {
    
    private WaterWorld world;
    private boolean sex;
    private int sexCounter;
    private int eatCounter;
    private Random r;
    private Whale whale;

    public Shark(boolean sex, WaterWorld world) {
        this.r= new Random();
        this.sex = sex;
        this.world=world;
    }
    
    
    private int isWhaleNear(){
        Position whalePos = whale.getInstance().getPosition();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        Position up = new Position(x, y+1, null);
        Position down = new Position(x, y-1, null);
        Position left = new Position(x-1, y, null);
        Position right = new Position(x+1, y, null);
        return 0;
        
        
    }

    public void breed() {
        throw new UnsupportedOperationException();
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {
       int direction = r.nextInt(5); //0 down, 1 up, 2 left, 3 right, 4 stay
       whale.getInstance().getPosition();
    }
    
    @Override
    public void kill(){
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
    public void updateCounters(){
        this.sexCounter++;
        this.eatCounter++;
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_SHARK;
    }

    @Override
    public void placeElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}