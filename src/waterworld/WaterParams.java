package waterworld;

public class WaterParams {
	private int nbOfShark;
	private int nbOfPenguin;
	private int nbOfIce;
	private int starving_each;
	private int world_height;
	private int world_width;

    public WaterParams(int nbOfShark, int nbOfPenguin, int nbOfIce, int starving_each, int world_height, int world_width) {
        this.nbOfShark = nbOfShark;
        this.nbOfPenguin = nbOfPenguin;
        this.nbOfIce = nbOfIce;
        this.starving_each = starving_each;
        this.world_height = world_height;
        this.world_width = world_width;
    }
    
    public int getNbOfShark() {
        return nbOfShark;
    }

    public int getNbOfPenguin() {
        return nbOfPenguin;
    }

    public int getNbOfIce() {
        return nbOfIce;
    }

    public int getStarving_each() {
        return starving_each;
    }

    public int getWorld_height() {
        return world_height;
    }

    public int getWorld_width() {
        return world_width;
    }
        
        
        
}
