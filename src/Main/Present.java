package Main;

import becker.robots.City;
import becker.robots.Thing;

public class Present extends Thing {

	public Present(City arg0, int arg1, int arg2) {
		super(arg0, arg1, arg2);
		setCanBeCarried(true);
		setIcon(new PresentIcon());
	}
}
