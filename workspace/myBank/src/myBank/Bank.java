package myBank;

import java.util.Random;
import java.util.Scanner;

public class Bank {
	Random r = new Random();
//				회원번호 시퀀스
	private static int seq = 0;

//	[종합 실습]
//			은행
//				예금주
	private String name;

//				회원번호
	private int memberNumber;

//				계좌번호(중복 없음)
	private String account;

//				핸드폰번호(중복 없음)
	private String phoneNumber;

//				비밀번호
	private String pw;

//				통장잔고
	private int balance;

	static {
		seq++;
	}

	public Bank() {
		;
	}

	public Bank(String name, String phoneNumber, String pw) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.pw = pw;
		this.memberNumber = Bank.getSeq();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	// 잔액조회(String account)
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public static int getSeq() {
		return seq;
	}

//	계좌개설

//	입금 기능(int depositMoney)
	void deposit(int depositMoney) {
		this.balance += depositMoney;
	}

//	출금 기능(int depositMoney)
	void withdraw(int withdrawMoney) {
		this.balance -= withdrawMoney;
	}

//	계좌개설(String name, String phoneNumber)
//	계좌번호는 따로 생성
//	중복검사(), this.name = name, this.phineNumber = phoneNumber
	boolean signin(String name, String password, String phoneNumber) {
		if (this.name == name || this.phoneNumber == phoneNumber) {
			return false;
		} else {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.pw = password;
			return true;
		}

	}

//	계좌 랜덤 개설(6자리)
	String makeAccount() {
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += r.nextInt(10);
		}
		return result;
	}

////	계좌 랜덤 개설
//	String makeAccountRandom(int end) {
//		// 은행마다 계좌번호의 길이가 다르므로
//		// 계좌번호의 길이를 매개변수로 받음.
//
//		String result = "";
//
//		for (int i = 0; i < end; i++) {
//			result += r.nextInt(10);
//		}
//
//		return result;
//
//	}

//	계좌번호 중복검사
	boolean checkAccount(String account) {
		if (this.account.equals(account)) {
			return true;
		}
		return false;
	}

//	로그인
	boolean login(String account, String password) {
		if (this.account == account && this.pw == password) {
			return true;
		}
		return false;
	}

//	비밀번호만 입력하여 로그인
	boolean login(String password) {
		if (this.pw == password) {
			return true;
		}
		return false;
	}

//	핸드폰 번호 중복 검사
//	이미 있으면 true 없으면 false
	static boolean isTherePhoneNumber(Bank[] arBank, String phoneNum) {
		for (int i = 0; i < arBank.length; i++) {
			if (arBank[i] == null) {
				return false;
			}
			if (arBank[i].getPhoneNumber().equals(phoneNum)) {
				return true;
			}
		}
		return false;
//		if(this.phoneNumber == phoneNumber) {
//			return true;
//		}
//		return false;
	}

//	계좌번호 찾기(String phoneNumber)
	String forgotAccount(String phoneNumber) {
		if (this.phoneNumber == phoneNumber) {
			return this.account;
		}
		return null;
	}

////	비밀번호 재설정(Bank bank, String newPw)
//	boolean newPassword(String account, String , String newPw) {
//		if(this.pw == bank.pw) {
//			this.pw = newPw;
//		}
//		return false;
//	}
	static String combinateArToMenu(String[] ar) {
		String result = "";
		for (int i = 0; i < ar.length; i++) {
			result += i + ar[i] + "\n";
		}
		return result;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", memberNumber=" + memberNumber + ", account=" + account + ", phoneNumber="
				+ phoneNumber + ", pw=" + pw + ", balance=" + balance + "]";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Shinhan[] arShinhans = new Shinhan[100];
		Kookmin[] arKookmins = new Kookmin[100];
		Kakao[] arKakaos = new Kakao[100];
		Bank[][] customers = new Bank[3][100];
		int[] arUserCount = new int[3];
		final int SHINHAN = 0;
		final int KOOKMIN = 1;
		final int KAKAO = 2;
		Bank customer = null;
		customers[0] = arShinhans;
		customers[1] = arKookmins;
		customers[2] = arKakaos;
		String welcomeList = "", mainMenu = "", forgotMenu = "";
		String[] arWelcome = { "종료", "사용자 등록", "로그인", "계좌번호 찾기" };
		String[] arMainList = { "로그아웃", "입금하기", "출금하기", "잔액조회", "계좌번호 찾기" };
		String[] arForgot = { "핸드폰 번호로 계좌 찾기", "계좌 새로 발급" };
		String plzInput = "입력 : ", inputErrMsg = "잘못 입력하셨습니다.", plzReinputMsg = "다시 입력해주시기 바랍니다.";
		String tempStr = "", exitMsg = "프로그램을 종료합니다.", alreadyExistErrMsg = "이미 존재하는 핸드폰 번호입니다.";
		String signupWelcome = "회원가입 페이지입니다.";
		int choice = 0;
		boolean whileFlag = false;
		String chooseBankMsg = "가입하실 은행을 골라주세요.\n";
		String[] arBanks = { "나가기", "신한은행", "국민은행", "카카오뱅크" };
		String name = "", phoneNum = "", pw1 = "", pw2 = "";
		String signupMsgName = "사용자 이름을 입력해주세요.", signupMsgPhoneNum = "유효한 핸드폰 번호를 입력해주세요(중복가입 불가)",
				signupPw1 = "비밀번호를 입력해주세요.", signupPw2 = "비밀번호를 다시 입력해주세요.";
		String loginErrMsg = "로그인 실패", backToMainMsg = "메인메뉴로 이동합니다.";

		welcomeList = Bank.combinateArToMenu(arWelcome);
		mainMenu = Bank.combinateArToMenu(arMainList);
		forgotMenu = Bank.combinateArToMenu(arForgot);
		chooseBankMsg += Bank.combinateArToMenu(arBanks);

//		for (int i = 0; i < customers.length; i++) {
//			switch (i) {
//			case 1:
//				for (int j = 0; j < customers[i].length; j++) {
//					Shinhan[] shinhans = new Shinhan[j];
//					customers[i][j] = shinhans[j];
//				}
//				break;
//
//			case 2:
//				for (int j = 0; j < customers[i].length; j++) {
//					Kukmin[] kukmins = new Kukmin[j];
//					customers[i][j] = kookmins[j];
//				}
//				break;
//
//			case 3:
//				for (int j = 0; j < customers[i].length; j++) {
//					Kakao[] kakaos = new Kakao[j];
//					customers[i][j] = kakaos[j];
//				}
//				break;
//
//			}
//		}

		while (true) {
			whileFlag = false;
			System.out.println(welcomeList);
			System.out.print(plzInput);
			tempStr = sc.next();
			choice = Integer.parseInt(tempStr);
			switch (choice) {
			case 0: // 프로그램 종료
				whileFlag = true;
				break;
			case 1: // 사용자 등록(가입)
				choice = 0;
				name = "";
				phoneNum = "";
				pw1 = "";
				pw2 = "";
				System.out.println(signupWelcome);
				System.out.println(chooseBankMsg);
				choice = sc.nextInt();

				System.out.println(signupMsgName);
				System.out.print(plzInput);
				name = sc.next();

				System.out.println(signupMsgPhoneNum);
				System.out.print(plzInput);
				phoneNum = sc.next();
//				if (Bank.isTherePhoneNumber(customers[choice - 1], phoneNum)) {
//					// 이미 가입한 적이 있으면 true가 뜨면서 진입
//					System.out.println(alreadyExistErrMsg);
//					break;
//				}

				System.out.println(signupPw1);
				System.out.println(plzInput);
				pw1 = sc.next();

				System.out.println(signupPw2);
				System.out.println(plzInput);
				pw2 = sc.next();

				if (!pw1.equals(pw2)) { //
					System.out.println(inputErrMsg);
					continue;
				}

				switch (choice - 1) {
				case SHINHAN:
					customer = arShinhans[arUserCount[SHINHAN]++] = new Shinhan(name, phoneNum, pw1);
					customer = (Shinhan) customer;
					System.out.println(customer.toString());
					break;
				case KOOKMIN:
					customer = arKookmins[arUserCount[KOOKMIN]++] = new Kookmin(name, phoneNum, pw1);
					customer = (Kookmin) customer;
					System.out.println(customer.toString());
					break;
				case KAKAO:
					customer = arKakaos[arUserCount[KAKAO]++] = new Kakao(name, phoneNum, pw1);
					customer = (Kakao) customer;
					System.out.println(customer.toString());
					break;
				}

				break;
			case 2: // 로그인
				if (customer instanceof Shinhan) {
					customer = (Shinhan) customer;
				} else if (customer instanceof Kookmin) {
					customer = (Kookmin) customer;
				} else if (customer instanceof Kakao) {
					customer = (Kakao) customer;
				} else {
					System.out.println(loginErrMsg);
					System.out.println(backToMainMsg);
					continue;
				}
				break;
				
			case 3: // 계좌번호 찾기(forgot)
				break;
			case 4:
				break;
			case 5:
				break;
			}
			if (whileFlag) {
				System.out.println(exitMsg);
				break;
			}

		}

	}

}
