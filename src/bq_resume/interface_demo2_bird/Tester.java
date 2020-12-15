package bq_resume.interface_demo2_bird;
//Project: techbow
//Package: bq_resume.interface_demo2_bird
//ClassName: Tester
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-21 星期六 16:02

/**
 *
 */
public class Tester {
	
	public static void main(String[] args) {
		final Eagle eagle = new Eagle("bird-1", 45);
		final Sparrow sparrow = new Sparrow("bird-2", 1);
		final SeaBird seaBird = new SeaBird("bird-3", 20);
		final Human human = new Human();
		eagle.fly();
		sparrow.fly();
		seaBird.fly();
		seaBird.swim();
		human.swim();
	}
}
