package codingDojang;

public abstract class InterfaceTestAdapter implements InterfaceTest {
	@Override
	public int add(int num1) {
		return 0;
	}
	//	추상 클래스의 추상 메소드는 인터페이스와 달리 abstract를 써야 한다.
//	abstract int add2(int num1);
}
