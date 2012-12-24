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
    private WaterParams params = world.getParams();

    public Penguin(boolean sex, WaterWorld world) {
        this.world = world;
        this.sex = sex;
        this.sexCounter = 0;
        this.r = new Random();
    }

    public void breed() {
        //check on near case
        //if there is a penguin
        boolean decision = r.nextBoolean();
        if (decision) {
            //create new penguin
        }


    }

    @Override
    public void move() {
        boolean speed = r.nextBoolean(); //1 or 2 squares
        int direction = r.nextInt(5); //0 down, 1 up, 2 left, 3 right, 4 stay
        //check no sharks in the zone
        //check validity
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
                    this.position.moveDown();
                }
            case 2:
                if (speed) {
                    this.position.moveLeft();
                    this.position.moveLeft();
                } else {
                    this.position.moveDown();
                }
            case 3:
                if (speed) {
                    this.position.moveRight();
                    this.position.moveRight();
                } else {
                    this.position.moveDown();
                }
            case 4:
                return;
            default:
                return;
        }

    }

    @Override
    public void kill() {
        //Penguins doesn't kill
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
        this.position = new Position(x, y, params);
        return true;
    }
}