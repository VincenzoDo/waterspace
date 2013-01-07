package waterspace;

//Vince
import java.util.ArrayList;

import spacelife.SpaceFactory;
import spacelife.SpaceParams;
import spacelife.SpaceWorld;
import ui.Command;
import ui.MainFrame;
import waterworld.WaterFactory;
import waterworld.WaterParams;
import waterworld.WaterWorld;

public class WorldManager {

    private static AbstractWorld world;
    private static WorldManager instance;
    private ThreadSimulation simulation;
    private MainFrame game;
    private AbstractFactory factory;

    private WorldManager() {
    }

    public void executeNextStep() {
//            Command cmd = world.nextStep();
//           // if(cmd != null){
//            if(true){
//            //    cmd.execute();
//                
//            } else {
//                simulation.pause();
//                return;
//            }
//            cmd.execute();

        world.nextStep();
        
        game.refresh(world.listElement);

        //listCommand.add();
    }

    public static WorldManager getInstance() {
        if (instance == null) {
            instance = new WorldManager();
        }
        return instance;
    }

    public void setWorldList(AbstractWorld world) {
        WorldManager.world = world;
    }

    public void setGUI(MainFrame game) {
        this.game = game;
    }
    
    public ArrayList<WorldElement> getListElement(){
        return world.listElement;
    }

    public void setParameters(SimulParams params){
        simulation = new ThreadSimulation(this, 100);
        //WaterParams params = new WaterParams(world_width, world_height, nbOfShark, nbOfPenguin, nbOfIce, starving_each, sexCounter);
        if(params instanceof WaterParams){
            //factory.setWorld(null);
            factory = new WaterFactory((WaterParams)params);
            world = factory.createWorld(params);
            System.out.println("WaterWorld created");
        }
        else{
        	factory = new SpaceFactory();
            world = factory.createWorld((SpaceParams)params);
            System.out.println("SpaceWorld created");
        }
        
        System.out.println("listElement size: " + world.listElement.size());
        for (WorldElement element : world.listElement) {
            System.out.println("ELT type: " + element.getType().toString() + "pos X: " + element.getPosition().getX());
            System.out.println("ELT type: " + element.getType().toString() + "pos Y: " + element.getPosition().getY());
        }
        
        game.setParam(params.getMapWidth(), params.getMapHeight());
        game.refresh(world.listElement);
    }

    public void runsim() {
        if(!world.isEndGame()){
            simulation.start();
        }
    }

    public boolean isEndGame() {
        return world.isEndGame();
    }
    
    public void endGame(){
        game.endGame();
    }
}
