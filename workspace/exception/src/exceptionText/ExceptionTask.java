package exceptionText;

import java.util.Scanner;

public class ExceptionTask {
	public static void main(String[] args) {
//		5개의 정수만 입력받기
//			- 무한 입력 상태로 구현
//			- q 입력 시 나가기
//			- 각 정수는 배열에 담기
//			- if문은 딱 한 번만 사용하기
		Scanner sc = new Scanner(System.in);
		String tempStr = null, startMsg = "5개의 정수를 띄어쓰기를 이용해 구분하여 입력해 주세요.\n나가기: q 입력\n입력: ";
		int[] arInt = new int[5];
		for (int i = 0; i < arInt.length; i++) {
			System.out.print(startMsg);
			tempStr = sc.next();
			tempStr = tempStr.toLowerCase();
			if (tempStr.equals("q")) {
				System.out.println("종료합니다.");
				break;
			}

			try {
				arInt[i++] = Integer.parseInt(tempStr);
			} catch (NumberFormatException e) {
				System.out.println("정수만 입력해 주세요.\n");
				tempStr = null;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("5개의 정수만 입력해 주세요.\n");
				for (int j = 0; j < arInt.length; j++) {
					System.out.print(arInt[i] + " ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
