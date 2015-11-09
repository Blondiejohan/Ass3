package Main;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import becker.robots.icons.Icon;



public class PresentIcon extends Icon{



	public PresentIcon(double relativesize){
		super(relativesize);
	}
	protected void renderImage(Graphics g){
		//			BufferedImage img = ImageIO.read(new File("prize.jpeg"));
		Graphics2D g2 = (Graphics2D) g;
		Image img1 = Toolkit.getDefaultToolkit().getImage("prize.jpeg");
		g2.drawImage(img1, 5, 5, null);
		g2.finalize();
		System.out.println("image loaded");

	}
}


