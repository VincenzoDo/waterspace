package waterworld;

import waterspace.ElementType;
import waterspace.WorldElement;

public class Whale extends WaterElement {

    private WaterWorld world;
    private boolean init=false;
    private static Whale instance;

    private Whale() {
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }

    public Whale getInstance() {
        if (instance == null) {
            instance = new Whale();
        }
        return this.instance;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException();
    }
    
   
    public void initWhale(WaterWorld world){
        if(!init){
            init=true;
            this.world=world;
        }
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_WHALE;
    }

    @Override
    public void placeElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
