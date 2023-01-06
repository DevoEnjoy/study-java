package myCastingTest;

class Car {
//	String brand;
//	String color;
//	int price;

	void engineStart() {
		System.out.println("¿­¼è·Î ½Ãµ¿ ÄÔ");
	}

}

class SuperCar extends Car {
	@Override
	void engineStart() {
//		super.engineStart();
		System.out.println("À½¼ºÀ¸·Î ½Ãµ¿ ÄÔ");
	}
	
	void openRoof() {
		System.out.println("ÁöºØ ¿­±â");
	}
}

public class CastingTest {
	public static void main(String[] args) {
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
//		up casting
		Car noOptionFerrari = new SuperCar();
		noOptionFerrari.engineStart();
		
//		ºôµå ¿À·ù
//		SuperCar brokenFerrari = (SuperCar)new Car();
		
//		down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		
		
	}
}
