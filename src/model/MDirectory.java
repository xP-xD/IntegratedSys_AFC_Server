package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import valueObject.VPreApplicationForClasses;
import valueObject.VRealApplicationForClasses;

public class MDirectory {

	private File rootDirectory;
	
	public MDirectory() {
		rootDirectory = new File("dataFileForSwing/root");
	}

	public DefaultMutableTreeNode getDirectoryTree() {
		return this.createDirectoryTree(rootDirectory);
	}
	
	private DefaultMutableTreeNode createDirectoryTree(File dir) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					node.add(createDirectoryTree(file));
				}
			}
		}
		return node;
	}
	
}
