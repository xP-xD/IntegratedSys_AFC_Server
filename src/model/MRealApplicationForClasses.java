package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import valueObject.VRealApplicationForClasses;

public class MRealApplicationForClasses {

	public ArrayList<String> getData(String id) {

		ArrayList<String> vRealApplicationForClassesList = null;

		try {
			File file = new File("dataFile/realStore");
			Scanner scanner = new Scanner(file);
			vRealApplicationForClassesList = new ArrayList<String>();

			while (scanner.hasNext()) {

				if (scanner.next().equals(id)) {
					
//					vRealApplicationForClassesList.add(scanner.next());
					vRealApplicationForClassesList.add(scanner.next());
					vRealApplicationForClassesList.add(scanner.next());
					vRealApplicationForClassesList.add(scanner.next());
					vRealApplicationForClassesList.add(scanner.next());
					vRealApplicationForClassesList.add(scanner.next());
				}
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return vRealApplicationForClassesList;

	}

	public String store(VRealApplicationForClasses vRealApplicationForClasses) {

		try {
			File file = new File("dataFile/realStore");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			// ID ID 과목명 교수명 학점 시간
			printWriter.print(vRealApplicationForClasses.getUserId());
			printWriter.print(" ");
			printWriter.print(vRealApplicationForClasses.getLectureId());
			printWriter.print(" ");
			printWriter.print(vRealApplicationForClasses.getLecture());
			printWriter.print(" ");
			printWriter.print(vRealApplicationForClasses.getProfessor());
			printWriter.print(" ");
			printWriter.print(vRealApplicationForClasses.getCredit());
			printWriter.print(" ");
			printWriter.println(vRealApplicationForClasses.getTime());
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
