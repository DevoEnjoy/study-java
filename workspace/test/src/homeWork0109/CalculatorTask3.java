package homeWork0109;

import java.util.Scanner;

public class CalculatorTask3 {
//		[��ȭ �ǽ�]
//		���� ���� ������ �Է¹޾Ƽ� �˸´� ����, ���� ����� Ȯ���ϴ� ���ø����̼� ����

//		�Է� ��1) 7 + 35 - 9
//		��� ��1) 33

//		�Է� ��2) -9 + 8 + 10
//		��� ��2) 9
//		* "ABC".split("")�� [A][B][C] 3ĭ ���ڿ� �迭�� ���ϵȴ�.
//		   "A,B,C".split(",")�� [A][B][C] 3ĭ ���ڿ� �迭�� ���ϵȴ�.
//		   split("������")�� �����ϸ� ���ڿ����� ������ �������� �������� ���ڿ� ���� �߶� �� ���ڿ� �迭�� �����Ѵ�.
//		   �������� ���� �� ����� ������ split("������|������")���� ����ϸ�, "+", "-"�� ���������� ����� ������ "\\+", "\\-"�� ǥ���Ѵ�.
//		   ��)"4 + 9".split("\\+")�� [4][9] 2ĭ ���ڿ� �迭�� ����
	//
//		* ����ڰ� ���������θ� �Է��Ѵٴ� ���� �Ͽ� �����ϵ��� �Ѵ�.
//		* �� ������ ���޹��� �� int�� �����ϴ� calc �߻�޼ҵ� ����(�Լ��� �������̽� ����)
//		* �� ������ ����, ������ �����ִ� �Լ��� �������̽��� �����ϴ� static �޼ҵ� ����(���ٽ� ����)
	public static Calculator add = (num1, num2) -> num1 + num2;
	public static Calculator sub = (num1, num2) -> num1 - num2;

//		* ��ü ���� ���޹��� �� String[]�� �����ϴ� getOpers �߻�޼ҵ� ����(�Լ��� �������̽� ����)
//		* main�޼ҵ忡 getOper�� ���ٽ����� ����
//		* ù��° ������ ������ ��� ���� �ذ�

//	public static int add(int start, int end) {
//		Calculator addCal = (num1, num2) -> num1 + num2;
//		return addCal.calc(start, end);
//	}

//	public static int sub(int start, int end) {
//		int result = 0;
//		Calculator subCal = (num1, num2) -> num1 + num2;
//		return subCal.calc(start, end);
//	}

	public static void main(String[] args) {

		// �����
		Scanner sc = new Scanner(System.in);
		String inputStr = null; // �Էµ� ���ڿ��� ��� ���� ����
		String[] arStr = null, // �� ���ڿ��� �迭�� �ٲ�� ��� ���� ����
				tempArStr = null; // arStr[]�� �ϳ��� ������ �ɰ��� ���� �ӽ� ���� ����
		int parsedInt = 0, // for�� ���� ��, �ɰ��� String�� Integer.parseInt�� �̿��� �ٲ� ���� ���� �ӽ� ���� ����
				resultInt = 0; // ���� ���������� ���� ���� ����

		// String�� String[]�� �ٲٴ� �߻�޼ҵ�
		Operator operator = (strings) -> { // Operator.getOpers(String string);
//			String[][] tempResult = null;	// ���� �迭�� �õ��ϴ� ����(����, �����ڸ� ���� �������� ����)

			// �Է°� �˻籸��
//			System.out.println(strings);
			String[] arResult = null;

			// ������ ���ķ� ���Ⱑ �� �� �ִٰ� ����
			// ���Ⱑ ���� �ʰų� ������ ���ķ� �ϳ����� �� ���, while���� ���ְ� �� ���� �����ص� ����.
			if (strings.contains(" ")) {
				strings = strings.replaceAll(" ", "");
			}

			// strings�� "+"�� �����ڷ� �Ͽ� ���ϰ��� String�迭�� ����.
			arResult = strings.split("\\+");

			// �迭�� �˻籸��
//			for (int i = 0; i < arResult.length; i++) {
//				System.out.println(i + ". " + arResult[i]);
//			}
//			System.out.println("operator\n");

			return arResult;
		};

		// �Է°� �ȳ�. Ȥ�� Scanner��� ��, nextLine()�� ���� �κ�.
//		inputStr = "31-20-4+5+2-3+2";

		// ��ĳ�� ����Ͽ� �Է�
		System.out.print("�Է�: ");
		inputStr = sc.nextLine();

		System.out.println("�Է°�: " + inputStr);

		// * ù��° ������ ������ ��� ���� �ذ�
		// ���� ���۰��� ����(-31 ��)���, �տ� ���� 0�� �ٿ� 0-31�� ���°� �ǰ� ����.
		if (inputStr.charAt(0) == '-') {
			inputStr = "0" + inputStr;
		}

		// operator.getOpers�� ���ϰ��� String�迭(�� �ּҰ�)�̹Ƿ�
		// ���������� String�迭Ÿ���� ������ �ּҰ��� ����.
		arStr = operator.getOpers(inputStr);
		// arStr ���� : {"31-20-4", "5", "2-3", "2"}

		// ���� arStr�� �迭���� �ϳ��� Ȯ���ϰ� ����ϴ� for��
		for (int i = 0; i < arStr.length; i++) {

			// arStr�� �迭���� �ɰ��� ���� �ӽ� ���� �ʱ�ȭ
			tempArStr = null;

			// i��° ���� �������� ���
			if (arStr[i].contains("-")) {

				// �������� ���, "-"�� �����ڷ� �Ͽ� �ӽ� �迭�� ����.
				tempArStr = arStr[i].split("\\-");
				// tempArStr ����: {"31","20","4"}

				// �ӽ÷� ��� ���ڿ� �迭�� ��ȯ�� for��
				for (int j = 0; j < tempArStr.length; j++) {

					// �迭�� ��� ������ ���ڿ��� ������ ġȯ�Ͽ� ������ �ӽ� ������ ����
					parsedInt = Integer.parseInt(tempArStr[j]);

//					�õ�2. �������� ����
//					����: 31-20-4�� ���� ���, ���� �� ���ڴ� ���� �ᱣ���� �տ��� �������� ������.
					// ��, resultInt+31�� resultInt�� ����.
					// ���� ��ȯ �� resultInt-20�� resultInt�� ����.
					// tempArStr�� �迭�� ���� ������ �ݺ�
					resultInt = ((j == 0) ? add.calc(resultInt, parsedInt) : sub.calc(resultInt, parsedInt));

					// �˻籸��
//					System.out.println("resultInt: " + resultInt);

//					�õ�1. ����ġ������ �غ�
//					switch (i) {
//					case 0:
//						resultInt = add(resultInt, parsedInt);
//						break;
//					default:
//						resultInt = sub(resultInt, parsedInt);
//						break;
//					}					
				} // ����for�� ��

				// �ӽ� ������� �ʱ�ȭ
				parsedInt = 0;

			} else { // "-"���� ��, �������� ���ٸ�

				// ���ڸ� ���� ���̹Ƿ� �ٷ� int�� ��ȯ
				parsedInt = Integer.parseInt(arStr[i]);

				// �ش簪�� ���� �ᱣ�� �տ���
				resultInt = add.calc(resultInt, parsedInt);
			}

			// �ܺ� for�� ��
		}
		System.out.println("���� ���: " + resultInt);

	}
}
