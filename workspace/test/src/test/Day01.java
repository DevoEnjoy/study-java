package test;

import java.util.Scanner;

public class Day01 {
	public static void main(String[] args) {

//		int age = 20;
//		int a = age;
//		System.out.printf("나이: %d, %.0f", age, 30f);
//		String agee = "30";
//		System.out.println(agee + 1);
//		System.out.println(Integer.parseInt(agee) + 1);
		
		Scanner sc/*객체명*/ = new Scanner(System.in);
		
		String input = "";
		System.out.print("입력: ");
		input = "" + sc.nextInt();
		input = ""/*문자열*/ + (int)/*정수*/(double)/*실수*/Integer.parseInt/*정수*/(input)/*문자열*/;
		System.out.println(Integer.parseInt(input + 1) + 1);
		
		
		
		
		
		
		
		
		
//		String input = "", input2 = "";
//		input = sc.nextLine();
//		System.out.println(input);
//		input2 = sc.next();
//		System.out.println(input2);

//		input2 = sc.nextLine();
//		System.out.println(input2);
		
		
		

	}
}
