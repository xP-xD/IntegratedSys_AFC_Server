package service;

import java.util.ArrayList;

import model.MPreApplicationForClasses;
import valueObject.VPreApplicationForClasses;

public class SPreApplicationForClasses implements IService {
	
	ArrayList<String> sendList;

	public SPreApplicationForClasses() {
		sendList = new ArrayList<String>();
	}

	public ArrayList<String> getData(VPreApplicationForClasses vPreApplicationForClasses) {
		sendList.clear();
		MPreApplicationForClasses mPreApplicationForClasses = new MPreApplicationForClasses();
		return mPreApplicationForClasses.getData(vPreApplicationForClasses.getUserId());
	}

	public ArrayList<String> store(VPreApplicationForClasses vPreApplicationForClasses) {
		sendList.clear();
		MPreApplicationForClasses mPreApplicationForClasses = new MPreApplicationForClasses();
		sendList.add(mPreApplicationForClasses.store(vPreApplicationForClasses));
		return sendList;
		
	}

}
