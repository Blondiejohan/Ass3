package Main;

import becker.robots.City;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.Sim;

public class EnemyRobot extends PlayerRobot implements IPredicate{
	private static java.util.Random random = new java.util.Random();

	public EnemyRobot(City arg0, int arg1, int arg2, Direction arg3, double s, Main m) {
		super(arg0, arg1, arg2, arg3,s,m);
		setSpeed(s);
		
		Color black = new Color(1);
		this.setColor(black);

	}

	public void go(int steps) {
		for(int i = 0; i != steps; i++) { 
			randomMove();
		}
	}

	public void pickThing() {
		if (canPickThing() == true)
			super.pickThing();
//		if (this.countThingsInBackpack() == 1){
//			JFrame frame = null;
//			JOptionPane.showMessageDialog(frame, "You win! Congratulations");
//		}
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
		if (this.countThingsInBackpack() == 1 || countThingsInBackpack(IPredicate.aRobot) > 0 ){
			int choice = JOptionPane.showConfirmDialog(null, "Evil prevails /n Restart game?", "Game over", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION)
				m.restart();
            else
                System.exit(0);
			
		}
		pickThing();
		move();
	}
	
//	public void pickThing(){
//		if(canPickThing() && (this.equals(aRobot) || this.equals(aThing))){
//			super.pickThing();
//		} else {
//			move();
//		}
//	}
	

	public static int randomInt(int n) {
		return random.nextInt(n);
	}

	@Override
	public void run() {
		go(1000);
		System.out.println("Evil has the runs");
	}

	@Override
	public boolean isOK(Sim s) {
		return s instanceof PlayerRobot;
	}
}
