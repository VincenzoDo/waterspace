package waterworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import ui.Command;
import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class WaterWorld extends AbstractWorld {

    private int maxIceSize;
    private WaterParams params;
    private WaterFactory factory;
    private Random r;
    private int iceCounter;
    private final Object lock = new Object();
    private boolean endgame = false;

    public WaterWorld(WaterParams params) {
        this.params = params;
        this.iceCounter = 0;
        this.r = new Random();

    }
    public void iniWorld(WaterFactory factory){
        this.factory = factory;
        
        // create all elements and place in world
        ElementType typeList[] = ElementType.values();
        for (ElementType type : typeList) {
            if (!type.toString().startsWith("WATER")) {
                continue;
            }

            int nbOfElement = params.getNbOfElement(type);
            for (int i = 0; i < nbOfElement; i++) {
                WaterElement elem = null;
                if (type == ElementType.WATER_ICE && iceCounter <= (params.getMapHeight()*params.getMapWidth()*100)/50) {
                    System.out.println("Creating ice");
                    iceCounter++;
                    elem = (WaterElement) factory.createIce();
                }
                if (type == ElementType.WATER_PENGUIN) {
                    System.out.println("Creating penguin");
                    elem = (WaterElement) factory.createPenguin();
                }
                if (type == ElementType.WATER_SHARK) {
                    System.out.println("Creating shark");
                    elem = (WaterElement) factory.createShark();
                }
                if (type == ElementType.WATER_WHALE) {
                    System.out.println("Creating whale");
                    elem = (WaterElement) factory.createWhale();
                    ((Whale) elem).initWhale(this, params);

                }

                

                if(elem.placeElement()){
                    listElement.add(elem);
                }
                
            }
        }




    }

    public boolean isCreature(int x, int y) {
        for (WorldElement worldElement : listElement) {
            Position pos = worldElement.getPosition();
            if (pos.getX() == x && pos.getY() == y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nextStep() {
        
        if(endgame){
            return;
        }
        
        /* 
        //FOR DEBUG...
        for (WorldElement elem1 : listElement) {
            for (WorldElement elem2 : listElement) {
                if(elem1.getId() == elem2.getId()) {
                    continue;
                }
                if(elem1.getPosition().getX() == elem2.getPosition().getX() && elem1.getPosition().getY() == elem2.getPosition().getY()){
                    if(elem1.getType() == ElementType.WATER_ICE && elem2.getType() == ElementType.WATER_PENGUIN ||
                            elem1.getType() == ElementType.WATER_PENGUIN && elem2.getType() == ElementType.WATER_ICE){
                        continue;
                    }
                    System.out.println("ELEM ON SAME PLACE");
                    System.out.println("#"+elem1.getId()+" "+elem1.getType()+" // "+elem1.getPosition().getX()+":"+elem1.getPosition().getY());
                    System.out.println("#"+elem2.getId()+" "+elem2.getType()+" // "+elem2.getPosition().getX()+":"+elem2.getPosition().getY());
                    System.exit(1);
                }
                
            }
        }
        */
        if(listElement.size() < 2){
            //stop game
            endgame = true;
            System.out.println("The game is finished");
            System.out.println("there is less than 2 elements....");
            return;
        }
        int nPenguin=0;
        int nSharks=0;
        for (WorldElement worldElement : listElement) {
            if(worldElement.getType() == ElementType.WATER_PENGUIN){
                nPenguin++;
            }
            if(worldElement.getType() == ElementType.WATER_SHARK){
                nSharks++;
            }
        }
        if(nPenguin == 0 || nSharks == 0){
            //stop game
            endgame = true;
            System.out.println("The game is finished");
            if(nPenguin == 0){
        		System.out.println("There is no more penguin");
        	}else{
        		System.out.println("There is no more shark");
        	}
            return;
        }

        System.out.println("step 1: kill starving shark");
        // update counters AND kill all starving shark
        for (WorldElement elem : listElement) {
            WaterElement waterElem = (WaterElement) elem;
            waterElem.updateCounters();
        }

        killStarvingShark();
        
        System.out.println("step 2: select random element");
        // select random element
        WaterElement waterElem = selectRandomElement();

        System.out.println("selected elt type: " + waterElem.getType());

        System.out.println("step 3: move element");
        // move element
        if (waterElem.getType() == ElementType.WATER_PENGUIN && !isIce(waterElem.getPosition())) {
            waterElem.move();
        }
        waterElem.move();

        System.out.println("step 4: kill elt");
        // element kill
        waterElem.kill();

        System.out.println("step 5: eat elt");
        // element eat
        waterElem.eat();

        System.out.println("step 6: breeds elt");
        if (waterElem.getType() == ElementType.WATER_PENGUIN || waterElem.getType() == ElementType.WATER_SHARK) {
            // breed if possible
            waterElem.breed();

        }
        /*
        for (WaterElement shark : getSharks()) {
            shark.updateCounters();
            
        }
        */
    }

    private void killStarvingShark() {
        
        for (Shark shark : getSharks()) {
            if (shark.getEatCounter() >= this.params.getStarving_each()) {
                    System.out.println("KILLED SHARK STARVING");
                    listElement.remove(shark);
                }
        }

    }

    private WaterElement selectRandomElement() {
        int index = r.nextInt(listElement.size() - 1);
        return (WaterElement) listElement.get(index);
    }

    public WaterElement selectRandomPrey(WorldElement elem) {

        Collections.shuffle(listElement);

        // the whale eats only sharks
        if (elem.getType() == ElementType.WATER_WHALE) {
            for (WorldElement worldElement : listElement) {
                if (worldElement.getType() == ElementType.WATER_SHARK) {
                    if (isNeightboor(elem, worldElement)) {
                        return (WaterElement) worldElement;
                    }
                }
            }
        }

        // the sharks eat only penguin in water
        if (elem.getType() == ElementType.WATER_SHARK) {
            for (WorldElement worldElement : listElement) {
                if (worldElement.getType() == ElementType.WATER_PENGUIN) {
                    Position pos = worldElement.getPosition();
                    if (isNeightboor(elem, worldElement) && !isIce(pos)) {
                        return (WaterElement) worldElement;
                    }
                }
            }
        }
        //Ice kills ice
        if (elem.getType() == ElementType.WATER_ICE) {
            for (WorldElement worldElement : listElement) {
                if (worldElement.getType() == ElementType.WATER_ICE) {
                    return (WaterElement) worldElement;
                }
            }
        }

        return null;
    }

    // For reproduction
    public WaterElement selectRandomNeighbour(WorldElement elem) {
        if (elem.getType() == ElementType.WATER_ICE || elem.getType() == ElementType.WATER_WHALE) {
            return null;
        }
        for (WorldElement worldElement : listElement) {
            if (worldElement.getType() == elem.getType()) {
                if (isNeightboor(elem, worldElement)) {
                    return (WaterElement) worldElement;
                }
            }
        }
        return null;
    }

    public void killPreyElement(WorldElement prey) {
        listElement.remove(prey);
    }

    public boolean isNeightboor(WorldElement elem1, WorldElement elem2) {
        if (elem1.equals(elem2)) { //check if the two object are the same
            return false;
        }
        Position pos1 = elem1.getPosition();
        Position pos2 = elem2.getPosition();
        if (pos1.getX() == pos2.getX() && Math.abs(pos1.getY() - pos2.getY()) <= 1) {
            System.out.println("This two elts are neighbour, elt1Pos= " + elem1.getPosition().getX() + ":" + elem1.getPosition().getY() + " elem2Pos=" + elem2.getPosition().getX() + ":" + elem2.getPosition().getY());
            return true;
        }
        if (pos1.getY() == pos2.getY() && Math.abs(pos1.getX() - pos2.getX()) <= 1) {
            System.out.println("This two elts are neighbour, elt1Pos= " + elem1.getPosition().getX() + ":" + elem1.getPosition().getY() + " elem2Pos=" + elem2.getPosition().getX() + ":" + elem2.getPosition().getY());

            return true;
        }
        return false;
    }

    public boolean isCellFree(int x, int y) {
        if (!listElement.isEmpty()) {
            for (WorldElement worldElement : listElement) {
                if (worldElement.getPosition().equals(new Position(x, y, null))) {
                    return false;
                }
            }
        }
        return true;
    }

    public WaterParams getParams() {
        return params;
    }

    public boolean isIce(Position p) {
        ArrayList<Ice> ice = new ArrayList();
        for (WorldElement creature : listElement) {
            if (creature.getType() == ElementType.WATER_ICE) {
                if (creature.getPosition().equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isIceOccupied(WorldElement ice) {
        for (WorldElement creature : listElement) {
            if (creature.getType() != ElementType.WATER_ICE) {
                if (creature.getPosition().equals(ice.getPosition())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isIceFree(Position p) {
        boolean isIce = false;
        ArrayList<Ice> ice = new ArrayList();
        for (WorldElement creature : listElement) {
            if (creature.getType() == ElementType.WATER_ICE) {
                if (creature.getPosition().equals(p)) {
                    isIce = true;
                }
            } else if (creature.getPosition().equals(p)) {
                return false;
            }
        }
        return isIce;
    }

    public boolean isPenguin(Position p) {
        ArrayList<Ice> penguins = new ArrayList();
        for (WorldElement creature : listElement) {
            if (creature.getType() == ElementType.WATER_PENGUIN) {
                if (creature.getPosition().equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Shark> getSharks() {
        ArrayList<Shark> sharks = new ArrayList();
        for (WorldElement creature : listElement) {
            if (creature.getType() == ElementType.WATER_SHARK) {
                sharks.add((Shark) creature);
            }
        }
        return sharks;

    }

    public WaterFactory getFactory() {
        return factory;
    }

    public int getIceCounter() {
        return iceCounter;
    }

    public void createNewborn(WorldElement type) {
        ElementType type1 = type.getType();

        WorldElement elem = null;

        if (type1 == ElementType.WATER_ICE) {
            System.out.println("Creating nb ice");
            elem = (WaterElement) factory.createIce();
        }
        if (type1 == ElementType.WATER_PENGUIN) {
            System.out.println("Creating nb penguin");
            elem = (WaterElement) factory.createPenguin();
        }
        if (type1 == ElementType.WATER_SHARK) {
            System.out.println("Creating nb shark");
            elem = (WaterElement) factory.createShark();
        }
        if (type1 == ElementType.WATER_WHALE) {
            System.out.println("Creating nb whale");
            elem = (WaterElement) factory.createWhale();
            ((Whale) elem).initWhale(this, params);

        }



        if (elem.getType() == ElementType.WATER_PENGUIN) {
            Collections.shuffle(listElement);
            Position p = null;
            for (WorldElement worldElement : listElement) {
                if (worldElement.getType() == ElementType.WATER_ICE && !isIceOccupied(worldElement)) {
                    p = worldElement.getPosition();
                    break;
                } else {
                    continue;
                }

            }
            //elem.setPos(p);
            elem.getPosition().setNewPosition(p.getX(), p.getY());
        } else {
            if (((WaterElement) elem).placeElement()) {
                listElement.add(elem);
            }
        }
        System.out.println("NewBornPosition = "+elem.getPosition().getX()+":"+elem.getPosition().getY());
    }
    
    @Override
    public boolean isEndGame(){
        return endgame;
    }
    
}
