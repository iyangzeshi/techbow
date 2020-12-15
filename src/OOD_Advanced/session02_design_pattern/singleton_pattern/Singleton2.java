package OOD_Advanced.session02_design_pattern.singleton_pattern;

public class Singleton2 {
	
	private static final Singleton2 INSTANCE = new Singleton2();
	
	private Singleton2() {
		// do sth;
	}
	
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
}
