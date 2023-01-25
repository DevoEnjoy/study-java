package level1;

import java.util.stream.IntStream;

//	0부터 9999까지 8을 포함하지 않는 수는 총 몇개일까?
//	8, 108, 888, 9998 등은 8을 포함하고 있는 수입니다. 111, 299, 4 등과 같은 수는 8을 포함하지 않는 수 입니다.
public class HowManyEight_720 {
	public static void main(String[] args) {
		System.out.println(count(9999, 8));
	}

	public static int count(int end, int target) {
//		return end + 1 - IntStream.rangeClosed(0, end).filter(v -> (v+"").contains(end+"")).count();
		return end + 1 - (int) IntStream.rangeClosed(0, end).filter(v -> String.valueOf(v).contains(String.valueOf(target))).count();
	}
}
