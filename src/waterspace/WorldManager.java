package waterspace;

//Vince

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
        
        private WorldManager(){
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
            if(instance == null ){
                instance = new WorldManager();
            }
	    return instance;	
	}
        
        public void setWorldList(AbstractWorld world){
            WorldManager.world = world;
        }
        
        
        public void setGUI(MainFrame game){
            this.game=game;
        }
        
        
        public void setParameters(int world_width,int world_height, int nbOfShark, int nbOfPenguin, int nbOfIce, int starving_each, int sexCounter){
            simulation = new ThreadSimulation(this, 100);
            WaterParams params = new WaterParams(world_width, world_height, nbOfShark, nbOfPenguin, nbOfIce, starving_each, sexCounter);
            
            //factory.setWorld(null);
            world =new WaterWorld(params);
            System.out.println("WorldCreated");
            System.out.println("listElement size: "+world.listElement.size());
            for (WorldElement element : world.listElement) {
                System.out.println("ELT type: "+ element.getType().toString()+ "pos X: "+element.getPosition().getX());
                System.out.println("ELT type: "+ element.getType().toString()+ "pos Y: "+element.getPosition().getY());
            }
            game.setParam(params.getMapWidth(), params.getMapHeight());
            game.refresh(world.listElement);
        }
        
        public void runsim(){
            simulation.start();
        }
                
}
