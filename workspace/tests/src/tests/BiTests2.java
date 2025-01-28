package tests;

public class BiTests2 {
	public static void main(String[] args) {
		
//		int biNum1 = 0b1010;
//		System.out.println(biNum1);
//		
//		int rvBiNum1 = ~biNum1;
//		System.out.println(rvBiNum1);
		
		
		int biNum2 = 0b00000011;
		System.out.println(biNum2); // 3
		
		int rvBiNum2 = ~biNum2;
		System.out.println(rvBiNum2);
		String b = Integer.toBinaryString(rvBiNum2);
		System.out.printf("b = %s\n", b);
//		int rv10Num2 = Integer.parseInt(, 2);
		System.out.println(rvBiNum2); // -4
//		System.out.println(rv10Num2);
		
	}
}
