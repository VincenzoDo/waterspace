package waterspace;
//Silvin
import waterspace.WorldManager;
import java.util.ArrayList;
import waterspace.WorldElement;

public class AbstractWorld {
	public WorldManager receive;
	public ArrayList<WorldElement> listElement = new ArrayList<WorldElement>();

    
	public void nextStep() {
		throw new UnsupportedOperationException();
	}
}