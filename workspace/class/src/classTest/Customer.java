package classTest;

public class Customer {
	/*
	 * 손님 클래스 이름 휴대폰 번호 통장잔고 할인율
	 */

	private String name;
	private String mobile;
	private int balance;
	private double discountRate;

	{
		balance = 0;
		discountRate = 1.0;
	}

//	생성자
	public Customer() {;}
	
	public Customer(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}

	public void addBalance(int money) {
		setBalance(getBalance() + money);
	}

	public void buyStuff(Shop shop) {
		shop.setPrice((int)(shop.getPrice() * (1 - this.discountRate)));
		if (this.balance >= shop.getPrice() && shop.getStock() >= 1) {
			this.balance = balance - shop.getPrice();
			shop.setStock(shop.getStock() - 1);
		}
	}

	public void checkBalance() {
		System.out.println("현재 잔고: " + getBalance());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public static void main(String[] args) {
		Customer customer = new Customer("홍길동", "01077287518");
		Shop doll = new Shop("인형", 3000);
		customer.addBalance(1000);
		customer.addBalance(1000);
		customer.addBalance(1000);
		customer.addBalance(1000);
		System.out.println(customer.getBalance());
		;
		System.out.println("===========");
		customer.buyStuff(doll);
		System.out.println("인형(3000) 구매");
		System.out.println(customer.getBalance());
		System.out.println("===========");
		customer.setDiscountRate(0.5);
		System.out.println("50%D.C.");
		customer.addBalance(5000);
		System.out.println("5000원 충전");
//		System.out.println("현재 잔고: "+ customer.getBalance());
		customer.checkBalance();

		customer.buyStuff(doll);
		System.out.println("인형(3000원) 구매");
		System.out.println("현재 잔고: " + customer.getBalance());

	}

}
