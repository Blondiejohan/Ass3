package Main;

import becker.robots.City;
import java.awt.Color;
import javax.swing.JOptionPane;
import becker.robots.Direction;
import becker.robots.RobotException;


public class EnemyRobot extends PlayerRobot {
	private static java.util.Random random = new java.util.Random();
	double speed;
	int identity;

	public EnemyRobot(City aCity,int aStreet,int anAvenue,Direction aDirection,int numThings,double speed, Main m) {
		super(aCity, aStreet, anAvenue, aDirection,numThings,speed,m);
		this.speed = speed;
		Color black = new Color(1);
		this.setColor(black);

	}

	public void go(int steps) {
		setSpeed(speed);
		for(int i = 0; i != steps; i++) { 
			randomMove();
		}
	}
	
	public void breakRobot(String message) {
        try{
		super.getBreakRobot(message);
        } catch (RobotException e){
        	int choice = JOptionPane.showConfirmDialog(null, "You win! Congratulations", "Restart game?", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION){
				m.restart(speed);
			} else{
				System.exit(0);
			}
        }
    }

	public void randomMove() {
		PlayerRobot r;
		if(this.examineRobots().hasNext()){
		r = (PlayerRobot) this.examineRobots().next();
		} else {
			r = null;
		}
		int nrTurns = randomInt(4)+1;
		if (nrTurns > 0){
			setSpeed(speed * nrTurns);
			for (int i = 0; i < nrTurns; i++){
				turnLeft();
			}
		}
		setSpeed(speed);
		
		if (r != null && r.identity == 0){
			r.breakRobot("Death");
		}
		move();
	}

	public static int randomInt(int n) {
		return random.nextInt(n);
	}

	@Override
	public void run() {
		System.out.println(speed);
		go(1000);
		System.out.println("Evil has the runs");
	}
}
