package waterworld;

import waterspace.IWorldElement;

public class Whale extends IWorldElement {

    private static Whale instance;

    private Whale() {
    }

    public void eat() {
        throw new UnsupportedOperationException();
    }

    public Whale getInstance() {
        if (instance == null) {
            instance = new Whale();
        }
        return this.instance;
    }

    public void move() {
        throw new UnsupportedOperationException();
    }
}