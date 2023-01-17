package threadTask230113;

import java.util.stream.IntStream;

public class LockRotateTask {
//		잠겨 있는 다이얼 자물쇠가 있습니다. 이 자물쇠를 풀기 위해서는 비밀번호를 눈금선에 맞추어야 합니다.
//		현재 눈금선에 맞추어져 있는 수의 각 자리를 정방향, 또는 역방으로 회전하여 비밀번호의 수와 맞출 수 있습니다.
//		이때, 자물쇠를 풀기 위해 회전시키는 횟수의 최솟값을 구하려고 합니다.
//		예를 들어, 현재 눈금선의 숫자는 "82195"이고, 비밀번호가 "64723"이라면 다음과 같은 연산을 거쳐 자물쇠를 풀 수 있습니다.
//	
//		- 1번째 비밀번호 : 8->7->6(역방향 2회)
//		- 1번째 비밀번호 : 2->3->4(정방향 2회)
//		- 1번째 비밀번호 : 1->0->9->8->7(역방향 4회)
//		- 1번째 비밀번호 : 9->0->1->2(정방향 3회)
//		- 1번째 비밀번호 : 5->4->3(역방향 2회)
//		- 총 횟수 : 13회
//		
//	물론 이 방법 이외에도 다른 방법으로 회전시켜 자물쇠를 풀 수 있지만,
//	해당 방법보다 더 작은 횟수로 자물쇠를 푸는 방법은 없습니다. 따라서 최솟값은 13이 됩니다.
//	현재 눈금선에 있는 숫자 P와, 비밀번호 S가 매개변수로 주어질 때,
//	자물쇠를 풀기 위한 최소 회전 횟수를 return 하는 solution 함수를 완성해 주세요.
//	
//	제한 사항
//		- 비밀번호의 길이 : 1000 자리 이하의 자연수
//		
//	입출력 예
//	
//		현재 눈금선P			비밀번호 S				최소 회전 횟수 result
//		"82195"					"64723"					13
//		"00000000000000000000"	"91919191919191919191"	20
//		
//	입출력 예 설명
//	입출력 예 # 1
//	위와 같습니다.
	
	//	현재 눈금석P와 비밀번호S를 입력하여 최소 회전 횟수를 구하는 메소드(public)
	public int rotate(String strP, String strS) {

		// 입력된 문자열의 길이가 다를 경우 예외 발생
		if (strP.length() != strS.length()) {

			try {
				throw new Exception("입력된 문자열의 길이가 다릅니다.");
			} catch (Exception e) {
				System.err.println("에러 메시지 : " + e.getMessage());
				e.printStackTrace();
			}
		}
		// 각 문자열을 정수배열로 바꾸는 메소드
		int[] arIntP = str2Int(strP), arIntS = str2Int(strS);

		// 각 정수배열의 같은 인덱스끼리 비교하여 계산 후 총 자물쇠 회전 수를 리턴하는 메소드를 리턴
		return rotateCount(arIntP, arIntS);
	}

	// 문자열을 정수배열로 바꾸는 메소드
	private int[] str2Int(String str) {
		//
		// 인덱스를 위한 IntStream
		return IntStream
				//	인덱스 길이는 문자열str의 길이만큼
				.range(0, str.length())
				//	인덱스를 이용해 문자열str의 각 문자를 매핑, 숫자 그대로를 추출하기 위해 -> 문자열 -> Integer타입으로 형변환
//				.map(i ->Integer.parseInt("" + str.charAt(i)))
				//	아스키코드 상 문자'0'은 정수형 48이므로 그만큼 차연산하여 정수 0 ~ 9로 만듦
				.map(i -> str.charAt(i) - '0')
				//	정수 배열로 만듦
				.toArray();

//		//	정수 배열의 길이는 입력받은 문자열의 길이만큼
//		int[] result = new int[str.length()];
//		
//		//	정수 배열의 길이만큼 반복
//		for (int i = 0; i < result.length; i++) {
//			
//			//	입력받은 문자열의 각 문자를 배열의 각 인덱스마다 대입
//			result[i] = str.charAt(i);
//		}

//		return result;

	}
	//	자물쇠 번호 회전 횟수를 세는 메소드
	private int rotateCount(int[] arFirst, int[] arSecond) {
		int result = 0;	//	정수형 결과값을 담을 변수
		//	입력받은 아무 매개변수의 길이만큼 반복
		for (int i = 0; i < arSecond.length; i++) {
			//	각 인덱스의 값을 계산하여 자물쇠 회전 횟수를 구하여 기존 값에 누적합연산 
			result += rotateCalc(arFirst[i], arSecond[i]);
		}
		return result;	//	반복문 종료 후 리턴
	}
	
	//	0~9 사이의 두 값을 받아서 자물쇠 회전의 최솟값을 구하는 메소드
	private int rotateCalc(int num1, int num2) {
		boolean isBigNum1 = num1 > num2;	//	매개변수의 두 값을 비교하여 큰 값을 판단
		int bigOne = isBigNum1 ? num1 : num2	//	매개변수 중 큰 값 담음
				, smallOne = isBigNum1 ? num2 : num1;	// 매개변수 중 작은 값 담음
		int differ = bigOne - smallOne;	//	매개변수들의 차(0 또는 양수)
		
		//	삼항으로 단축. 설명은 아래 주석
		return differ > 5 ? (smallOne + 10) - bigOne : differ;
		
//		if (differ > 5) {	//	매개변수의 차이가 5보다 크면(예 9, 3 -> 6)
//			return (smallOne + 10) - bigOne;	//	작은 값에 10을 더하여(예 9, 3+10) 그 차이를 리턴(13-9=4) 4< 9-3
//		}
//		return differ;	//	매개변수의 차이가 5이하이면 차이값 리턴
	}

	public static void main(String[] args) {
		LockRotateTask lock = new LockRotateTask();
		String strS = "82195", strP = "64723";
		System.out.println(lock.rotate(strS, strP));
		
		
		strS = "00000000000000000000";
		strP = "91919191919191919191";

		System.out.println(lock.rotate(strS, strP));
	}

}
