package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Tank extends Element{
	public static BufferedImage[] imgs;//164*141
	
	static{
		imgs = new BufferedImage[4];
		try {
			for(int i = 0; i<imgs.length; i++){
				imgs[i] = ImageIO.read(Tank.class.getResource("img/tank"+i+".png"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int hitPoint = 1000;
	private Hero hero = null;
	
	public Tank() {
		super(imgs[0].getWidth(),imgs[0].getHeight(),2400,312);
		
	}
	int xstep = 1;
	
	public void rushLeft(){
		this.x -= xstep;
	}
	public void rushRight(){
		this.x += xstep;
	}
	public Bullet shoot(){
		
			Bullet bs = new Bullet(this.x-20, this.y+this.height/2+17);
			return bs;
		}
	
	int imgIndex = 0;
	private BufferedImage getImage(){
		if(isLife()){
			return imgs[imgIndex++%2];
		}
		return null;
	}
	
	public void paintObject(Graphics g){
		g.drawImage(getImage(),x,y,null);
	}

	
}
