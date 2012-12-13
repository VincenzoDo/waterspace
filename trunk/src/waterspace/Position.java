
public class Position {
  
  private int xCor;
  private int yCor;
  
  public Position(int x, int y){
    xCor = x;
    yCor = y;
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }
  
  public void setX(int x){
    xCor = x;
  }
  
  public void setY(int y){
    yCor = y;
  }
  
  public void setNewPosition(int x, int y){
    
    setX(x);
    setY(y);
    
  }

}
