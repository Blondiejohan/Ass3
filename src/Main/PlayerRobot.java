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
		if (frontIsClear()){
			super.move();
			System.out.println("Gogogo!");
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
			System.out.println("Go nr " + i);
		}
		System.out.println("End of go()");
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
				break;
			}
		}
		
	}
	
	@Override
	public void run() {
		go(10);
		System.out.println("In run(), after go()");
	}

}
