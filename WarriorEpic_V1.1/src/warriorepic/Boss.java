package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Boss extends Element{
	public static BufferedImage[] imgs;
	
	static{
		imgs = new BufferedImage[2];
		try {
			for(int i = 0; i<imgs.length; i++){
				imgs[i] = ImageIO.read(Boss.class.getResource("img/boss"+i+".png"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int hitPoint = 2000;
	
	public Boss(int x) {
		super(imgs[0].getWidth(),imgs[0].getHeight(),x,161);
	}
	
	public void missile(int x,int y){
		
		
		
	}
	
	public void lasing(){
		
	}
	
	public void enterAction(){
		
		this.x -= 10;
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
