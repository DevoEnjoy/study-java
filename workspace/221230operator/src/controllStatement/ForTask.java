package controllStatement;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
//		브론즈
//		1 ~ 100까지 출력
		for (int i = 0; i < 100; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("\n브론즈1\n");
		
//		100 ~ 1까지 출력
		for (int i = 0; i < 100; i++) {
			System.out.print(100 - i + ", ");
		}
		System.out.println("\n브론즈2\n");
		
//		1 ~ 100까지 중 짝수만 출력
		// 방법1
		for (int i = 0; i < 100; i++) {
			if ((i+1)%2 == 0) {
				System.out.print(i+1 + ", ");
			}
		}
		System.out.println("\n방법1\n");
		
		// 방법2
		for (int i = 0; i < 50; i++) {
			System.out.print((i+1)*2 + ", ");
		}
		System.out.println("\n방법2");
		
		System.out.println("\n브론즈3");
		
//		실버
//		1 ~ 100까지 합 출력
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			result+=i;
		}
		System.out.println(result);
		
//		1 ~ n까지 합 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("\nn까지의 합을 구합니다. n을 입력해주세요\n입력: ");
		int inputNum = sc.nextInt();
		int resultN = 0;
		for (int i = 0; i < inputNum; i++) {
			resultN += i+1;
		}
		System.out.println(resultN);
		
//		골드
//		A~F까지 출력
		for (int i = 0; i < 6; i++) {
			System.out.print((char)('A'+i) + ", ");
		}
		System.out.println("\n골드1\n");
		
//		A~F까지 중 C제외하고 출력
		for (int i = 0; i < 5; i++) {
//			if (i!=2) {
//				System.out.print((char)('A'+i) + ", ");
//			}
			System.out.print((char)((i+'A')>'B' ? (char)'A'+i+1 : (char)'A'+i));
			System.out.print(", ");
		}
		System.out.println("\n골드2");
		
//		다이아
//		0 1 2 3 0 1 2 3 0 1 2 3 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(j + ", ");
			}
		}
		System.out.println("\n다이아1\n");
		
//		수업
		for (int i = 0; i < 12; i++) {
			System.out.print(i%4 + ", ");
		}
		System.out.println("\n다이아2\n");
		
//		aBcDeFgH...Z 출력
		for (int i = 0; i < 26; i++) {
			if ((i+1)%2!=0) {
				System.out.print((char)('a'+i) + ", ");
			}else {
				System.out.print((char)('a'-32+i) + ", ");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
