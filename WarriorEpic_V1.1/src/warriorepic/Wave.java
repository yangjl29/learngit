package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * 剑气
 * @author Liam Young
 * 
 */
public class Wave extends Element{
	private static BufferedImage[] imgs;//75*27
	static{
		imgs = new BufferedImage[2];
		for(int i = 0; i<imgs.length; i++){
			imgs[i] = loadImage("img/wave"+i+".png");
		}
		
	}
	

	Hero hero = null;
	
	public Wave(Hero hero){
		super(imgs[0].getWidth(),imgs[0].getHeight(),0,0);
		this.hero = hero;
	}
	
	public BufferedImage getImage(){
		if(hero.kleft||hero.kright&&!hero.jump){
			return null;
		}
		if(hero.dir==Dir.L&&hero.attack){
			return imgs[0];
		}
		if(hero.dir==Dir.R&&hero.attack){
			return imgs[1];
		}
		
		return null;
	}
	
	public void paintObject(Graphics g){
		
		if(hero.dir==Dir.L){
			x = hero.x-hero.width/2-this.width/2;
		}
		if(hero.dir==Dir.R){
			x = hero.x+hero.width/2+this.width/2+1;
		}
		y = hero.y+hero.height/2;
		g.drawImage(getImage(),x-this.width/2,y+10,null);
	}

}
