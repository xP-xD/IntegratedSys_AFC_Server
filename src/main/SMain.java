package main;
public class SMain {
		
	Skeleton skeletonForRecive;
    Skeleton skeletonForSend;

    public SMain() {
        this.skeletonForRecive = new Skeleton();
        this.skeletonForSend = new Skeleton();
    }

    public void run() {
        Thread reciveThread = new Thread(() -> {
            this.skeletonForRecive.processForRecive();
        });

        Thread sendThread = new Thread(() -> {
            this.skeletonForSend.processForSend();
        });

        reciveThread.start();
        sendThread.start();
    }
	
	public static void main(String[] args) {

		SMain main = new SMain();
		main.run();
	}


}