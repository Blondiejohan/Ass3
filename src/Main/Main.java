package Main;

import becker.robots.City;
import becker.robots.CityView;
import becker.robots.Direction;
import becker.robots.RobotUIComponents;


public class Main extends Menu {

	public Main(){
		super();
	}

	public void restart() {
        super.restart();
    }
	
	public void addCity() {

		City.showFrame(false);
		PresentCity presentCity = new PresentCity(size);
		Layout.presentCity = presentCity;

		RobotUIComponents uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);
		this.uiStuff = uiStuff;

		rob = new PlayerRobot(presentCity, 7, 7, Direction.NORTH, 3.0, this);
		evilRob = new EnemyRobot(presentCity, 3, 3, Direction.SOUTH,1.0, this);
		robThread = new Thread(rob);
		evilThread = new Thread(evilRob);
		

		robThread.start();
		evilThread.start();
		CityView view = uiStuff.getCityView();
		view = uiStuff.getCityView();
		this.view = view;
		presentCity.placePresent();
		presentCity.walls();
		panel.add(this.view);
		frame.pack();

	}

	public static void main(String[] args) {
		Main window = new Main();
		window.addMenu();

	}
}