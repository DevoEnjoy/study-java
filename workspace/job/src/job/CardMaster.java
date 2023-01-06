package job;

import java.util.Random;
import java.util.Scanner;

// 타짜
// 족보(끗, 땡, 광땡)
// 나랑 상대방과 대결
// 계급: 호구, 물주, 마담, 타짜
// 패를 받을 시 추가 금액 설정
// 같은 패가 나올 시 다음 판 두 배
// 다이, 고 결정
// 판돈: 1억
// 연속 3회 승리 시 계급 상승

public class CardMaster {
	
	String nickname;	//	타짜들의 닉네임 
	int money;			//	개인 소유금
	int level;			//	타짜 등급
	int deck;			//	손패
	int winCount;		//	연승횟수(등급에 영향을 줌)
	
	public CardMaster() {;}	// 기본생성자

	public CardMaster(String nickname, int money) {	// 생성자 - 닉네임과 시작금을 매개변수로 받음
		this.nickname = nickname;	// 받은 매개변수를 멤버변수에 대입
		this.money = money;			// 위와 같음
	}
	
//	판돈 및 추가 금액을 받는다.
	void deposit(int money) {
		// 리턴타입이 있으므로 메소드이다
		
		this.money -= money;
		// 멤버변수인 this.money에서 매개변수로 받은 money만큼을 빼고 다시 this.money에 대입한다.
	}
	
//	끗(60%) 땡(30%) 광땡(10%)
	void getMyDeck() {	// 손패를 받는다
		Random random = new Random();	// 랜덤을 위한 선언
		
		int[] rating = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2};
		// 확률 구현을 위한 배열 선언 및 초기화
		// 확률은 개수에 비례함
		
		this.deck = rating[	// rating[랜덤수]로 나오게 되어 배열의 값을 가져오게 된다.
		                random.nextInt(
		                // 랜덤 수를 rating.length의 범위(0 ~ 9) 안에서 출력하여
                		   	rating.length)];
							// 확률 구현을 위한 배열의 길이 만큼을 매개변수로 하여 랜덤값의 범위를 정한다.
	}
	
	int battle(CardMaster cardMaster) {	// 대결 기능
//		-1 : draw, 0 : lose, 1 : win
		boolean draw = this.deck == cardMaster.deck; 	// 타짜들 각 손패의 급이 같으면 무승부
		boolean lose = this.deck > cardMaster.deck;		// 타짜들 중 cardMaster의 덱의 수가 낮으면 패배
		boolean win = this.deck < cardMaster.deck;		// 타짜들 중 cardMaster의 덱의 수가 높으면 승리
		boolean[] status = {draw, lose, win};			// 승패 무승부의 값을 넣을 배열 선언
		int result = 0;	// 리턴값 초기화
		
		for (int i = -1; i < 2; i++) {
		// 리턴값이 -1~1 범위이므로 i는 -1로 시작
			
			if(status[1 + i]) {
			// 승패 무승부의 값을 검사
				
				result = i;
				// i==-1이면 무승부, 0이면 패배, 1이면 승리
				
				break;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		String[] arLevel = {"호구", "물주", "마담", "타짜"};
		// 등급 선언
		
		String[] decks = {"광땡", "땡", "끗"};
		// 손패 등급
		
		String[] status = {"무승부", "패배", "승리"};
		// 승부 결과값
		
		String message = "1. 대결하기\n2. 나의 정보\n3. 나가기";
		// 메시지
		
		String depositMessage = "1. 추가금액 입력\n2. 추가금액 없이 진행";
		// 추가금 여부 입력 메시지
		
		int choice = 0/*선택을 받을 변수*/, money = 0/*판돈*/, defaultMoney = 10_000/*시드머니*/,
				result = 0/*대결 결과값(-1~1)*/, depositMoney = 0/*대출금*/;
		Scanner sc = new Scanner(System.in);	// 입력을 위한 스캐너 객체 선언
		CardMaster me = new CardMaster("고니", 0);	// 플레이어 객체 선언
		CardMaster computer = new CardMaster("아귀", 0);	// 컴퓨터 객체 선언
		String title = null;	// 나의 정보 출력
		
		while (true) {
		// 특정 조건 하에 반복문 탈출
			title = "[" + arLevel[me.level] + "]" + me.nickname + " 자산: " + me.money + "\n"
					+ "[" + arLevel[computer.level] + "]" + computer.nickname + " 자산: " + computer.money;
			// 정보 출력을 위한 문자열 나열 및 결합, 대입
			System.out.println(title);	// 정보 출력
			System.out.println(message);	// 메시지 출력
			choice = sc.nextInt();	// 1. 대결하기 2. 나의 정보 3. 나가기 선택
			
			if(choice == 3) {break;}	// 3. 나가기 선택시 바로 while문 탈출
			
			switch(choice) {	// 3. 나가기가 아닌 경우 switch문(조건문) 진입
			case 1: // 대결하기
				me.deposit(defaultMoney);
				computer.deposit(defaultMoney);
				// 10000을 대출받음
				
				money += defaultMoney * 2;
				// 판돈에 판돈 + (기본대출금의 두 배)을 더한다.
				// 왜 기본대출금의 두 배이냐하면, 플레이가 두 명이기 때문이다
				
				me.getMyDeck();
				computer.getMyDeck();
				// 각 타짜가 덱을 뽑는다
				
				System.out.println("나의 패: " +decks[me.deck]);
				// 메시지 출력
				
				System.out.println(depositMessage);
				// 1. 추가금액 입력\n2. 추가금액 없이 진행
				// 추가금액 입력 여부 메시지 출력
				
				choice = sc.nextInt();
				// 추가금액 여부 입력
				
				if(choice == 1) {	// 추가금액 입력을 선택한 경우
//				if(!(choice == 1)) {	// 추가금액 입력을 선택한 경우
					System.out.print("추가 금액: ");
					// 추가금액 입력 메시지 출력
					
					depositMoney = sc.nextInt();
					// 추가금액 입력
					
					me.deposit(depositMoney);
					computer.deposit(depositMoney);
					// 양 타짜 모두 입력한 금액만큼 대출
					
					money += depositMoney * 2;
					// 판돈에 10000 * 타짜수(2)만큼 추가
				}
				
				result = me.battle(computer);
				System.out.println(status[result + 1]);
				
				switch(result) {
				case -1: // 무승부
					while(result == -1) {
						money *= 2;
						System.out.println(money);
						me.getMyDeck();
						System.out.println("나의 패: " +decks[me.deck]);
						System.out.println("1. 고\n2. 다이");
						choice = sc.nextInt();
						if(choice == 2) { 
							result = 0; 
							System.out.println(status[result + 1]);
							computer.money += money;
							System.out.println(computer.nickname + "의 현재 금액: " + computer.money);
							
							System.out.println(me.nickname + "의 현재 금액: " + me.money);
							System.out.println("현재 판돈: " + money);
							me.money = me.money - money;
							System.out.println(me.nickname + "의 현재 금액에서 판돈을 뺀 금액: " + me.money);
							
							me.money = me.money - defaultMoney - depositMoney;
							System.out.println(me.nickname + "의 판돈을 뺀 금액에서 기본 대출금과 추가금을 뺀 금액: " + me.money);
							
//							me.money = me.money - (money - defaultMoney - depositMoney); 
							
//							me.money -= (money - defaultMoney - depositMoney);
							// 판돈에서 기본으로 빌린 금액과 추가금액을 뺀 금액 만큼을 플레이어의 현재 금액에서 차감
							me.winCount = 0;	// 다이 선택했기 때문에 무조건 연승횟수를 0으로 초기화
							System.out.println(me.nickname + "의 연승횟수: " + me.winCount);
							
							computer.winCount++;	// 컴퓨터의 승리횟수는 1증가
							System.out.println(computer.nickname + "의 연승횟수: " + computer.winCount);
							
							break;	// while(result == -1) 탈출
						}
						result = me.battle(computer);	// 선택이 2. 다이가 아니라면 대결 실행(무승부일 때 '고'하는 경우)
						System.out.println(status[result + 1]);	// 승부 결과 출력
						
						switch(result) {
						case 0: // 플레이어 패배
							computer.money += money;	// 다이했을 때와 동일함
							System.out.println(computer.nickname + "의 현재 금액: " + computer.money);
							
							me.money -= money - defaultMoney - depositMoney;
							System.out.println(me.nickname + "의 패배 후 현재 금액: " + me.money);
							
							me.winCount = 0;
							computer.winCount++;
							break;
						case 1: // 승리
							me.money += money;	// 다이했을 때의 반대의 경우
							computer.money -= money - defaultMoney - depositMoney;
							me.winCount++;
							computer.winCount = 0;
							break;
						}
					}
					break;
					
				case 0: // 패배
					computer.money += money;
					me.money -= money - defaultMoney - depositMoney;
					me.winCount = 0;
					computer.winCount++;
					break;
				case 1: // 승리
					System.out.println(money);
					me.money += money;
					computer.money -= money - defaultMoney - depositMoney;
					me.winCount++;
					computer.winCount = 0;
					break;
				}
				if(me.winCount > 2	// 플레이어의 연승횟수가 2보다 크고(3 이상이고)
						&& me.level < 3) {	// 플레이어의 레벨이 3(최대치)보다 작을 때
					me.level++;	// 플레이어의 레벨 상승
				}
				if(computer.winCount > 2 && computer.level < 3) {
					computer.level++;
				}
				break;
			case 2: // 나의 정보
				break;
			default: // 그 외
				System.out.println("다시 입력해주세요.");
				break;
			}
		}
		
		
	}
}









