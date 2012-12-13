package spacelife;

import waterspace.IWorldElement;
import java.util.Random;

public class Alien extends IWorldElement {
  
  Random r;
  
  public Alien(Position pos, int speed, ImageIcon img,
      ElementType type){
    
    super(pos, speed, img type);
    
  }
  
  public void move(int tickNbr){
    
    //Check if it's time to move
    if((tickNbr % speed)==0){
      
    }
    
  }
  
}