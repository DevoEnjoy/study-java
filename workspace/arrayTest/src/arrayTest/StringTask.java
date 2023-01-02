package arrayTest;

import java.util.Scanner;

public class StringTask {
	public static void main(String[] args) {
//		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
//		대문자는 모두 소문자로 변경한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요\n입력: ");
		String str = sc.nextLine();
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char dum = str.charAt(i);	// 문자열의 각 글자를 char로 바꾸어 dum에 임시로 담는다.
			if (dum >= 'A' && dum <= 'Z') {	//	dum의 문자가 대문자 범위에 있을 경우
				result += (char) (dum + 32);	// 32를 더해서 소문자로 바꿔준다.
			} else if (dum >= 'a' && dum <= 'z') {	// 소문자 범위에 있을 경우
				result += (char) (dum - 32);	// 32를 빼서 대문자로 바꿔준다.
			} else {
				result += dum;	// 위 범위를 벗어났다면 그대로 출력한다.
			}

		}
		System.out.println(result);

//		정수를 한글로 변경
//		예) 1024 -> 일공이사
		char[] hans = new char[10];
		final String han = "공일이삼사오육칠팔구";
		String inputNum = null;
		String resultStr = "";

		for (int i = 0; i < 10; i++) {
			hans[i] = han.charAt(i);
		}

		System.out.print("숫자를 입력하세요\n입력: ");
		inputNum = sc.next();

		for (int i = 0; i < inputNum.length(); i++) {
			resultStr += hans[Integer.parseInt("" + inputNum.charAt(i))];
//			resultStr += han.charAt(inputNum.charAt(i) - 48);
			System.out.println(resultStr);
		}
		System.out.println(resultStr);

	}
}
