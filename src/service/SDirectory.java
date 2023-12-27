package service;
import javax.swing.tree.DefaultMutableTreeNode;

import model.MDirectory;

public class SDirectory {
	
	private MDirectory mDirectory;
	
	public SDirectory() {
		mDirectory = new MDirectory();
	}

	public DefaultMutableTreeNode getDirectoryTree() {
		return mDirectory.getDirectoryTree();
	}


}
