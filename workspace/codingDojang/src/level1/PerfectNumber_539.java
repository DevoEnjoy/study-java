package level1;

public class PerfectNumber_539 {
//	�ڱ� �ڽ��� ������ ��� ���� ������� ���� �ڱ� �ڽ��� �Ǵ� �ڿ����� ��������� �Ѵ�.
//	���� ���, 6�� 28�� �������̴�.
//	6=1+2+3 // 1,2,3�� ���� 6�� ���
//	28=1+2+4+7+14 // 1,2,4,7,14�� ���� 28�� ���
//	�Է����� �ڿ��� N�� �ް�, ������� N ������ ��� �������� ����ϴ� �ڵ带 �ۼ��϶�.

	public static int getFactorSum(int num) {
		int result = 0;
		if(num == 0 || num == 1) {return 0;}
		for (int i = 0; i < num; i++) {
			if (i == 0) {continue;}
			if (num % i == 0) {result += i;}
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
