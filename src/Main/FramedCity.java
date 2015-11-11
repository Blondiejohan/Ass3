package Main;

import becker.robots.*;

public class FramedCity {

	static MainFrame frame;
	protected int size=20;
	PresentCity presentCity;
	RobotUIComponents uiStuff;

//	RobotUIComponents uiStuff;

//	PresentCity presentCity;

	public FramedCity() {
		frame = new MainFrame("Presenttopolis");
	}
	
//	public void addCity() {
//
//        City.showFrame(false);
//
//        presentCity = new PresentCity(size);
//
//        uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);
//
//        CityView view = uiStuff.getCityView();
//
//        frame.add(view);
//
//        frame.pack();
//
//    }

//	public void addCity() {
//
//		City.showFrame(false);
//
//		presentCity = new PresentCity();
//
//		uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);
//
//		CityView view = uiStuff.getCityView();
//
//		frame.add(view);
//
//		frame.pack();
//
//	}
}
