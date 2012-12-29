package waterworld;

import waterspace.AbstractFactory;

public class WaterFactory extends AbstractFactory {
    
    private WaterParams params;
    private WaterWorld world;
    //singletons
    private Whale whale;
    private boolean genderP;
    private boolean genderS;
    
    public WaterFactory(WaterParams params) {
        this.params = params;
        this.genderP= false;
        this.genderS= true;
    }

    public Shark createShark() {
        this.genderS = !genderS;
        return new Shark(genderS, world);
    }

    public Penguin createPenguin() {
        this.genderP = !genderP;
        return new Penguin(genderP, world);
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