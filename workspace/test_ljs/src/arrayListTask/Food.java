package arrayListTask;

public class Food {
//	음식 정보를 담을 클래스 선언(Food)
//	- 음식 이름
//	- 음식 가격
//	- 음식 종류(한식, 중식, 일식, 양식)
	private String name;
	private int price;
	private String kind;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
