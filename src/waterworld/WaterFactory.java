package waterworld;

import waterspace.AbstractFactory;

public class WaterFactory extends AbstractFactory {
    
    private WaterParams params;
    private WaterWorld world;
    //singletons
    private Whale whale;

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
        return whale.getInstance();
    }

    public Ice createIce() {
        return new Ice(world);
    }

    public WaterWorld createWorld() {
        return new WaterWorld(params, this);
    }
    
    public void setWorld(WaterWorld world){
        this.world=world;
    }
}