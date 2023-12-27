package service;

import java.util.Vector;

import model.MPreApplicationForClasses;
import valueObject.VLecture;
import valueObject.VPreApplicationForClasses;

public class SPreApplicationForClasses {

	public SPreApplicationForClasses() {
	}

	public Vector<VPreApplicationForClasses> getData(String id) {

		MPreApplicationForClasses mPreApplicationForClasses = new MPreApplicationForClasses();
		return mPreApplicationForClasses.getData(id);
	}

	public void store(String id, VLecture vLecture) {

		MPreApplicationForClasses mPreApplicationForClasses = new MPreApplicationForClasses();
		mPreApplicationForClasses.store(id, vLecture);

	}

	public void store(String id, Vector<String> lectures) {
		MPreApplicationForClasses mPreApplicationForClasses = new MPreApplicationForClasses();
		mPreApplicationForClasses.store(id, lectures);
		
	}

}
