package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

public class PlayerRobot extends Robot implements Runnable{
	Double speed;
	
	public PlayerRobot(City arg0, int arg1, int arg2, Direction arg3, Double speed) {
		super(arg0, arg1, arg2, arg3);
		this.speed = speed;
		setSpeed(speed);
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
		if (frontIsClear()){
			super.move();
		} else {
			while(!frontIsClear()){
				turnLeft();
			}
		}
	}
	public void turnAround() {
		double speed = getSpeed();
		setSpeed(2 * speed);
		turnLeft();
		turnLeft();
		setSpeed(speed);
	}
	

	public void go(int nrSteps) {
		for (int i = 0; i < nrSteps; i++) {
			move();
		}
	}

	public void moveTo(String s){
		switch(s){
		case("up"):
			if(this.getDirection() == Direction.NORTH){
				move();
				break;
			} else {
				while(this.getDirection() != Direction.NORTH){
					turnLeft();
				}
				move();
				break;
			}
		case("down"):
			if(this.getDirection() == Direction.SOUTH){
				move();
				break;
			} else {
				while(this.getDirection() != Direction.SOUTH){
					turnLeft();
				}
				move();
				break;
			}
		case("left"):
			if(this.getDirection() == Direction.WEST){
				move();
				break;
			} else {
				while(this.getDirection() != Direction.WEST){
					turnLeft();
				}
				move();
				break;
			}
		case("right"):
			if(this.getDirection() == Direction.EAST){
				move();
				break;
			} else {
				while(this.getDirection() != Direction.EAST){
					turnLeft();
				}
				move();
				break;
			}
		}
		
	}
	
	@Override
	public void run() {
		go(0);
	}

}
