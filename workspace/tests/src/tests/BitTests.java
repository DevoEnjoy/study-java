package tests;

public class BitTests {

	public static void main(String[] args) {
		
		// 10을 시작값으로
		int num10 = 10;
		int numBi = 0b1010;
		System.out.println(numBi);
		
		// 10을 이진법 표현(문자열)으로 바꾸고
		String binaryNumStr = Integer.toBinaryString(num10);
		
		// 이를 숫자형으로 형변환 후
		int binaryNum = Integer.parseInt(binaryNumStr);
//		System.out.println(binaryNum);
		
		// 두 값을 같이 보여줌.
		System.out.printf("(2)\t%d \t== (10)\t%d\n",binaryNum, num10);
		
		// 이진법 10에 논리부정부호를 붙이면
		// 1010 -> -1010이 되고 1이 더해져서 -1011
		int rvsBinaryNum = ~binaryNum;
//		System.out.println(rvsBinaryNum);
		
		// -1011을 십진법으로 바꾸면 -11이 나옴.
		num10 = Integer.parseInt(rvsBinaryNum+"", 2);
//		System.out.println(num10);
		System.out.printf("(2)\t%d\t== (10)\t%d", rvsBinaryNum, num10);
		
	}

}
