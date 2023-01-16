package threadTest;

public class Thread2 implements Runnable {
	public Thread2() {;}
	
	
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
	
	
}
