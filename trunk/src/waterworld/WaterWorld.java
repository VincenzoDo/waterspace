package waterworld;

import waterspace.AbstractWorld;

public class WaterWorld extends AbstractWorld {

    private int maxIceSize;
    private WaterParams params;
    private WaterFactory factory;

    public WaterWorld(WaterParams params, WaterFactory factory) {
        this.params = params;
        this.factory = factory;
        
        // create elements via factory
        // place elements
        
    }

    @Override
    public void nextStep() {
		throw new UnsupportedOperationException();
        
        // kill all starving sharks
        
        //select random element
        
        //move element
        
        //selectRandomPreyNeighbour
        
        // kill neighbour
        
        //selectRandomNeighbour
        
        //checkbredcounter
        
            // create new element
        
	}
    
    private void killStarvingShark() {
        throw new UnsupportedOperationException();
    }

    private void selectRandomElement() {
        throw new UnsupportedOperationException();
    }

    private void selectRandomPrey() {
        throw new UnsupportedOperationException();
    }

    private void placeElements() {
        throw new UnsupportedOperationException();
    }

    private void killPreyElement() {
        throw new UnsupportedOperationException();
    }
}
