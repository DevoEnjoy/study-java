package classTest;

class Company {
//	static Long sequence;
//	static Long total;
//	
//	Long id;
//	String name;
//	Long salary;
//	int income;
//
//	static {
//		sequence = 0L;
//	}
//	{
//		id = ++sequence ; // 초기화 블록	// this생략가능
//	}
//
//	public Company(String name, Long salary) {
//		this.name = name;
//		this.salary = salary;
//	}
//
//	void printMyData() {
//		System.out.println(id + ", " + name + ", 연" + salary + "만원");
//	}

	static int sequence;
	static int total;
	int id;
	String name;
	int income;

//	초기화 블록
//	생성자가 호출될 때마다 실행
	{
		id = ++sequence;
	}

}

public class Market {
	public static void main(String[] args) {
		String[] name1 = { "한동석", "이순신", "홍길동", "장보고" };
//		Company 홍길동 = new Company("홍길동", 4000L);
//
//		System.out.println(홍길동.id);
//		
//		홍길동.printMyData();
//		
//		Company.total += 홍길동.income = 1000;

	}
}
