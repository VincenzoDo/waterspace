package ui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import waterspace.WorldManager;

public class RunSim implements Command {

    WorldManager wm;
    public RunSim(WorldManager wm){
        this.wm = wm;
    }
    
    @Override
    public void execute() {
        wm.runsim();
    }

    @Override
    public void undo() {
        throw new NotImplementedException();
    }

}
