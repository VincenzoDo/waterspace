package spacelife;

import ui.Command;
import waterspace.AbstractWorld;
import waterworld.WaterParams;

public class SpaceWorld extends AbstractWorld {

    SpaceParams params;
    public SpaceWorld(SpaceParams params){
        this.params = params;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEndGame() {
        // TODO Auto-generated method stub
        return false;
    }
}