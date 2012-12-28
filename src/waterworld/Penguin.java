package waterworld;
/*
 * Vincenzo Do, Romain Monnard
 * Penguin, a class to rapresent a penguin
 * 
 * Version 1
 */

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Penguin extends WaterElement {

    private WaterWorld world;
    //true male, false female
    private boolean sex;
    private int sexCounter;
    private Random r;
    private Position position;
    private WaterParams params;

    public Penguin(boolean sex, WaterWorld world) {
        this.world = world;
        this.sex = sex;
        this.sexCounter = 0;
        this.r = new Random();
        this.params = world.getParams();
    }

    public void breed() {
        //do something

        //if there is a penguin
        boolean decision = r.nextBoolean();
        if (decision) {
            //create new penguin
        }


    }

    @Override
    public void move() {
        boolean speed = r.nextBoolean(); //1 or 2 squares
        int direction = 0; //0 down, 1 up, 2 left, 3 right, 4 stay
        int isSharkNear = isSharkNear();
        boolean free = false;
        //check no sharks in the 
        if (isSharkNear == -1) {

            while (!free) {

                direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay

                Position p = this.getPosition();

                if (direction == 0) {
                    p.moveDown();
                    if(speed){
                        p.moveDown();
                    }
                } else if (direction == 1) {
                    if(speed){
                        p.moveUp();
                    }
                    p.moveUp();
                } else if (direction == 2) {
                    if(speed){
                        p.moveLeft();
                    }
                    p.moveLeft();
                } else if (direction == 3) {
                    if(speed){
                        p.moveRight();
                    }
                    p.moveRight();
                } else {
                    //do nothing
                }

                if (this.world.isCellFree(p.getX(), p.getY()) || this.world.isIce(p)) {
                    free = true;
                }
            }

            //check validity ALSO OF duble 
            switch (direction) {
                case 0:
                    if (speed) {
                        this.position.moveDown();
                        this.position.moveDown();
                    } else {
                        this.position.moveDown();
                    }
                case 1:
                    if (speed) {
                        this.position.moveUp();
                        this.position.moveUp();
                    } else {
                        this.position.moveUp();
                    }
                case 2:
                    if (speed) {
                        this.position.moveLeft();
                        this.position.moveLeft();
                    } else {
                        this.position.moveLeft();
                    }
                case 3:
                    if (speed) {
                        this.position.moveRight();
                        this.position.moveRight();
                    } else {
                        this.position.moveRight();
                    }
                case 4:
                    return;
                default:
                    return;
            }

        } else { //shark near got to go
            Position p = this.getPosition();
            //backwards movement
            if (isSharkNear == 0) {
                    p.moveDown();
                    if(speed){
                        p.moveDown();
                    }
                } else if (isSharkNear == 1) {
                    if(speed){
                        p.moveUp();
                    }
                    p.moveUp();
                } else if (isSharkNear == 2) {
                    if(speed){
                        p.moveLeft();
                    }
                    p.moveLeft();
                } else if (isSharkNear == 3) {
                    if(speed){
                        p.moveRight();
                    }
                    p.moveRight();
                } else {
                    //do nothing
                }

            direction = isSharkNear;
            
            if (!this.world.isCellFree(p.getX(), p.getY()) && !this.world.isIce(p)) {
                direction = 4;

            }

            switch (direction) {
                case 0:
                    if (speed) {
                        this.position.moveUp();
                        this.position.moveUp();
                    } else {
                        this.position.moveUp();
                    }
                case 1:
                    if (speed) {
                        this.position.moveDown();
                        this.position.moveDown();
                    } else {
                        this.position.moveDown();
                    }
                case 2:
                    if (speed) {
                        this.position.moveRight();
                        this.position.moveRight();
                    } else {
                        this.position.moveRight();
                    }
                case 3:
                    if (speed) {
                        this.position.moveLeft();
                        this.position.moveLeft();
                    } else {
                        this.position.moveLeft();
                    }
                case 4:
                    return;
                default:
                    return;
            }

        }

    }

    @Override
    public void kill() {
        //Penguins doesn't kill
    }

    private int isSharkNear() {
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        Position up = new Position(x, y + 1, null);
        Position down = new Position(x, y - 1, null);
        Position left = new Position(x - 1, y, null);
        Position right = new Position(x + 1, y, null);

        for (Shark shark : this.world.getSharks()) {
            if (shark.getPosition().equals(up)) {
                return 1;
            } else if (shark.getPosition().equals(down)) {
                return 0;
            } else if (shark.getPosition().equals(left)) {
                return 2;
            } else if (shark.getPosition().equals(right)) {
                return 3;
            }
        }

        return -1;

    }

    public boolean getSex() {
        return sex;
    }

    public int getSexCounter() {
        return sexCounter;
    }

    public void updateCounters() {
        this.sexCounter++;
    }

    public ElementType getElementType() {
        return ElementType.WATER_PENGUIN;
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
}