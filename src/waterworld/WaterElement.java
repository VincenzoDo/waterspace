/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterworld;

import waterspace.WorldElement;

/**
 *
 * @author romain
 */
public abstract class WaterElement extends WorldElement {
    
    public abstract void placeElement();

    public abstract void move();
    
    public void breed(){
    }
    
    public void kill(){
    }
    
    public void updateCounters(){
    }
    
}
