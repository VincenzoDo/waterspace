package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Ice extends WaterElement {

    private WaterWorld world;
    private WaterParams params;
    private Random r;
    private boolean meltOrGrow;

    public Ice(WaterWorld world, Position pos, ElementType type) {
        super(pos, type);
        this.setType(type);
        this.setPos(pos);
        this.setImg("/image/ice.jpg");
        this.world = world;
        this.params = world.getParams();
        r = new Random();
        this.meltOrGrow = false;
    }

    @Override
    public void move() {
        this.meltOrGrow = r.nextBoolean();
        if (meltOrGrow) {
            this.world.createNewborn(this);
        } else {
            //melt the ice
            WorldElement ice = this.world.selectRandomPrey(this);
            if (ice != null) {
                // kill prey
                System.out.println("Removing ICE in pos = "+this.getPosition().getX()+":"+this.getPosition().getY());
                this.world.killPreyElement(ice);
            }
        }
    }

    private void addIce(int x, int y) {
        if (this.world.getIceCounter() < ((params.getWorld_height() * params.getWorld_width()) / 100) * 50) {
            Position p = new Position(x, y, params);
            WaterFactory factory = this.world.getFactory();
            Ice ice = factory.createIce();
            ice.setPos(p);
        }

    }

    public ElementType getElementType() {
        return ElementType.WATER_ICE;
    }

    @Override
    public boolean placeElement() {
        boolean found = false;
        while (!found) {
            int x = r.nextInt(params.getWorld_width());
            int y = r.nextInt(params.getWorld_height());
            //check position
            if (this.world.isCellFree(x, y) || this.world.isPenguin(new Position(x,y,null))) {
                this.setPos(new Position(x, y, params));
                System.out.println("Adding ICE in pos = "+this.getPosition().getX()+":"+this.getPosition().getY());
                found=true;
            }
        }
        return true;
    }

    @Override
    public void kill() {
        //do nothing
    }

    @Override
    public void eat() {
        //do nothing
    }

    @Override
    public void breed() {
        //do nothing
    }
}
