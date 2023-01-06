package myBank;

public class Kakao extends Bank {
	
	static int indexSeq;
	
	static {
		indexSeq++;
	}
	
	
	public Kakao() {;}
	
	public Kakao(String name, String phoneNumber, String pw) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setPw(pw);
		this.setAccount(this.makeAccount());
		this.setMemberNumber(super.getSeq());
	}

	
	@Override
	public int getBalance() {
		return (int)(super.getBalance() / 2.0);
	}
	
	public static int getIndexSeq() {
		return indexSeq;
	}

	public static void setIndexSeq(int indexSeq) {
		Shinhan.indexSeq = indexSeq;
	}
}
