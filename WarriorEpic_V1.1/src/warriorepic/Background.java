package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background extends Element{
	public static BufferedImage img;
	
	static{
		try {
			img = ImageIO.read(Background.class.getResource("img/level0.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Background(){
		super(img.getWidth(),img.getHeight(),0,0);

	}
 	
	public void paintObject(Graphics g){
		g.drawImage(img,x,y,null);
	}
}
