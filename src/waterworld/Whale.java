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
    private Position position;
    private WaterParams params;
    private boolean hasKilled;
    private int eatCounter;

    private Whale() {
    }
    
    
    @Override
    public void kill(){
        //selectRandomPreyNeighbour
        WorldElement prey = this.world.selectRandomPrey(this);
        if (prey != null) {
            // kill prey
            this.world.killPreyElement(prey);
        }
        
        
    }

    @Override
    public void eat() {
        if(hasKilled){
            hasKilled= false;
            eatCounter++;
        }
    }

    public Whale getInstance() {
        if (instance == null) {
            instance = new Whale();
        }
        return this.instance;
    }

    @Override
    public void move() {
        boolean free = false;
        int direction=0;
        while (!free) {

            direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay

            Position p = this.getPosition();

            if (direction == 0) {
                p.moveDown();
            } else if(direction == 1) {
                p.moveUp();
            } else if(direction == 2){
                p.moveLeft();
            } else if(direction == 3){
                p.moveRight();
            } else {
                //do nothing
            }
            
            if(this.world.isCellFree(p.getX(), p.getY())){
                free = true;
            }
        }

        switch (direction) {
            case 0:
                this.position.moveDown();
            case 1:
                this.position.moveUp();
            case 2:
                this.position.moveLeft();
            case 3:
                this.position.moveRight();
            default:
            //do nothing
        }


    }

    public void initWhale(WaterWorld world) {
        if (!init) {
            this.init = true;
            this.r = new Random();
            this.eatCounter=0;
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
        int x = r.nextInt(params.getWorld_width());
        int y = r.nextInt(params.getWorld_height());
        //check position
        if (this.world.isCellFree(x, y)) {
            this.position = new Position(x, y, params);
        } else {
            placeElement();
        }
        return true;
    }

    @Override
    public void breed() {
        //no breed for whale
    }
}
