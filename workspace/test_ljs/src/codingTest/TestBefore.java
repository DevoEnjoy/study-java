package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestBefore {
	{	//	���� ����
		//	���ѽð� : 1�ð�
		//	3���� �����尡 �ִ�.
		//	Thread1, Thread2, Thread3
		//	����ڰ� �Է��� ������� �� �˸´� ���ڿ��� ��µȴ�.
	
		//	�Է� ��) 3 1 2
		//	��� ��) third first second
		
		//	��, Thread���� �׻� 1, 2, 3 ������ ����Ǿ�� �Ѵ�.
		
		//	Thread1 : third
		//	Thread2 : first
		//	Thread3 : second
	
	// ��� �� �������� ��ȣ�� ����� ��� ���������� ó���Ѵ�.
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;	// �Է��� ���� ����

		// �ε����� �����ϱ� ���� ArrayList
		ArrayList<ThreadTaskBefore> arListThread = new ArrayList<ThreadTaskBefore>(Arrays.asList(
				new ThreadTaskBefore(), // ���ο� ��ü�� �� �� ��Ƶд�.
				new ThreadTaskBefore(),
				new ThreadTaskBefore()
				));

		System.out.print("�Է�: ");	// ����� �����Ͽ� �Է�

		// ArrayList�� ������ ��ŭ �ݺ�
		for (int i = 0; i < arListThread.size(); i++) {
			input = sc.nextInt();	//	�Է��� �ݺ�Ƚ����ŭ ����
			ThreadTaskBefore t = arListThread.get(i);	//	ArrayList���� ���������� i��° �濡 �����Ͽ� t�� ����
			t.setName("Thread" + (i + 1));	//	�� �������� �̸��� ������(for�� �ۿ��� �ص� ����)
			t.start();	//	�ش� ������ �۵�
			try {t.join();} catch (InterruptedException e) {;}//	�ش� �����忡 �켱���� �ο�
			switch (input) {	//	�Է��� ��(1~3)�� ���� ����� �ٸ��� ��
			case 1:
				t.printFirst(() -> {System.out.println("first");});
				break;
			case 2:
				t.printSecond(() -> {System.out.println("second");});
				break;
			case 3:
				t.printThird(() -> {System.out.println("third");});
				break;
			}
		}
		sc.close();

	}
}
