package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class Shark extends WaterElement {

    private WaterWorld world;
    private boolean sex;
    private int sexCounter;
    private int eatCounter;
    private Random r;
    private WaterParams params;
    private boolean hasKilled;

    public Shark(boolean sex, WaterWorld world, Position pos, ElementType type) {
        super(pos, type);
        this.setType(type);
        this.setPos(pos);
        this.setImg("/image/shark.png");
        this.r = new Random();
        this.sex = sex;
        this.world = world;
        params = world.getParams();
        this.hasKilled = false;
    }

    private int isWhaleNear() {
        Position whalePos = Whale.getInstance().getPosition();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        Position up = new Position(x, y + 1, null);
        Position down = new Position(x, y - 1, null);
        Position left = new Position(x - 1, y, null);
        Position right = new Position(x + 1, y, null);
        if (whalePos.getX() == down.getX() && whalePos.getY() == down.getY()) {
            return 0;
        }
        if (whalePos.getX() == up.getX() && whalePos.getY() == up.getY()) {
            return 1;
        }
        if (whalePos.getX() == left.getX() && whalePos.getY() == left.getY()) {
            return 2;
        }
        if (whalePos.getX() == right.getX() && whalePos.getY() == right.getY()) {
            return 3;
        }
        return -1;//0 down, 1 up, 2 left, 3 right, -1 not found


    }

    public void breed() {
        WaterElement neighbour = this.world.selectRandomNeighbour(this);

        if (neighbour != null) {//found a mate
            if (((Shark) neighbour).getSexCounter() <= this.params.getSexCounter() && this.sexCounter <= this.params.getSexCounter()) {
                this.sexCounter++;
                int sexC = ((Shark) neighbour).getSexCounter() + 1;
                ((Shark) neighbour).setSexCounter(sexC);
                this.world.createNewborn(this);
            }


        }



    }

    public void eat() {
        if (hasKilled) {
            hasKilled = false;
            eatCounter--;
        }
    }

    @Override
    public void move() {
        System.out.println("moving shark in pos: " + this.getPosition().getX() + ":" + this.getPosition().getY());
        boolean free = false;
        boolean noPlace = false;
        int direction = 0;
        int whaleP = isWhaleNear();
        System.out.println("whale is near: " + whaleP);
        Position p = null;
        if (whaleP == -1) {

            while (!free) {

                direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay

                System.out.println("Direction is :" + direction);

                p = new Position(this.getPosition().getX(), this.getPosition().getY(), params);

                System.out.println("TEST POS: " + p.getX() + ":" + p.getY());
                if (direction == 0 && this.getPosition().getY() > 0) {
                    p.moveDown();
                    System.out.println("TEST POS AF: " + p.getX() + ":" + p.getY());
                } else if (direction == 1 && this.getPosition().getY() < params.getMapHeight()) {
                    p.moveUp();
                    System.out.println("TEST POS AF: " + p.getX() + ":" + p.getY());
                } else if (direction == 2 && this.getPosition().getX() > 0) {
                    p.moveLeft();
                    System.out.println("TEST POS AF: " + p.getX() + ":" + p.getY());
                } else if (direction == 3 && this.getPosition().getX() < params.getMapHeight()) {
                    p.moveRight();
                    System.out.println("TEST POS AF: " + p.getX() + ":" + p.getY());
                } else {
                    noPlace = true;
                }
                System.out.println("Check if it's free");
                if (!noPlace) {
                    if (this.world.isCellFree(p.getX(), p.getY()) && !this.world.isIce(p)) {
                        free = true;
                        System.out.println("Cell is free");
                    }
                } else {
                    free = true;
                    noPlace = false;
                }

            }

            if (p != null) {
                this.getPosition().setNewPosition(p.getX(), p.getY());
            }
        } else { //whale is near need to go backwards

            p = this.getPosition();
            //backwards movement
            if (whaleP == 0) {
                p.moveUp();
            } else if (whaleP == 1) {
                p.moveDown();
            } else if (whaleP == 2) {
                p.moveRight();
            } else if (whaleP == 3) {
                p.moveLeft();
            } else {
                //do nothing
            }

            direction = whaleP;
            if (!this.world.isCellFree(p.getX(), p.getY()) && !this.world.isIce(p)) {
                //no pother place to go
                direction = 4;

            }

            if (p != null) {
                this.getPosition().setNewPosition(p.getX(), p.getY());
            }
        }
    }

    @Override
    public void kill() {
        //selectRandomPreyNeighbour
        WorldElement prey = this.world.selectRandomPrey(this);
        if (prey != null) {
            // kill prey
            this.world.killPreyElement(prey);
            hasKilled = true;
        }
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getSexCounter() {
        return sexCounter;
    }

    public void setSexCounter(int sexCounter) {
        this.sexCounter = sexCounter;
    }

    public int getEatCounter() {
        return eatCounter;
    }

    public void setEatCounter(int eatCounter) {
        this.eatCounter = eatCounter;
    }

    @Override
    public void updateCounters() {
        this.eatCounter++;
    }

    public ElementType getElementType() {
        return ElementType.WATER_SHARK;
    }

    @Override
    public boolean placeElement() {
        boolean found = false;
        while (!found) {
            int x = r.nextInt(params.getWorld_width());
            int y = r.nextInt(params.getWorld_height());
            //check position
            if (this.world.isCellFree(x, y) && !this.world.isIce(new Position(x, y, params))) {
                this.setPos(new Position(x, y, params));
                found = true;
            }
        }
        return true;
    }
}