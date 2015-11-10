package Main;

import javax.swing.*;

import java.awt.*;

import becker.robots.*;

public class Layout extends FramedCity {

	JButton startStop;
	JPanel panel;
	CityView view;
	PlayerRobot rob;
	EnemyRobot evilRob;
	PresentCity presentCity;
	RobotUIComponents uiStuff;


	public Layout() {
		super();
		addPanel();
	}

	public void addCity() {

		City.showFrame(false);
		PresentCity presentCity = new PresentCity();
		this.presentCity = presentCity;
		RobotUIComponents uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);
		this.uiStuff = uiStuff;
		CityView view = uiStuff.getCityView();
		this.view = view;
		rob = new PlayerRobot(presentCity, 7, 7, Direction.NORTH, 1.0);
		evilRob = new EnemyRobot(presentCity, 3, 3, Direction.SOUTH);
		presentCity.placePresent();
		presentCity.walls();
		panel.add(this.view);
		frame.pack();

	}

	public void addStartStop() {
		startStop = this.uiStuff.getStartStopButton();
		frame.add(startStop);
		frame.pack();
	}          

	public void addPanel() {

		panel = new JPanel(new BorderLayout());
		addCity();
		addStartStop();
		panel.add(view, BorderLayout.CENTER);
		panel.add(startStop, BorderLayout.SOUTH);
		frame.setContentPane(panel);
		frame.pack();

	}
}
