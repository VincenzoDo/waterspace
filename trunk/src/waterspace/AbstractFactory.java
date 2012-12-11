package waterspace;
//Silvin
public class AbstractFactory {

	public AbstractWorld createWorld() {
		throw new UnsupportedOperationException();
	}

	public void createElement(ElementType type) {
		throw new UnsupportedOperationException();
	}
}