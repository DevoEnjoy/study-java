package controllStatement;

import java.util.Scanner;

public class IfTask {
   public static void main(String[] args) {
//      사용자에게 아래의 메뉴를 출력하고
//      번호를 입력받는다.
	   int inputNum = 0;
	   String result = null;
	   final String RED = "빨간색", BLACK = "검은색", YELLOW = "노란색", WHITE = "흰색";
//      1. 빨간색
//      2. 검은색
//      3. 노란색
//      4. 흰색
	   System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n", RED, BLACK, YELLOW, WHITE );
	   System.out.print("입력 : ");
	   Scanner sc = new Scanner(System.in);
	   inputNum = sc.nextInt();

//      사용자가 입력한 번호의 색상을 영어로 출력한다.
	   if(inputNum == 1) {
		   result = "RED";
	   }else if(inputNum == 2) {
		   result = "BLACK";
	   }else if(inputNum == 3) {
		   result = "YELLOW";
	   }else if(inputNum == 4) {
		   result = "WHITE";
	   }else {
		   result = "잘못 입력하셨습니다";
	   }
	   
	   System.out.println(result);
   }
}











