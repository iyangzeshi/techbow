package javaOOD_system.java_OOD.problem3_in_memory_file_system;//Project: techbow

//Package: javaOODSystem.javaOOD.in_memory_file_system
//ClassName: File
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-19 星期四 21:41
public class File extends Node {
	private String content;
	private long size;
	
	public File(String name, Node parent) {
		super(name, parent);
	}
	
	public File(String name, Node parent, long size, boolean[] permission) {
		super(name, parent);
		this.size = size;
		super.permission = permission; //protected
	}
	
	public String setContent(String content, long size) {
		this.size = size;
		this.content = content;
		return content;
	}
	
	@Override
	public long getSize() {
		return size;
	}
	
	@Override
	public void setParent(Node parent) {
	}
	
	@Override
	public int countFiles() {
		return 1;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof File)) {
			return false;
		}
		File that = (File) obj;
		return ((File) this).getContent().equals(that.getContent());
	}
}

