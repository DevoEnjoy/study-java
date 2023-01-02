package arrayTest;

import java.util.Scanner;

public class ArTask2 {
	public static void main(String[] args) {
//		각 버튼을 눌렀을 때, 이동하는 페이지는 다음과 같다.

//		btn1 :	회원가입 페이지 
//		btn2 : 	로그인 페이지
//		btn3 : 	마이 페이지

//		회원가입 -> 로그인 -> 마이 페이지
//		위 순서대로 입력해야 하며, 만약 이전 단계를 진행하기 전에 다음 단계 버튼을 누를 경우, 이전 단계에 대한 메시지를 출력해준다.
//		예) 로그인 클릭 시, "회원가입을 먼저 진행해주세요" 출력

//		알맞은 단계의 버튼을 누르면, 해당 단계에 대한 메세지를 출력해준다.
//		예) 회원가입 클릭 시, 회원가입 성공
//		마이페이지 클릭 시, 본인 이름과 나이 출력

		String[] arBtn = { "btn1", "btn2", "btn3", "btn4", "btn5" };
		
		final int EXIT = 0, SIGN_IN = 1, LOGIN = 2, MY_PAGE = 3, LOGOUT = 4;
		
		
		arBtn[EXIT] = "프로그램 종료";
		arBtn[SIGN_IN] = "회원가입 페이지";
		arBtn[LOGIN] = "로그인 페이지";
		arBtn[MY_PAGE] = "마이 페이지";
		arBtn[LOGIN] = "로그아웃";
		
		int choice = 0; // 사용자 입력을 담을 변수
		int needChoice = 1; // 페이지 진입에 필요한 값을 담을 변수
		Scanner sc = new Scanner(System.in); // 스캐너 선언
		String msgChoice = "원하는 페이지에 해당하는 숫자를 입력해주세요."
				+ "\n1.%s\n2.%s\n3.%s\n4.%s\n5.%s"
				// 1.회원가입 2.로그인 3.마이페이지 4.로그아웃 5.프로그램 종료
				+ "\n입력 :";
		// 선택 안내 메시지 문구
		
		String splitLine = "--------", sl1 = "\n" + splitLine, sl2 = splitLine + "\n";
		
		String[] arMsgErr = { "잘못 입력하셨습니다.",
				"회원가입을 먼저 진행해주세요.",
				"로그인을 먼저 진행해주세요.",
				"현재 페이지가 마이페이지입니다.",
				"이미 진행한 과정입니다." };
		// 에러 메시지 문구

		String[] arMsgWelcome = { "프로그램을 종료합니다.", "회원가입 성공", "로그인 성공", "이준상(30)", "로그아웃합니다." };
		// 성공 메시지 문구

		for (int i = 0; i < arMsgWelcome.length; i++) {arMsgWelcome[i] = sl1 + arMsgWelcome[i] + sl2;}
		// 절취선 추가
		
		for (int i = 0; i < arMsgErr.length; i++) {arMsgErr[i] = sl1 + arMsgErr[i] + sl2;}
		// 절취선 추가
		
		while (true) {
			System.out.printf(msgChoice, arBtn[SIGN_IN], arBtn[LOGIN], arBtn[MY_PAGE], arBtn[LOGOUT], arBtn[EXIT]);
			// 선택 안내 메시지 문구와 %s에 출력될 변수값들

			choice = sc.nextInt();
			// 선택값을 받음.
			
			if (choice == LOGOUT) {
				// 로그아웃을 누른 경우
				System.out.println(arMsgWelcome[LOGOUT]);
				needChoice = LOGIN;
				// 회원가입은 했으니 로그인부터 가능
				continue;
			}else if(choice == EXIT) {
				// 프로그램 종료를 누른 경우
				System.out.println(arMsgWelcome[EXIT]);
				sc.close();
				break;
				// 반복문 탈출
			}
			
			if (needChoice < choice && choice <= LOGOUT) {
				// 선택값이 요구값보다 높은 경우
				// 예) 회원가입(needChoice==1)을 안했는데 로그인(choice==2)을 하려는 경우
				// 단, 선택값은 상정한 범위 이내인 경우로 한정

				System.out.println(arMsgErr[choice]);
				// 선택값과 arMsgErr[값]의 값을 일치시킬 수 있으니 한 줄로 가능
//				
			} else if (needChoice == choice) {
				needChoice++; // 요구값과 선택값이 같으니 다음 절차로 넘어가기 위해 요구값 1증가

				System.out.println(arMsgWelcome[choice]);
				//	선택값이 인덱스와 일치하니 한 줄로 처리 가능
				
			} else if (needChoice > MY_PAGE && choice == MY_PAGE) {
				// 요구 선택 번호가 마이페이지 초과인데(즉 마이페이지 진입했는데)
				// 4를 선택한 경우
				System.err.println(arMsgErr[3]);
				// 이미 마이페이지라는 오류 문구 출력
			} else if(needChoice > choice && choice >= 1 && choice < 4) {
				System.out.println(arMsgErr[4]);
				// 이미 앞선 과정을 했는데 다시 하려는 경우
			} else {
				// 위 어느 경우도 아니라면
				System.err.println(arMsgErr[0]);
				// 잘못 입력 메시지 출력

			}
			System.out.println();
			// 가독성을 위한 줄바꿈
		}

	}
}
