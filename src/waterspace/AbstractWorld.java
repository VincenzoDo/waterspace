package waterspace;
//Silvin
import waterspace.WorldManager;
import java.util.ArrayList;
import waterspace.IWorldElement;

public class AbstractWorld {
	private IWorldElement listElement;
	public WorldManager receive;
	public ArrayList<IWorldElement> unnamed_IWorldElement_ = new ArrayList<IWorldElement>();

    
	public void nextStep() {
		throw new UnsupportedOperationException();
	}
}