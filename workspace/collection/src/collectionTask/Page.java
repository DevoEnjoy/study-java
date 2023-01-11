package collectionTask;

import java.util.Scanner;

//[심화 실습]
//Page 클래스 선언
//- main 메소드 선언
//- 테스트 진행
//- 아이디 중복검사
//- 회원가입
//- 로그인
//- 암호화
//- 비밀번호 변경(비밀번호 찾기 서비스)
//- 인증번호 전송
public class Page {
	public static void main(String[] args) {
		User ljs = new User();
		
		String inputId = "ljs1993", inputName ="이준상", inputPassword = "1324", inputPhoneNumber = "01077287518";

		// 등록 테스트
		ljs.setId(inputId);
		ljs.setName(inputName);
		ljs.setPassword(inputPassword);
		ljs.setPhoneNumber(inputPhoneNumber);
		
		// 세팅 확인
		System.out.println(ljs);

		// 등록 전 -> null값 리턴
		System.out.println(UserField.checkExistId(inputId) + "-> 등록 전");

		// 등록 후
		if (UserField.register(ljs) != null) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}
		System.out.println("==================");
		
		// 중복 검사 테스트
		// null or 유저정보 출력
		System.out.print("중복검사 테스트 -> ");
		System.out.println(UserField.checkExistId(inputId));

		// 등록 확인 테스트
		System.out.println(ljs/* .toString() */);

		// 로그인테스트
		System.out.println(UserField.login(ljs));

		// 암호화 테스트
//		System.out.println(UserField.encrypt(inputPassword));		

		// 비밀번호 변경 테스트
//		System.out.println("변경전 -> " + UserField.dencrypt(ljs.getPassword()));
//		ljs.setPassword(UserField.encrypt("1q2w3e4r"));
//		System.out.println(UserField.changePassword(ljs) + "-> 비밀번호 변경 테스트");
//		System.out.println("변경 후 ->" + UserField.dencrypt(ljs.getPassword()));

		// 인증번호 생성 테스트
//		System.out.println(UserField.generateCertifyNum());

//		String certifyNum = UserField.generateCertifyNum();
		String phoneNum = ljs.getPhoneNumber();

		//	문자 전송 테스트
//		System.out.println("인증번호 문자를 발송합니다.");
//		UserField.sendCertifyMsg(certifyNum, phoneNum);
		
		//	인증번호 입력 및 일치 확인 테스트
//		Scanner sc = new Scanner(System.in);
//		System.out.print("인증번호 입력: ");
//		boolean booleanVal = UserField.checkCertify(certifyNum, sc.nextLine());
//		
//		System.out.println("인증번호 일치여부: " + booleanVal);
		
		
		
		
		
	}
}
