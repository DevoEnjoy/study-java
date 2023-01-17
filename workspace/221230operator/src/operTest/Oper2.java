package operTest;

import java.util.Scanner;

public class Oper2 {
	public static void main(String[] args) {
//		두 정수 대소비교
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0, result = 0;
		System.out.println("정수를 두 개 입력하세요");
		System.out.print("입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		result = num1 > num2 ? num1 : (num1 == num2 ? num1 : num2);
		System.out.println("더 큰 값은 " + result);
	}
}
