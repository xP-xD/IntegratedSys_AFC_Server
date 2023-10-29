package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MLecture {

	public ArrayList<String> getData(String fileName) {

		ArrayList<String> vLectureList = null;
		File file = new File("dataFile/" + fileName);
		Scanner scanner;

		try {
			scanner = new Scanner(file);
			vLectureList = new ArrayList<String>();

			while (scanner.hasNext()) {
				vLectureList.add(scanner.next());
				vLectureList.add(scanner.next());
				vLectureList.add(scanner.next());
				vLectureList.add(scanner.next());
				vLectureList.add(scanner.next());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vLectureList;

	}

}
