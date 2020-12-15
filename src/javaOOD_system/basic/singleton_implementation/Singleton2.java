package javaOOD_system.basic.singleton_implementation;

//Project: techbow
//Package: javaOODSystem.basic.singleton_implementation
//ClassName: Singleton2
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 20:53

public class Singleton2 {
	
	private static final Singleton2 INSTANCE = new Singleton2();
	
	private Singleton2() {
		// do sth;
	}
	
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
}
