package level1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PerfectNumber_539 {
//	�ڱ� �ڽ��� ������ ��� ���� ������� ���� �ڱ� �ڽ��� �Ǵ� �ڿ����� ��������� �Ѵ�.
//	���� ���, 6�� 28�� �������̴�.
//	6=1+2+3 // 1,2,3�� ���� 6�� ���
//	28=1+2+4+7+14 // 1,2,4,7,14�� ���� 28�� ���
//	�Է����� �ڿ��� N�� �ް�, ������� N ������ ��� �������� ����ϴ� �ڵ带 �ۼ��϶�.

//	public static int getFactorSum(int num) {
//		int result = 0;
//		if(num == 0 || num == 1) {return 0;}
//		for (int i = 0; i < num; i++) {
//			if (i == 0) {continue;}
//			if (num % i == 0) {result += i;}
//		}
//		
////		HashSet<Integer> set = new HashSet<Integer>();
////		for (int i = 2; i < num; i++) {
////			if(num % i == 0 && set.add(i)) {
////				result += i;
////			}
////		}
//		
//		return num == result ? result : 0;
//	}
//	
//	public ArrayList<Integer> isPerfectNums(int num){
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		IntStream.range(0, num).map(PerfectNumber_539::getFactorSum).forEach(result::add);
////		IntStream.range(0, num).map(v -> v == getFactorSum(v) ? v : 0).filter(v -> v !=0).forEach(result::add);
//		return result;
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
//		PerfectNumber_539 isP = new PerfectNumber_539();
//		isP.isPerfectNums(inputNum).stream().filter(v -> v != 0 && v != 1).forEach(System.out::println);
		
		//	���� �ڵ�
//		num= int(input("���ڸ� �Է��Ͻÿ� : "))
//		print([x for x in range(1, num+1) if x==sum(y for y in range(1, x) if x%y==0)])
		
		//	������ �ڵ带 ������� �� �� �ڵ� ����
		IntStream.range(1, inputNum+1).filter(v -> v == IntStream.range(1, v).filter(v2 -> v%v2==0).sum()).forEach(System.out::println);
		
		
	}
}






















