package homeWork0109;

import java.util.Scanner;

public class CalculatorTask2 {
//	[��ȭ �ǽ�]
//	���� ���� ������ �Է¹޾Ƽ� �˸´� ����, ���� ����� Ȯ���ϴ� ���ø����̼� ����
//
//	�Է� ��1) 7 + 35 - 9
//	��� ��1) 33
//
//	�Է� ��2) -9 + 8 + 10
//	��� ��2) 9
//
//	* "ABC".split("")�� [A][B][C] 3ĭ ���ڿ� �迭�� ���ϵȴ�.
//	   "A,B,C".split(",")�� [A][B][C] 3ĭ ���ڿ� �迭�� ���ϵȴ�.
//	   split("������")�� �����ϸ� ���ڿ����� ������ �������� �������� ���ڿ� ���� �߶� �� ���ڿ� �迭�� �����Ѵ�.
//	   �������� ���� �� ����� ������ split("������|������")���� ����ϸ�, "+", "-"�� ���������� ����� ������ "\\+", "\\-"�� ǥ���Ѵ�.
//	   ��)"4 + 9".split("\\+")�� [4][9] 2ĭ ���ڿ� �迭�� ����
//
//	* ����ڰ� ���������θ� �Է��Ѵٴ� ���� �Ͽ� �����ϵ��� �Ѵ�.
//	* �� ������ ���޹��� �� int�� �����ϴ� calc �߻�޼ҵ� ����(�Լ��� �������̽� ����)
//	* �� ������ ����, ������ �����ִ� �Լ��� �������̽��� �����ϴ� static �޼ҵ� ����(���ٽ� ����)
	public static int addCal(int num1, int num2) {
		Calculator add = (first, second) -> first + second;
		return add.calc(num1, num2);
	}

	public static int subCal(int num1, int num2) {
		Calculator sub = (first, second) -> num1 - num2;
		return sub.calc(num1, num2);
	}
//	* ��ü ���� ���޹��� �� String[]�� �����ϴ� getOpers �߻�޼ҵ� ����(�Լ��� �������̽� ����)
//	* main�޼ҵ忡 getOper�� ���ٽ����� ����
//	* ù��° ������ ������ ��� ���� �ذ�

	public static int calc(String[] arNums) {
		int count = 0;
		int result = 0;
		String temp = "";
		while (true) {
			for (int i = 0; i < arNums.length; i++) {

				if ((arNums[count + i] == "+"/* || arNums[count + i] == "-" */) && i != arNums.length) {
					temp = arNums[count + i];
					continue;
				} else {
					switch (temp) {
					case "+":
						result = addCal(result, Integer.parseInt(arNums[count + i + 1]));
						break;
					case "-":
						result = subCal(result, Integer.parseInt(arNums[count + i + 1]));
						break;
					default:

					}

					temp = "";
				}
			}
			if (arNums[count] == null) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
//String[] arStr = null;

		Calculator add = (num1, num2) -> num1 + num2;
		Calculator sub = (num1, num2) -> num1 - num2;
		System.out.print("�Է�: ");
		input = sc.nextLine();
		
		Operator operator = (operStr) -> {
			String[] result = null;
			operStr = operStr.replaceAll(" ", "");
			operStr = operStr.replaceAll("-", ".-");
			result = operStr.split(".|\\+");
//			for (int i = 0; i < result.length; i++) {
//				System.out.println("index :" + i + " " + result[i]);
//			}
			return result;
		};
//calc(operator.getOpers(input));
//		operator.getOpers(input);
		System.out.println(operator.getOpers(input).length);
		for (int i = 0; i < operator.getOpers(input).length; i++) {
			System.out.println(operator.getOpers(input)[i]);
		}
	}
}
