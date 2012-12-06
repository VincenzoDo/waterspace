package WaterWorld;

import java.util.Vector;
import FusionCalssDiagram.Command;
import FusionCalssDiagram.AbstractWorld;

public class WorldManager {
	private Worldmanager _instance;
	public WorldManager _unnamed_WorldManager_;
	public Vector<Command> _unnamed_Command_ = new Vector<Command>();
	public AbstractWorld _receive;

	public void nextStep() {
		throw new UnsupportedOperationException();
	}

	private WorldManager() {
		throw new UnsupportedOperationException();
	}

	private WorldManager getInstance() {
		throw new UnsupportedOperationException();
	}
}