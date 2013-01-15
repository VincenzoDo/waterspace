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
        for (int y = 0; y < gridLab.length; y++) {
            for (int x = 0; x < gridLab[y].length; x++) {
                gridLab[y][x].setOpaque(false);
                gridLab[y][x].setIcon(null);
                gridLab[y][x].setHorizontalAlignment(SwingConstants.CENTER);
                boolean found = false;
                Position p = new Position(x, y, null);
                for (WorldElement worldElement : elementList) {
                    if (worldElement.getPosition().equals(p)) {
                        if (worldElement.getType() == ElementType.WATER_ICE) {
                            gridLab[y][x].setOpaque(true);
                            gridLab[y][x].setBackground(new Color(180, 216, 231));
                            //gridLab[x][y].setText("ICE");
                            found = true;
                        } else {
                            ImageIcon image = new javax.swing.ImageIcon(getClass().getResource(worldElement.getImage()));
                            gridLab[y][x].setIcon(image);
                        }
                        //found = true;
                    }
                }
                if (!found) {

                    //gridLab[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/empty.png")));
                    gridLab[y][x].setOpaque(true);
                    gridLab[y][x].setBackground(new Color(51, 102, 153));
                }
            }
        }

    }

    @Override
    public void setParameters(JPanel panel, SimulParams params) {
        int nbrX = params.getMapWidth();
        int nbrY = params.getMapHeight();


        GridLayout grid = new GridLayout(nbrY, nbrX);
        panel.setLayout(grid);
        gridLab = new JLabel[nbrY][nbrX];
        for (int y = 0; y < nbrY; y++) {
            for (int x = 0; x < nbrX; x++) {
                gridLab[y][x] = new JLabel();

                //gridLab[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/empty.png")));

                panel.add(gridLab[y][x]);
            }
        }
    }
}
