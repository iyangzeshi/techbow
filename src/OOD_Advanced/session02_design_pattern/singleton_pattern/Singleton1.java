package OOD_Advanced.session02_design_pattern.singleton_pattern;

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
