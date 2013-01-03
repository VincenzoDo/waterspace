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

public class Penguin extends WaterElement {

    private WaterWorld world;
    //true male, false female
    private boolean sex;
    private int sexCounter;
    private Random r;
    private WaterParams params;
    private int eatCounter;

    public Penguin(boolean sex, WaterWorld world, Position pos, ElementType type) {
        super(pos, type);
        this.setType(type);
        this.setPos(pos);
        this.setImg("/image/penguin.png");
        this.world = world;
        this.sex = sex;
        this.sexCounter = 0;
        this.r = new Random();
        this.params = world.getParams();
        this.eatCounter = 0;
    }

    public void breed() {
        WaterElement neighbour = this.world.selectRandomNeighbour(this);

        if (neighbour != null) {//found a mate
            System.out.println("CreatingNewBornPenguin");
            if (((Penguin) neighbour).getSexCounter() <= this.params.getSexCounter() && this.sexCounter <= this.params.getSexCounter()) {
                this.sexCounter++;
                int sexC = ((Penguin) neighbour).getSexCounter() + 1;
                ((Penguin) neighbour).setSexCounter(sexC);
                this.world.createNewborn(this);
            }


        }


    }

    @Override
    public void move() {
        System.out.println("Moving penguin in= " + this.getPosition().getX() + ":" + this.getPosition().getY());
        int direction = 0; //0 down, 1 up, 2 left, 3 right, 4 stay
        int isSharkNear = isSharkNear();
        boolean free = false;
        Position p = null;
        //check no sharks in the 
        System.out.println("Shark is near = " + isSharkNear);
        int nbOfTries = 0;
        if (isSharkNear == -1) {

            while (!free && nbOfTries <= 5) {

                direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay
                System.out.println("Direction is =" + direction);

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

                if (this.world.isCellFree(p.getX(), p.getY()) || this.world.isIce(p)) {
                    free = true;
                    System.out.println("Found clean pos = " + p.getX() + ":" + p.getY());
                }
                nbOfTries ++;
            }

            if (p != null) {
                this.getPosition().setNewPosition(p.getX(), p.getY());
            }

        } else { //shark near got to go

            p = this.getPosition();
            //backwards movement
            if (isSharkNear == 0) {
                p.moveDown();
            } else if (isSharkNear == 1) {
                p.moveUp();
            } else if (isSharkNear == 2) {
                p.moveLeft();
            } else if (isSharkNear == 3) {
                p.moveRight();
            } else {
                //do nothing
            }

            if (this.world.isCellFree(p.getX(), p.getY()) || this.world.isIce(p)) {
                if (p != null) {
                    this.getPosition().setNewPosition(p.getX(), p.getY());
                }

                System.out.println("Found clean pos = " + p.getX() + ":" + p.getY());
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
        boolean found = false;
        while (!found) {
            int x = r.nextInt(params.getWorld_width());
            int y = r.nextInt(params.getWorld_height());
            //check position
            if (this.world.isCellFree(x, y) || this.world.isIce(new Position(x, y, null))) {
                this.setPos(new Position(x, y, params));
                found = true;
            }

        }
        return true;
    }

    @Override
    public void eat() {
        eatCounter++;
    }

    private void setSexCounter(int sexC) {
        this.sexCounter = sexC;
    }
}