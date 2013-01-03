package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Whale extends WaterElement {

    private WaterWorld world;
    private boolean init = false;
    private static Whale instance;
    private Random r;
    private WaterParams params;
    private boolean hasKilled;
    private int eatCounter;

    private Whale() {
        super(new Position(0, 0, null), ElementType.WATER_WHALE);
    }

    @Override
    public void kill() {
        //selectRandomPreyNeighbour
        WorldElement prey = this.world.selectRandomPrey(this);
        if (prey != null) {
            // kill prey
            this.world.killPreyElement(prey);
        }


    }

    @Override
    public void eat() {
        if (hasKilled) {
            hasKilled = false;
            eatCounter++;
        }
    }

    public static Whale getInstance() {
        if (instance == null) {
            instance = new Whale();
        }
        return instance;
    }

    @Override
    public void move() {
        System.out.println("Moving whale: "+this.getPosition().getX()+":"+this.getPosition().getY());
        boolean free = false;
        int direction;
        Position p =null;
        int nbOfTries = 0;
        while (!free && nbOfTries<=5) {

            direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay

             p = new Position(this.getPosition().getX(), this.getPosition().getY(), params);

            if (direction == 0) {
                p.moveDown();
            } else if (direction == 1) {
                p.moveUp();
            } else if (direction == 2) {
                p.moveLeft();
            } else if (direction == 3) {
                p.moveRight();
            } else {
                //do nothing
            }
            System.out.println("Moving whale in pos: "+p.getX()+":"+p.getY());

            if (this.world.isCellFree(p.getX(), p.getY()) && !this.world.isIce(new Position(p.getX(),p.getY(),params))) {
                free = true;
            }
            nbOfTries ++;
        }

        if(p != null){
            this.getPosition().setNewPosition(p.getX(), p.getY());
        }
        
        System.out.println("New Whale Position: "+this.getPosition().getX()+":"+this.getPosition().getY());


    }

    public void initWhale(WaterWorld world, WaterParams params) {
        if (!init) {
            this.setPos(new Position(0, 0, params));
            this.setImg("/image/whale.png");
            this.init = true;
            this.r = new Random();
            this.eatCounter = 0;
            this.world = world;
            this.params = world.getParams();
            this.hasKilled = false;
        }
    }

    public ElementType getElementType() {
        return ElementType.WATER_WHALE;
    }

    @Override
    public boolean placeElement() {
        boolean found = false;
        while (!found) {
            int x = r.nextInt(params.getWorld_width());
            int y = r.nextInt(params.getWorld_height());
            //check position
            if (this.world.isCellFree(x, y) && !this.world.isIce(new Position(x,y,params))) {
                this.setPos(new Position(x, y, params));
                found=true;
            }
        }
        return true;
    }

    @Override
    public void breed() {
        //no breed for whale
    }
}
