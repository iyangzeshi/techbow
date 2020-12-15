package bq_resume.interface_demo1_read;

//Project: techbow
//Package: bqResume.interFaceDemo1
//ClassName: Book
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 14:59
public class Book implements IReadable {

	@Override
	public String getContent() {
		return "This is a book";
	}
}
