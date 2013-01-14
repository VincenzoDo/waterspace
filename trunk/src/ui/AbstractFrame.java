/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import waterspace.SimulParams;
import waterspace.WorldManager;

/**
 *
 * @author vince
 */
public abstract class AbstractFrame extends JFrame {
    
    private final WorldManager wm;
    
    public Command cmdRunSim;
    public Command cmdNextStep;
    
    public Display display;
    
    public JPanel panel;
    
    
   public AbstractFrame(WorldManager wm){
       this.wm=wm;
       cmdNextStep = new NextStep(wm);
       cmdRunSim = new RunSim(wm);
       
       
       if(wm.getParameters().isText()){
           display = new DisplayText();
       } else {
           display = new DisplayGraphic();
       }
       
       
       display.setParameters(panel, wm.getParameters());
       
   }
   
   
   public void endGame(){
        JOptionPane.showMessageDialog(null, "The game is finished!");
    }
    
}
