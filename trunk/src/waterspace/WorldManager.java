package waterspace;

//Vince
import java.util.Vector;
import ui.Command;
import waterspace.AbstractWorld;

public class WorldManager {

    private WorldManager instance;
   
    public void nextStep() {
        throw new UnsupportedOperationException();
    }

    private WorldManager() {
       
    }

    public WorldManager getInstance() {
        if (instance == null) {
            instance = new WorldManager();
        }
        return this.instance;
    }
    
    public void initWM(){
        //initialisation of WM
    }
}