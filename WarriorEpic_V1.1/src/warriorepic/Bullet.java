package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Bullet extends Element{
	private static BufferedImage image;
	static{
		image = loadImage("img/bullet.png");
	}
	private int speed;
	
	public Bullet(int x, int y){
		super(14,8,x,y);
		speed = 10;
	}
	
	public void step(){
		x -= speed;
	}
	//重写getImage,获取图片
	public BufferedImage getImage(){
		if(isLife()){
			return image;
		}
		else if(isDead()){
			state = REMOVE;//将状态改为删除
		}
		return null;
	}
	
	public void paintObject(Graphics g){
		g.drawImage(getImage(),x,y,null);
	}
	
	
}