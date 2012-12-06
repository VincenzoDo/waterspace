package waterworld;

import waterspace.IWorldElement;

public class Whale extends IWorldElement {

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

    public void move() {
        throw new UnsupportedOperationException();
    }
    
    public void initWhale(WaterWorld world){
        if(!init){
            init=true;
            this.world=world;
        }
    }
}