package test;

import java.util.Scanner;

public class Day02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� �Է��� �ּ���.");
		int a = sc.nextInt();
		boolean flag = false;

//		if (a * 3 - 2 > -1) {
//			System.out.println("�� ������ ���̾�" + (a == 1 ? "a�� 1�̾�" : "1�� �ƴϾ�"));
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
				System.out.println("�������100Gb");
				flag = true;
				break;
			case 2:
				System.out.println("������ ���ͳ�");
			case 3:
				System.out.println("��ȭ��ǰ�� 1������");
				break;
			}
			
			if(flag) {
				break;
			}
			
		}
	}
}
