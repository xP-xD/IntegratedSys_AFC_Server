package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import valueObject.VPreApplicationForClasses;

public class MPreApplicationForClasses {

	public ArrayList<String> getData(String id) {

		ArrayList<String> vPreApplicationForClassesList = null;

		try {
			File file = new File("dataFile/preStore");
			Scanner scanner = new Scanner(file);
			vPreApplicationForClassesList = new ArrayList<String>();

			while (scanner.hasNext()) {

				if (scanner.next().equals(id)) {
					
//					vPreApplicationForClassesList.add(scanner.next());
					vPreApplicationForClassesList.add(scanner.next());
					vPreApplicationForClassesList.add(scanner.next());
					vPreApplicationForClassesList.add(scanner.next());
					vPreApplicationForClassesList.add(scanner.next());
					vPreApplicationForClassesList.add(scanner.next());
				}
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return vPreApplicationForClassesList;

	}

	public String store(VPreApplicationForClasses vPreApplicationForClasses) {

		try {
			File file = new File("dataFile/preStore");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			// ID ID 과목명 교수명 학점 시간
			printWriter.print(vPreApplicationForClasses.getUserId());
			printWriter.print(" ");
			printWriter.print(vPreApplicationForClasses.getLectureId());
			printWriter.print(" ");
			printWriter.print(vPreApplicationForClasses.getLecture());
			printWriter.print(" ");
			printWriter.print(vPreApplicationForClasses.getProfessor());
			printWriter.print(" ");
			printWriter.print(vPreApplicationForClasses.getCredit());
			printWriter.print(" ");
			printWriter.println(vPreApplicationForClasses.getTime());
			// 일렬로 쫙 써서 저장해놓고 가져올때는 아이디 맞는거로 해서 뒤에 저장돼있는 과목들 불러오는거로 하는데 일단 한 줄로 저장하면 그거 하고
			// 한줄 개행

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "미리담기가 완료 되었습니다.";
	}

}
