package spacelife;

import waterspace.AbstractFactory;

public class SpaceFactory extends AbstractFactory {

	public void createPlanet(int x, int y) {
		throw new UnsupportedOperationException();
	}

	public void createAsteroid(int x, int y) {
		throw new UnsupportedOperationException();
	}

	public void createBlackHole(int x, int y) {
		throw new UnsupportedOperationException();
	}

	public void createAlien(int x, int y) {
		throw new UnsupportedOperationException();
	}

	public SpaceWorld createWorld() {
		throw new UnsupportedOperationException();
	}
}