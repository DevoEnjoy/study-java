package inputTest;

import java.util.Scanner;

public class InputTask1 {
	public static void main(String[] args) {
//		두 정수를 입력한 뒤 덧셈 결과 출력
//		단, next()만 사용한다.
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		System.out.println("정수를 두 개 입력해주세요.");
		System.out.print("입력 :");
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		result = num1 + num2;
		System.out.println("결과 :" + result);
	}
}
