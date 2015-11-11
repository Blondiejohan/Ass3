package Main;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import becker.robots.Direction;

public class Menu extends Layout{
	private boolean paused = false;

	public Menu() {
		super();
	}

	public void pause(){
		if(paused == false){
			try {
				frame.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			frame.notify();
		}
	}

	public void restart(){

		frame.repaint();
		frame.remove(panel);
		
		addPanel();
		 addButtons();
	     addCity();
	     addMenu();
	}

	public JMenu makeActionsMenu() {
		JMenuItem pause = new JMenuItem("Pause");
		JMenuItem restart = new JMenuItem("Restart");

		pause.addActionListener(e -> pause());
		restart.addActionListener(e -> restart());

		JMenu action = new JMenu("Actions");
		action.add(pause);
		action.add(restart);

		return action;
	}

	public JMenu makeSettingsMenu() {
		JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
		JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Medium");
		JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");

		easy.setSelected(true);

		easy.addActionListener(e -> changeRobotSpeed(1.0));
		medium.addActionListener(e -> changeRobotSpeed(2.0));
		hard.addActionListener(e -> changeRobotSpeed(3.0));

		ButtonGroup settingsGroup = new ButtonGroup();
		settingsGroup.add(easy);
		settingsGroup.add(medium);
		settingsGroup.add(hard);

		JMenu settings = new JMenu("Settings");
		settings.add(easy);
		settings.add(medium);
		settings.add(hard);

		return settings;
	}

	private void changeRobotSpeed(double d) {
		restart();
		evilThread.interrupt();
		evilRob = new EnemyRobot(presentCity, size, size, Direction.SOUTH, d);
		evilThread = new Thread(evilRob);
		evilThread.start();
	}

	public void addMenu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu actions = makeActionsMenu(); 
		JMenu settings = makeSettingsMenu();

		menuBar.add(actions);
		menuBar.add(settings);

		frame.setJMenuBar(menuBar);
		frame.pack();
	}
}
