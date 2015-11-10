package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Wall;



public class PresentCity extends City {

	private static java.util.Random random = new java.util.Random();
	public int size;


	public PresentCity(){
		super();
		this.size = 20;

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
		
		int vertical = randomInt(size);
		int horizontal = randomInt(size);
		
		new Present(this, vertical, horizontal, Direction.NORTH,true,new PresentIcon());


	}
	
	public static int randomInt(int n) {
        return random.nextInt(n);
    }

}

