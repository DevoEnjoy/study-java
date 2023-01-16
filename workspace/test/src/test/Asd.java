package test;

import java.util.Random;
import java.util.Scanner;

public class Asd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력 받을 준비(choice)
		Random r = new Random(); // 랜덤 받을 준비(번호표)

		// 구현한 기능
		// 1. 관리자 비밀번호 변경
		// 2. 대기번호 랜덤 출력
		// 3. 장바구니 기능
		// 4. 장바구니 초기화 기능

		String adminCode = "0000"; // 관리자 비밀번호를 저장할 변수

		int hamPrice = 1500; // 햄버거 초기가격
		int gamPrice = 2000; // 감자튀김 초기가격
		int colaPrice = 500; // 콜라 초기가격
		int hamCnt = 0; // 햄버거 갯수를 저장할 변수
		int gamCnt = 0; // 감튀 갯수를 저장할 변수
		int colaCnt = 0;// 콜라 갯수를 저장할 변수

		String menu1 = "햄버거"; // 첫번째 메뉴 이름
		String menu2 = "감자튀김";// 두번째 메뉴 이름
		String menu3 = "콜라"; // 세번째 메뉴 이름

		String errMsg = "다시 입력하세요."; // 잘못 입력했을 경우 출력할 에러 메시지
		String goToMain = "메인메뉴로 돌아갑니다."; // 메인메뉴로 돌아갈 때 출력할 안내메시지
		String profit = "설정 완료!"; // 설정 완료시 출력 메시지
		String fail = "설정 실패!"; // 설정 실패시 출력 메시지

		while (true) { // 메인메뉴
			hamCnt = 0;
			gamCnt = 0;
			colaCnt = 0;
			System.out.println("★☆★☆어서오세요★☆★☆");
			System.out.println("┌────────────────┐");
			System.out.println("│1.주문하기        │");
			System.out.println("│2.관리자메뉴  	 │");
			System.out.println("└────────────────┘");
			System.out.print("입력 >> "); // 주문하기
										// 혹은
										// 관리자메뉴
										// 선택
			int choice = Integer.parseInt(sc.nextLine());// 입력을 받을 변수 choice

			if (choice == 1) { // 주문하기 화면
				while (true) {// 음식메뉴출력 while문 여는 중괄호
					System.out.println("★ ────────가격표─────────\t★");
					System.out.printf("│ 1. %-4s\t-%5d원 │\n", menu1, hamPrice); // 햄버거
					System.out.printf("│ 2. %-4s\t-%5d원 │\n", menu2, gamPrice); // 감자튀김
					System.out.printf("│ 3. %-4s\t-%5d원 │\n", menu3, colaPrice);// 콜라
					System.out.println("★ ─────────────────────\t★");
					System.out.println("4. 결제하기"); // 결제하기로 이동
					System.out.println("5. 장바구니 비우기"); // hamCnt, gamCnt, colaCnt 초기화
					System.out.println("6. 메인메뉴로 돌아가기");// 메인메뉴로 이동
					System.out.print("입력 >> "); // 입력 안내 메시지
					choice = Integer.parseInt(sc.nextLine()); // 주문 메뉴 번호 입력
					int tempCnt = 0; // 수량 변수 tempCnt 선언
					if (choice == 1 || choice == 2 || choice == 3) {
						do {
							System.out.print("수량 >> ");
							tempCnt = Integer.parseInt(sc.nextLine()); // 수량
																		// 변수
																		// tempCnt
																		// 입력
						} while (tempCnt < 0); // 수량을 0보다 작게 입력하면 다시 입력하게 이동
						if (tempCnt == 0) { // 수량을 0개 입력하면 음식메뉴로 다시 이동
							continue; // 음식메뉴로 이동
						}
					}

					if (choice == 1) { // 1. 햄버거 선택
						hamCnt += tempCnt;
						System.out.printf("장바구니에 %s %d개 추가 완료!\n", menu1, hamCnt); // 메뉴1 햄버거 장바구니 안내 메시지
					} else if (choice == 2) { // 2. 감자튀김 선택
						gamCnt += tempCnt;
						System.out.printf("장바구니에 %s %d개 추가 완료!\n", menu2, gamCnt); // 메뉴2 감자튀김 장바구니 안내 메시지
					} else if (choice == 3) { // 3. 콜라 선택
						colaCnt += tempCnt;
						System.out.printf("장바구니에 %s %d개 추가 완료!\n", menu3, colaCnt); // 메뉴3콜라 장바구니 안내 메시지
					} else if (choice == 4) { // 4. 결제하기
						int total = hamCnt * hamPrice + gamCnt * gamPrice + colaCnt * colaPrice; // 결제 필요 금액 변수 선언
						System.out.println("결제하시겠습니까?"); // 결제할지 묻는 메시지
						System.out.println("총 결제 금액 : " + total); // 필요한 결제 금액 안내 메시지
						System.out.print("금액 입력 >> "); // 금액 입력 안내 메시지
						int money = Integer.parseInt(sc.nextLine()); // 금액 입력 변수 money 선언
						if (money >= total) { // 입력한 금액이 결제할 금액보다 크거나 같은 경우(결제 가능한 경우)
							System.out.println("입력된 금액 : \t" + money); // 입력한 금액
							System.out.println("총 결제 금액 : \t" + total); // 필요한 결제 금액
							if (money > total) { // 입력 금액이 결제에 필요한 금액보다 많은 경우
								System.out.println("반환될 금액 : \t" + (money - total)); // 잔돈 안내 메시지
							}
							System.out.printf("대기번호 : %04d\n", r.nextInt(9999) + 1); // 대기번호 출력 메시지
							System.out.println("결제가 완료되었습니다.\n식사 맛있게 하세요!\n"); // 결제완료 안내 메시지

						} else { // money > total 입력 금액이 결제에 필요한 금액보다 적은 경우
							System.out.println("잔액이 부족합니다."); // 안내 메시지
							System.out.println(goToMain); // 메인메뉴 복귀 메시지
						}
						break; // 메인메뉴 복귀

					} else if (choice == 5) { // 장바구니 초기화
						hamCnt = 0;
						gamCnt = 0;
						colaCnt = 0;
					} else if (choice == 6) { // 6. 메인메뉴로 돌아가기
						System.out.println(goToMain); // 메인메뉴 복귀 메시지
						break; // 메인메뉴 복귀
					} else {
						System.out.println(errMsg);
					}
					// 현재 장바구니에 담겨있는 음식들 출력하기
					System.out.println();
					System.out.println("★ ─장바구니─ ★");
					if (hamCnt >= 1) {
						System.out.printf("│%s\t: %d개│\n", menu1, hamCnt);
					}
					if (gamCnt >= 1) {
						System.out.printf("│%s\t: %d개│\n", menu2, gamCnt);
					}
					if (colaCnt >= 1) {
						System.out.printf("│%s\t: %d개│\n", menu3, colaCnt);
					}
					System.out.println();
					System.out.println("★ ──────── ★");
				} // 음식메뉴출력
					// while문
					// 닫는
					// 중괄호

			} else if (choice == 2) { // 관리자메뉴 화면
				System.out.print("비밀번호 >> ");
				String code = sc.nextLine(); // 입력받은 비밀번호
				if (!adminCode.equals(code)) { // 관리자비밀번호와 입력된 값이 다르다면
					System.out.println("잘못된 접근입니다.");
					continue;

				}
				// 여기까지 왔다는 건 비밀번호가 잘 입력되었다는 것.
				System.out.println("1.마감하기");
				System.out.println("2.비밀번호재설정");
				System.out.println("3.가격 설정");
				System.out.print("입력 >> ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					System.out.println("오늘도 고생했습니다.");
					break;
				} else if (choice == 2) {
					System.out.print("새 비밀번호 입력 >> ");
					String newPw = sc.nextLine();

					System.out.print("비밀번호 확인 >> ");
					String tempPw = sc.nextLine();
					// 새로 설정한 비밀번호와 비밀번호 확인이 같다면
					// 설정 성공! 출력 후 메인메뉴로 이동,
					// 같지 않다면 설정 실패! 출력 후 메인메뉴로 이동
					if (!newPw.equals(tempPw)) {
						System.out.println(fail);
						continue;
					}
					System.out.println(profit);
					adminCode = newPw;

				} else if (choice == 3) {
					System.out.println("가격을 변경한 메뉴를 고르세요");
					System.out.println("1.햄버거\n2.감자튀김\n3.콜라");
					System.out.print("입력 >> ");
					choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						System.out.printf("%s 현재 가격 : %d\n", menu1, hamPrice);
						System.out.println("바꿀 가격을 입력하세요.");
						System.out.print("입력 >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("입력된 금액 : %d\n", dummyPrice);
						System.out.println("이 가격으로 설정하시겠습니까?");
						System.out.println("1.예\n2.아니오(메인메뉴로 이동)");
						System.out.println("입력 >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							hamPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					} else if (choice == 2) {
						System.out.printf("%s 현재 가격 : %d\n", menu2, gamPrice);
						System.out.println("바꿀 가격을 입력하세요.");
						System.out.print("입력 >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("입력된 금액 : %d\n", dummyPrice);
						System.out.println("이 가격으로 설정하시겠습니까?");
						System.out.println("1.예\n2.아니오(메인메뉴로 이동)");
						System.out.println("입력 >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							gamPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					} else if (choice == 3) {
						System.out.printf("%s 현재 가격 : %d\n", menu3, hamPrice);
						System.out.println("바꿀 가격을 입력하세요.");
						System.out.print("입력 >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("입력된 금액 : %d\n", dummyPrice);
						System.out.println("이 가격으로 설정하시겠습니까?");
						System.out.println("1.예\n2.아니오(메인메뉴로 이동)");
						System.out.println("입력 >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							colaPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					}

				}

			} else { // 1.주문하기 2.관리자메뉴 외의 다른 숫자입력시
				System.out.println(errMsg); // 오류메시지 출력
			}
			System.out.println();
		} // 메인메뉴while 닫음
	}
}
