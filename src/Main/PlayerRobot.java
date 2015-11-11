package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

public class PlayerRobot extends Robot implements Runnable{
	Double speed = 1.0;
	
	public PlayerRobot(City arg0, int arg1, int arg2, Direction arg3, Double speed) {
		super(arg0, arg1, arg2, arg3);
		this.speed = speed;
	}

	public void turnRight() {
		double speed = getSpeed();
		setSpeed(3 * speed);
		turnLeft();
		turnLeft();
		turnLeft();
		setSpeed(speed);
	}

	public void putThing() {
		if (countThingsInBackpack() > 0)
			super.putThing();
	}

	public void pickThing() {
		if (canPickThing())
			super.pickThing();
	}
	public void move() {
		if (frontIsClear())
			super.move();
	}
	public void turnAround() {
		double speed = getSpeed();
		setSpeed(2 * speed);
		turnLeft();
		turnLeft();
		setSpeed(speed);
	}

	public void move(int nrSteps) {
		for (int i = 0; i < nrSteps; i++) {
			move();
		}
	}

	@Override
	public void run() {
		move(2);
		
	}

}
