package controllStatement;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
//      사용자에게 아래의 메뉴를 출력하고
//      번호를 입력받는다.
		int inputNum = 0;
		String msg = null;
		final String RED = "빨간색", BLACK = "검은색", YELLOW = "노란색", WHITE = "흰색";
//      1. 빨간색
//      2. 검은색
//      3. 노란색
//      4. 흰색
		System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n", RED, BLACK, YELLOW, WHITE);
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		inputNum = Integer.parseInt(sc.next());

//      사용자가 입력한 번호의 색상을 영어로 출력한다.
		switch (inputNum) {
		case 1:
			msg = "red";
			break;
		case 2:
			msg = "black";
			break;
		case 3:
			msg = "yellow";
			break;
		case 4:
			msg = "white";
			break;
		default:
			msg = "잘못 입력하셨습니다.";
			break;
		}
		System.out.println(msg);
	}
}
