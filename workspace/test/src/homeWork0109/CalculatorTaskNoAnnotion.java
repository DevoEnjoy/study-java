package homeWork0109;

import java.util.Scanner;

public class CalculatorTaskNoAnnotion {
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

//		* ��ü ���� ���޹��� �� String[]�� �����ϴ� getOpers �߻�޼ҵ� ����(�Լ��� �������̽� ����)
//		* main�޼ҵ忡 getOper�� ���ٽ����� ����
//		* ù��° ������ ������ ��� ���� �ذ�
	public static Calculator add = (num1, num2) -> num1 + num2;
	public static Calculator sub = (num1, num2) -> num1 - num2;

	public static void main(String[] args) {

		// �����
		Scanner sc = new Scanner(System.in);
		String inputStr = null; // �Էµ� ���ڿ��� ��� ���� ����
		String[] arStr = null, // �� ���ڿ��� �迭�� �ٲ�� ��� ���� ����
				tempArStr = null; // arStr[]�� �ϳ��� ������ �ɰ��� ���� �ӽ� ���� ����
		int parsedInt = 0, // for�� ���� ��, �ɰ��� String�� Integer.parseInt�� �̿��� �ٲ� ���� ���� �ӽ� ���� ����
				resultInt = 0; // ���� ���������� ���� ���� ����
		Operator operator = (strings) -> {
			String[] arResult = null;
			if (strings.contains(" ")) {strings = strings.replaceAll(" ", "");}
			arResult = strings.split("\\+");
			return arResult;
		};
		System.out.print("�Է�: ");
		inputStr = sc.nextLine();

		if (inputStr.charAt(0) == '-') {inputStr = "0" + inputStr;}

		arStr = operator.getOpers(inputStr);

		for (int i = 0; i < arStr.length; i++) {
			tempArStr = null;
			if (arStr[i].contains("-")) {
				tempArStr = arStr[i].split("\\-");
				for (int j = 0; j < tempArStr.length; j++) {
					parsedInt = Integer.parseInt(tempArStr[j]);
					resultInt = ((j == 0) ? add.calc(resultInt, parsedInt) : sub.calc(resultInt, parsedInt));
				} // ����for�� ��
			} else {resultInt = add.calc(resultInt, Integer.parseInt(arStr[i]));}
			parsedInt = 0;
		}
		System.out.println("���� ���: " + resultInt);
	}
}
