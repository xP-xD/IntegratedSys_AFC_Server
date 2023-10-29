package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import service.IService;
import service.SLecture;
import service.SLogIn;
import service.SMajor;
import service.SPersonalInfo;
import service.SPreApplicationForClasses;
import service.SRealApplicationForClasses;
import valueObject.IValueObject;
import valueObject.VLecture;
import valueObject.VLogIn;
import valueObject.VMajor;
import valueObject.VPersonalInfo;
import valueObject.VPreApplicationForClasses;
import valueObject.VRealApplicationForClasses;

public class Skeleton {

	private ArrayList<String> objectInfoList;// 0.objectName 1.MathodName 2.args~
	private HashMap<String, Object> objectMap;

	public Skeleton() {
		this.objectInfoList = new ArrayList<String>();
		this.objectMap = new HashMap<String, Object>();

		this.objectMap.put("sPersonalInfo", new SPersonalInfo());
		this.objectMap.put("sLogIn", new SLogIn());
		this.objectMap.put("sMajor", new SMajor());
		this.objectMap.put("sLecture", new SLecture());
		this.objectMap.put("sPreApplicationForClasses", new SPreApplicationForClasses());
		this.objectMap.put("sRealApplicationForClasses", new SRealApplicationForClasses());

		this.objectMap.put("vPersonalInfo", new VPersonalInfo());
		this.objectMap.put("vLogIn", new VLogIn());
		this.objectMap.put("vMajor", new VMajor());
		this.objectMap.put("vLecture", new VLecture());
		this.objectMap.put("vPreApplicationForClasses", new VPreApplicationForClasses());
		this.objectMap.put("vRealApplicationForClasses", new VRealApplicationForClasses());
		
	}
	
	// 클라이언트로 부터 요청 받은 정보를 보내기
	public void process() {
		final int port = 10000;

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			while (true) {
				System.out.println("Skeleton-listening on port " + port);
				Socket clientSocket = serverSocket.accept();
				System.out.println("Skeleton-Client connected: " + clientSocket.getInetAddress());

				Session session = new Session(clientSocket, objectMap, objectInfoList);
				session.start();
				
			}
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	public class Session extends Thread{
		private Socket clientSocket;
		private HashMap<String, Object> objectMap;
		private ArrayList<String> objectInfoList;
		
		public Session(Socket clientSocket, HashMap<String, Object> objectMap, ArrayList<String> objectInfoList) {
			this.clientSocket = clientSocket;
			this.objectMap = objectMap;
			this.objectInfoList = objectInfoList;
		}

		public void run() {
			// Creat a new tread to handle client communication
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

				int repeatCount = Integer.parseInt(reader.readLine());
				for (int i = 0; i < repeatCount; i++) {
					objectInfoList.add(reader.readLine());
//					System.out.println("Skeleton-Received: " + objectInfoList.get(i));
				}

				String objectName = null;
				String methodName = null;
				String args = null;
				Object valueObject = null;
				for (int i = 0; i < objectInfoList.size(); i++) {

					objectName = objectInfoList.get(i++);
					methodName = objectInfoList.get(i++);
					args = objectInfoList.get(i);

					Object object = this.objectMap.get(objectName);

					if (object instanceof IValueObject) {
						object.getClass().getMethod(methodName, String.class).invoke(object, args);
						valueObject = object;
					} else if (object instanceof IService) {
						objectInfoList.clear();
						objectInfoList = (ArrayList<String>) object.getClass().getMethod(methodName, valueObject.getClass()).invoke(object, valueObject);
						break;
					} 
				}

				// 클라이언트로 메시지 전송
				writer.println(objectInfoList.size());
				for (String string : objectInfoList) {
					writer.println(string);
//					System.out.println("Skeleton-Message sent to Client: " + string);
				}
				
				objectInfoList.clear();
				clientSocket.close();
				System.out.println("Skeleton-Client disconnected: " + clientSocket.getInetAddress());
			} catch (IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
