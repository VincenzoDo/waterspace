package waterworld;

import waterspace.AbstractFactory;

public class WaterFactory extends AbstractFactory {
    
    private WaterParams params;
    private WaterWorld world;

    public WaterFactory(WaterParams params) {
        this.params = params;
    }

    public Shark createShark(boolean sex) {
        return new Shark(sex, world);
    }

    public Penguin createPenguin(boolean sex) {
        return new Penguin(sex, world);
    }

    public Whale createWhale() {
        throw new UnsupportedOperationException();
    }

    public void createIce() {
        throw new UnsupportedOperationException();
    }

    public WaterWorld createWorld() {
        return new WaterWorld(params, this);
    }
    
    public void setWorld(WaterWorld world){
        this.world=world;
    }
}