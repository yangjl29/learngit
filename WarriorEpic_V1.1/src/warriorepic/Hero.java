package warriorepic;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 英雄的类
 * @author Liam Young
 *
 */
public class Hero extends Element {
	private static BufferedImage[] leftimgs;
	private static BufferedImage[] rightimgs;
	private static BufferedImage[] attackimgs;
	
	static{
		try {
			leftimgs = new BufferedImage[2];
			rightimgs = new BufferedImage[2];
			attackimgs = new BufferedImage[2];
			for(int i = 0; i<leftimgs.length; i++){
				leftimgs[i] = ImageIO.read(Hero.class.getResource("img/left"+i+".png"));
				rightimgs[i] = ImageIO.read(Hero.class.getResource("img/right"+i+".png"));
				attackimgs[i] = ImageIO.read(Hero.class.getResource("img/attack"+i+".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int hitPoint; //生命值
	public static int atk; //攻击力
	
	
	public boolean attack,jump; 
	boolean kleft,kright,kc,kx; 
	private int step;
	
	public Hero(int x) {
		super(leftimgs[0].getWidth(),leftimgs[0].getHeight(),x,347);//人物坐标在中间上方
		hitPoint = 100;
		atk = 20;
		dir = Dir.R;
		attack = false;
		step = SPEED;
	}
	int liIndex = 0;
	int riIndex = 0;
	public void keyPress(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			kleft = true;
			dir=Dir.L;
		}
		if (key == KeyEvent.VK_RIGHT) {
			kright = true;
			dir=Dir.R;
			
		}
		if(key == KeyEvent.VK_C){
			kc = true;
			attack = true;
			width = attackimgs[0].getWidth();
		}
		if(key == KeyEvent.VK_X){
			kx = true;
			jump = true;
		}
		move();
	}
	
	public void move() {
		if(MainGame.allmove){
			return;
		}
		//若按下左键，则往左移动
		if(kleft&&!kright&&!kc&&!kx){
			for(int i = 0; i<step; i++){
				x--;
			}
		}
		//若按下右键，则往右移动
		if(!kleft&&kright&&!kc&&!kx){
			for(int i = 0; i<step; i++){
				x++;
			}
		}
		//若按下X键和左键，则往左跳
		if(kleft&&!kright&&!kc&&kx){
			//跳跃
//			jump();
			x -= step;
		}
		//若按下X键和右键，则往右跳
		if(!kleft&&kright&&!kc&&kx){
			//跳跃
//			jump();
			x += step;
		}
	}
	public void keyRelease(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			kleft = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			kright = false;
		}
		if(key == KeyEvent.VK_C){
			kc = false;
			attack = false;
			width = leftimgs[0].getWidth();
			cast();
		}
		if(key == KeyEvent.VK_X){
			kx = false;
			
		}
		
	}

	int lindex = 0;
	int rindex = 0;
	public BufferedImage getImage(){
		if(jump){
			if(dir==Dir.L&&attack){
				return attackimgs[0];
			}
			if(dir==Dir.R&&attack){
				return attackimgs[1];
			}
		}
		if(dir == Dir.L){
			if(kleft){
				if(lindex++%3==0)
					liIndex++;
				return leftimgs[liIndex%2];
			}
			
		}
		else if(dir == Dir.R){
			if(kright){
				if(rindex++%3==0)
					riIndex++;
				return rightimgs[riIndex%2];
			}
		}
		if(attack){
			if(dir==Dir.L){
				return attackimgs[0];
			}
			if(dir==Dir.R){
				return attackimgs[1];
			}
		}
		if(!kleft&&!kright){
			if(dir==Dir.L){
				return leftimgs[liIndex%2];
			}
			if(dir==Dir.R){
				return rightimgs[riIndex%2];
			}
		}
		if(lindex==10000){
			lindex=0;
			liIndex=0;
			rindex=0;
			riIndex=0;
			
		}
		return null;
	}
	
	int a = -15;
	int ystep = a;
	public void jump(){
		if(jump){
			y += ystep;
			ystep += 1;
			if(y==453-this.height){
				jump=false;
				ystep = a;
			}
		}
		
	}
	
	public void paintObject(Graphics g){
		g.drawImage(getImage(),x-49,y,null);
		move();
		jump();
	}
	
	
	
	public void cast(){
		Dart d = new Dart(this.x,this.y);
		d.dir = this.dir;
	}
	

}


