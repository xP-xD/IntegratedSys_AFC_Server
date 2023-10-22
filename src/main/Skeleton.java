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

import service.SLogIn;
import service.SPersonalInfo;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;



//20231022 skeleton 일반화, 서버와 클라이언트에 뜨는 말들 수정해야함
public class Skeleton {
	
	private ArrayList<String> objectInfoList;// 0.objectName 1.MathodName 2.args~
	private HashMap<String, Object> objectMap;

	public Skeleton() {
		this.objectInfoList = new ArrayList<String>();
		this.objectMap = new HashMap<String, Object>(); 
		
		this.objectMap.put("sPersonalInfo", new SPersonalInfo());
		this.objectMap.put("sLogIn", new SLogIn());
		
		this.objectMap.put("vPersonalInfo", new VPersonalInfo());
		this.objectMap.put("vLogIn", new VLogIn());
	}

	//클라이언트로 부터 요청 받은 정보를 보내기
	public void processForSend() {
		final int port = 10000;

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			while (true) {
				System.out.println("Skeleton-listening on port " + port);
				Socket clientSocket = serverSocket.accept();
				System.out.println("Skeleton-Client connected: " + clientSocket.getInetAddress());

				// Creat a new tread to handle client communication
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

				int repeatCount = Integer.parseInt(reader.readLine());
				for(int i = 0; i< repeatCount; i++) {
					objectInfoList.add(reader.readLine());
					 System.out.println("Skeleton-Received: " + objectInfoList.get(i));
				}
				
				String objectName = null;
				String methodName = null;
				String args = null;
				Object valueObject = null;
				for(int i = 0; i < objectInfoList.size(); i++) {

					objectName = objectInfoList.get(i); i++;
					methodName = objectInfoList.get(i); i++;
					args = objectInfoList.get(i);
					
					Object object = this.objectMap.get(objectName);
					
					if(object instanceof VLogIn) {
						try {
							object.getClass().getMethod(methodName, String.class).invoke(object, args);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						valueObject = object;
					}else if(object instanceof SLogIn) {
						try {
							 objectInfoList.removeAll(objectInfoList);
							 objectInfoList = (ArrayList<String>) object.getClass().getMethod(methodName, valueObject.getClass()).invoke(object, valueObject);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
				// 클라이언트로 메시지 전송
				writer.println(objectInfoList.size());
				for (String string : objectInfoList) {
					writer.println(string);
					System.out.println("Skeleton-Message sent to Client: " + string);
				}
				
				clientSocket.close();
				System.out.println("Skeleton-Client disconnected: " + clientSocket.getInetAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트로부터 받은 정보를 서버에 저장
	public void processForRecive() {
		final int port = 10001;

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			while (true) {
				System.out.println("Skeleton-listening on port " + port);
				Socket clientSocket = serverSocket.accept();
				System.out.println("Skeleton-Client connected: " + clientSocket.getInetAddress());

				// Creat a new tread to handle client communication
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

				int repeatCount = Integer.parseInt(reader.readLine());
				for(int i = 0; i< repeatCount; i++) {
					objectInfoList.add(reader.readLine());
					 System.out.println("Skeleton-Received: " + objectInfoList.get(i));
				}
				
				String objectName = null;
				String methodName = null;
				String args = null;
				Object valueObject = null;
				for(int i = 0; i < objectInfoList.size(); i++) {

					objectName = objectInfoList.get(i); i++;
					methodName = objectInfoList.get(i); i++;
					args = objectInfoList.get(i);
					
					Object object = this.objectMap.get(objectName);
					
					if(object instanceof VPersonalInfo) {
						try {
							object.getClass().getMethod(methodName, String.class).invoke(object, args);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						valueObject = object;
					}else if(object instanceof SPersonalInfo) {
						try {
							object.getClass().getMethod(methodName, valueObject.getClass()).invoke(object, valueObject);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
				clientSocket.close();
				System.out.println("Skeleton-Client disconnected: " + clientSocket.getInetAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
