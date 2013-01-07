package waterspace;

import spacelife.SpaceFactory;
import spacelife.SpaceParams;

//Silvin
public abstract class AbstractFactory {

	public abstract AbstractWorld createWorld(SimulParams params);

	public abstract WorldElement createElement(ElementType type, Position pos);
}