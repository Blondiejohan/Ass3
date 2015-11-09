package Main;

import becker.robots.City;
import becker.robots.CityView;
import becker.robots.RobotUIComponents;

public class Main extends Menu {

	//int size=10;
	
public Main(){
	super();
}


	public static void main(String[] args) {
		Main window = new Main();
		
		window.addMenu();
		window.addCity();
		window.presentCity.placePresent();
	}
}