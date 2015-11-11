package Main;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends Layout{
	public Menu() {
		super();
	}

	public void pause(){
		startStop.doClick();
	}

	public void restart(){
		startStop.doClick();
		frame.remove(panel);
		frame.repaint();

		addPanel();
		addMenu();
	}
	
	public void restart(double speed){
		startStop.doClick();
		frame.remove(panel);
		frame.repaint();

		addPanel();
	//	addButtons();
	//	addCity();
		addMenu();
		
		evilRob.setSpeed(speed);
		
	//	startStop.doClick();
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
		
		restart(d);

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
