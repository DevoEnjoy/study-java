package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestRefactored {
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
		ArrayList<ThreadTaskRefactored> arListThread = new ArrayList<ThreadTaskRefactored>(Arrays.asList(
				new ThreadTaskRefactored(), // ���ο� ��ü�� �� �� ��Ƶд�.
				new ThreadTaskRefactored(),
				new ThreadTaskRefactored()
				));
		
		for (int i = 0; i < arListThread.size(); i++) {
			arListThread.get(i).setName("Thread" + (i + 1));	// 	�� ������ �̸� ����
//			System.out.println(arListThread.get(i).getName());	//	�� ������ �̸� Ȯ��
			arListThread.get(i).start();	//	��� ������ ������� start(�����ѱ�?)
			//	start �� �͸����δ� ����Ǵ� �� ����(�Ʒ� for������ print***�� ����)
		}
		
		System.out.print("�Է�: ");	// ����� �����Ͽ� �Է�
		for (ThreadTaskRefactored t : arListThread) {	// ArrayList�� ������ ��ŭ �ݺ�
			input = sc.nextInt();	//	�Է��� �ݺ�Ƚ����ŭ ����

			try {t.join();} catch (InterruptedException e) {;}//	�ش� �����忡 �켱���� �ο�
			
			switch (input) {	//	�Է��� ��(1~3)�� ���� ����� �ٸ��� ��
			case 1:
				t.printFirst(() -> {System.out.println(t.getName() + " : first");});
				break;
			case 2:
				t.printSecond(() -> {System.out.println(t.getName() + " : second");});
				break;
			case 3:
				t.printThird(() -> {System.out.println(t.getName() + " : third");});
				break;
			}
		}
		sc.close();

	}
}
