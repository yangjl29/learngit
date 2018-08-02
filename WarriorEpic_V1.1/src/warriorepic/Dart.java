package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Dart extends Element{
	private static BufferedImage[] imgs;
	
	static{
		imgs = new BufferedImage[2];
		for(int i = 0; i<imgs.length; i++){
			imgs[i] = loadImage("img/sss"+i+".png");
		}
	}
	
	private int speed;

	public Dart(int x, int y) {
		super(22, 17, x, y);
		speed = 10;
	}
	
	public void step(){
		if(dir==Dir.L){
			x -= speed;
		}
		if(dir==Dir.R){
			x += speed;
		}
	}
	
	int dIndex = 0;
	public BufferedImage getImage(){
		return imgs[dIndex++%2];
	}
	
	public void paintObject(Graphics g){
		g.drawImage(getImage(),x,y,null);
	}
	

}
