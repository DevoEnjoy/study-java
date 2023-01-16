package test;

import java.util.Scanner;

public class Day02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("등급을 입력해 주세요.");
		int a = sc.nextInt();
		boolean flag = false;

//		if (a * 3 - 2 > -1) {
//			System.out.println("내 생각엔 말이야" + (a == 1 ? "a는 1이야" : "1이 아니야"));
//			System.out.println("return true" + a);
//		} else {
//			System.out.println(a);
//			System.out.println("return false" + a);
//		}

//		while (true) {
//			if (flag) {
//				break;
//			}
//		}
		while (true) {
			switch (a) {
			case 1:
				System.out.println("저장공간100Gb");
				flag = true;
				break;
			case 2:
				System.out.println("무제한 인터넷");
			case 3:
				System.out.println("문화상품권 1만원권");
				break;
			}
			
			if(flag) {
				break;
			}
			
		}
	}
}
