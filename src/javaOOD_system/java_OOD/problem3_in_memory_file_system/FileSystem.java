package javaOOD_system.java_OOD.problem3_in_memory_file_system;//Project: techbow

//Package: javaOODSystem.javaOOD.in_memory_file_system
//ClassName: FileSystem
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-19 星期四 21:43
public abstract class FileSystem {
	// fields
	Node root;
	
	// methods
	public FileSystem() {
		root = new Directory("anyName", null, new boolean[]{true, true, true});
		// root.setParent(root); 在
	}
	
	public Directory mkDir(String path) {
		if (path == null || path.length() == 0) {
			return null;
		}
		String[] dirs = path.split("/");
		Directory cur = (Directory) root;
		goDir:
		for (String dir : dirs) {
			// reset
			for (Node child : cur.getChildren()) {
				if (child.name.equals(dir)) {
					cur = (Directory) child;
					break goDir; // must break after chagne cur otherwise, iterator
				}
			} // else
			Directory newDir = new Directory(dir, null, new boolean[] {true, true, true});
			cur.getChildren().add(newDir);
			cur = newDir;
		}
		// put the Directory in this path, if this path not exists, create it.
		return cur;
	}
	
	public boolean createFile(String path, File file) {
		Directory cur = mkDir(path);
		if (cur.getChildren().contains(file)) {
			return false;
		}
		cur.getChildren().add(file);
		return true;
	}
	
	public boolean cd(String path, File file) {
		Directory cur = mkDir(path);
		if (cur.getChildren().contains(file)) {
			return false;
		}
		cur.getChildren().add(file);
		file.setParent(cur);
		return true;
	}
	
	public boolean delete(String path) {
		if (path == null || path.length() == 0) {
			return false;
		}
		String[] dirs = path.split("/");
		Directory cur = (Directory) root;
		goDir:
		for (int i = 0; i < dirs.length; i++) {
			String dir = dirs[i];
			if (i == dirs.length - 1) {
				for (Node child : cur.getChildren()) {
					if (child.name.equals(dir)) {
						cur.deleteNode(child);
						child.setParent(null);
						return true;
					}
				}
			}
			for (Node child : cur.getChildren()) {
				if (child.name.equals(dir)) {
					cur = (Directory) child;
					/*
					must break after change Directory cur,
					otherwise continue iterator
					 */
					break goDir;
				}
			}
			// if can not find directory in this path, the path does not exist, return false
			return false;
		}
		// put the Directory in this path, if this path not exists, create it.
		return false;
	}
	
	public int countFiles() {
		return root.countFiles();
	}
	
	public long getSize() {
		return root.getSize();
	}
	
	public static void main(String[] args) {
		return;
	}
}

