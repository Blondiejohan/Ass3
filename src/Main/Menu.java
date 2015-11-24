package Main;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Menu extends Layout{
	JRadioButtonMenuItem easy, medium, hard;
	
	public Menu() {
		super();
	}

	public void pause(){
		startStop.doClick();
	}
	
	public void restart(double speed){
		startStop.doClick();
		frame.remove(panel);
		frame.repaint();

		addPanel();
		addMenu();
		
		evilRob.speed = speed;
		
		if(speed == 1.0){
			easy.setSelected(true);
			evilRob.setSpeed(evilRob.speed);
		} else if (speed == 2.0) {
			medium.setSelected(true);
			evilRob.setSpeed(evilRob.speed);
		} else {
			hard.setSelected(true);
			evilRob.setSpeed(evilRob.speed);
		}
	}

	public JMenu makeActionsMenu() {
		JMenuItem pause = new JMenuItem("Pause");
		JMenuItem restart = new JMenuItem("Restart");

		pause.addActionListener(e -> pause());
		restart.addActionListener(e -> restart(evilRob.speed));

		JMenu action = new JMenu("Actions");
		action.add(pause);
		action.add(restart);

		return action;
	}

	public JMenu makeSettingsMenu() {
		easy = new JRadioButtonMenuItem("Easy");
		medium = new JRadioButtonMenuItem("Medium");
		hard = new JRadioButtonMenuItem("Hard");

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

	public void changeRobotSpeed(double d) {
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
