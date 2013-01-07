/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterworld;

import waterspace.ElementType;
import waterspace.Position;
import waterspace.WorldElement;

/**
 *
 * @author Vince
 */
public abstract class WaterElement extends WorldElement {
    
    private static int idCount = 0;
    private int id;
    
    public WaterElement(Position pos, ElementType type){
        super(pos, 0, null, type);
        this.id = ++idCount;
    }
    
    public int getId(){
        return id;
    }
    
    public abstract void move();
    
    public abstract void kill();
    
    public abstract void eat();
    
    public abstract void breed();
    
    public void updateCounters(){
        
    }
    
    public abstract boolean placeElement();
  
   
    
}
