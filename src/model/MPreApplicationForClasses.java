package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VPreApplicationForClasses;

public class MPreApplicationForClasses {

	public Vector<VPreApplicationForClasses> getData(String id) {

		Vector<VPreApplicationForClasses> vPreApplicationForClasses = null;

		try {
			File file = new File("user/temporaryLectureStorage");
			Scanner scanner = new Scanner(file);
			vPreApplicationForClasses = new Vector<VPreApplicationForClasses>();

			while (scanner.hasNext()) {
				if (scanner.next().equals(id)) {
					VPreApplicationForClasses vPreApplicationForClass = new VPreApplicationForClasses();
//					vPreApplicationForClass.setUserId(scanner.next());
					vPreApplicationForClass.setLectureId(scanner.next());
					vPreApplicationForClass.setLecture(scanner.next());
					vPreApplicationForClass.setProfessor(scanner.next());
					vPreApplicationForClass.setCredit(scanner.next());
					vPreApplicationForClass.setTime(scanner.next());

					vPreApplicationForClasses.add(vPreApplicationForClass);
				}
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vPreApplicationForClasses;

	}

	public void store(String id, VLecture vLecture) {

		try {
			File file = new File("user/temporaryLectureStorage");
			
			
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			
			// ID ID 과목명 교수명 학점 시간
			printWriter.print(id);
			printWriter.print(" ");
			printWriter.print(vLecture.getId());
			printWriter.print(" ");
			printWriter.print(vLecture.getLecture());
			printWriter.print(" ");
			printWriter.print(vLecture.getProfessor());
			printWriter.print(" ");
			printWriter.print(vLecture.getCredit());
			printWriter.print(" ");
			printWriter.println(vLecture.getTime());
			// 일렬로 쫙 써서 저장해놓고 가져올때는 아이디 맞는거로 해서 뒤에 저장돼있는 과목들 불러오는거로 하는데 일단 한 줄로 저장하면 그거 하고
			// 한줄 개행

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void store(String id, Vector<String> lectures) {
		try {
			File file = new File("user/temporaryLectureStorage");
			
			Vector<String> fileDataVector = new Vector<String>();
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				fileDataVector.add(scanner.nextLine());
			}

			ArrayList<Integer> removeList = new ArrayList<Integer>();
			for (int i = 0; i < fileDataVector.size(); i++) {
				if (Arrays.asList(fileDataVector.get(i).toString().split(" ")).get(0).equals(id)) {
					removeList.add(i);
				}
			}
			removeList.sort(Collections.reverseOrder());
			for (int i = 0; i < removeList.size(); i++) {
				int index = removeList.get(i);
				fileDataVector.remove(index);
			}

			if (!lectures.isEmpty()) {
				for (String lecture : lectures) {
					String temp = id + " "+ lecture;
					fileDataVector.add(temp);
				}
			}
			
			FileWriter fileWriter = new FileWriter(file);
			fileWriter = new FileWriter(file,true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for(String fileData:fileDataVector) {
				printWriter.println(fileData);
			}

			scanner.close();

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
