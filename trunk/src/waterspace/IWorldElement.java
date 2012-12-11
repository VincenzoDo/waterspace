package waterspace;
//Tarek
public class IWorldElement {
	private int x;
	private int y;
	private int speed;
        
	public AbstractWorld world;

	public int getPosition() {
		throw new UnsupportedOperationException();
	}
        
        public void move(){
            
        }
        
        public void kill(){
            
        }

	public ElementType getType() {
		throw new UnsupportedOperationException();
	}

	public void getSpeed() {
		throw new UnsupportedOperationException();
	}

	public void getImage() {
		throw new UnsupportedOperationException();
	}
        
        public void placeElement() {
                throw new UnsupportedOperationException();
        }
        
        public void updateCounters(){
        
        }
}