package arrayListTask;

//		과일 정보를 담을 클래스 선언(Fruit)
//			- 과일 이름(중복 없음)
//			- 과일 가격

public class Fruit {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[과일명 =" + name + ", 과일가격=" + price + "]";
	}
	
	
}
