package Main;

import javax.swing.*;

import java.awt.*;

import becker.robots.*;


public class Layout extends FramedCity {

	JButton startStop;
	JPanel panel;
	private CityView view;

	public Layout() {
		super();
		addPanel();
	}

	public void addCity() {

		City.showFrame(false);

		presentCity = new PresentCity();

		uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);

		CityView view = uiStuff.getCityView();

		this.view = uiStuff.getCityView();

		panel.add(view);

		frame.pack();

	}

	//    public void addStartStop() {
		//        startStop = uiStuff.getStartStopButton();
	//
	//        panel.add(startStop);
	//
	//        frame.pack();
	//    }        

	public void addPanel() {
		panel = new JPanel(new FlowLayout());
		addCity();
		panel.add(view);
		//        panel.add(startStop);


		//         startStop = uiStuff.getStartStopButton();
		panel = new JPanel(new BorderLayout());

		panel.add(view, BorderLayout.NORTH);

		//         panel.add(startStop, BorderLayout.SOUTH);

		panel = new JPanel(new GridLayout(2, 1));

		panel.add(view);
		//         panel.add(startStop);

		panel = new JPanel(null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		frame.setContentPane(panel);

		frame.pack();

	}



	    public static void main(String[] args) {
	
	        Layout framedCity = new Layout();
	
	        framedCity.addCity();
	        framedCity.presentCity.placePresent();
//	        framedCity.addStartStop();
}

}
