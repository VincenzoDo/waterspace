package waterworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Ice extends WaterElement {

    private WaterWorld world;
    private static Ice instance;
    private ArrayList<Position> position;
    private boolean init = false;
    private WaterParams params = world.getParams();
    private Random r;

    private Ice() {
    }

    public static Ice getInstance() {
        if (instance == null) {
            instance = new Ice();
        }
        return instance;
    }

    @Override
    public void move() {
        if(init){
            
        }
        throw new UnsupportedOperationException();
    }
    
    public void addIce(int x, int y) {
        if (init) {
            Position p = new Position(x, y, params);
            for (Position position1 : position) {
                if(position1.getX() != p.getX() && position1.getY() != p.getY()){
                    continue;
                } else {
                    break;
                }
                
            }
            this.position.add(p);
        }
    }
    
    public boolean isIce(int x, int y){
        for (Position position1 : position) {
                if(position1.getX() == x && position1.getY() == y){
                    return true;
                } 
            }
        return false;
    }
    
    public void initIce(int x, int y, WaterWorld world) {
        if(!init){
            init=true;
            this.world=world;
            r = new Random();
        }
    }
    
    
    public ElementType getElementType(){
        return ElementType.WATER_ICE;
    }
    
    @Override
    public Position getPosition(){
        if(!this.position.isEmpty()){
            return this.position.get(0);
        } else {
            return null; //TODO null exception
        }
    }

      @Override
    public boolean placeElement() {
        int x = r.nextInt(params.getWorld_width());
        int y = r.nextInt(params.getWorld_height());
        //check position
        if(this.world.isCellFree(x, y)){
            Position p=  new Position(x, y, params);
            this.position = new ArrayList<Position>();
            this.position.add(p);
        } else {
            placeElement();
        }
        return true;
    }
}