package bq_resume.interface_demo2_bird;

//Project: techbow
//Package: bqResume.interfaceDemo2
//ClassName: Bird
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:19
public abstract class Bird {
	final String id;
	final int size;
	
	public Bird(String id, int size) {
		this.id = id;
		this.size = size;
	}
	public abstract void fly();
}
