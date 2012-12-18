/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.*;
import javax.swing.*;
import waterspace.WorldElement;
import waterspace.WorldManager;

/**
 *
 * @author PBK2
 */
public class IHM extends JFrame{
    // --- Components - not private to have easy access
    JButton nextStep = new JButton("NextStep");
    ImageIcon[][] elements = new ImageIcon[10][10];
    JLabel[][] images = new JLabel[10][10];
    private JPanel container = new JPanel();
    private JLabel ecran = new JLabel();
     // --- MVC
    WorldManager vm;

   

    /**
     * Constructor of the IHM
     * <p/>
     * @param simulation used to obtain the {@link WorldManager}, because this
     * is the {@link Simulation} who create the {@code WorldManager}
     */
    public IHM(WorldManager vm) {
        this.vm = vm;
        this.setTitle("SimulLife");
        JPanel panEcran = new JPanel();
        panEcran.setPreferredSize(new Dimension(220, 30));
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
        // --- the main UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Add Icon of Element in the tab
        for(int i=0; i<vm.listElement.size() ; i++){
            WorldElement elt = vm.listElement.get(i);
            int x = elt.getPosition().getX();
            int y = elt.getPosition().getY();
            elements[x][y]=elt.getImage();
            images[x][y] = new JLabel(elements[x][y]);
        }
        
        // Add Image to the JPanel
        for(int i=0; i<images.length ; i++){
            for(int j = 0 ; j<images[0].length ; j++){
                panEcran.add(images[i][j]);
            }
        }
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(panEcran, BorderLayout.CENTER); 
        this.setVisible(true);

    }

   
    public static void main(String[] args) {
        WorldManager world = WorldManager.getInstance();
        IHM game = new IHM(world);
        //Ajout de la fenêtre comme observer de notre modèle
  }

    
    
}
