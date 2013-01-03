/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import waterspace.WorldManager;

/**
 *
 * @author vince
 */
public class main {

    public static void main(String[] args) {
        WorldManager wm = WorldManager.getInstance();
        MainFrame gui = new MainFrame(wm);
        wm.setGUI(gui);
        ParamsForms p = new ParamsForms(wm, gui);
        p.setSize(600, 400);
        p.setLocation(70, 70);
        p.setVisible(true);



    }
}
