package exceptionText;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(10 / 0);
			System.out.println("연산 성공");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
//			e.printStackTrace();	// 검증
			System.err.println(e.getMessage());
			System.err.println(e);
		} catch (Exception e) {
			e.printStackTrace();	// 검증
		}
	}
}
