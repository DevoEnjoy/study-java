package homeWork0109;

import java.util.Scanner;

public class CalculatorTask3 {
//		[심화 실습]
//		여러 개의 정수를 입력받아서 알맞는 덧셈, 뺄셈 결과를 확인하는 애플리케이션 제작

//		입력 예1) 7 + 35 - 9
//		출력 예1) 33

//		입력 예2) -9 + 8 + 10
//		출력 예2) 9
//		* "ABC".split("")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//		   "A,B,C".split(",")은 [A][B][C] 3칸 문자열 배열로 리턴된다.
//		   split("구분점")을 전달하면 문자열에서 동일한 구분점을 기준으로 문자열 값을 잘라낸 후 문자열 배열로 리턴한다.
//		   구분점을 여러 개 사용할 때에는 split("구분점|구분점")으로 사용하며, "+", "-"를 구분점으로 사용할 때에는 "\\+", "\\-"로 표현한다.
//		   예)"4 + 9".split("\\+")은 [4][9] 2칸 문자열 배열로 리턴
	//
//		* 사용자가 정상적으로만 입력한다는 가정 하에 구현하도록 한다.
//		* 두 정수를 전달받은 후 int로 리턴하는 calc 추상메소드 선언(함수형 인터페이스 제작)
//		* 두 정수의 덧셈, 뺄셈을 구해주는 함수형 인터페이스를 리턴하는 static 메소드 선언(람다식 리턴)
	public static Calculator add = (num1, num2) -> num1 + num2;
	public static Calculator sub = (num1, num2) -> num1 - num2;

//		* 전체 식을 전달받은 후 String[]로 리턴하는 getOpers 추상메소드 선언(함수형 인터페이스 제작)
//		* main메소드에 getOper를 람다식으로 구현
//		* 첫번째 정수가 음수일 경우 오류 해결

//	public static int add(int start, int end) {
//		Calculator addCal = (num1, num2) -> num1 + num2;
//		return addCal.calc(start, end);
//	}

//	public static int sub(int start, int end) {
//		int result = 0;
//		Calculator subCal = (num1, num2) -> num1 + num2;
//		return subCal.calc(start, end);
//	}

	public static void main(String[] args) {

		// 선언부
		Scanner sc = new Scanner(System.in);
		String inputStr = null; // 입력될 문자열이 담길 변수 선언
		String[] arStr = null, // 위 문자열이 배열로 바뀌면 담길 변수 선언
				tempArStr = null; // arStr[]을 하나씩 가져와 쪼개어 넣을 임시 변수 선언
		int parsedInt = 0, // for문 연산 중, 쪼개진 String을 Integer.parseInt를 이용해 바뀐 값을 넣을 임시 변수 선언
				resultInt = 0; // 최종 연산결과값을 담을 변수 선언

		// String을 String[]로 바꾸는 추상메소드
		Operator operator = (strings) -> { // Operator.getOpers(String string);
//			String[][] tempResult = null;	// 이중 배열로 시도하던 흔적(숫자, 연산자를 따로 담으려고 했음)

			// 입력값 검사구문
//			System.out.println(strings);
			String[] arResult = null;

			// 연산자 전후로 띄어쓰기가 들어갈 수 있다고 가정
			// 띄어쓰기가 들어가지 않거나 연산자 전후로 하나씩만 들어간 경우, while문을 없애고 한 번만 동작해도 무관.
			if (strings.contains(" ")) {
				strings = strings.replaceAll(" ", "");
			}

			// strings를 "+"를 구분자로 하여 리턴값인 String배열에 담음.
			arResult = strings.split("\\+");

			// 배열값 검사구문
//			for (int i = 0; i < arResult.length; i++) {
//				System.out.println(i + ". " + arResult[i]);
//			}
//			System.out.println("operator\n");

			return arResult;
		};

		// 입력값 안내. 혹은 Scanner사용 시, nextLine()이 사용될 부분.
//		inputStr = "31-20-4+5+2-3+2";

		// 스캐너 사용하여 입력
		System.out.print("입력: ");
		inputStr = sc.nextLine();

		System.out.println("입력값: " + inputStr);

		// * 첫번째 정수가 음수일 경우 오류 해결
		// 만약 시작값이 음수(-31 등)라면, 앞에 숫자 0을 붙여 0-31의 형태가 되게 만듦.
		if (inputStr.charAt(0) == '-') {
			inputStr = "0" + inputStr;
		}

		// operator.getOpers의 리턴값이 String배열(의 주소값)이므로
		// 마찬가지로 String배열타입의 변수에 주소값을 담음.
		arStr = operator.getOpers(inputStr);
		// arStr 예시 : {"31-20-4", "5", "2-3", "2"}

		// 위의 arStr의 배열값을 하나씩 확인하고 계산하는 for문
		for (int i = 0; i < arStr.length; i++) {

			// arStr의 배열값을 쪼개어 넣을 임시 공간 초기화
			tempArStr = null;

			// i번째 방이 차연산인 경우
			if (arStr[i].contains("-")) {

				// 차연산인 경우, "-"를 구분자로 하여 임시 배열에 담음.
				tempArStr = arStr[i].split("\\-");
				// tempArStr 예시: {"31","20","4"}

				// 임시로 담긴 문자열 배열을 순환할 for문
				for (int j = 0; j < tempArStr.length; j++) {

					// 배열에 담긴 숫자형 문자열을 정수로 치환하여 정수형 임시 공간에 담음
					parsedInt = Integer.parseInt(tempArStr[j]);

//					시도2. 삼항으로 단축
//					예시: 31-20-4이 들어올 경우, 가장 앞 숫자는 기존 결괏값에 합연산 나머지는 차연산.
					// 즉, resultInt+31을 resultInt에 넣음.
					// 다음 순환 때 resultInt-20을 resultInt에 넣음.
					// tempArStr의 배열이 끝날 때까지 반복
					resultInt = ((j == 0) ? add.calc(resultInt, parsedInt) : sub.calc(resultInt, parsedInt));

					// 검사구문
//					System.out.println("resultInt: " + resultInt);

//					시도1. 스위치문으로 해봄
//					switch (i) {
//					case 0:
//						resultInt = add(resultInt, parsedInt);
//						break;
//					default:
//						resultInt = sub(resultInt, parsedInt);
//						break;
//					}					
				} // 내부for문 끝

				// 임시 저장공간 초기화
				parsedInt = 0;

			} else { // "-"없이 즉, 차연산이 없다면

				// 숫자만 있을 것이므로 바로 int로 전환
				parsedInt = Integer.parseInt(arStr[i]);

				// 해당값과 기존 결괏값 합연산
				resultInt = add.calc(resultInt, parsedInt);
			}

			// 외부 for문 끝
		}
		System.out.println("연산 결과: " + resultInt);

	}
}
