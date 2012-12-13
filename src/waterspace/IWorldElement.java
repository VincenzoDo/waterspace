package waterspace;

//Tarek

import javax.swing.ImageIcon;

public class IWorldElement {
  private Position     pos;
  private int          speed;
  private ImageIcon    img;
  private ElementType  type;

  public AbstractWorld world;

  public IWorldElement(Position pos, int speed, ImageIcon img,
      ElementType type) {
    this.pos = pos;
    this.speed = speed;
    this.img = img;
    this.type = type;
  }

  public Position getPosition() {
    return pos;
  }

  public ElementType getType() {
    return type;
  }

  public int getSpeed() {
    return speed;
  }

  public ImageIcon getImage() {
    return img;
  }

  /*
   * Specialisation de WaterWorld
  public void placeElement() {
    throw new UnsupportedOperationException();
  }


  public void updateCounters() {

  }
  */
}