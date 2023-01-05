package job;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class CoupangMan {
	Random random = new Random();

	String name; // 쿠팡맨 이름
	static int needHouses; // 레벨업에 필요한 가구수
	int level; // 쿠팡맨 레벨
	int income; // 쿠팡맨 월급
	int todayHouses; // 금일 배정된 가구 수
	int totalHouse; // 지금까지 배송한 가구 수
	int incomeByHouses; // 가구 당 책정한 금액
	int total; // 지금까지 수입의 총합
	boolean nightWork; // 야간작업 여부
	boolean assigned; // 금일 배정 여부

	{
		level = 1;
		income = 250;
		incomeByHouses = 300;
	}
	static {
		needHouses = 500;
	}

	public CoupangMan() {
		;
	}

	public CoupangMan(String driverName) {
		this.name = driverName;
	}

	public CoupangMan(String driverName, boolean nightWork) {
		this.name = driverName;
		this.nightWork = nightWork;
	}

//	// 배송 시작
//	void startDelivery() {
//	}

//	배송 종료 - 배송 종료시 배송한 가구 수 산정, 레벨업 여부 확인
//	void stopDelivery() {
//		assigned = false;
//		
//		levelUp();
//		
//	}

//	배송 진행(void)
//	void delivery() {
//	}

//	로그인
	boolean checkName(String name) {
		return this.name.equals(name);
	}

//	레벨업 요건 확인(boolean)
	boolean checkLevelUp() {
		return (this.totalHouse >= (this.level * needHouses)) ? true : false;
	}

//	레벨업 기능(void)
	void levelUp() {
		if (checkLevelUp()) {
			this.level++;
		}
	}

////	레벨 확인(int 레벨 리턴)
//	int checkLevel() {
//		return this.level;
//	}

	// 야간 작업 전환(void)
	void turnNightWork(boolean nightWork) {
		this.nightWork = nightWork;
	}

//	야간 작업 여부(boolean)
	boolean checkNightWork() {
		return this.nightWork;
	}

////	금일 배정 가구 수 확인(int 리턴)
//	int checkHouses() {
//		return assignHouses();
//	}

//	예상 급여 확인(int 리턴)
	int TodayIncome() {
		int result = (int) (assignHouses() * incomeByHouses * ((this.level + 10) / 10));
//		if()
		return result;
	}

//	확률 - 가구 수 배정(int 레벨 비례)
	int assignHouses() {
		if (!assigned) {
			todayHouses = random.nextInt(level * 10) + level * 70;
			assigned = true;
		}
		return todayHouses;
	}

//	확률 - 배송 중 부상 입을 확률 계산

	@Override
	public String toString() {
		return "CoupangMan\n이름= " + name + ",\nLevel=" + level + ",\n야간작업=" + nightWork + ",\n금일 가구 배정 여부=" + assigned;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNeedHouses() {
		return needHouses;
	}

	public static void setNeedHouses(int needHouses) {
		CoupangMan.needHouses = needHouses;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getTodayHouses() {
		return todayHouses;
	}

	public void setTodayHouses(int todayHouses) {
		this.todayHouses = todayHouses;
	}

	public int getTotalHouse() {
		return totalHouse;
	}

	public void setTotalHouse(int totalHouse) {
		this.totalHouse = totalHouse;
	}

	public int getIncomeByHouses() {
		return incomeByHouses;
	}

	public void setIncomeByHouses(int incomeByHouses) {
		this.incomeByHouses = incomeByHouses;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isNightWork() {
		return nightWork;
	}

	public void setNightWork(boolean nightWork) {
		this.nightWork = nightWork;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

}

class Console {

}

public class CoupangMain {

	String combiMenu(String[] arStr) {
		String result = "";
		for (int i = 0; i < arStr.length; i++) {
			result += i + "." + arStr[i];
			if (arStr.length - 1 != i) {
				result += "\n";
//				System.out.println(121 + ". " + result);
			} else {
//				result = i + "." + result + arStr[i];
//				System.out.println(124 + ". " + result);
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CoupangMan cm = new CoupangMan();

		final String WELCOME_MSG = "쿠팡맨 서비스입니다.\n원하는 서비스를 고르세요.";
		String[] arMenu = { "종료", "쿠팡맨 가입", "쿠팡맨 로그인" };
		/* 서비스 목록
		 * 0. 종료
		 * 1. 내 정보
		 * 2. 배송 시작()
		 * 3. */
		String[] arSvcMenu = {"종료", ""};
		String errMsg = "잘못 입력하셨습니다.";
		String signupMsg = "쿠팡맨 가입메뉴입니다.\n쿠팡맨 이름과 야간작업 여부를 입력해 주세요.\n가입취소는 0을 입력해주세요.";
		String loginMsg = "로그인 성공", wrongLoginMsg = "존재하지 않는 이름입니다.";
		String menuMsg = new CoupangMain().combiMenu(arMenu);
		String driverName = null;
		String tempString = "";
		boolean booleanTemp = false;
		boolean nightWork = false, checkLogin = false;
//		temp
		int tempInt = 0;

//		System.out.println(arMenu[1] + arMenu[2]);
//		System.out.println("------135----");

//		CoupangMan cp = new CoupangMan("홍길동");

//		System.out.println(cp.toString());
//		System.out.println();
//		System.out.println("배정 가구: " + cp.assignHouses());
//		System.out.println();
//		System.out.println(cp.toString());

		while (true) {
			boolean exitFlag = false;
			sc.nextLine();
			System.out.print("\n아무키나 입력시 메뉴 출력\n");
			sc.nextLine();
//			ClearConsole();
			System.out.println(WELCOME_MSG);
//			======================가입, 로그인 서비스==============
			if (!checkLogin) { // 로그인 여부 체크
				System.out.println(menuMsg);
				int choice = -1;
				choice = sc.nextInt();
				switch (choice) {
				case 0: // 종료
					exitFlag = true;
					break;
				case 1: // 쿠팡맨 가입
					System.out.println();
					System.out.print("이름 입력: ");
					driverName = sc.next();
					if (driverName.equals("0")) {
						break;
					}
					System.out.print("\n\n야간 작업 여부\n1. 가능\n2. 불가능\n입력: ");
					tempInt = sc.nextInt();
					if (!(tempInt == 1 || tempInt == 2)) {
						System.out.println(errMsg);
						break;
					}
					nightWork = tempInt == 1;
					cm.setName(driverName);
					cm.setNightWork(nightWork);
					nightWork = false;

					System.out.println(cm.name + "님 가입이 완료되었습니다\n");
					System.out.println("\n=========가입 정보===========");
					System.out.println(cm.toString());

					break;
				case 2: // 쿠팡맨 로그인
					if (!driverName.equals(null)) {
						System.out.print("가입한 이름 입력: ");
						if (cm.checkName(sc.next())) {
							checkLogin = true;
							System.out.println(loginMsg);
						} else {
							checkLogin = false;
							System.out.println(wrongLoginMsg);
						}
					}
					break;
				default: // 잘못 입력한 경우
					System.out.println(errMsg);
					break;
				}

				if (exitFlag) {
					System.out.println("종료합니다.");
					break;
				}

//				==================회원 서비스================
			} else { // 로그인 후
				
			}

		}

	}

	public static void ClearConsole() {
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}

	}
}
