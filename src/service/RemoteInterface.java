package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import valueObject.VLecture;
import valueObject.VLogIn;
import valueObject.VMajor;
import valueObject.VPersonalInfo;
import valueObject.VPreApplicationForClasses;
import valueObject.VRealApplicationForClasses;

public interface RemoteInterface extends Remote {

	// public
	public String write(VPersonalInfo vPersonalInfo) throws RemoteException;
	public VPersonalInfo validate(VLogIn vLogIn) throws RemoteException;
	public Vector<VPreApplicationForClasses> getPreApplicationForClassesData(String id) throws RemoteException;
	public Vector<VRealApplicationForClasses> getRealApplicationForClassesData(String id) throws RemoteException;

	public Vector<VMajor> getMajorData(String fileName) throws RemoteException;
	public Vector<VLecture> getLectureData(String fileName) throws RemoteException;
	public void preStore(String id, VLecture vLecture) throws RemoteException;
	public void preStore(String id, Vector<String> lectures) throws RemoteException;
	public void realStore(String id, VLecture vLecture) throws RemoteException;
	public void realStore(String id, Vector<String> lectures) throws RemoteException;

	public DefaultMutableTreeNode getDirectoryTree() throws RemoteException;

}
