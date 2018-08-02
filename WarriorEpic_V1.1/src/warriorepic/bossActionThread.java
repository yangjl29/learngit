package warriorepic;

public class bossActionThread implements Runnable {

	Background bg = null;
	Boss boss = null;
	Hero hero = null;
	
	public bossActionThread(Background bg,Boss boss,Hero hero) {
		this.bg = bg;
		this.boss = boss;
		this.hero = hero;
	}
	public void run() {
		while(true){
			if(MainGame.state==MainGame.GAME_OVER){
				return;
			}
			if((boss.x>bg.x+bg.width-boss.width)&&(hero.x>=bg.x+bg.width-MainGame.FWIDTH/2)){
				boss.enterAction();
			}
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
