package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Wall;



public class PresentCity extends City {


	static int size=20;
	int present=1;

	public PresentCity(){
		super(size,size);
		walls();
		placePresent();
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

		PresentIcon ico = new PresentIcon(3);
		
		new Present(this, 10, 10, Direction.NORTH, true, ico);
		
	}


}

