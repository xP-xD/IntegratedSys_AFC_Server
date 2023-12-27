package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import valueObject.VPersonalInfo;

public class MPersonalInfo {

	public MPersonalInfo() {
		// TODO Auto-generated constructor stub
	}

	public String write(VPersonalInfo vPersonalInfo) {
		try {

			File file = new File("user/userData");
			Scanner scanner = new Scanner(file);

			VPersonalInfo validateRepetition = new VPersonalInfo();
			validateRepetition.setId(vPersonalInfo.getId());

			String readLine = null;
			int nameCount = 0;
			Path path = Paths.get("user/userData");
			List<String> allLines;
			allLines = Files.readAllLines(path);
			while (!vPersonalInfo.getId().equals(readLine) && allLines.size() > nameCount) {
				readLine = allLines.get(nameCount);

				validateRepetition.setId(scanner.next());
				validateRepetition.setPassword(scanner.next());
				validateRepetition.setName(scanner.next());

				nameCount += 3;
			}
			scanner.close();

			if (!vPersonalInfo.getId().equals(readLine)) {

				FileWriter fileWriter;
				fileWriter = new FileWriter(file,true);
				PrintWriter printWriter = new PrintWriter(fileWriter);

				printWriter.println(vPersonalInfo.getId());
				printWriter.println(vPersonalInfo.getPassword());
				printWriter.println(vPersonalInfo.getName());

				fileWriter.close();
				
				return "회원 가입이 완료 되었습니다. 감사합니다.";
			} 
			// fileWriter로 개행해주는 명령어를 입력해서 하는 방법도 있음
//			fileWriter.write(vPersonalInfo.getId()+"\r\n");
//			fileWriter.write(vPersonalInfo.getPassword()+"\r\n");
//			fileWriter.write(vPersonalInfo.getName()+"\r\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "아이디가 중복됩니다. 다른 아이디를 사용해주세요.";
	}

	public VPersonalInfo read(String id) {
		try {
			File file = new File("user/userData");
			Scanner scanner = new Scanner(file);

			VPersonalInfo vPersonalInfo = new VPersonalInfo();

			try {
				String readLine = null;
				int nameCount = 0;
				Path path = Paths.get("user/userData");
				List<String> allLines;
				allLines = Files.readAllLines(path);

				while (!id.equals(readLine) && allLines.size() > nameCount) {

					readLine = allLines.get(nameCount);

					vPersonalInfo.setId(scanner.next());
					vPersonalInfo.setPassword(scanner.next());
					vPersonalInfo.setName(scanner.next());

					nameCount += 3;

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			scanner.close();

			if (vPersonalInfo.getId().equals(id)) {

				return vPersonalInfo;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
