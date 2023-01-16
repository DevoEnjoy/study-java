package threadTask01;

import java.util.ArrayList;

public class ThreadTask01 {
//	'0'과 '1'로만 이루어진 문자열이 있습니다.
//	이 문자열에서 '1'이 최대 몇 번 연속해서 나타나는지 구하려 합니다.
//	예를 들어 110111 이라는 문자열이 주어졌을 때,
//	'1'이 연속해 나타나는 곳은 맨 앞의 11 과 맨 뒤의 111 입니다.
//	이 경우 1은 최대 3번 연속해서 나타났습니다.
//
//	'0'과 '1'로만 이루어진 문자열 s가 매개변수로 주어질 때,
//	이 문자열에서 '1'이 최대 몇 번 연속해서 나타나는지 return 하도록 solution 함수를 완성해 주세요.
//
//	제한사항
//		- s의 길이는 3 이상 5,000 이하입니다.
//		- s는 '0'과 '1'로만 구성되어 있습니다.
//		
//	입출력 예
//		s			result
//		"110111"	3
//		"00000"		0
//		
//	입출력 예 설명
//		입출력 예 #1
//		문제의 예시와 같습니다.
//		
//		입출력 예 #2
//		문자열은 '0'으로만 구성되어 있습니다. '1'은 최대 0번 연속해서 나타납니다.

	// 연속된 수 중 가장 큰 수를 리턴하는 메소드
	public static int getMaxCount(String str) {
		int result = 0;	//	 결괏값을 담을 변수 선언
		//	 makeArInt메소드는 str값을 {"111", "1", "11", "11"}처럼 바꾸고 그 1의 개수를 구하는 메소드
		ArrayList<Integer> tempArList = makeArInt(str);	//	{ 3, 1, 2, 5}와 같이 결과가 나옴
		
		for (Integer i : tempArList) {	//	각 값을 가져옴
			if(i >= result) {	//	만약 가져온 값이 이전의 최대값보다 크거나 같으면
				result = i;	//	가져온 값이 더 큰 값이므로 결괏값에 담음.
			}
		}	//	위 과정을 tempArList의 길이만큼 반복
		return result;	//	최종 결괏값은 최댓값이므로 리턴
	}

	//	"1100111001" 등의 값을 String타입으로 받아 0을 하나만 남기고 전부 제거(구분자용으로 하나 남김)
	//	"11011101"이 되고 이를 split()을 이용해 0을 구분점으로 하여 배열에 담음
	//	{"11", "11","1"} 그리고 배열의 각 방의 String.length()를 ArrayList<Integer>에 담아 리턴하는 메소드
	public static ArrayList<Integer> makeArInt(String str) {
		ArrayList<Integer> arResult = new ArrayList<Integer>();	//	ArrayList<Integer>의 타입을 담아 리턴할 변수 선언
		
		while(str.contentEquals("00")) {	//	구분점이 될 0을 //
			str = str.replaceAll("00", "0");
		}
		
		String[] arString = str.split("0");
		for (String string : arString) {
			arResult.add(string.length());
		}
		
		return arResult;
	}

	public static void main(String[] args) {
		System.out.println(getMaxCount("1101111"));
		System.out.println(getMaxCount("00000"));
	}
}
