package lambdaTest;

public class LambdaTest {
	public static void main(String[] args) {
		LambdaInter lambdaInter = (number) -> number % 10 == 0;
		System.out.println(lambdaInter.checkMultipleOf10(100));
	}
}
