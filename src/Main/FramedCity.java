package Main;

import becker.robots.*;

public class FramedCity {
	
	MainFrame frame;
    int size;

    RobotUIComponents uiStuff;
	
	PresentCity presentCity;
    
    public FramedCity() {
    	frame = new MainFrame("Presenttopolis");
        size = 10;
        
    }

    public void addCity() {

        City.showFrame(false);

        presentCity = new PresentCity();

        uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);

        CityView view = uiStuff.getCityView();

        frame.add(view);

        frame.pack();

    }
    
//	public static void main(String[] args) {
//		FramedCity city = new FramedCity();
//		city.addCity();
//	}

}
