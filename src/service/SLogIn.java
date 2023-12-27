package service;

import model.MPersonalInfo;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;

public class SLogIn  {
	
	public SLogIn() {
	}

	public VPersonalInfo validate(VLogIn vLogIn) {

		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		return mPersonalInfo.read(vLogIn.getId());
	}

}
