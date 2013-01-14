/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JPanel;
import waterspace.SimulParams;
import waterspace.WorldElement;

/**
 *
 * @author vince
 */
public interface Display {
    
    
    public void refresh(ArrayList<WorldElement> elementList);
    
    public void setParameters(JPanel panel, SimulParams params);
    
}
