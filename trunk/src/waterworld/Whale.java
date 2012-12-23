package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;

public class Whale extends WaterElement {

    private WaterWorld world;
    private boolean init=false;
    private static Whale instance;
    private Random r;
    private Position position;

    private Whale() {
    }

    public void eat() {
        // if a neighbour case contains an etabel element (shark)
            //then eat it
            //and remove the elt from the list
        //else
            //do nothing
    }

    public Whale getInstance() {
        if (instance == null) {
            instance = new Whale();
        }
        return this.instance;
    }

    @Override
    public void move() {
        int direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay
        
        //what if the position is already occupied?
        switch(direction){
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
    
   
    public void initWhale(WaterWorld world){
        if(!init){
            init=true;
            r= new Random();
            this.world=world;
        }
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_WHALE;
    }

    @Override
    public boolean placeElement() {
        //get a random case 
        //check if it's already occupied
            //choose another random case
        //place the element
        return false;
    }
}
