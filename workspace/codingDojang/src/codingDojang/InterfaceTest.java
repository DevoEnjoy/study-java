package codingDojang;

public /* abstract */ interface InterfaceTest {
	//	강제성 부여
	/* abstract */ int add(int num1);
	// 기본형이므로 생략가능

	//	강제성 부여
	int sub(int num1);
//	default int add2(int num1) {return 0;};
	// 기본형이 abstract이므로 일반메소드는 앞에 default를 명시해야 한다.
}
