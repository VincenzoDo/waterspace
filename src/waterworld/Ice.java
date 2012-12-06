package waterworld;

import waterspace.IWorldElement;

public class Ice extends IWorldElement {
	private Ice instance;
	private Object[][] position;
	public Ice unnamed_Ice_;

	private Ice() {
		throw new UnsupportedOperationException();
	}

	public Ice getInstance() {
		return this.instance;
	}

	public void move() {
		throw new UnsupportedOperationException();
	}
}