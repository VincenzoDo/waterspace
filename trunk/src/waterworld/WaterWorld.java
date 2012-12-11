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
        
        // update counters AND kill all starving shark
        for (IWorldElement elem : listElement) {
            
            elem.updateCounters();
            
            if(elem.getType() != ElementType.WATER_SHARK)
                continue;
            
            Shark shark = (Shark)elem;
            
            if(shark.getEatCounter() == params.getStarving_each()){
                shark.kill();
            }
            
        }
        
        // select random element
        IWorldElement elem = selectRandomElement();
        
        // move element
        elem.move();
        
        //selectRandomPreyNeighbour
        IWorldElement prey = selectRandomPrey(elem);
        
        if(prey != null){
        // kill prey
        killPreyElement(prey);
        }
        
        //selectRandomNeighbour
        IWorldElement neighbour = selectRandomNeightbour(elem);
        
        if(neighbour != null){
        
        //checkbreedcounter
            
        
        
            // create new element
        }
            
	}
    
    private void killStarvingShark() {
        throw new UnsupportedOperationException();
    }

    private IWorldElement selectRandomElement() {
        throw new UnsupportedOperationException();
    }

    private IWorldElement selectRandomPrey(IWorldElement elem) {
        throw new UnsupportedOperationException();
    }
    
    private IWorldElement selectRandomNeightbour(IWorldElement elem) {
        throw new UnsupportedOperationException();
    }

    /*
    private void placeElements() {
        throw new UnsupportedOperationException();
    }
*/
    private void killPreyElement(IWorldElement prey) {
        throw new UnsupportedOperationException();
    }
    
    private boolean isReadyToBreed(IWorldElement elem){
        
        switch(elem.getType()){
            case WATER_PENGUIN:
                return true;
            case WATER_SHARK:
                return true;
            default: return false;
        }
        
    }
    
}
