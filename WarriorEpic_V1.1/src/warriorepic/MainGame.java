 package warriorepic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Liam Young
 * @version 1.0.1 鏈鏇存柊纭畾鍏ㄩ儴鍧愭爣涓轰腑闂翠笂鏂�
 */
public class MainGame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static BufferedImage start;
	public static BufferedImage gameover;
	public static BufferedImage win;
	
	static{
		start = Element.loadImage("img/start.png");
		gameover = Element.loadImage("img/gameover.png");
		win = Element.loadImage("img/win.png");
		
		
	}
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	public static final int WIN = 4;
	
	public static int state = START;
	
	//绐楀彛鐨勫鍜岄珮
	public static final int FWIDTH = 800;
	public static final int FHEIGHT = 600;
	
	public static boolean allmove = false; 
	public static boolean canMoveLeft = false;
	public static boolean canMoveRight = false;
	
	Background bg = new Background();
	Hero hero = new Hero(bg.x+20);
	Wave wave = new Wave(hero);
	Boss boss = new Boss(bg.x+bg.width);
	Tank tank = new Tank();
	List<Bullet> bullets = new ArrayList<Bullet>(); 
	List<Snail> snails = new ArrayList<Snail>();
	Dart dart = new Dart(hero.x,hero.y);
	
	public static int count = 0;
	public static boolean display = false;
	
	public MainGame(){
		JFrame frame = new JFrame("Warrior Epic");
		frame.add(this);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FWIDTH, FHEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		KeyConsole keyc = new KeyConsole();
		frame.addKeyListener(keyc);
		
		new Thread(new paintThread()).start();
		new Thread(new tankAttackThread()).start();
		new Thread(new bossActionThread(bg,boss,hero)).start();
	}
	
	
	
	public static void main(String[] args) {
		MainGame mg = new MainGame();
		mg.action();
	}
	
	public void action(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				if(state==RUNNING){
					enterAction();
					stepAction();
					bangWaveAction();
					bangHeroAction();
					shootAction();
					move();
					judge();
					subtank();
					subboss();
				}
			}
			
		}, 10,30);
		
	}
	
	public void reset(){
		new Thread(new paintThread()).start();
		new Thread(new tankAttackThread()).start();
		new Thread(new bossActionThread(bg,boss,hero)).start();
	}
	
	public void judge(){
		if(boss.hitPoint<=0){
			state = WIN;
		}
		if(hero.hitPoint<=0){
			state = GAME_OVER;
			bg = new Background();
			hero = new Hero(bg.x+20);
			wave = new Wave(hero);
			tank = new Tank();
			boss = new Boss(bg.x+bg.width);
			snails.clear();
			bullets.clear();
			display = false;
		}
	}
	
	int enterIndex = 0; 
	public void enterAction(){
		enterIndex++;
		if(enterIndex%140==0){
			snails.add(new Snail(bg.x+bg.width));
			enterIndex=0;
		}
	}
	public void stepAction(){
		for (Snail s : snails) {
			s.move();
		}
		for (Bullet b : bullets) {
			b.step();
		}
		
	}
	public void subtank(){
		if((hero.x+135>=tank.x)&&hero.attack){
			tank.hitPoint -= 20;
			if(tank.hitPoint<=0){
				tank.goDead();
			}
		}
		
	}
	public void subboss(){
		if((hero.x+135>=boss.x)&&hero.attack){
			boss.hitPoint -= 20;
			
		}
	}
	public void bangHeroAction(){
		for (Snail s : snails) {
			if(s.isLife()&&hero.isLife()&&s.hitH(hero)&&!hero.attack){
				hero.hitPoint -= 2;
				if(hero.dir==Dir.L){
					hero.x += 3;
				}
				if(hero.dir==Dir.R){
					hero.x -= 3;
				}
			}
			if(s.isLife()&&hero.isLife()&&s.hitH(hero)&&hero.attack){
				s.goDead();
			}
			
		}
		if(boss.isLife()&&hero.isLife()&&boss.hitH(hero)){
			hero.x -= 3;
		}
		for (Bullet b : bullets) {
			if(b.isLife()&&hero.isLife()&&b.hitH(hero)){
				hero.hitPoint--;
			}
		}
		if(tank.isLife()&&hero.isLife()&&tank.hitH(hero)){
			hero.x--;
		}
	}
	
	public void bangWaveAction(){

		for (Snail s : snails) {
			if(s.isLife()&&s.hitH(wave)){
				s.goDead();
				
			}
		}
		if(boss.isLife()&&wave.isLife()&&boss.hitH(wave)){
			boss.hitPoint -= hero.atk;
		}
	}
	
	
	int shootIndex = 0; 
	public void shootAction(){ 
		if(tank.isDead()){
			return;
		}
		shootIndex++; 
		if(shootIndex%150==0){
			bullets.add(tank.shoot());
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(state==RUNNING){
			bg.paintObject(g);
			boss.paintObject(g);
			for (Snail s : snails) {
				s.paintObject(g);
			}
			tank.paintObject(g);
			wave.paintObject(g);
			hero.paintObject(g);
			for (Bullet b : bullets) {
				b.paintObject(g);
			}
		}
		
		drawBar(g);
		g.setColor(Color.red);
		g.drawString("C:ATTACK", 20, 40);
		g.drawString("X:JUMP", 20, 60);
		g.setColor(Color.white);
//		g.drawString("y:453", 10, 453);

		switch (state) {
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawString("PAUSE", 400, 300);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
			break;
		case WIN:
			g.drawImage(win,0,0,null);
			break;
		}
	}
	
	public void drawBar(Graphics g){
		g.setColor(Color.white);
		g.drawRoundRect(20, 505, 200, 12, 15, 12);
		g.setColor(Color.red);
		g.fillRoundRect(21, 506, (int)(198*hero.hitPoint/100.0), 11, 15, 12);
		g.setColor(Color.white);
		g.drawString(hero.hitPoint+"/100", 105, 516);
		
		if((hero.x>=bg.x+bg.width-FWIDTH/2)&&(boss.x<=bg.x+bg.width)){
			display = true;
		}
		if(display){
			g.setColor(Color.white);
			g.drawRect(20, 20, 700, 30);
			g.setColor(Color.red);
			g.fill3DRect(21, 21, 698*boss.hitPoint/2000, 28, true);
		}
	}

	/**
	 * 寰�宸︾Щ
	 */
	private void allMoveLeft(){
		
		bg.moveToLeft();
		for (Snail s : snails) {
			s.moveToLeft();;
		}
		tank.moveToLeft();
		boss.moveToLeft();
	}
	/**
	 * 寰�鍙崇Щ
	 */
	private void allMoveRight(){
		
		bg.moveToRight();
		for (Snail s : snails) {
			s.moveToRight();
		}
		tank.moveToRight();
		boss.moveToRight();
	}
	/**
	 * 闄や簡鑻遍泟澶栭兘绉诲姩
	 */
	public void move(){
		allmove = false;
		if(hero.x>=FWIDTH*5/8){
			if(hero.kright&&!(bg.x==FWIDTH-bg.width)){
				allmove = true;
				allMoveLeft();
			}
			if(hero.kleft){
				allmove = false;
			}
		}
		if(hero.x<=FWIDTH*3/8){
			if(hero.kright){
				allmove = false;
			}
			if(hero.kleft&&!(bg.x==0)){
				allmove = true;
				allMoveRight();
			}
		}
		
	}
	
	private class KeyConsole extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_1&&state==WIN){
				state = START;
				reset();
				return;
			}
			if(key == KeyEvent.VK_1&&state==GAME_OVER){
				state = START;
				reset();
				return;
			}
			if(key == KeyEvent.VK_ENTER){
				if(state==START){
					state = RUNNING;
					return;
				}
				if(state==RUNNING){
					state = PAUSE;
					return;
				}
				if(state==PAUSE){
					state = RUNNING;
					return;
				}
				
			}
			if(key == KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
			
			if(state==RUNNING){
				hero.keyPress(e);
			}
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			hero.keyRelease(e);
		}
	}
	
	public class paintThread implements Runnable{

		@Override
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public class tankAttackThread implements Runnable{
		public void run() {
			int xstep = 3;
			while(true){
				if(state==RUNNING){
					tank.x -= xstep;
					if((tank.x<=hero.x+hero.width/2+3)||tank.x>=bg.x+bg.width){
						xstep *= -1;
					}
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}


