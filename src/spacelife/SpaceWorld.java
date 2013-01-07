package spacelife;

import java.util.ArrayList;
import java.util.Random;

import ui.Command;
import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;
import waterworld.WaterElement;
import waterworld.Whale;

public class SpaceWorld extends AbstractWorld {
	private SpaceParams sp;
	private SpaceFactory sf;
	private boolean endgame = false;
	private Position trouNoir;
	private Random r;
	private Position placement;
	
	public SpaceWorld(SpaceParams sp, SpaceFactory sf){
		this.sp = sp;
		this.sf=sf;
		r = new Random();
		 // create all elements and place in world
        ElementType typeList[] = ElementType.values();
        for (ElementType type : typeList) {
            if (!type.toString().startsWith("SPACE")) {
                continue;
            }
			//Creer les elts
            int nbOfElement = sp.getNbOfElement(type);
            System.out.println(type+" " +nbOfElement);
			for(int i=0; i<nbOfElement; i++){
				WorldElement elem = null;
				if(placeElement()){
					elem = sf.createElement(type, placement);
	                if (type == ElementType.SPACE_BLACKHOLE) {
	                    trouNoir = elem.getPosition();
	                }
	                listElement.add(elem);
				}
			}
        }
	}
	
	public boolean placeElement() {
		boolean found = false;
		while (!found) {
			int x = r.nextInt(sp.getWorld_width());
			int y = r.nextInt(sp.getWorld_height());
			// check position
			if (isCellFree(x, y)) {
				placement = new Position(x, y, sp);
				found = true;
			}

		}
		return true;
	}
	
	 public boolean isCellFree(int x, int y) {
         if (!listElement.isEmpty()) {
             for (WorldElement worldElement : listElement) {
                 if (worldElement.getPosition().equals(new Position(x, y, null)) && x <= sp.getMapHeight() && y <= sp.getMapWidth() && x >= 0 && y >= 0) {
                     return false;
                 }
             }
         }
         return true;
     }

	public void moveElements() {
		throw new UnsupportedOperationException();
	}

	public void killPlanet() {
		throw new UnsupportedOperationException();
	}

	public void occupyPlanet() {
		throw new UnsupportedOperationException();
	}

	public void killAsteroid() {
		throw new UnsupportedOperationException();
	}

	public void killAlien() {
		throw new UnsupportedOperationException();
	}

	public void selectNextElement() {
		throw new UnsupportedOperationException();
	}

    @Override
    public void nextStep() {
    	if(endgame){
            return;
        }
        if(listElement.size() < 2){
            //stop game
            endgame = true;
            System.out.println("The game is finished");
            return;
        }
        int nbPlanete=0;
        int nbMartian=0;
        int nbKrypto=0;
        int nbAstero=0;
        for (WorldElement worldElement : listElement) {
            if(worldElement.getType() == ElementType.SPACE_PLANET){
            	nbPlanete++;
            }
            if(worldElement.getType() == ElementType.SPACE_ASTEROID){
            	nbAstero++;
            }
            if(worldElement.getType() == ElementType.SPACE_KRYPTONIAN){
            	nbKrypto++;
            }
            if(worldElement.getType() == ElementType.SPACE_MARTIAN){
            	nbMartian++;
            }
        }
        if(nbPlanete == 0 && nbAstero == 0 && nbMartian==0 && nbKrypto==0){
            //stop game
            endgame = true;
            System.out.println("The game is finished");
            return;
        }


        ArrayList<WorldElement> deleteElement = new ArrayList<WorldElement>();
        for (WorldElement worldElement : listElement) {
             if(worldElement.getType() != ElementType.SPACE_BLACKHOLE){
            	 worldElement.move(worldElement.getSpeed());
            	//Collision astero avec trou noir
            	 if(worldElement.getPosition().getX()==trouNoir.getX() && worldElement.getPosition().getY()==trouNoir.getY()){
            		 deleteElement.add(worldElement);
            	 }
             }      	 
        }
        for (WorldElement worldElement : deleteElement) {
        	listElement.remove(worldElement);
        }

        return;
    }

	@Override
	public boolean isEndGame() {
		// TODO Auto-generated method stub
		return false;
	}
}