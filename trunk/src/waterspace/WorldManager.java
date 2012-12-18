package waterspace;

//Vince
import java.util.ArrayList;
import java.util.Vector;
import ui.Command;
import waterspace.AbstractWorld;

public class WorldManager {
        public ArrayList<Command> listCommand;
        public static ArrayList<WorldElement> listElement;
        public Command cmd;
	private static WorldManager _instance;
	public AbstractWorld _receive;
        
        private WorldManager(){
            _instance = new WorldManager();
            listCommand = new ArrayList<Command>();
            cmd = new Command();
            
        }

	public void executeCommand(Command c) {
            cmd.execute();
            listCommand.add(c);
	}

	public static WorldManager getInstance() {
            if(_instance == null ){
                _instance = new WorldManager();
            }
	    return _instance;	
	}
}
