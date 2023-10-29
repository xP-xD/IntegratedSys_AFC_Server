package service;

import java.util.ArrayList;

import model.MMajor;
import valueObject.VMajor;

public class SMajor implements IService{
public ArrayList<String> getData(VMajor vMajor) {
		
		MMajor mMajor = new MMajor();
		return mMajor.getData(vMajor.getFileName());
		
	}

}
