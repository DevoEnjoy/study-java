package arrayListTask3;

import java.util.ArrayList;
import java.util.Collections;

public class DateApp {

//	  CRUD 관련 기능을 담아놓을 클래스 선언(DateApp)
//		  - 사용자가 원하는 나이의 이상형 목록 조회 
//		  - 이상형의 나이 수정
//		  - 이상형 나이 순 정렬
	public static ArrayList<Love> peopleDB = DBConnector.people;

	public static Love register(String name, String phoneNumber, int age) {
		Love result = new Love();
		result.setAge(age);
		result.setName(name);
		result.setPhoneNumber(phoneNumber);
		return result;
	}
	
	
	// 특정 나이 목록 조회
//	  - 사용자가 원하는 나이의 이상형 목록 조회 
	public ArrayList<Love> findAllByAge(int age) {
		ArrayList<Love> arListResult = new ArrayList<Love>();
		for (Love love : peopleDB) {
			if (love.getAge() == age) {
				arListResult.add(love);
			}
		}
		return arListResult;
	}

//	  - 이상형의 나이 수정
	public void modifyAge(Love person) {
		Love findedByName = null;
		findedByName = findByName(person.getName());
		if (findedByName != null) {
			findedByName.setAge(person.getAge());
		}
	}

	// 이름으로 정보 조회(이름 중복 검사)
	public Love findByName(String name) {
		for (Love love : peopleDB) {
			if (love.getName().equals(name)) {
				return love;
			}
		}
		return null;
	}

//	  - 이상형 나이 순 정렬
	public static ArrayList<Love> orderByAge() {
		ArrayList<Love> arListResult = new ArrayList<Love>();

		for (Integer age : findAllOrderByAge()) {
			System.out.println(age);
			for (Love love : peopleDB) {
				if ((int)love.getAge() == (int)age) {
					arListResult.add(love);
					System.out.println("추가 완료");
				}
			}
		}
		DBConnector.people = arListResult;
		return arListResult;
	}

	public static int findMaxAgeOne() {
		int result = 0;
		for (Love love : peopleDB) {
			if (love.getAge() >= result) {
				result = love.getAge();
			}
		}
		return result;
	}

	public static int findMinAgeOne() {
		int result = 100;
		for (Love love : peopleDB) {
			if (love.getAge() <= result) {
				result = love.getAge();
			}
		}
		return result;
	}

	public static ArrayList<Integer> findAllOrderByAge() {
		ArrayList<Integer> arListResult = new ArrayList<Integer>();

		for (Love love : peopleDB) {
			arListResult.add(Integer.valueOf(love.getAge()));
		}
		Collections.sort(arListResult);
		return arListResult;
	}

}
