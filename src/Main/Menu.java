package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

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
		frame.remove(panel);

		addMenu();
		addPanel();
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

	public void addMenu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu actions = makeActionsMenu(); 
		JMenu settings = makeSettingsMenu();

		menuBar.add(actions);
		menuBar.add(settings);

		frame.setJMenuBar(menuBar);
		frame.pack();
	}



	//	public static void main(String[] args) {
	//
	//		MenuThing framedCity = new MenuThing();
	//
	//        framedCity.addCity();
	//        framedCity.addStartStop();
	//        framedCity.addMenu();
	//
	//    }
}
