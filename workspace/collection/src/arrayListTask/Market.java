package arrayListTask;

import java.util.ArrayList;

/*
 * CRUD 관련 기능을 담아놓을 클래스 선언(Market)
	- 과일 추가
	- 과일 삭제
	- 과일 가격이 평균 가격보다 낮은지 검사
	- 과일 전체 조회
	- 과일 이름으로 가격 조회
*/
public class Market {
	public static ArrayList<Fruit> fruits = DBConnector.fruit;
	
	// 과일명 중복검사
//	public Fruit checkFruit(String name) {
//		
//		for(Fruit fruit:fruitDB)
//			
//	}
	
//	과일 이름으로 조회
	public Fruit checkFruit(String name) {
		for(Fruit fruit:fruits) {
			if(fruit.getName().equals(name)) {
				return fruit;
			}
		}
		return null;
	}
	
//	- 과일 추가
	public void add(Fruit fruit) {
		fruits.add(fruit);
	}
	
//	- 과일 삭제
	public void remove(String name) {
		for(Fruit fruit:fruits) {
			if(fruit.getName().equals(name)) {
				fruits.remove(fruit);
			}
		}
	}
	
	// 과일 가격 평균 계산
	public double checkAvg() {
		double sum = 0;
		for (Fruit fruits:fruits) {sum += fruits.getPrice();}
		return sum / fruits.size();
	}
	
//	- 과일 가격이 평균 가격보다 낮은지 검사
	public boolean checkAvgBelowByPrice(int price) {
		return price < checkAvg();
	}
//	- 과일 전체 조회
	public ArrayList<Fruit> selectAll(){
		return fruits;
	}
	
	
//	- 과일 이름으로 가격 조회
	public int findByName(String name) {
		return checkFruit(name).getPrice();
		
	}
	
}
