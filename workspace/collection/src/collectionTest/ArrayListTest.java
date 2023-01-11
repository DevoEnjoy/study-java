package collectionTest;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
//		<?> : 제네릭(이름이 없는)
//		객체화 시 타입을 지정하는 기법
//		설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용한다.
//		따로 다운 캐스팅을 할 필요가 없으며, 지정할 타입에 제한을 줄 수 있다.

		ArrayList<Integer> datas = new ArrayList<Integer>();
		final int SIZE = 9;

//		C
		for (int i = 0; i < SIZE; i++) {
			if (i > 4) {
				datas.add((14 - i) * 10);
				System.out.println(datas.size());
				continue;
			}
			datas.add((i + 1) * 10);
			System.out.println(datas.size());
		}

////		R
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}
//
//		Collections.sort(datas);
////		Collections.reverse(datas);
//
////		R
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}

//		Collections.shuffle(datas);

////		R
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}

//		추가(삽입)
//		50 뒤에 500 삽입
		if (datas.contains(50)) {
			datas.add(datas.indexOf(50) + 1, 500);
		}

		System.out.println(datas);
		System.out.println("\n=======500추가완료=========\n\n");
//		수정
//		90을 9로 수정

//		if (datas.contains(90)) {
//			datas.set(datas.indexOf(90), 9);
//			System.out.println(datas);
//			System.out.println("9 수정 완료\n");
//		}

		if (datas.contains(90)) {
			int index = 0;
			index = datas.indexOf(90);
			datas.remove(index);
			datas.add(index, 9);
			System.out.println(datas);
			System.out.println("9 수정 완료\n");
		}

//		삭제
//		80 삭제
////		1. 인덱스로 삭제
//		if (datas.contains(80)) {
//			datas.remove(datas.indexOf(80));
//		}
////		2. 값으로 삭제
//		if (datas.remove(Integer.valueOf(80))) {
//		}
//		Object index80 = 80;
//		if (datas.remove((Object)80)) {}
		if (datas.remove((Integer)80)) {System.out.println("성공");}
		System.out.println("\n80 삭제 완료\n");

		System.out.println(datas);
		
//		빠른 for문(forEach, 향상된 for문)
//		for(자료형 변수명 : 순서가 있는 무언가)
		for(Integer data: datas) {
			System.out.println(data);
		}
		
		for(int data: datas) {
			System.out.println(data);
		}
		
		
	}
}
