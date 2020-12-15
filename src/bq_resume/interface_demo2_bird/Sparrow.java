package bq_resume.interface_demo2_bird;

//Project: techbow
//Package: bqResume.interfaceDemo2
//ClassName: Sparrow
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:19
public class Sparrow extends Bird {
	public static final String TAG = Sparrow.class.getSimpleName();
	
	public Sparrow(String id, int size) {
		super(id, size);
	}
	
	@Override
	public void fly() {
		System.out.printf("%s fly slow%n", TAG);
	}
}
