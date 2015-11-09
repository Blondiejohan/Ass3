package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Wall;



public class PresentCity extends City {


	static int size=10;


	public PresentCity(){
		super(size,size);
		placePresent();
		walls();

	}

	void walls() {

		for (int i = 0; i < size; i++) {
			new Wall(this, 0, i, Direction.NORTH);
			new Wall(this, size-1, i, Direction.SOUTH);
			new Wall(this, i, 0, Direction.WEST);
			new Wall(this, i, size-1, Direction.EAST);
		}

	}

	void placePresent() {
		showThingCounts(true);
		new Present(this, 5, 5);


	}
//	public static void main(String[] args) {
//
//		PresentCity city = new PresentCity();
//		city.walls();
//		city.placePresent();
//
//	}

}

