package intefaceTest;

public class Cat implements Pet{

	@Override
	public void giveYourHand() {
		System.out.println("못 본 척한다.");
	}

	@Override
	public void bang() {
		System.out.println("못 들은 척한다.");
	}

	@Override
	public void sitDown() {
		System.out.println("무시한다.");
	}

	@Override
	public void waitNow() {
		System.out.println("안 기다린다.");		
	}

	@Override
	public void getNose() {
		System.out.println("하악질을 한다.");
	}

}
