package operTest;

import java.util.Scanner;

public class Oper3 {
	public static void main(String[] args) {
//		����ڿ��� Ű�� �Է¹ް�
//		������� ������ ���
//		�Ǽ���� �Ǽ��� ���
//		��) 183 -> 183 ���
//			183.5 -> 183.5 ���
//		���� �����ڸ� ���!
		// 1��°
//		double num = 0;	// �Է��� ���� ����. �Է¹��� ���� ������ ���� �Ǽ��� ����
//		boolean tof = false;	// ����/�Ǽ� ���θ� ������ ����
//		String result = null;	// ���Ĺ��ڸ� �����ϴ�, ����� ���ڿ� �޽����� ���� ����
//		
//		Scanner sc = new Scanner(System.in);	// ��ĳ�� ����
////		�Է� �ȳ��� ���� �޽��� ���
//		System.out.println("����/�Ǽ� �Ǻ����Դϴ�.\n���ڸ� �Է����ּ���.");
//		System.out.print("�Է� : ");
//		num = sc.nextDouble();	// �Է°��� ������ ����.
//		
//		tof = num - (int)num == 0;	// '�Ǽ� - ����'�� ���� 0�̶�� true�� ������ num�� ������� �� �� �� ����.
//		result = tof ? "�ᱣ��(����) : %.0f" : "�ᱣ��(�Ǽ�) : %.1f";	// �� ���ǽ��� ����� ���ǿ� ���� ���Ĺ��ڸ� �ٸ��� ����
//		
//		System.out.printf(result, num);
////		System.out.printf(result, tof ? (int)num : num);	// ������ %f�� ����� �Ǽ��̹Ƿ� �Ķ���Ϳ����� ���׿����ڸ� ����� �ʿ䰡 ����.

//		����
//      ����ڿ��� Ű�� �Է¹ް�
//      ������� ������ ���
//      �Ǽ���� �Ǽ��� ���
//      ��)   183 -> 183 ���
//         183.5 -> 183.5 ���
//      ���� �����ڸ� ���!

//      ��Ʈ!
//      �������� Ǯ�� ����
//      ���Ĺ��ڷ� Ǯ�� �� ����
//      double height = 0.0;
//      String message = "Ű: ";
//      Scanner sc = new Scanner(System.in);
//      boolean check = false;
//      String format = null;
//      String forLength = "";
//      int length = 0;
//      
//      System.out.print(message);
//      height = sc.nextDouble();
//      check = height - (int)height == 0;
//      forLength = height - (int)height + "";
//      
//      length = forLength.length() > 6 ? 8 : forLength.length();
//      
//      format = check ? "%.0fcm" : "%." + (length - 2) + "fcm";
//      System.out.printf(format, height); 

//		����+
//      ����ڿ��� Ű�� �Է¹ް�
//      ������� ������ ���
//      �Ǽ���� �Ǽ��� ���
//      ��)   183 -> 183 ���
//         183.5 -> 183.5 ���
//      ���� �����ڸ� ���!

//      ��Ʈ!
//      �������� Ǯ�� ����
//      ���Ĺ��ڷ� Ǯ�� �� ����
		double height = 0.0;
		String message = "Ű: ";
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		String format = null;
		String forLength = "";
		int afterDotLength = 0;
		int length = 0;

		System.out.print(message);
		height = sc.nextDouble();
		check = height - (int) height == 0;
		forLength = height - (int) height + "";

		length = forLength.length() - 2;
		length =  length >= 6 ? 6 : length;
		format = check ? "%.0fcm" : "%." + length + "fcm";
		System.out.printf(format, height);

		// ���ο� �� �ڵ�
//      key > 0 ? ��� : ����
//      ��� -> �Ǽ� > ����
//      ���� -> �Ǽ� < ����
//      key > 0 ? ���(�Ǽ� > ���� ? �Ǽ� : ����) : ����(�Ǽ� < ���� ? �Ǽ� : ����)
//      String.valueOf

//      result = key > 0 ? 
//            key > (int)key ? key : (int)key 
//                  : key < (int)key ? key : (int)key;
		// �õ��غ����� �����
//		result = "" + (num > 0 ? (num > (int)num ? num : (int)num) : (num < (int)num ? num : (int)num));
//		result = num > 0 ? (num > (int)num ? "%.0f" : "%.0f") : (num < (int)num ? "%.0f" : "%.0f");
//		System.out.printf(result, num > 0 ? /*���*/ (num > (int)num ? /**/num : (int)num)
//				: /*����*/(num < (int)num ? num : (int)num));

	}
}