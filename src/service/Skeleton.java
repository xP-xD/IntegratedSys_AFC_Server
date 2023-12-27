package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import valueObject.VLecture;
import valueObject.VLogIn;
import valueObject.VMajor;
import valueObject.VPersonalInfo;
import valueObject.VPreApplicationForClasses;
import valueObject.VRealApplicationForClasses;

public class Skeleton extends UnicastRemoteObject implements RemoteInterface {

	private static final long serialVersionUID = 1L;

	//public
	private SPersonalInfo sPersonalInfo;
	private SLogIn sLogIn;
	
	//console
	private SMajor sMajor;
	private SLecture sLecture;
	private SPreApplicationForClasses sPreApplicationForClasses;
	private SRealApplicationForClasses sRealApplicationForClasses;
	
	//swing
	private SDirectory sDirectory;

	public Skeleton() throws RemoteException {
		super();
		sPersonalInfo = new SPersonalInfo();
		sLogIn = new SLogIn();
		
		sMajor = new SMajor();
		sLecture = new SLecture();
		sPreApplicationForClasses = new SPreApplicationForClasses();
		sRealApplicationForClasses = new SRealApplicationForClasses();
		
		sDirectory = new SDirectory();
	}
	
	@Override
	public String write(VPersonalInfo vPersonalInfo) throws RemoteException {
		return sPersonalInfo.write(vPersonalInfo);
	}
	@Override
	public VPersonalInfo validate(VLogIn vLogIn) throws RemoteException {
		// TODO Auto-generated method stub
		return sLogIn.validate(vLogIn);
	}

	
	
	@Override
	public Vector<VMajor> getMajorData(String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		return sMajor.getData(fileName);
	}

	@Override
	public Vector<VLecture> getLectureData(String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		return sLecture.getData(fileName);
	}

	@Override
	public void preStore(String id, VLecture vLecture) throws RemoteException {
		// TODO Auto-generated method stub
		sPreApplicationForClasses.store(id, vLecture);
	}
	
	@Override
	public void preStore(String id, Vector<String> lectures) throws RemoteException {
		sPreApplicationForClasses.store(id, lectures);
		
	}


	@Override
	public Vector<VPreApplicationForClasses> getPreApplicationForClassesData(String id) throws RemoteException {
		return sPreApplicationForClasses.getData(id);
	}

	@Override
	public void realStore(String id, VLecture vLecture) throws RemoteException {
		sRealApplicationForClasses.store(id, vLecture);
	}
	
	@Override
	public void realStore(String id, Vector<String> lectures) throws RemoteException {
		sRealApplicationForClasses.store(id, lectures);
	}

	@Override
	public Vector<VRealApplicationForClasses> getRealApplicationForClassesData(String id) throws RemoteException {
		return sRealApplicationForClasses.getData(id);
	}

	
	
	@Override
	public DefaultMutableTreeNode getDirectoryTree() throws RemoteException {
		return sDirectory.getDirectoryTree();
	}




}
