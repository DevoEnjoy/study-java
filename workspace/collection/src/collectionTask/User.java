package collectionTask;

import java.util.ArrayList;

//[심화 실습]
//	User 클래스 선언
//	- 이름, 아이디, 비밀번호, 휴대폰번호
//	- private으로 선언
//	- 기본 생성자만 선언
//	- toString() 재정의
public class User{
	
	// 이름
	private String name;

	// 아이디
	private String id;

	// 비밀번호
	private String password;

	// 휴대폰번호
	private String phoneNumber;

	public User() {;}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	// toString() 재정의
	@Override
	public String toString() {
		String result = "이름 :" + getName() + "\n아이디: " + getId() + "\n핸드폰 번호: " + getPhoneNumber();
		return result;
	}

}
