package service;

import java.util.ArrayList;

import model.MRealApplicationForClasses;
import valueObject.VRealApplicationForClasses;

public class SRealApplicationForClasses implements IService {
	
	ArrayList<String> sendList;

	public SRealApplicationForClasses() {
		sendList = new ArrayList<String>();
	}

	public ArrayList<String> getData(VRealApplicationForClasses vRealApplicationForClasses) {
		sendList.clear();
		MRealApplicationForClasses mRealApplicationForClasses = new MRealApplicationForClasses();
		return mRealApplicationForClasses.getData(vRealApplicationForClasses.getUserId());
	}

	public ArrayList<String> store(VRealApplicationForClasses vRealApplicationForClasses) {
		sendList.clear();
		MRealApplicationForClasses mRealApplicationForClasses = new MRealApplicationForClasses();
		sendList.add(mRealApplicationForClasses.store(vRealApplicationForClasses));
		return sendList;
		
	}

}
