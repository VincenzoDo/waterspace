/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterworld;

import waterspace.WorldElement;

/**
 *
 * @author Vince
 */
public abstract class WaterElement extends WorldElement {
    
    public WaterElement(){
        
    }
    
    
    public abstract void move();
    
    public void kill(){
        
    }
    
    public void breed(){
        
    }
    
    public void updateCounters(){
        
    }
    
    public abstract void placeElement();
  
   
    
}
