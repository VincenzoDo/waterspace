package waterworld;

import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.WorldElement;

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
                WaterElement elem = (WaterElement)factory.createElement(type);
                this.listElement.add(elem);
                elem.placeElement();
            }
        }
        
    }

    @Override
    public void nextStep() {
        
        // update counters AND kill all starving shark
        for (WorldElement elem : listElement) {
            WaterElement waterElem = (WaterElement)elem;
            waterElem.updateCounters();
            
            if(waterElem.getType() != ElementType.WATER_SHARK)
                continue;
            
            Shark shark = (Shark)waterElem;
            
            if(shark.getEatCounter() == params.getStarving_each()){
                shark.kill();
            }
            
        }
        
        // select random element
        WaterElement waterElem = selectRandomElement();
        
        // move element
        waterElem.move();
        
        //selectRandomPreyNeighbour
        WorldElement prey = selectRandomPrey(waterElem);
        
        if(prey != null){
        // kill prey
        killPreyElement(prey);
        }
        
        //selectRandomNeighbour
        WorldElement neighbour = selectRandomNeightbour(waterElem);
        
        if(neighbour != null){
        
        //checkbreedcounter
            
        
        
            // create new element
        }
            
	}
    
    private void killStarvingShark() {
        throw new UnsupportedOperationException();
    }

    private WaterElement selectRandomElement() {
        throw new UnsupportedOperationException();
    }

    private WaterElement selectRandomPrey(WorldElement elem) {
        throw new UnsupportedOperationException();
    }
    
    private WaterElement selectRandomNeightbour(WorldElement elem) {
        throw new UnsupportedOperationException();
    }

    /*
    private void placeElements() {
        throw new UnsupportedOperationException();
    }
*/
    private void killPreyElement(WorldElement prey) {
        throw new UnsupportedOperationException();
    }
    
    private boolean isReadyToBreed(WorldElement elem){
        
        switch(elem.getType()){
            case WATER_PENGUIN:
                return true;
            case WATER_SHARK:
                return true;
            default: return false;
        }
        
    }
    
}
