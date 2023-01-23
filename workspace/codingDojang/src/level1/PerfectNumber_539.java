package level1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PerfectNumber_539 {
//	자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를 완전수라고 한다.
//	예를 들면, 6과 28은 완전수이다.
//	6=1+2+3 // 1,2,3은 각각 6의 약수
//	28=1+2+4+7+14 // 1,2,4,7,14는 각각 28의 약수
//	입력으로 자연수 N을 받고, 출력으로 N 이하의 모든 완전수를 출력하는 코드를 작성하라.

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
		
		//	참고 코드
//		num= int(input("숫자를 입력하시오 : "))
//		print([x for x in range(1, num+1) if x==sum(y for y in range(1, x) if x%y==0)])
		
		//	참고한 코드를 기반으로 한 줄 코드 만들어봄
		IntStream.range(1, inputNum+1).filter(v -> v == IntStream.range(1, v).filter(v2 -> v%v2==0).sum()).forEach(System.out::println);
		
		
	}
}






















