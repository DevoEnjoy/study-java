package inheritanceTest;

class A {
	String name = "A";
	int data = 10;

	void printName() {
		System.out.println(data);
	}
}

class B extends A {

	public B() {
		super();
	}

	void printData() {
		System.out.println(data);
	}
}

class Human {
	void eat() {
		System.out.println("먹기");
	}

	void sleep() {
		System.out.println("잠자기");
	}

	void walk() {
		System.out.println("두발걷기");
	}

}

class Monkey extends Human {
	void shakeTail() {
		System.out.println("꼬리 치기");
	}

	void walk() {
		System.out.println("두 발 또는 네 발로 걷기");
	}

}

public class InheritanceTest1 {

	public static void main(String[] args) {
		Monkey monkey = new Monkey();
		
	}
}
