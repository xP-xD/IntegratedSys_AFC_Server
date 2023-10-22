package service;

import java.util.ArrayList;

import model.MPersonalInfo;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn {

	private ArrayList<String> sendList;
	
	public SLogIn() {
		sendList = new ArrayList<String>();
	}

	public void saveVPersonalInfo(VPersonalInfo vPersonalInfo) {
		sendList.add("vPersonalInfo");
		sendList.add("setId");
		sendList.add(vPersonalInfo.getId());
		
		sendList.add("vPersonalInfo");
		sendList.add("setPassword");
		sendList.add(vPersonalInfo.getPassword());
		
		sendList.add("vPersonalInfo");
		sendList.add("setName");
		sendList.add(vPersonalInfo.getName());
	}

	public ArrayList<String> validate(VLogIn vLogIn) {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vLogIn.getId());

		if (vPersonalInfo == null) {
			System.out.println("회원 정보가 존재하지 않습니다.");
			return null;
		} else if (vLogIn.getPassword().equals(vPersonalInfo.getPassword())) {
			this.saveVPersonalInfo(vPersonalInfo);
			return sendList;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
			return null;
		}
	}

}
