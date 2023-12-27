package service;
import java.rmi.RemoteException;

import model.MPersonalInfo;
import valueObject.VPersonalInfo;

public class SPersonalInfo {
	
	public SPersonalInfo() throws RemoteException {
		super();
	}

	public String write(VPersonalInfo vPersonalInfo) {
		MPersonalInfo mPersonalInfo = new MPersonalInfo();
		return mPersonalInfo.write(vPersonalInfo);
	}
}
