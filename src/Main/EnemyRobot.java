package Main;

import becker.robots.City;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import becker.robots.Direction;

public class EnemyRobot extends PlayerRobot{
	private static java.util.Random random = new java.util.Random();
	Double speed;

	public EnemyRobot(City arg0, int arg1, int arg2, Direction arg3, double s) {
		super(arg0, arg1, arg2, arg3,s);
		this.speed = s;
		setSpeed(s);
		
		Color black = new Color(1);
		this.setColor(black);

	}

	public void go(int steps) {
		for(int i = 0; i != steps; i++) { 
			setSpeed(speed);
			System.out.println(speed);
			randomMove();
		}
	}

	public void pickThing() {
		if (canPickThing())
			super.pickThing();
		if (this.countThingsInBackpack() == 1){
			JFrame frame = null;
			JOptionPane.showMessageDialog(frame, "You win! Congratulations");
		}
	}
	
	public void randomMove() {
		int nrTurns = randomInt(4)+1;
		if (nrTurns > 0){
			setSpeed(speed * nrTurns);
			for (int i = 0; i < nrTurns; i++){
				turnLeft();
			}
		}
		setSpeed(speed);
		if (this.countThingsInBackpack() == 1){
			JFrame frame = null;
			JOptionPane.showMessageDialog(frame, "Evil prevails");
			
		}
		pickThing();
		move();
	}

	public static int randomInt(int n) {
		return random.nextInt(n);
	}

	@Override
	public void run() {
		go(1000);
		System.out.println("Evil has the runs");
	}
}
