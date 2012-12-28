package waterworld;

import java.util.Collections;
import java.util.Random;
import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

public class WaterWorld extends AbstractWorld {

    private int maxIceSize;
    private WaterParams params;
    private WaterFactory factory;
    private Random r;

    public WaterWorld(WaterParams params, WaterFactory factory) {
        this.params = params;
        this.factory = factory;

        this.r = new Random();

        // create all elements and place in world
        ElementType typeList[] = ElementType.values();
        for (ElementType type : typeList) {
            if (!type.toString().startsWith("WATER")) {
                continue;
            }

            int nbOfElement = params.getNbOfElement(type);
            for (int i = 0; i < nbOfElement; i++) {
                WaterElement elem = (WaterElement) factory.createElement(type);
                if (elem.placeElement()) {
                    this.listElement.add(elem);
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

        // update counters AND kill all starving shark
        for (WorldElement elem : listElement) {
            WaterElement waterElem = (WaterElement) elem;
            waterElem.updateCounters();

            if (waterElem.getType() != ElementType.WATER_SHARK) {
                continue;
            }

            Shark shark = (Shark) waterElem;

            if (shark.getEatCounter() == params.getStarving_each()) {
                shark.kill();
            }

        }

        // select random element
        WaterElement waterElem = selectRandomElement();

        // move element
        waterElem.move();

        //selectRandomPreyNeighbour
        WorldElement prey = selectRandomPrey(waterElem);

        if (prey != null) {
            // kill prey
            killPreyElement(prey);
        }

        if (waterElem.getType() == ElementType.WATER_PENGUIN || waterElem.getType() == ElementType.WATER_SHARK) {
            //selectRandomNeighbour
            WaterElement neighbour = selectRandomNeighbour(waterElem);

            if (neighbour != null) {
                int sexCounter = 0;

                if (neighbour.getType() == ElementType.WATER_PENGUIN) {
                    sexCounter = ((Penguin) neighbour).getSexCounter();
                } else if (neighbour.getType() == ElementType.WATER_SHARK) {
                    sexCounter = ((Shark) neighbour).getSexCounter();
                }

                if (sexCounter >= 5) { //wrong? on augmente le counter quand la creature se reproduit,
                    WorldElement born = factory.createElement(neighbour.getType());
                    if (((WaterElement) born).placeElement()) {
                        listElement.add(born);
                    }
                }


            }

        }
    }

    private void killStarvingShark() {
        for (WorldElement worldElement : listElement) {
            if (worldElement.getType() == ElementType.WATER_SHARK) {
                Shark shark = (Shark) worldElement;
                if (shark.getEatCounter() == 5) {
                    shark.kill();
                    listElement.remove(worldElement);
                }
            }
        }
    }

    private WaterElement selectRandomElement() {
        int index = r.nextInt(listElement.size() - 1);
        return (WaterElement) listElement.get(index);
    }

    private WaterElement selectRandomPrey(WorldElement elem) {

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
            Ice ice = Ice.getInstance();
            for (WorldElement worldElement : listElement) {
                if (worldElement.getType() == ElementType.WATER_PENGUIN) {
                    Position pos = worldElement.getPosition();
                    if (isNeightboor(elem, worldElement) && !ice.isIce(pos.getX(), pos.getY())) {
                        return (WaterElement) worldElement;
                    }
                }
            }
        }

        return null;
    }

    // For reproduction
    private WaterElement selectRandomNeighbour(WorldElement elem) {
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

    private void killPreyElement(WorldElement prey) {
        ((WaterElement) prey).kill();
        listElement.remove(prey);
    }
    
    private boolean isNeightboor(WorldElement elem1, WorldElement elem2){
        Position pos1 = elem1.getPosition();
        Position pos2 = elem2.getPosition();
        if(pos1.getX() == pos2.getX() && Math.abs(pos1.getY()-pos2.getY()) <= 1) {
            return true;
        }
        if(pos1.getY() == pos2.getY() && Math.abs(pos1.getX()-pos2.getX()) <= 1) {
            return true;
        }
        return false;
    }

    public boolean isCellFree(int x, int y) {
        for (WorldElement worldElement : listElement) {
            int xe = worldElement.getPosition().getX();
            int ye = worldElement.getPosition().getY();
            if (x == xe && y == ye) {
                return false;
            }
        }
        return true;
    }

    public WaterParams getParams() {
        return params;
    }
}
