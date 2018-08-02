package warriorepic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 蜗牛
 * @author Administrator
 *
 */
public class Snail extends Element{
	private static BufferedImage[] imgs;//44*34
	static{
		imgs = new BufferedImage[2];
		try {
			imgs[0] = ImageIO.read(Snail.class.getResource("img/snail0.png"));
			imgs[1] = ImageIO.read(Snail.class.getResource("img/snail1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private int step;
	
	public Snail(int x){
		super(imgs[0].getWidth(),imgs[0].getHeight(),x,419);//419
		step = 2;
	}
	
	public void move(){
		x -= step;
	}
	
	int index = 0;
	int a = 0;
	public BufferedImage getImage(){
		if(isLife()){
			if(a++%10==0)
				index++;
			return imgs[index%2];
		}
		if(isDead()){
			state = DEAD;
		}
		return null;
	}
	
	public void paintObject(Graphics g){
		g.drawImage(getImage(),x,y,null);
	}
}
