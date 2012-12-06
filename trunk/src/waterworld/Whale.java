package waterworld;

import waterspace.IWorldElement;

public class Whale extends IWorldElement {
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