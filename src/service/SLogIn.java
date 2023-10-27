package service;

import java.util.ArrayList;

import model.MPersonalInfo;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn implements IService {

	private ArrayList<String> sendList;
	
	public SLogIn() {
		sendList = new ArrayList<String>();
	}

	public void saveVPersonalInfo(VPersonalInfo vPersonalInfo) {
		sendList.add(vPersonalInfo.getId());
		sendList.add(vPersonalInfo.getPassword());
		sendList.add(vPersonalInfo.getName());
	}

	public ArrayList<String> validate(VLogIn vLogIn) {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vLogIn.getId());

		if (vPersonalInfo == null) {
			sendList.add("회원 정보가 존재하지 않습니다.");
			return sendList;
		} else if (vLogIn.getPassword().equals(vPersonalInfo.getPassword())) {
			this.saveVPersonalInfo(vPersonalInfo);
			return sendList;
		} else {
			sendList.add("비밀번호가 틀렸습니다.");
			return sendList;
		}
	}

}
