package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import service.Skeleton;

public class SMain {

	Skeleton skeleton;

	public SMain() {
		try {
			this.skeleton =  new Skeleton();
			LocateRegistry.createRegistry(1099);
	        Naming.rebind("RemoteService", skeleton);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		 System.out.println("서버가 실행중입니다.");
	}

	public static void main(String[] args) {

		SMain main = new SMain();
		main.run();
	}

}
