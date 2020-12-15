package bq_resume.interface_demo2_bird;

//Project: techbow
//Package: bqResume.interfaceDemo2
//ClassName: Human
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:19
public class Human implements Swimmable{
	public static final String TAG = Human.class.getSimpleName();
	
	@Override
	public void swim() {
		System.out.printf("%s can swim.%n", TAG);
	}
}
