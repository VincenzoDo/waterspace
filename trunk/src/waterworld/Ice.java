package waterworld;

import waterspace.IWorldElement;

public class Ice extends IWorldElement {

    private static Ice instance;
    private boolean[][] position;
    public Ice unnamed_Ice_;

    private Ice() {
    }

    private Ice(int x, int y) {
        position = new boolean[x][y];

    }

    public Ice getInstance() {
        if (instance == null) {
            instance = new Ice();
        }
        return this.instance;
    }

    public Ice getInstance(int x, int y) {
        if (instance == null) {
            instance = new Ice();
        }
        return this.instance;
    }

    public void move() {
        throw new UnsupportedOperationException();
    }

    public void addIce(int x, int y) {
        position[x][y] = true;
    }
}