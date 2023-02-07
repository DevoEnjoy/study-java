package lambdaTest;

import java.util.stream.IntStream;

public class PrintNameTest {
	public void printFullName(PrintName printName, String firstName, String lastName) {
		System.out.println(printName.getFullName(firstName, lastName));
	}

	public static void main(String[] args) {
		PrintNameTest printNameTest = new PrintNameTest();
//		printNameTest.printFullName((f, lastName) -> lastName + f);
//		printNameTest.printFullName((f, l) -> f + l + "�� �������", "��", "����");
//		printNameTest.printFullName(((f, l) -> f + l + "�� �������"), "��", "����");

		IntStream.range(0, 10).map(v -> (char) (v + 'a')).forEach(v -> System.out.println((char) v));

	}

}
