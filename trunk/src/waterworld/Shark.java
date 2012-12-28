package waterworld;

import java.util.Random;
import waterspace.ElementType;
import waterspace.WorldElement;
import waterspace.Position;

public class Shark extends WaterElement {

    private WaterWorld world;
    private boolean sex;
    private int sexCounter;
    private int eatCounter;
    private Random r;
    private Whale whale;
    private WaterParams params;
    private Position position;

    public Shark(boolean sex, WaterWorld world) {
        this.r = new Random();
        this.sex = sex;
        this.world = world;
        params = world.getParams();
    }

    private int isWhaleNear() {
        Position whalePos = whale.getInstance().getPosition();
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
        throw new UnsupportedOperationException();
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {
        boolean free = false;
        int direction = 0;
        int whaleP = isWhaleNear();

        if (whaleP == -1) {

            while (!free) {

                direction = r.nextInt(5);//0 down, 1 up, 2 left, 3 right, 4 stay

                Position p = this.getPosition();

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

                if (this.world.isCellFree(p.getX(), p.getY())) {
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
        } else { //whale is near need to go backwards

            Position p = this.getPosition();
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
            if (!this.world.isCellFree(p.getX(), p.getY())) {
                //no pother place to go
                direction = 4;

            }

            switch (direction) { //still backwards
                case 0:
                    this.position.moveUp();
                case 1:
                    this.position.moveDown();
                case 2:
                    this.position.moveRight();
                case 3:
                    this.position.moveLeft();
                default:
                //do nothing
            }
        }
    }

    @Override
    public void kill() {
        throw new UnsupportedOperationException();
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
        this.sexCounter++;
        this.eatCounter++;
    }

    public ElementType getElementType() {
        return ElementType.WATER_SHARK;
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