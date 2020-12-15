package javaOOD_system.basic.singleton_implementation;

//Project: techbow
//Package: javaOODSystem.basic.singleton_implementation
//ClassName: SIngleton1
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:53

public class Singleton1 {
	
	private static Singleton1 instance;
	
	private Singleton1() {
		// this.instance = null;
		// do sth
	}
	
	public static synchronized Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
