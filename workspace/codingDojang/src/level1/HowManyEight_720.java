package level1;

import java.util.stream.IntStream;

//	0���� 9999���� 8�� �������� �ʴ� ���� �� ��ϱ�?
//	8, 108, 888, 9998 ���� 8�� �����ϰ� �ִ� ���Դϴ�. 111, 299, 4 ��� ���� ���� 8�� �������� �ʴ� �� �Դϴ�.
public class HowManyEight_720 {
	public static void main(String[] args) {
		System.out.println(count(9999, 8));
	}

	public static int count(int end, int target) {
//		return end + 1 - IntStream.rangeClosed(0, end).filter(v -> (v+"").contains(end+"")).count();
		return end + 1 - (int) IntStream.rangeClosed(0, end).filter(v -> String.valueOf(v).contains(String.valueOf(target))).count();
	}
}
