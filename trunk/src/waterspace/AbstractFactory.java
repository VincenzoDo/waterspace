package waterspace;
//Silvin
public class AbstractFactory {

	public AbstractWorld createWorld() {
		throw new UnsupportedOperationException();
	}

	public WorldElement createElement(ElementType type) {
		throw new UnsupportedOperationException();
	}
}