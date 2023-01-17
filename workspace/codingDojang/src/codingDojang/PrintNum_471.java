package codingDojang;

public class PrintNum_471 {
	public static void main(String[] args) {
//		https://codingdojang.com/scode/471
//		20150111을 출력합니다.
//		4가지 기준만 만족하면 됩니다.
//
//		1. 코드 내에 숫자가 없어야 합니다.
//		2. 파일 이름이나 경로를 사용해서는 안됩니다.
//		3. 시간, 날짜 함수를 사용해서는 안됩니다.
//		4. 에러 번호 출력을 이용해서는 안됩니다.
		
		String result = "";
		int[] nums = {'U' - 'A', 'P' - 'A', 'a'-'a', 'o' };
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		System.out.println(result);
		
		
		
	}
}
