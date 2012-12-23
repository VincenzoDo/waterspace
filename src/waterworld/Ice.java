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

    public static Ice getInstance() {
        if (instance == null) {
            instance = new Ice();
        }
        return instance;
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
    
    public boolean isIce(int x, int y){
        return position[x][y];
    }
    
    public void initIce(int x, int y, WaterWorld world) {
        if(!init){
            init=true;
            this.world=world;
            position = new boolean[x][y];
        }
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_ICE;
    }

    @Override
    public boolean placeElement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}