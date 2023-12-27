package service;

import java.util.Vector;

import model.MMajor;
import valueObject.VMajor;

public class SMajor {
public Vector<VMajor> getData(String fileName) {
		
		MMajor mMajor = new MMajor();
		return mMajor.getData(fileName);
		
	}

}
