package javaOOD_system.java_OOD.problem3_in_memory_file_system;//Project: techbow

import java.util.Date;

//Package: javaOODSystem.javaOOD.in_memory_file_system
//ClassName: Node
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-19 星期四 21:25
abstract class Node {
	protected String name;
	protected boolean[] permission;
	protected Node parent;
	protected final Date created;
	protected Date modified;
	
	protected Node(String name, Node parent) {
		this.name = name;
		this.parent = parent;
		created = new Date();;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Date getModified() {
		return modified;
	}
	
	public Date setModified(Date time) {
		modified = time;
		return modified;
	}
	
	public void reName(String n) {
		name = n;
	}
	
	/*public*/
	
	public String getCurrentPath() {
		if (parent == this /*null*/) {
			return "";
		}
		return parent.getCurrentPath() + "/" + name;
	}
	
	public abstract void setParent(Node parent);
	
	public abstract int countFiles();
	
	protected abstract long getSize(); //所有derived class必须实现，并且实现不一样
	
}

