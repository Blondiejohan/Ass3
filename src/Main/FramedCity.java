package Main;

import becker.robots.*;

public class FramedCity {

	static MainFrame frame;
	protected int size=10;
	PresentCity presentCity;
	RobotUIComponents uiStuff;

	public FramedCity() {
		frame = new MainFrame("Presenttopolis");
	}
}