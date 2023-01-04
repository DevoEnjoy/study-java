package classTest;

class SuperCar {
//	브랜드, 색상, 가격
	String brand;
	String color;
	int price;

	String password;
	int wrongInput;

//	엔진 상태
	boolean engineStatus;

	{
//		engineStatus = false;
		password = "1324";
		wrongInput = 0;
	}

//	생성자
	SuperCar(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	시동켜기
	boolean engineStart() {
		engineStatus = engineStatus ? false : true;
		return engineStatus;
	}

	boolean engineStop() {
		engineStatus = engineStatus ? true : false;
		return engineStatus;
	}

	void turnOn() {
//	엔진 상태를 확인하고
//		if (this.engineStatus == false) {
		if (!this.engineStatus) {
//	시동이 꺼져있다면, "시동 켜기" 출력
			this.engineStatus = true;
			System.out.println("시동 켜기");
//		} else if (this.engineStatus == true) {
		} else {
//	이미 시동이 켜져있다면, "이미 시동이 켜져 있습니다" 출력
			System.out.println("이미 시동이 켜져 있습니다");
		}
	}

//	시동끄기
	void turnOff() {
//		엔진 상태를 확인하고
//		if (this.engineStatus == true) {
		if (this.engineStatus) {
//		시동이 켜져있다면, "시동 끄기" 출력
			this.engineStatus = false;
			System.out.println("시동 끄기");
//		} else if (this.engineStatus == false) {
		} else {
//		이미 시동이 꺼져있다면, "이미 시동이 꺼져 있습니다" 출력
			System.out.println("이미 시동이 꺼져 있습니다");
		}
	}

//	시동을 켜기 위해서 비밀번호 4자리를 입력받아야 한다.
//	3번 연속 잘못 입력했을 시 "경찰 출동" 출력
//	문자열 비교는 ==이 아닌 equals()로 비교한다.

	
	
	
//	boolean engineStartByPw(String password) {
//		while (wrongInput < 3) {
//			if (password.equals(this.password)) {
//				turnOn();
//				return true;
//			} else {
//				wrongInput++;
//				return false;
//			}
//		}
//		System.out.println("경찰 출동");
//		wrongInput = 0;
//		return false;
//
//	}

}

public class ClassTask1 {
	public static void main(String[] args) {
		SuperCar sc = new SuperCar("BENZ", "Black", 300);
		
		
		
		
		
//		sc.engineStartByPw("1324");
//		System.out.println(sc.wrongInput);
//		sc.engineStartByPw("1342");
//		System.out.println(sc.wrongInput);
//		sc.engineStartByPw("1344");
//		System.out.println(sc.wrongInput);
//		sc.engineStartByPw("1333");
//		System.out.println(sc.wrongInput);
//		sc.engineStartByPw("1333");
//		System.out.println(sc.wrongInput);
//		sc.engineStartByPw("1324");
//		System.out.println(sc.wrongInput);

	}
}
