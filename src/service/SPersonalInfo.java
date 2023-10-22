package service;
import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SPersonalInfo {

	public void SPersonalInfo() {
	}

	public void write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		mPersonalInfo.write(vPersonalInfo);
	}
}
