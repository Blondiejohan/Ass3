package Main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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


	public void pickThing() {
		if (canPickThing())
			super.pickThing();
		if (this.countThingsInBackpack() == 1){
			JFrame frame = null;
			JOptionPane.showMessageDialog(frame, "You win! Congratulations");
		}
	}




	public void go(int nrSteps) {
		for (int i = 0; i < nrSteps; i++) {
			move();
		}
	}
	
	public void freeze(){
		//TODO
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
