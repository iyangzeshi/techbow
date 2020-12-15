package OOD_Advanced.session03_OODquestions.hashmap;

import java.util.Date;

//Project: techbow
//Package: OOD_Advanced.session03_OODquestions.hashmap
//ClassName: Student
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 12:03
public class Student {
	
	String id;
	String name;
	Date birthday;
	Gender gender;
	
	@Override
	public int hashCode() {
		int sum = 0;
		int k = 0;
		for (char ch : id.toCharArray()) {
			sum += (int) ch * Math.pow(31, k++);
		}
		return sum;
	}
	
	@Override
	public boolean equals(Object o) { // equals继承自父类Object，要和父类的object保持一致
		// the result of the instanceof operator is true
		//  if the value of the RelationalExpression is not null and
		//  the reference could be cast to the ReferenceType without raising a ClassCastException.
		// Otherwise the result is false.
		if (this == o) { // 如果两者都是null或者地址相同
			return true;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student that = (Student) o; // O 有可能为null，所以下面要判断 that == null
		return that.getId().equals(this.getId());
	}
	
	private String getId() {
		return id;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Student ID: " + this.id + " Student Name: " + this.name;
	}
}
