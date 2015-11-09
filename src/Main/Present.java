package Main;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.icons.Icon;

public class Present extends Thing {

	

	
	public Present(City arg0, int arg1, int arg2, Direction arg3, boolean arg4, Icon arg5) {
		super(arg0, arg2, arg2, arg3, arg4, arg5);
		setCanBeCarried(true);
		

	}
}
