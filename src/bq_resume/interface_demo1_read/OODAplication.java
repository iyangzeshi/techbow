package bq_resume.interface_demo1_read;

//Project: techbow
//Package: bqResume.OodAplication
//ClassName: OODAplication
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:13

public class OODAplication {
	
	public static void main(String[] args) {
		final Person person = new Person("Frank", "1");
		final Book book = new Book();
		final Newspaper newspaper = new Newspaper();
		final Magzine magzine = new Magzine();
		final Novel novel = new Novel();
		
		person.read(book);
		person.read(newspaper);
		person.read(magzine);
		person.read(novel);
	}
}