package WaterWorld;

import FusionCalssDiagram.IWorldElement;

public class Whale extends Creature1 {
	private Whale instance;
	public Whale unnamed_Whale_;

	public void eat() {
		throw new UnsupportedOperationException();
	}

	private Whale() {
		throw new UnsupportedOperationException();
	}

	public Whale getInstance() {
		return this.instance;
	}

	public void move() {
		throw new UnsupportedOperationException();
	}
}