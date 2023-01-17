package operTest;

import java.util.Scanner;

public class Oper4 {
	public static void main(String[] args) {
//      심리 테스트
		/*
		 * Q. 당신이 좋아하는 색을 선택하세요. 1. 빨간색 2. 노란색 3. 검은색 4. 흰색
		 * 
		 * 빨간색 : 불같고 열정적이고 적극적이다.
		 * 노란색 : 발랄하고 밝고 귀엽고 개성있고 착하다.
		 * 검은색 : 묵묵하고 든든하고 냉철하고 멋지다.
		 * 흰색 : 천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.
		 * 
		 */
//		색상을 상수로 선언하여 재사용성을 높임.
		final String RED = "빨간색", BLACK = "검은색", YELLOW = "노란색", WHITE = "흰색";
		
//		색상별 메시지를 상수로 선언하여 유지보수를 용이하게 함.
		final String RED_MSG = "불같고 열정적이고 적극적이다.", BLACK_MSG = "묵묵하고 든든하고 냉철하고 멋지다.",
				YELLOW_MSG = "발랄하고 밝고 귀엽고 개성있고 착하다.", WHITE_MSG = "천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.";
		

		String msg = null/*결과메시지 선언 및 초기화*/, question = "Q. 당신이 좋아하는 색을 선택하세요.";//		입력 전 출력 메시지
		int choice = 0;// 입력값을 받을 변수

//		printf를 이용해 상수 사용
		System.out.printf("%s\n1. %s\n2. %s\n3. %s\n4. %s\n", question, RED, YELLOW, BLACK, WHITE);
		
//		입력을 받기 위한 출력 메시지
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		msg =	// 조건에 따라 변수에 넣을 값이 달라짐.
			choice == 1 ? RED + " : " + RED_MSG	// 입력받은 값이 1인 경우
				: choice == 2 ? YELLOW + " : " + YELLOW_MSG	// 입력받은 값이 2인 경우
						: choice == 3 ? BLACK + " : " + BLACK_MSG	// 입력받은 값이 3인 경우
								: choice == 4 ? WHITE + " : " + WHITE_MSG	//	입력받은 값이 4인 경우
										: "잘못 입력하셨습니다";	// 위 경우가 모두 아닌 경우
		System.out.println(msg);	// 일괄처리로 출력

	}
}