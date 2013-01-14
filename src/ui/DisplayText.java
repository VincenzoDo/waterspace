/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import waterspace.SimulParams;
import waterspace.WorldElement;

/**
 *
 * @author vince
 */
public class DisplayText implements Display {
    
    private JTextArea tArea;
    
    @Override
    public void refresh(ArrayList<WorldElement> elementList) {
        tArea.append("-----------------------------------------------------\n");
        tArea.append("#ID\tElement\t\t\tX:Y\n");
        tArea.append("-----------------------------------------------------\n");
        for (WorldElement worldElement : elementList) {
            tArea.append(worldElement.toString() + "\n");
        }
        tArea.append("============================================\n\n\n");
        tArea.selectAll();
    }
    
    @Override
    public void setParameters(JPanel panel, SimulParams params) {
        int nbrX = params.getMapHeight();
        int nbrY = params.getMapWidth();
        
        System.out.println("aaa");
        BorderLayout b = new BorderLayout();
        
        panel.setLayout(b);
        tArea = new JTextArea();
        tArea.setEditable(false);
        tArea.setHighlighter(null);
        panel.add(tArea, BorderLayout.CENTER);
        
        
        
        
        
    }
}
