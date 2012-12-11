package waterspace;
//Silvin
import waterspace.WorldManager;
import java.util.ArrayList;
import waterspace.IWorldElement;

public class AbstractWorld {
	public WorldManager receive;
	public ArrayList<IWorldElement> listElement = new ArrayList<IWorldElement>();

    
	public void nextStep() {
		throw new UnsupportedOperationException();
	}
}