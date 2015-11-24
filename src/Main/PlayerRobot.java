package Main;

import javax.swing.JOptionPane;
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.RobotException;

public class PlayerRobot extends Robot implements Runnable{
	double speed;
	int identity;
	Main m;

	public PlayerRobot(City aCity,int aStreet,int anAvenue,Direction aDirection,int numThings,double speed, Main m) {
		super(aCity, aStreet, anAvenue, aDirection, numThings);
		this.speed = speed;
		this.m = m;
		
		setSpeed(speed);
	}

	public void getBreakRobot(String message){
		  super.breakRobot(message);
		 }
	
	public void breakRobot(String message) {
        try{
		super.breakRobot(message);
        } catch (RobotException e){
        	int choice = JOptionPane.showConfirmDialog(null, "Evil prevails" + '\n' + "Restart game?", "Game over", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION)
				m.restart(m.evilRob.speed);
			else
				System.exit(0);
        }
    }
	
	public void move(){
		if(!frontIsClear()){
			turnLeft();
			move();
		} else {
			super.move();
		}
	}

	public void pickThing() {
		if (canPickThing())
			super.pickThing();
		if (this.countThingsInBackpack() == 1){
			m.evilRob.breakRobot("Death");
			
		}
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
				setSpeed(speed);
				move();

				break;
			} else {
				while(this.getDirection() != Direction.NORTH){
					setSpeed(4);
					turnLeft();
				}
				setSpeed(speed);
				move();
				break;
			}
		case("down"):
			if(this.getDirection() == Direction.SOUTH){
				setSpeed(speed);
				move();
				break;
			} else {
				while(this.getDirection() != Direction.SOUTH){
					setSpeed(4);
					turnLeft();
				}
				setSpeed(speed);
				move();
				break;
			}
		case("left"):
			if(this.getDirection() == Direction.WEST){
				setSpeed(speed);
				move();
				break;
			} else {
				while(this.getDirection() != Direction.WEST){
					setSpeed(4);
					turnLeft();
				}
				setSpeed(speed);
				move();
				break;
			}
		case("right"):
			if(this.getDirection() == Direction.EAST){
				setSpeed(speed);
				move();
				break;
			} else {
				while(this.getDirection() != Direction.EAST){
					setSpeed(4);
					turnLeft();
				}

				setSpeed(speed);
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
