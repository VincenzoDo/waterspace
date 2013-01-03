/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterspace;

import com.sun.istack.internal.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author vince
 */
class ThreadSimulation extends Thread {
    
    private final WorldManager wm;
    private boolean pause = false;
    
    private long stepT=600;

    public ThreadSimulation(WorldManager wm, int stepT) {
        this.wm = wm;
        this.stepT=stepT;
    }
    
    
    @Override
    public void run(){
        try{
            while(!pause){
                wm.executeNextStep();
                Thread.sleep(stepT);
            }
        } catch (InterruptedException ex){
            
            
        }
    }
    
    public void pause(){
        this.pause=true;
    }
    
}
