package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VMajor;

public class MMajor {

	public Vector<VMajor> getData(String fileName) {

		// 데이터 읽어오기 만들자 ("dataFile" + fileName) 이게 핵심

		Vector<VMajor> vMajor = null;
		try {
			// fileName == root
			File file = new File("dataFileForConsole/" + fileName);
			Scanner scanner = new Scanner(file);

			vMajor = new Vector<VMajor>();
			while (scanner.hasNext()) {
				VMajor vMajorData = new VMajor();

				// split 쪼개서 저장해서 순서대로 저기에 박으면 되겠다 그럴필요없네??

				vMajorData.setId(scanner.next());
				vMajorData.setText(scanner.next());
				vMajorData.setFileName(scanner.next());

				vMajor.add(vMajorData);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vMajor;
	}

}
