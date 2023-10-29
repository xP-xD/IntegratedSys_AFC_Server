package service;

import java.util.ArrayList;

import model.MLecture;
import valueObject.VLecture;

public class SLecture implements IService {

	public ArrayList<String> getData(VLecture vLecture) {
		
		MLecture mLecture = new MLecture();
		return mLecture.getData(vLecture.getFileName());
		
	}
	
}
