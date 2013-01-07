package spacelife;

import java.util.ArrayList;

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
	
	public SpaceWorld(SpaceParams sp){
		this.sp = sp;
		sf = new SpaceFactory(sp, this);
		
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
				if (type == ElementType.SPACE_PLANET) {
                    System.out.println("Creating planete");
                    elem = sf.createPlanet();
                }
                if (type == ElementType.SPACE_ASTEROID) {
                    System.out.println("Creating asteroid");
                    elem = sf.createAsteroid();
                }
                if (type == ElementType.SPACE_BLACKHOLE) {
                    System.out.println("Creating blackhole");
                    elem = sf.createBlackHole();
                    trouNoir = elem.getPosition();
                }
                if (type == ElementType.SPACE_MARTIAN) {
                    System.out.println("Creating martian");
                    elem = sf.createMartian();
                }
                if (type == ElementType.SPACE_KRYPTONIAN) {
                    System.out.println("Creating krypronian");
                    elem = sf.createKryptonian();
                }

                listElement.add(elem);
			}
        }
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
    public Command nextStep() {
    	if(endgame){
            return null;
        }
        if(listElement.size() < 2){
            //stop game
            endgame = true;
            System.out.println("The game is finished");
            return null;
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
            return null;
        }


        ArrayList<WorldElement> deleteElement = new ArrayList<WorldElement>();
        for (WorldElement worldElement : listElement) {
             if(worldElement.getType() == ElementType.SPACE_ASTEROID){
            	 worldElement.move(2);
            	 //Collision astero avec trou noir
            	 if(worldElement.getPosition().getX()==trouNoir.getX() && worldElement.getPosition().getY()==trouNoir.getY()){
            		 deleteElement.add(worldElement);
            	 }
            	 //Collision aster avec astero
            	 
             }
             if(worldElement.getType() == ElementType.SPACE_KRYPTONIAN || worldElement.getType() ==  ElementType.SPACE_MARTIAN ||worldElement.getType() == ElementType.SPACE_PLANET){
            	 worldElement.move(1);
            	 //Collision avec trou noir
            	 if(worldElement.getPosition().getX()==trouNoir.getX() && worldElement.getPosition().getY()==trouNoir.getY()){
            		 deleteElement.add(worldElement);
            	 }
            	 //Collision avec astero
             }
        }
        for (WorldElement worldElement : deleteElement) {
        	listElement.remove(worldElement);
        }

        return null;
    }

	@Override
	public boolean isEndGame() {
		// TODO Auto-generated method stub
		return false;
	}
}