package exceptionText;

// Exception 상속: 컴파일러가 체크
// RuntimeException: 컴파일러가 체크하지 않음
public class BadWordsException extends Exception {
	public BadWordsException(String message) {
		super(message);
	}
}
