package Main;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


import becker.robots.icons.Icon;

public class PresentIcon extends Icon{



	public PresentIcon(){
		super();
	}
	protected void renderImage(Graphics g){
//		Image img1 = null;
//		try {
//			img1 = ImageIO.read(new File("prize.jpeg"));
//			System.out.println("image loaded");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("image not loaded");
//		}
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("prize.jpeg");
		System.out.println(img1);
		System.out.println("image loaded");
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img1, 5, 5, null);

	}
}


