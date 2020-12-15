package bq_resume.interface_demo1_read;

import com.sun.istack.internal.NotNull;

//Project: techbow
//Package: bqResume.interFaceDemo1
//ClassName: Person
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 14:56

public class Person {
	
	private final String name;
	private final String id;
	
	public Person(@NotNull final String name, @NotNull final String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	// 为什么加final?
	/* 防止object在函数里面改变了，
	代码如果很短的话，可以直接看，
	代码如果很长的话，就很难检查出来是不是被改变了
	 */
	public String read(final IReadable readable) {
		System.out.println(readable.getContent());
		return readable.getContent();
	}
	
}
