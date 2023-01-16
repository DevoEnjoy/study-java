package homeWork0109;

import java.util.Scanner;

public class PrintNameTest {
	
	public static void printFullName(String fullName) {
		System.out.println(fullName);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성 입력: ");
		String lastName = sc.nextLine();
		
		System.out.print("이름 입력: ");
		String firstName = sc.nextLine();

		PrintName printName = (last, first) -> last + first;
//		printFullName(printName.getFullName("이", "순신"));
		printFullName(printName.getFullName(lastName, firstName));

	}
}
