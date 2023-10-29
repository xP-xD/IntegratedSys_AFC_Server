package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VMajor;

public class MMajor {

	public ArrayList<String> getData(String fileName) {

		// 데이터 읽어오기 만들자 ("dataFile" + fileName) 이게 핵심
//		Vector<VMajor> vMajor = null;
		ArrayList<String> vMajorList = null;
		try {
			// fileName == root
			File file = new File("dataFile/" + fileName);
			Scanner scanner = new Scanner(file);

			vMajorList = new ArrayList<String>();
			while (scanner.hasNext()) {
				//ID, Text, FileName
				vMajorList.add(scanner.next());
				vMajorList.add(scanner.next());
				vMajorList.add(scanner.next());
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vMajorList;
	}

}
