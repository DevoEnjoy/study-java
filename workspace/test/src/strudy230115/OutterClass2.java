package strudy230115;

public class OutterClass2 {
	private static int seq = 0;
	private String name;
	private int memberNumber;
	private int phoneNumber;

	static {
		seq++;
	}
	{
		setMemberNumber(seq);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

}
