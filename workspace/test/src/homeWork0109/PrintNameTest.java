package homeWork0109;

import java.util.Scanner;

public class PrintNameTest {
	
	public static void printFullName(String fullName) {
		System.out.println(fullName);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �Է�: ");
		String lastName = sc.nextLine();
		
		System.out.print("�̸� �Է�: ");
		String firstName = sc.nextLine();

		PrintName printName = (last, first) -> last + first;
//		printFullName(printName.getFullName("��", "����"));
		printFullName(printName.getFullName(lastName, firstName));

	}
}
