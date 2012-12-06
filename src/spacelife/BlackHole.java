package spacelife;

import waterspace.IWorldElement;
//Silvin aime cette classe
public class BlackHole extends IWorldElement {
	private BlackHole instance;
	public BlackHole unnamed_BlackHole_;

	public BlackHole getInstance() {
		return this.instance;
	}

	private BlackHole() {
		throw new UnsupportedOperationException();
	}
}