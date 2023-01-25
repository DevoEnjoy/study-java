package domain;

public class UserVO {
//	   USER_ID NUMBER CONSTRAINT PK_USER PRIMARY KEY,
//	   USER_IDENTIFICATION VARCHAR2(500) UNIQUE NOT NULL,
//	   USER_NAME VARCHAR2(500) NOT NULL,
//	   USER_PASSWORD VARCHAR2(500) NOT NULL,
//	   USER_PHONE VARCHAR2(100) NOT NULL,
//	   USER_NICKNAME VARCHAR2(500),
//	   USER_EMAIL VARCHAR2(100) CONSTRAINT UK_USER UNIQUE NOT NULL,
//	   USER_ADDRESS VARCHAR2(500),
//	   USER_BIRTH DATE,
//	   USER_GENDER CHAR(1) DEFAULT 'N' CHECK(USER_GENDER IN('M', 'W', 'N')),
//	   USER_RECOMMENDER_ID VARCHAR2(500)
	private Long userId;
	private String userIdentification;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userNickName;
	private String userEmail;
	private String userAddress;
	private String userBirth;
	private String userGender;
	private String userRecommenderId;
	
	public UserVO() {;}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserRecommenderId() {
		return userRecommenderId;
	}

	public void setUserRecommenderId(String userRecommenderId) {
		this.userRecommenderId = userRecommenderId;
	}
	
	
}
