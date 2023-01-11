package arrayListTask2;

import java.util.ArrayList;

public class Restaurant {
//CRUD 관련 기능을 담아놓을 클래스 선언(Restaurant)
//	- 음식 추가 
//	- 음식 이름으로 음식 종류 조회
//	- 사용자가 원하는 종류의 음식 전체 조회
//	- 음식 종류 수정 후 가격 10% 상승
//	- 사용자가 원하는 종류의 음식 개수 조회
	public static ArrayList<Food> foods = DBConnector.foods;

//	- 음식 추가 
	public void add(Food food) {
		foods.add(food);
	}

//	- 음식 이름으로 음식 종류 조회
	public String findKindByName(String name) {
		return findByName(name).getKind();
	}

//	음식 이름으로 음식 조회
	public Food findByName(String name) {

		for (Food food : foods) {
			if (food.getName().equals(name)) {
				return food;
			}
		}
		return null;
	}

//	- 사용자가 원하는 종류의 음식 전체 조회
	public ArrayList<Food> findAllByKind(String kind) {
		ArrayList<Food> arListResult = null;
		for (Food food : foods) {
			if (food.getKind().equals(kind)) {
				arListResult.add(food);
			}
		}
		return arListResult;

	}
	
//	오버로딩 적극 활용

//	- 음식 종류 수정 후 가격 10% 상승(이미 수정된 Food 객체를 받음)
	public void modifyKindAndPrice(Food modedFood) {
		modifyKind(modedFood, modedFood.getKind());
		modifyPrice(modedFood, (int) (modedFood.getPrice() * (100 + 10) / 100));
	}

//	Food 객체에 바꾸고자 하는 음식 종류를 kind 매개변수로 받아 수정함.
	public void modifyKindAndPrice(Food food, String kind) {
		modifyKind(food, kind);
		modifyPrice(food, (int) (food.getPrice() * 1.1));
	}

//	Food 객체의 음식종류를 바꾸고 변경하고자 하는 배율로 가격 변경(20%할인은 0.8 입력)
	public void modifyKindAndPrice(Food food, String kind, double changeRatePrice) {
		modifyKind(food, kind);
		modifyPrice(food, changeRatePrice);
	}

//	Food 객체의 가격을 특정 금액으로 변경(ex 3000)
	public void modifyKindAndPrice(Food modedFood, int newPrice) {
		modifyKind(modedFood, modedFood.getKind());
		modifyPrice(modedFood, newPrice);
	}

//	Food 객체의 음식 종류를 수정하고 특정 금액으로 가격 변경(ex 3000)
	public void modifyKindAndPrice(Food modedFood, String newKind, int newPrice) {
		modifyKind(modedFood, modedFood.getKind());
		modifyPrice(modedFood, newPrice);
	}

	// 음식 종류 수정(이미 음식 종류가 수정된 객체 가져옴)
	public void modifyKind(Food modifiedFood) {
		findByName(modifiedFood.getName()).setName(modifiedFood.getKind());
	}

	// 음식 종류 수정(기존 객체와 새로운 종류 입력)
	public void modifyKind(Food existedFood, String newFind) {
		findByName(existedFood.getName()).setKind(newFind);
	}

	// 음식 가격 수정(이미 수정된 객체 가져옴)
	public void modifyPrice(Food modifiedFood) {
		findByName(modifiedFood.getName()).setPrice(modifiedFood.getPrice());
	}

	// 음식 가격 수정(기존 객체와 새로운 가격(ex 3000) 입력)
	public void modifyPrice(Food existedFood, int newPrice) {
		findByName(existedFood.getName()).setPrice(newPrice);
	}

	// 음식 가격 수정(기존 객체와 곱할 배수 입력)
	public void modifyPrice(Food existedFood, double multiplyPrice) {
		findByName(existedFood.getName()).setPrice((int) (existedFood.getPrice() * multiplyPrice));
	}

//	- 사용자가 원하는 종류의 음식 개수 조회
	public int getCountByKind(String kind) {
		return findAllByKind(kind).size();
	}

}
