package waterworld;

import spacelife.SpaceFactory;
import spacelife.SpaceParams;
import waterspace.AbstractFactory;
import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.SimulParams;
import waterspace.WorldElement;

public class WaterFactory extends AbstractFactory {
    
    private WaterParams params;
    private WaterWorld world;
    private boolean genderP;
    private boolean genderS;
    private Position pos;
    
    public WaterFactory(WaterParams params) {
        this.params = params;
        this.genderP= false;
        this.genderS= true;
        this.pos = new Position(0,0,params);
    }

    /**
     * Create a new Shark
     * @pre createWorld must be called before
     * @return Skark
     */
    public Shark createShark() {
        this.genderS = !genderS;
        return new Shark(genderS, world,pos, ElementType.WATER_SHARK);
    }
    
    /**
     * Create a new Penguin
     * @pre createWorld must be called before
     * @return Penguin
     */
    public Penguin createPenguin() {
        if(this.world == null){
            System.out.println("BAH");
            System.exit(1);
        }
        this.genderP = !genderP;
        return new Penguin(genderP, world, pos, ElementType.WATER_PENGUIN);
    }

    /**
     * Create a new Whale
     * @pre createWorld must be called before
     * @return Whale
     */
    public Whale createWhale() {
        return Whale.getInstance();
    }
    
    /**
     * Create a new Ice
     * @pre createWorld must be called before
     * @return Ice
     */
    public Ice createIce() {
        return new Ice(world, pos , ElementType.WATER_ICE);
    }

	@Override
	public WorldElement createElement(ElementType type, Position pos) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Create a new World
     * @return World
     */
	@Override
	public AbstractWorld createWorld(SimulParams param) {
		this.world = new WaterWorld((WaterParams)params);
        this.world.iniWorld(this);
		return this.world;
	}

    boolean isWorld() {
        return this.world != null;
    }


}