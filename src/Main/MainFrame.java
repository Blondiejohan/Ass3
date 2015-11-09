package Main;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public MainFrame(String name){
		super(name);
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame("");
		main.setSize(1028,768);
		main.setResizable(false);

	}

}
