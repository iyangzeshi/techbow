package OOD_Advanced.session02_design_pattern.builder_pattern;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern
//ClassName: User
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 19:15

/*class User {
	private String username; // required
	private String password; // required
	private final String firstname;
	private final String lastname;
	private String phone;
	private String address;
	private String email;

	// overloading
	public User(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	//

	public User(String username, String password, String firstname, String lastname,
			String phone, String address, String email) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
}*/
// 这个方法不好，因为如果要初始化某种

import java.util.Date;

public final class User { // --> immutable class
	
	private final String username; // required
	private final String password; // required
	private final String firstName;
	private final String lastName;
	private final String nickName; // optional
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional
	private final String email; // optional
	private final Date birthday; // optional
	
	// 2^6 = 64 个 constructor --> constructor 太多
	// public User(Sting userName, String pwd) {}
	// public void setAge(int age) {}
	// public void setAddress(String address) {}
	// immutable class不能有setter(),比如filterParam
	// setter()的解决方案局限性很强
	
	private User(UserBuilder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.nickName = builder.nickName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
		this.email = builder.email;
		this.birthday = builder.birthday;
	}
	
	public String toString() {
		/*return username + ", " + password + ", " + firstName + ", " + lastName + ", " + phone +
				", " + address + ", " + email;*/
		return String.format("%s, %s, %s, %s, %s, %s, %s", username, password, firstName,
				lastName, phone, address, email);
	}
	
	public static class UserBuilder { // inner class，离开User，UserBuilder将毫无意义
		
		private String username; // required
		private String password; // required
		private String firstName;
		private String lastName;
		private String nickName; // optional
		private int age; // optional
		private String phone; // optional
		private String address; // optional
		private String email; // optional
		private Date birthday; // optional
		
		public UserBuilder(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		public UserBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public UserBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public UserBuilder setNickName(String nickName) {
			this.nickName = nickName;
			return this;
		}
		
		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserBuilder setBirthday(Date date) {
			this.birthday = date;
			return this;
		}
		
		public UserBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}

// 	void main() {
// 		// create
// 		User user = new User.UserBuilder("snake", "123").setEmail("snakesp24@gmail.com")
// 				.setPhone("bu gao su").build();
// // builder的中间状态无所谓，最终效果是UserBuilder一旦build，build出的结果一定不会被改变
// 		public UserBuilder toBuilder () {
// 			return new UserBuilder(this.userName, this.pwd).set()...setAddress(this.address);
// 		}
// 		// update
// 		User user1 = user.toBuilder().setPhone("123-234-6789").build();
// 	} // 一般只有inner class是static
	
	public static void main(String[] args) {
		// create
		User user = new User.UserBuilder("snake", "123").
				setEmail("snakesp24@gmail.com").setPhone("bu gao su").build();
		// builder的中间状态无所谓，最终效果是UserBuilder一旦build，build出的结果一定不会被改变
		// update
		System.out.println(user);
	}
}

