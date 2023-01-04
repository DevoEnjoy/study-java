package classTest;

class A {
	int data;
	
	A(int data){
		System.out.println("기본 생성자");
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}

}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(20);
		System.out.println(a);	
		System.out.println(a.data);
//		a.data = 20;
		a.printData();
	}
	
}
