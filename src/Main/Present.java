package Main;


import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.icons.Icon;

public class Present extends Thing {

	public Present(City aCity, int aStreet, int anAvenue, Direction orientation, boolean canBeMoved, Icon anIcon)  {
		super(aCity, anAvenue, anAvenue, orientation, canBeMoved, anIcon);
		setCanBeCarried(true);
	}
}
