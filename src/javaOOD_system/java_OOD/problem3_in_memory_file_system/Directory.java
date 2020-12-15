package javaOOD_system.java_OOD.problem3_in_memory_file_system;//Project: techbow

import java.util.ArrayList;
import java.util.List;

//Package: javaOODSystem.javaOOD.in_memory_file_system
//ClassName: Directory
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-19 星期四 21:41
public class Directory extends Node {
	private List<Node> children;
	
	public Directory(String n, Node parent, boolean[] pm) {
		super(n, parent);
		permission = pm; //protected
		children = new ArrayList<>();
		if (parent == null) {
			setParent(this);
		}
	}
	
	@Override
	public long getSize() { // 必须实现
		long size = 0;
		for (Node n : children) {
			size += n.getSize(); // recursion return case1 leaf file case2 leaf empty
		}
		return size;
	}
	
	public void addNode(Node node) {
		children.add(node);
	}
	public void deleteNode(Node node) {
		children.remove(node);
	}
	
	public int countFiles() {
		int count = 0;
		for (Node child : children) {
			if (child instanceof Directory) {
				Directory d = (Directory) child;
				count += d.countFiles();
			} else {
				count++;
			}
		}
		return count;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public List<Node> getChildren() {
		return children;
	}
}

