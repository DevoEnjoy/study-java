package myBank;

public class Kookmin extends Bank {

	static int indexSeq;
	
	static {
		indexSeq++;
	}
	
	public Kookmin() {;}
	
	public Kookmin(String name, String phoneNumber, String pw) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setPw(pw);
		this.setMemberNumber(super.getSeq());
	}

	
	@Override
	void deposit(int depositMoney) {
		this.setBalance(this.getBalance() - (int)(depositMoney / 2.0));
	}
	
	public static int getIndexSeq() {
		return indexSeq;
	}

	public static void setIndexSeq(int indexSeq) {
		Shinhan.indexSeq = indexSeq;
	}
}
