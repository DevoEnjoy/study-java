package tests;

public class BitTests {

	public static void main(String[] args) {
		
		// 10�� ���۰�����
		int num10 = 10;
		int numBi = 0b1010;
		System.out.println(numBi);
		
		// 10�� ������ ǥ��(���ڿ�)���� �ٲٰ�
		String binaryNumStr = Integer.toBinaryString(num10);
		
		// �̸� ���������� ����ȯ ��
		int binaryNum = Integer.parseInt(binaryNumStr);
//		System.out.println(binaryNum);
		
		// �� ���� ���� ������.
		System.out.printf("(2)\t%d \t== (10)\t%d\n",binaryNum, num10);
		
		// ������ 10�� ��������ȣ�� ���̸�
		// 1010 -> -1010�� �ǰ� 1�� �������� -1011
		int rvsBinaryNum = ~binaryNum;
//		System.out.println(rvsBinaryNum);
		
		// -1011�� ���������� �ٲٸ� -11�� ����.
		num10 = Integer.parseInt(rvsBinaryNum+"", 2);
//		System.out.println(num10);
		System.out.printf("(2)\t%d\t== (10)\t%d", rvsBinaryNum, num10);
		
	}

}
