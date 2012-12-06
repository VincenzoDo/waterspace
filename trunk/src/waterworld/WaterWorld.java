package waterworld;

import waterspace.AbstractWorld;

public class WaterWorld extends AbstractWorld {

    private int maxIceSize;
    private WaterParams params;

    public WaterWorld(WaterParams params) {
        this.params = params;
    }

    public void killStarvingShark() {
        throw new UnsupportedOperationException();
    }

    public void selectRandomElement() {
        throw new UnsupportedOperationException();
    }

    public void selectRandomPrey() {
        throw new UnsupportedOperationException();
    }

    public void placeElements() {
        throw new UnsupportedOperationException();
    }

    public void killPreyElement() {
        throw new UnsupportedOperationException();
    }
}