package spacelife;

import java.util.Random;

import waterspace.AbstractFactory;
import waterspace.AbstractWorld;
import waterspace.ElementType;
import waterspace.Position;
import waterspace.SimulParams;
import waterspace.WorldElement;
import waterworld.WaterParams;
import waterworld.WaterWorld;

public class SpaceFactory extends AbstractFactory {


	public SpaceFactory() {
		
	}

	public Planet createPlanet(Position pos) {
			return new Planet(pos, 1, "/image/planete.jpg", "/image/planete_mars.jpg", "/image/planete_krypton.jpg");
	}

	public Asteroid createAsteroid(Position pos) {
		return new Asteroid(pos, 2, "/image/Asteroide.jpg");
	}

	public BlackHole createBlackHole(Position pos) {
		BlackHole.getInstance().initObject(pos, 0, "/image/trounoir.jpg");
		return BlackHole.getInstance();
	}

	public Martian createMartian(Position pos) {
		return new Martian(pos, 1, "/image/mars.jpg");
	}

	public Kryptonian createKryptonian(Position pos) {
		return new Kryptonian(pos, 1, "/image/krypton.jpg");
	}


	public SpaceWorld createWorld(SimulParams sp) {
		return new SpaceWorld((SpaceParams)sp, this);
	}

	@Override
	public WorldElement createElement(ElementType type, Position placement) {
		// TODO Auto-generated method stub
		WorldElement elem = null;
		if (type == ElementType.SPACE_PLANET) {
            System.out.println("Creating planete");
            elem = createPlanet(placement);
        }
        if (type == ElementType.SPACE_ASTEROID) {
            System.out.println("Creating asteroid");
            elem = createAsteroid(placement);
        }
        if (type == ElementType.SPACE_BLACKHOLE) {
        	System.out.println("Creating blackhole");
            elem = createBlackHole(placement);
        }
        if (type == ElementType.SPACE_MARTIAN) {
        	System.out.println("Creating martian");
            elem = createMartian(placement);
        }
        if (type == ElementType.SPACE_KRYPTONIAN) {
        	System.out.println("Creating krypronian");
            elem = createKryptonian(placement);
        }
		return elem;
	}

}