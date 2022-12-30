package inputTest;

import java.util.Scanner;

public class InputTask2 {
	public static void main(String[] args) {
//		3개의 정수를 한번에 입력받은 후
//		세 정수의 곱셈 출력
//		next()만 사용.
		
//		입력을 받기위해 Scanner를 선언한다.
		Scanner sc = new Scanner(System.in);
		
//		입력받을 정수를 저장할 변수를 선언한다.
		int num1 = 0, num2 = 0, num3 = 0;
		int result = 0;
		
//		정수를 입력받기 위해 출력한다.
		System.out.println("세 개의 정수를 띄어쓰기를 구분점으로 하여 입력해주세요.");
		System.out.print("입력 : ");
		
//		정수를 세 개 입력받는다.
//		입력받은 문자열을 정수로 형변환한다.
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		num3 = Integer.parseInt(sc.next());
		
//		형변환한 정수를 곱연산한다.
		result = num1 * num2 * num3;
		
//		결과값을 출력한다.
		System.out.print("결과 : " + result);
	}
}
