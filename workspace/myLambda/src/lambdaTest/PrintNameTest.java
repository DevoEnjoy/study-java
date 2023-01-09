package lambdaTest;

public class PrintNameTest {
	public void printFullName(PrintName printName) {
		System.out.println(printName.getFullName("ÀÌ", "¼ø½Å"));
	}
	
	public static void main(String[] args) {
		PrintNameTest printNameTest = new PrintNameTest();
		printNameTest.printFullName((f, l) -> l + f);
	}

}
