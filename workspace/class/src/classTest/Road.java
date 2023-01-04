package classTest;


class Car{
//	브랜드
	String brand;
//	색상
	String color;
//	가격
	int price;
	
	Car(String brand, String color, int price){
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
//	시동켜기(브랜드 시동 켜기)
	void turnOn() {
		System.out.printf("%s 시동 켜기\n", this.brand);
	}
	
	
//	시동끄기(브랜드 시동 끄기)
	void turnOff() {
		System.out.printf("%s 시동 끄기\n", this.brand);
	}
}

public class Road {
	public static void main(String[] args) {
		SuperCar kia = new SuperCar("KIA", "black", 30000000);
		kia.turnOn();
		kia.turnOff();
		
		
		
		
		
	}
}
