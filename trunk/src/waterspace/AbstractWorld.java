package waterspace;
//Silvin
import waterspace.WorldManager;
import java.util.ArrayList;
import ui.Command;
import waterspace.WorldElement;

public abstract class AbstractWorld {
	public WorldManager wm;
	public ArrayList<WorldElement> listElement = new ArrayList<WorldElement>();

    
	public abstract void nextStep();
    
    public abstract boolean isEndGame();
}