package collectionTask;
//[심화 실습]

//	UserField 클래스 선언
//	- 회원 정보를 담을 DB를 ArrayList로 선언
//	- 아이디 중복검사
//	- 회원가입
//	- 로그인
//	- 암호화
//	- 비밀번호 변경(비밀번호 찾기 서비스)
//	- 인증번호 전송

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
	// 회원 정보를 담을 DB를 ArrayList로 선언
	public static ArrayList<User> users = DBConnector.users;
	final private static int KEY = ' ';
	final int LENGTH = 6;
	public UserField() {;}

	// 아이디 중복검사
	public static User checkExistId(String id) {

		// 중복되는 값이 없을 경우 null값 return
		User arResult = null, arTemp = null;
		
		// 화면에서 하는 것
//		if (users == null) {return null;}
		
		// DB조회하여 일치하는 ID 찾는 for문
		for (int i = 0; i < users.size(); i++) {
			arTemp = users.get(i);
			// 만약 i번째 회원번호의 id(get(ID))랑 입력한 id가 같으면
			if (arTemp.getId().equals(id)) {
				arResult = arTemp;
				break;
			}
		}
		return arResult;
	}

	// 회원가입
	public static User register(User userInfo) {
		userInfo.setPassword(encrypt(userInfo.getPassword()));
		users.add(userInfo);
		return userInfo;
	}

	// 로그인
	public static User login(User memberInfo) {
		// User or null
		User checked = checkExistId(memberInfo.getId());
		boolean result = false;
		String encryptedPassword = encrypt(memberInfo.getPassword());
//		memberInfo.setPassword(encryptedPassword);
		result = checked != null && checked.getPassword().equals(encryptedPassword);
		
		return result ? memberInfo : null;
		
		// 기존 코드
//		if (result) {
//			m.setPassword(inputEncryptedPassword);
//		} else {
//			m = null;
//		}
//		return m;
	}

	// 암호화
	private static String encrypt(String password) {

		String result = "", temp = "";
		temp = password.replaceAll(" ", " ");
		for (int i = 0; i < temp.length(); i++) {
			result += (char) (temp.charAt(i) + KEY);
		}
//		System.out.println("기존 비밀번호: " + temp);
//		System.out.println("암호화 비밀번호: " + result);
		return result;
	}

	// 복호화(확인용 코드)
//	public static String dencrypt(String password) {
//
//		String result = "", temp = "";
//		temp = password.replaceAll(" ", " ");
//		for (int i = 0; i < temp.length(); i++) {
//			result += (char) (temp.charAt(i) - getKEY());
//		}
////		System.out.println("기존 비밀번호: " + temp);
////		System.out.println("암호화 비밀번호: " + result);
//		return result;
//	}
	
	// 비밀번호 변경
	private void changePassword(User userInfo) {
		
		// 강사님 코드
		User userInDataBase = checkExistId(userInfo.getId());
		userInDataBase.setPassword(encrypt(userInfo.getPassword()));
		
//		User result = null;
//		for (int i = 0; i < users.size(); i++) {
//			result = users.get(i);
//			if (checkExistId(userInfo.getId()) != null && result.getPhoneNumber().equals(userInfo.getPhoneNumber())) {
//				result.setPassword(userInfo.getPassword());
//				break;
//			}
//		}
//		return result;
	}

	// 인증번호 확인
//	public boolean checkCertify(String sendedNum, String inputCertifyNum) {
//		return sendedNum.equals(inputCertifyNum);
//	}
	
	// 인증번호 6자리 생성
	private String generateCertifyNum() {

		String resultNum = "";
		Random r = new Random();
		for (int i = 0; i < LENGTH; i++) {
			resultNum += r.nextInt(LENGTH);
		}
		return resultNum;
	}

	// 문자 전송
	public String sendCertifyMsg(String phoneNum) {
		String api_key = "NCS0IMQ0YEPATROO";
		String api_secret = "CVX43ZMO1MPUW4OFKGFCNXULGART56JA";
		Message coolsms = new Message(api_key, api_secret);
		String certifiedNum = generateCertifyNum();

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNum);
		params.put("from", phoneNum);
		params.put("type", "SMS");
		params.put("text", "인증번호: " + certifiedNum);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
//			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return certifiedNum;
	}
	
}
