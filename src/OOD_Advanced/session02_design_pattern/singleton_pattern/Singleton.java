package OOD_Advanced.session02_design_pattern.singleton_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.singletonPattern
//ClassName: singleton
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 19:54

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton() {
		// do sth
	}
	
	public static Singleton getInstance() {
		if (instance == null) { // 第1个check null: performance-purpose (提高performance)
			synchronized(Singleton.class) {
				if (instance == null) { // thread safe purpose (保证线程安全)
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}



