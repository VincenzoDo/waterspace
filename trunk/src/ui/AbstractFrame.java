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
       panel = new JPanel();
   }
   
   public void setParams(SimulParams params){
       initFrame();
       if(params.isText()){
           display = new DisplayText();
       } else {
           display = new DisplayGraphic();
       }
       
       display.setParameters(getGamePanel(), params);
   }
   
   
   public Display getDisplay(){
       return display;
   }
   
   public void endGame(){
        JOptionPane.showMessageDialog(null, "The game is finished!");
    }
    
   public abstract void initFrame();
   
   public abstract JPanel getGamePanel();
   
}
