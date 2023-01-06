package myBank;

public class Shinhan extends Bank {
	
	static int indexSeq;
	

	public Shinhan() {
		super();
	}

	public Shinhan(String name, String phoneNumber, String pw) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setPw(pw);
		this.setMemberNumber(super.getSeq());
	}

	@Override
	void withdraw(int withdrawMoney) {
		this.setBalance(this.getBalance() + (int) (withdrawMoney / 2.0));
	}

	public static int getIndexSeq() {
		return indexSeq;
	}

	public static void setIndexSeq(int indexSeq) {
		Shinhan.indexSeq = indexSeq;
	}
	

}
