package arrayListTask3;

public class Page {
	public static void main(String[] args) {
		Love p1 = new Love();
		p1.setAge(24);
		p1.setName("한동석");
		p1.setPhoneNumber("01077287518");
		Love p2 = new Love();
		p2.setAge(29);
		p2.setName("이순신");
		p2.setPhoneNumber("01077287519");
		Love p3 = new Love();
		p3.setAge(33);
		p3.setName("장보고");
		p3.setPhoneNumber("01077287519");
		
//		DateApp.register("", null, 0);
		
		DBConnector.people.add(p1);
		DBConnector.people.add(p3);
		DBConnector.people.add(p2);

		for (Love love : DBConnector.people) {
			System.out.println(love.getAge());
			System.out.println(love.getName());
			System.out.println(love.getPhoneNumber());
		}

		System.out.println("정렬");

		DBConnector.people = DateApp.orderByAge();

		for (Love love : DBConnector.people) {
			System.out.println(love.getAge());
			System.out.println(love.getName());
			System.out.println(love.getPhoneNumber());
		}
	}
}
