package spacelife;

import java.util.Random;

import waterspace.AbstractFactory;
import waterspace.Position;
import waterworld.WaterParams;
import waterworld.WaterWorld;

public class SpaceFactory extends AbstractFactory {

	private SpaceParams params;
	private SpaceWorld world;
	private Position pos;
	private Random r;

	public SpaceFactory(SpaceParams params, SpaceWorld world) {
		this.params = params;
		this.world = world;
		this.pos = new Position(0, 0, params);
		r = new Random();
	}

	public Planet createPlanet() {
		if(placeElement()){
			return new Planet(pos, 1, "/image/planete.jpg");
		}else{
			return null;
		}
	}

	public Asteroid createAsteroid() {
		if(placeElement()){
		return new Asteroid(pos, 1, "/image/Asteroide.jpg");
	}else{
		return null;
	}
	}

	public BlackHole createBlackHole() {
		if(placeElement()){
		BlackHole.getInstance().initObject(pos, 1, "/image/trounoir.jpg");
		return BlackHole.getInstance();
	}else{
		return null;
	}
	}

	public Martian createMartian() {
		if(placeElement()){
		return new Martian(pos, 1, "/image/mars.jpg");
	}else{
		return null;
	}
	}

	public Kryptonian createKryptonian() {
		if(placeElement()){
		return new Kryptonian(pos, 1, "/image/krypton.jpg");
	}else{
		return null;
	}
	}

	public boolean placeElement() {
		boolean found = false;
		while (!found) {
			int x = r.nextInt(params.getWorld_width());
			int y = r.nextInt(params.getWorld_height());
			// check position
			if (this.world.isCellFree(x, y)) {
				pos = new Position(x, y, params);
				found = true;
			}

		}
		return true;
	}

	public SpaceWorld createWorld() {
		throw new UnsupportedOperationException();
	}
}