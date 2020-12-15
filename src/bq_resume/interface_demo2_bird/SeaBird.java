package bq_resume.interface_demo2_bird;

//Project: techbow
//Package: bqResume.interfaceDemo2
//ClassName: SeaBird
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:19
public class SeaBird extends Bird implements Swimmable, IJumpable {
	public static final String TAG = SeaBird.class.getSimpleName();
	
	public SeaBird(String id, int size) {
		super(id, size);
	}
	
	@Override
	public void fly() {
		System.out.printf("%s can fly above sea.%n", TAG);
	}
	
	@Override
	public void swim() {
		System.out.printf("%s can swim to catch fish%n", TAG);
	}
	
	@Override
	public void jump() {
		System.out.printf("%s can jump%n", TAG);
	}
}
