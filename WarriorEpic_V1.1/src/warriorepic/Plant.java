package warriorepic;

public class Plant extends Element{

	public Plant() {
		super(55, 89, 2400, 453);
	}
	int a = 20;
	public void step(){
		this.x -= 2;
		this.y -= 20;
	}
	
}
