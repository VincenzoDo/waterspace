package ui;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import waterspace.WorldManager;



public class NextStep implements Command {
    // Receiver
    WorldManager wm;
    
    public NextStep(WorldManager wm){
        this.wm = wm;
    }
    
    @Override
    public void execute (){
        wm.executeNextStep();
    }

    @Override
    public void undo() {
        throw new NotImplementedException(); // no time
    }
}