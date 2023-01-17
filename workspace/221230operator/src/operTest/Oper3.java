package operTest;

import java.util.Scanner;

public class Oper3 {
	public static void main(String[] args) {
//		사용자에게 키를 입력받고
//		정수라면 정수로 출력
//		실수라면 실수로 출력
//		예) 183 -> 183 출력
//			183.5 -> 183.5 출력
//		삼항 연산자를 사용!
		// 1번째
//		double num = 0;	// 입력을 받을 변수. 입력받은 값의 범위가 넓은 실수로 선언
//		boolean tof = false;	// 정수/실수 여부를 저장할 변수
//		String result = null;	// 서식문자를 포함하는, 출력할 문자열 메시지를 담을 변수
//		
//		Scanner sc = new Scanner(System.in);	// 스캐너 선언
////		입력 안내를 위한 메시지 출력
//		System.out.println("정수/실수 판별기입니다.\n숫자를 입력해주세요.");
//		System.out.print("입력 : ");
//		num = sc.nextDouble();	// 입력값을 변수에 담음.
//		
//		tof = num - (int)num == 0;	// '실수 - 정수'의 값이 0이라면 true가 나오고 num이 정수라는 걸 알 수 있음.
//		result = tof ? "결괏값(정수) : %.0f" : "결괏값(실수) : %.1f";	// 위 조건식을 사용해 조건에 따라 서식문자를 다르게 적용
//		
//		System.out.printf(result, num);
////		System.out.printf(result, tof ? (int)num : num);	// 어차피 %f를 사용할 실수이므로 파라미터에서는 삼항연산자를 사용할 필요가 없음.

//		수업
//      사용자에게 키를 입력받고
//      정수라면 정수로 출력
//      실수라면 실수로 출력
//      예)   183 -> 183 출력
//         183.5 -> 183.5 출력
//      삼항 연산자를 사용!

//      힌트!
//      뺄셈으로 풀면 쉬움
//      서식문자로 풀면 더 쉬움
//      double height = 0.0;
//      String message = "키: ";
//      Scanner sc = new Scanner(System.in);
//      boolean check = false;
//      String format = null;
//      String forLength = "";
//      int length = 0;
//      
//      System.out.print(message);
//      height = sc.nextDouble();
//      check = height - (int)height == 0;
//      forLength = height - (int)height + "";
//      
//      length = forLength.length() > 6 ? 8 : forLength.length();
//      
//      format = check ? "%.0fcm" : "%." + (length - 2) + "fcm";
//      System.out.printf(format, height); 

//		수업+
//      사용자에게 키를 입력받고
//      정수라면 정수로 출력
//      실수라면 실수로 출력
//      예)   183 -> 183 출력
//         183.5 -> 183.5 출력
//      삼항 연산자를 사용!

//      힌트!
//      뺄셈으로 풀면 쉬움
//      서식문자로 풀면 더 쉬움
		double height = 0.0;
		String message = "키: ";
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		String format = null;
		String forLength = "";
		int afterDotLength = 0;
		int length = 0;

		System.out.print(message);
		height = sc.nextDouble();
		check = height - (int) height == 0;
		forLength = height - (int) height + "";

		length = forLength.length() - 2;
		length =  length >= 6 ? 6 : length;
		format = check ? "%.0fcm" : "%." + length + "fcm";
		System.out.printf(format, height);

		// 윤민우 님 코드
//      key > 0 ? 양수 : 음수
//      양수 -> 실수 > 정수
//      음수 -> 실수 < 정수
//      key > 0 ? 양수(실수 > 정수 ? 실수 : 정수) : 음수(실수 < 정수 ? 실수 : 정수)
//      String.valueOf

//      result = key > 0 ? 
//            key > (int)key ? key : (int)key 
//                  : key < (int)key ? key : (int)key;
		// 시도해봤으나 어려움
//		result = "" + (num > 0 ? (num > (int)num ? num : (int)num) : (num < (int)num ? num : (int)num));
//		result = num > 0 ? (num > (int)num ? "%.0f" : "%.0f") : (num < (int)num ? "%.0f" : "%.0f");
//		System.out.printf(result, num > 0 ? /*양수*/ (num > (int)num ? /**/num : (int)num)
//				: /*음수*/(num < (int)num ? num : (int)num));

	}
}
