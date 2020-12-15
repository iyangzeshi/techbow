package bq_resume.interface_demo2_bird;

//Project: techbow
//Package: bqResume.interfaceDemo2
//ClassName: Eagle
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:19
public class Eagle extends Bird {
	// String id;
	
	public static final String TAG = Eagle.class.getSimpleName();
	
	public Eagle(String id, int size) {
		super(id, size);
	}
	
	@Override
	public void fly() {
		System.out.printf("%s fly fast%n", TAG);
	}

//	public static void main(String[] args) {
//		Eagle eagle = new Eagle("Eagle", 2);
//		Bird that = (Bird) eagle;
//		System.out.printf("ID: %s%n", that.id);
//		System.out.printf("TAG: %s%n",eagle.TAG);
//	}
}
