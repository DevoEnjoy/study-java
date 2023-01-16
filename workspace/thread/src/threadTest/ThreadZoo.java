package threadTest;

public class ThreadZoo extends Thread{

	public ThreadZoo() {
		;
	}
	
	public ThreadZoo(Runnable target) {
		super();
	}
	
	public ThreadZoo(Runnable target, String name) {
		super();
	}
	
	public void animalCry(Runnable cry) {
		cry.run();
	}

}
