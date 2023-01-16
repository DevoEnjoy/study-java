package threadTest;

public class ThreadTask {
	public static void main(String[] args) {
		Runnable target = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}
			}
		};

		String[] animals = {"À½¸Ó", "¸Û¸Û", "¸Þ¿¡¿¡"};
		
		Thread t1 = new Thread(target, animals[0]);
		Thread t2 = new Thread(target, animals[1]);
		Thread t3 = new Thread(target, animals[2]);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {;}

		t3.start();

	}
}
