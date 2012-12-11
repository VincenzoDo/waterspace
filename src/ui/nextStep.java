package ui;

import waterspace.AbstractWorld;



public class nextStep extends Command {
    // Receiver
    AbstractWorld world;
    
    public nextStep(AbstractWorld w){
        this.world = w;
    }
    
    public void execute (){
        world.nextStep();
    }
    
    //public void undo(){
    //}
}