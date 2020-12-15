package bq_resume.interface_demo1_read;
//Project: techbow
//Package: bq_resume.interface_demo1_read
//ClassName: Tester
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-21 星期六 15:56

/**
 *
 */
final class Tester {
	
	public static void main(String[] args) {
		final Newspaper p1= new Newspaper();
		final Book b1 = new Book();
		final IReadable p2 = new Newspaper();
		final IReadable b2 = new Book();
		final Person person = new Person("Flk", "123");
		System.out.println(person.read(p1));
		System.out.println(person.read(b1));
		System.out.println(person.read(p2));
		System.out.println(person.read(b2));
	}
}
