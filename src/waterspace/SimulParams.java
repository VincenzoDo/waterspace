/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterspace;

/**
 *
 * @author Raiden
 */
public abstract class SimulParams {
    
    private  int mapWidth;
    private  int mapHeight;
    private boolean text=true;
    
    
    public SimulParams(int mapWidth, int mapHeight, boolean text){
        this.mapWidth=mapWidth;
        this.mapHeight= mapHeight;
        this.text = text; 
    }
    
    public SimulParams(int mapWidth, int mapHeight){
        this.mapWidth=mapWidth;
        this.mapHeight= mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }
    
    public void setText(boolean text){
        this.text = text;
    }
    
    public boolean isText(){
        return text;
    }
    
    
    
}
