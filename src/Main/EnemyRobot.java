package Main;

import becker.robots.City;

import java.awt.Color;
import becker.robots.Direction;
import becker.robots.Robot;

public class EnemyRobot extends Robot {
	private static java.util.Random random = new java.util.Random();
	Double speed=1.0;

	public EnemyRobot(City arg0, int arg1, int arg2, Direction arg3) {
		super(arg0, arg1, arg2, arg3);
		Color black = new Color(1);
		this.setColor(black);

	}
	
	public void go(int steps) {
		for(int i = 0; i != steps; i++) { 
			if (canPickThing()==true){
				pickThing();	
			}else{
				continue;
			}
			randomMove();
			System.out.println("Bad guy moved");
		}
	}

	public void randomMove() {
		int nrTurns = randomInt(4)+1;
		if (nrTurns > 0)
			setSpeed(speed);
		for (int i = 0; i < nrTurns; i++)
			turnLeft();
		setSpeed(speed);
		move();
	}

	public static int randomInt(int n) {
		return random.nextInt(n);
	}
}
