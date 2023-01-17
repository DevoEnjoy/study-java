package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestRefactored {
	{	//	문제 설명
		//	제한시간 : 1시간
		//	3개의 쓰레드가 있다.
		//	Thread1, Thread2, Thread3
		//	사용자가 입력한 순서대로 각 알맞는 문자열이 출력된다.
	
		//	입력 예) 3 1 2
		//	출력 예) third first second
		
		//	단, Thread들은 항상 1, 2, 3 순서로 실행되어야 한다.
		
		//	Thread1 : third
		//	Thread2 : first
		//	Thread3 : second
	
	// 출력 시 쓰레드의 번호도 출력할 경우 가산점으로 처리한다.
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;	// 입력을 받을 변수

		// 인덱스로 접근하기 위한 ArrayList
		ArrayList<ThreadTaskRefactored> arListThread = new ArrayList<ThreadTaskRefactored>(Arrays.asList(
				new ThreadTaskRefactored(), // 새로운 객체를 세 개 담아둔다.
				new ThreadTaskRefactored(),
				new ThreadTaskRefactored()
				));
		
		for (int i = 0; i < arListThread.size(); i++) {
			arListThread.get(i).setName("Thread" + (i + 1));	// 	각 쓰레드 이름 배정
//			System.out.println(arListThread.get(i).getName());	//	각 쓰레드 이름 확인
			arListThread.get(i).start();	//	모든 쓰레드 순서대로 start(전원켜기?)
			//	start 한 것만으로는 실행되는 게 없음(아래 for문에서 print***를 실행)
		}
		
		System.out.print("입력: ");	// 띄어쓰기로 구분하여 입력
		for (ThreadTaskRefactored t : arListThread) {	// ArrayList의 사이즈 만큼 반복
			input = sc.nextInt();	//	입력은 반복횟수만큼 받음

			try {t.join();} catch (InterruptedException e) {;}//	해당 쓰레드에 우선순위 부여
			
			switch (input) {	//	입력한 값(1~3)에 따라 출력을 다르게 함
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
