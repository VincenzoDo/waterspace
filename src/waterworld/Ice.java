package waterworld;

import waterspace.ElementType;
import waterspace.WorldElement;

public class Ice extends WaterElement {

    private WaterWorld world;
    private static Ice instance;
    private boolean[][] position;
    private boolean init = false;

    private Ice() {
    }

    public Ice getInstance() {
        if (instance == null) {
            instance = new Ice();
        }
        return this.instance;
    }

    @Override
    public void move() {
        if(init){
            
        }
        throw new UnsupportedOperationException();
    }
    
    public void addIce(int x, int y) {
        if (init) {
            position[x][y] = true;
        }
    }

    public void initIce(int x, int y, WaterWorld world) {
        if(!init){
            init=true;
            this.world=world;
            position = new boolean[x][y];
        }
    }
    
    @Override
    public void placeElement(){
        
    }
    
    public ElementType getElementType(){
        return ElementType.WATER_ICE;
    }
}