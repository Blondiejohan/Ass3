package Main;

import becker.robots.City;
import becker.robots.CityView;
import becker.robots.RobotUIComponents;

public class Main extends MenuThing {

	int size=10;
	
public Main(){
	super();
}


	public static void main(String[] args) {
		Main city = new Main();
		city.addCity();
		city.presentCity.placePresent();
	}
}