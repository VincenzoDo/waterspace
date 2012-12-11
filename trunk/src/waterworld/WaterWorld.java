package waterworld;

import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.IWorldElement;

public class WaterWorld extends AbstractWorld {

    private int maxIceSize;
    private WaterParams params;
    private WaterFactory factory;

    public WaterWorld(WaterParams params, WaterFactory factory) {
        this.params = params;
        this.factory = factory;
        
        // create all elements and place in world
        ElementType typeList[] = ElementType.values();
        for (ElementType type : typeList) {
            if(!type.toString().startsWith("WATER"))
                continue;
            
            int nbOfElement = params.getNbOfElement(type);
            for (int i = 0; i < nbOfElement; i++) {
                IWorldElement elem = factory.createElement(type);
                this.listElement.add(elem);
                elem.placeElement();
            }
        }
        
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
