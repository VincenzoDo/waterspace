package waterworld;

import waterspace.AbstractFactory;
import waterspace.ElementType;
import waterspace.Position;

public class WaterFactory extends AbstractFactory {
    
    private WaterParams params;
    private WaterWorld world;
    private boolean genderP;
    private boolean genderS;
    private Position pos;
    
    public WaterFactory(WaterParams params, WaterWorld world) {
        this.params = params;
        this.genderP= false;
        this.genderS= true;
        this.world=world;
        this.pos = new Position(0,0,params);
    }

    public Shark createShark() {
        this.genderS = !genderS;
        return new Shark(genderS, world,pos, ElementType.WATER_SHARK);
    }

    public Penguin createPenguin() {
        this.genderP = !genderP;
        return new Penguin(genderP, world, pos, ElementType.WATER_PENGUIN);
    }

    public Whale createWhale() {
        return Whale.getInstance();
    }

    public Ice createIce() {
        return new Ice(world, pos , ElementType.WATER_ICE);
    }


}