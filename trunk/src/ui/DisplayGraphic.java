/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.SimulParams;
import waterspace.WorldElement;

/**
 *
 * @author vince
 */
public class DisplayGraphic implements Display {

    public JLabel[][] gridLab;

    @Override
    public void refresh(ArrayList<WorldElement> elementList) {
        for (int x = 0; x < gridLab.length; x++) {
            for (int y = 0; y < gridLab[x].length; y++) {
                gridLab[x][y].setOpaque(false);
                gridLab[x][y].setIcon(null);
                gridLab[x][y].setHorizontalAlignment(SwingConstants.CENTER);
                boolean found = false;
                Position p = new Position(x, y, null);
                for (WorldElement worldElement : elementList) {
                    if (worldElement.getPosition().equals(p)) {
                        if (worldElement.getType() == ElementType.WATER_ICE) {
                            gridLab[x][y].setOpaque(true);
                            gridLab[x][y].setBackground(new Color(180, 216, 231));
                            //gridLab[x][y].setText("ICE");
                            found = true;
                        } else {
                            ImageIcon image = new javax.swing.ImageIcon(getClass().getResource(worldElement.getImage()));
                            gridLab[x][y].setIcon(image);
                        }
                        //found = true;
                    }
                }
                if (!found) {

                    //gridLab[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/empty.png")));
                    gridLab[x][y].setOpaque(true);
                    gridLab[x][y].setBackground(new Color(51, 102, 153));
                }
            }
        }

    }

    @Override
    public void setParameters(JPanel panel, SimulParams params) {
        int nbrX = params.getMapWidth();
        int nbrY = params.getMapHeight();


        GridLayout grid = new GridLayout(nbrX, nbrY);
        panel.setLayout(grid);
        gridLab = new JLabel[nbrX][nbrY];
        for (int x = 0; x < nbrX; x++) {
            for (int y = 0; y < nbrY; y++) {
                gridLab[x][y] = new JLabel();

                //gridLab[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/empty.png")));

                panel.add(gridLab[x][y]);
            }
        }
    }
}
