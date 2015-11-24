package Main;

import javax.swing.*;

import java.awt.*;

import becker.robots.*;

public class Layout extends FramedCity{

	JButton startStop;
	JPanel panel;
	CityView view;

	static PresentCity presentCity;
	RobotUIComponents uiStuff;
	PlayerRobot rob;
	EnemyRobot evilRob;
	Thread robThread;
	Thread evilThread;


	public Layout() {
		super();
		addPanel();
	}

	public void addCity() {

		City.showFrame(false);
		PresentCity presentCity = new PresentCity(size);
		Layout.presentCity = presentCity;

		RobotUIComponents uiStuff = new RobotUIComponents(presentCity, 0, 0, size, size);
		this.uiStuff = uiStuff;

		
		CityView view = uiStuff.getCityView();
		view = uiStuff.getCityView();
		this.view = view;
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

	public JPanel addButtons(){
		JPanel bPanel = new JPanel();

		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		JButton left = new JButton("LEFT");
		JButton right = new JButton("RIGHT");
		JButton pick = new JButton("PICK");

		up.addActionListener(e -> rob.moveTo("up"));
		down.addActionListener(e -> rob.moveTo("down"));
		left.addActionListener(e -> rob.moveTo("left"));
		right.addActionListener(e -> rob.moveTo("right"));
		pick.addActionListener(e -> rob.pickThing());


		GroupLayout layout = new GroupLayout(bPanel);
		bPanel.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addComponent(left)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(up)
						.addComponent(pick)
						.addComponent(down))
				.addComponent(right)
				);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(up)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(left)
						.addComponent(pick)
						.addComponent(right))
				.addComponent(down)
				);

		return bPanel;
	}

	public void addPanel() {

		panel = new JPanel(new BorderLayout());
		addCity();
		addStartStop();
		panel.add(view, BorderLayout.CENTER);
		panel.add(addButtons(), BorderLayout.SOUTH);
		frame.setContentPane(panel);
		frame.pack();

		startStop.doClick();

	}	
}
