package bq_resume.interface_demo1_read;

//Project: techbow
//Package: bqResume.interFaceDemo1
//ClassName: Novel
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:11
public class Novel implements IReadable{
	
	@Override
	public String getContent() {
		return "This is a novel";
	}
}
