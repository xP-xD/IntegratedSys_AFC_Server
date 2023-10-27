package service;
import java.util.ArrayList;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SPersonalInfo implements IService {
	
	ArrayList<String> sendList;

	public SPersonalInfo() {
		sendList = new ArrayList<String>();
	}

	public ArrayList<String> write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		sendList.add(mPersonalInfo.write(vPersonalInfo));
		return sendList;
	}
}
