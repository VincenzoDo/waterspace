package waterspace;

//Tarek
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

  public int getPosition() {
    return pos;
  }

  public ElementType getType() {
    return type;
  }

  public void getSpeed() {
    return speed;
  }

  public void getImage() {
    return img;
  }

  /*
  public void placeElement() {
    throw new UnsupportedOperationException();
  }
  */

  public void updateCounters() {

  }
}