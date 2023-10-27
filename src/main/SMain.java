package main;
public class SMain {
		
	Skeleton skeleton;
	
	public SMain() {
		this.skeleton =  new Skeleton();
	}
	
	public void run() {
		this.skeleton.process();
	}

	public static void main(String[] args) {

		SMain main = new SMain();
		main.run();
	}

}