package arrayTest;

import java.util.Scanner;

public class ArTask1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
////		브론즈
////		1~10까지 배열에 담고 출력
//		int[] arData1 = new int[10];
//		for (int i = 0; i < arData1.length; i++) {
//			arData1[i] = i + 1;
//			System.out.print(arData1[i]);
//		}
//		System.out.println("\n============1====");

////		10~1까지 중 짝수만 배열에 담고 출력
//		int[] arData2 = new int[5];
//		for (int i = 0; i < arData2.length; i++) {
//			arData2[i] = 10 - i * 2;
//			System.out.print(arData2[i] + " ");
//		}
//		System.out.println("\n=========2==========");

////		1~100까지 배열에 담은 후 홀수만 출력
//		int[] arData3 = new int[100];
//		for (int i = 0; i < arData3.length; i++) {
//			arData3[i] = i + 1;
//			if (arData3[i] % 2 == 0) {continue;}
//			System.out.print(arData3[i] + " ");
//		}
//		System.out.println("\n============3=============");

////		실버
////		1~100까지 배열에 담은 후 짝수의 합 출력
//		int[] arData4 = new int[100];
//		int total4 = 0;
//		for (int i = 0; i < arData4.length; i++) {
//			arData4[i] = i + 1;
//			if ((i + 1) % 2 == 0) {
//				total4 += i + 1;
//			}
//		}
//		System.out.print(total4);
//
//		System.out.println("\n============4=============");

////		A~F까지 배열에 담고 출력
//		char[] arData5 = new char[6];
//		for (int i = 0; i < arData5.length; i++) {
//			arData5[i] = (char)('A' + i);
//			System.out.print(arData5[i] + " ");
//		}
//		System.out.println("\n============5=============");

////		A~F까지 중 C 제외하고 배열에 담은 후 출력
//		char[] arData6 = new char[5];
//		for (int i = 0; i < arData6.length; i++) {
//			if (i < 2) {
//				arData6[i] = (char)('A' + i);
//			} else {
//				arData6[i] = (char)('A' + 1 + i);
//			}
//			System.out.print(arData6[i] + " ");
//		}
//		System.out.println("\n============6=============");

////		골드
////		5개의 정수를 입력받고 담은 후 최대값과 최소값 출력
//		int[] arData7 = new int[5];

//		int max = 0;
//		int min = 0;
//		System.out.println("정수 5개 입력\n입력: ");
//		for (int i = 0; i < arData7.length; i++) {
//			arData7[i] = sc.nextInt();
//		}
//		max = arData7[0];
//		min = arData7[0];
//		for (int i = 0; i < arData7.length; i++) {
////			if (i == 0) {
////				min = arData7[i];
////			}
//			if (max < arData7[i]) {
//				max = arData7[i];
//			} else if (min >= arData7[i]) {
//				min = arData7[i];
//			}
//		}
//		System.out.println("max: " + max + "\nmin: " + min);
//		System.out.println("\n============7=============");

//		다이아
//		사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		System.out.print("\n사용자가 입력할 정수의 개수 입력: ");
		double avg = 0;
		int total = 0;
		int[] arData8 = null;
		arData8 = new int[sc.nextInt()];
		System.out.printf("정수 %d개 입력(공백 혹은 엔터로 구분\n입력: ", arData8.length);
		for (int i = 0; i < arData8.length; i++) {
//			System.out.printf("\n입력할 정수%d: ", i + 1);
			arData8[i] = sc.nextInt();
		}
		for (int i = 0; i < arData8.length; i++) {
			total += arData8[i];
		}
		avg = total / arData8.length;
		System.out.println("평균: " + avg);

		System.out.println("\n============8=============");

	}
}
