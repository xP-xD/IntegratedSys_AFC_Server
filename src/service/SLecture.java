package service;

import java.util.Vector;

import model.MLecture;
import valueObject.VLecture;

public class SLecture  {

	public Vector<VLecture> getData(String fileName) {
		
		MLecture mLecture = new MLecture();
		return mLecture.getData(fileName);
		
	}
	
}
