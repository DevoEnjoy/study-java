package classTest;

public class Shop {
	/*
	 * 상점 클래스 상품명 상품가격 재고
	 */

	private String stuff;
	private int price;
	private int stock;
	{
		this.price = 1_000;
		this.stock = 10;
	}

	public Shop(String stuff, int price) {
		this.stuff = stuff;
		this.price = price;
//		this.stock = stock;
	}
	
	public Shop(String stuff, int price, int stock) {
		this.stuff = stuff;
		this.price = price;
		this.stock = stock;
	}
	
	void sell(Customer customer) {
		stock--;
		customer.getBalance();
	}

	public String getStuff() {
		return stuff;
	}

	public void setStuff(String stuff) {
		this.stuff = stuff;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
