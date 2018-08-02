package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class Element {

	public static final int LIFE = 0;
	public static final int DEAD = 1;
	public static final int REMOVE = 2;
	public int state = LIFE;
	
	public static final int SPEED = 5;
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	public Dir dir;
	
	public Element(int width,int height,int x,int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public static BufferedImage loadImage(String fileName){
		try{
			BufferedImage img = ImageIO.read(Element.class.getResource(fileName));//ͬ���ж�ȡfileName
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void moveToLeft(){
		for(int i = 0; i<SPEED; i++){
			this.x--;
		}
	}
	public void moveToRight(){
		for(int i = 0; i<SPEED; i++){
			this.x++;
		}
	}
	
	
	public boolean hitH(Element e){
		int x1 = e.x-e.width/2-this.width;
		int x2 = e.x+e.width/2;
		int y1 = e.y+this.height;
		int y2 = e.y+e.height;
		int x = this.x;
		int y = this.y;
		return x>=x1&&x<=x2&&y>=y1&&y<=y2;
	}
	
	public void goDead(){
		state = DEAD;
	}
	
	public boolean isLife(){
		return state == LIFE;
	}
	public boolean isDead(){
		return state == DEAD;
	}
	
	public boolean outOfBound(){
		return x<0||x>MainGame.FWIDTH;
	}
}
