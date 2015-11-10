package Main;



import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import becker.robots.icons.Icon;

public class PresentIcon extends Icon{


	BufferedImage  img=null;

	public PresentIcon(){
		this.setSize(0.4);
		try {
			img = ImageIO.read(new File("prize.jpeg"));
			System.out.println("present loaded");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("present not loaded");
		}
		Graphics g;
		g = img.getGraphics() ;
		this.paintIcon(g);
	}



	protected void paintIcon(Graphics g){

	g.drawImage(img, 0, 0, null);
	}
}


