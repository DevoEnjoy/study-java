package codingDojang;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Multiplies_350 {
	public static void main(String[] args) {
//		https://codingdojang.com/scode/350
//		10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다. 이들의 총합은 23이다.
//
//		1000미만의 자연수에서| 3,5의 배수의 총합을 구하라.

		// 답1
//		int sum = 0;
//		for (int i = 0; i < 1000; i++) {
//			if (i % 3 == 0 || i % 5 == 0) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);

		// 참고코드
//	    import java.util.stream.IntStream;
//	    public static void main(String[] args) {
//	        System.out.println(String.format("정답: %d", foo(1000)));
//	    }
//
//	    private static int foo(int end) {
//	        return IntStream.range(1, end).filter(j -> j%3==0 || j%5==0).sum();
//	    }

		// 커스텀이 가능하게 만든 버전
		int start = 1; // 시작값을 받을 변수 선언
		int end = 1000; // 끝값을 받을 변수 선언
		Scanner sc = new Scanner(System.in); // 입력기능 불러오기
		System.out.print("입력한 수의 모든 배수의 합을 구하는 프로그램입니다.\n입력할 수의 개수를 입력하세요.\nEnter: ");
		int ea = sc.nextInt(); // 입력할 수의 개수를 받을 변수. 안내 메시지에서 재사용
		int[] factors = new int[ea]; // 입력할 수의 개수를 이용해 배열의 길이를 정함.

		System.out.print("시작값과 끝값을 입력해주세요.\nEnter: ");
		start = sc.nextInt(); // 입력으로 시작값 변수에 저장
		end = sc.nextInt(); // 입력으로 끝값 변수에 저장

		System.out.printf("\n%d개의 수를 공백이나 Enter를 구분점으로 하여 입력해주세요.\nEnter: ", ea);
		for (int i = 0; i < factors.length; i++) { // factors.length 대신 ea를 써도 무방하지만 직관적 이해를 위해 그대로 둠.
			factors[i] = sc.nextInt(); // 배열의 길이만큼 수를 입력받아 배열에 채워넣기.
		}

		System.out.println("정답: " + sumByFactors(start, end, factors)); // 위에서 받은 변수를 이용해 sumByFactors메소드를 사용하여 값을 반환받음.
		sc.close(); // 필요는 없으나 노란밑줄이 신경쓰여 적은 코드. 스캐너를 닫아준다.
	}

	private static int sumByFactors(int start, int end, int[] factors) {
		// 배수를 기반으로 모든 배수의 합을 구하는 기능의 메소드

		return IntStream.range(start, end) // 범위를 정하는 부분
				.filter(j -> { // 조건식 입력하는 부분
					boolean tf = false; // return할 조건식의 값이 될 변수 선언
					for (int i = 0; i < factors.length; i++) { // 파라미터로 받은 배열의 길이 만큼 반복
						tf = tf || j % factors[i] == 0;
						// 범위의 수(j)를 파라미터로 받은 배열(int[] factor)의 각 수(factor[i])로 나눈 나머지가 0이면
						// factor[i]가 j의 약수인 것이므로 true가 나오고 이를 이전의 tf값과 ||(또는)으로 연결함.
					}
					return tf; 	// 모든 반복이 끝났을 때의 tf 값을 반환함.
				}).sum(); 		// 위 조건이 true인 range내의 수의 값만 모두 더하고 return함.
	}
}
