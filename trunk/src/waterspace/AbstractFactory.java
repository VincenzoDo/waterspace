package waterspace;
//Silvin
public class AbstractFactory {

	public AbstractWorld createWorld() {
		throw new UnsupportedOperationException();
	}

	public IWorldElement createElement(ElementType type) {
		throw new UnsupportedOperationException();
	}
}