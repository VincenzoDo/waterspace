package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Ice extends WaterElement {

    private WaterWorld world;
    private Position position;
    private WaterParams params = world.getParams();
    private Random r;
    private boolean meltOrGrow;

    public Ice(WaterWorld world) {
        this.world = world;
        r = new Random();
        this.meltOrGrow = false;
    }

    @Override
    public void move() {
        this.meltOrGrow = r.nextBoolean();
        if (meltOrGrow) {
            boolean free = false;
            while (!free) {
                int x = r.nextInt(params.getWorld_width());
                int y = r.nextInt(params.getWorld_height());
                if (this.world.isCellFree(x, y)) {
                    addIce(x, y);
                    free = true;
                }

            }
        } else {
            //melt the ice
            WorldElement ice = this.world.selectRandomPrey(this);
            if (ice != null) {
                // kill prey
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
        int x = r.nextInt(params.getWorld_width());
        int y = r.nextInt(params.getWorld_height());
        //check position
        if (this.world.isCellFree(x, y)) {
            this.getPosition().setNewPosition(x, y);
        } else {
            placeElement();
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
