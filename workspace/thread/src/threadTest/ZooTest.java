package threadTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ZooTest {
	public static void main(String[] args) {
		String[] sounds = { "¸Û¸Û", "¾ß¿Ë", "Â±Â±" };
		String[] animals = { "¸Ø¹³¹Ì", "°íÎ¹Ì", "´ßµÑ±â" };
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		};

		ArrayList<ThreadZoo> arListThread = new ArrayList<ThreadZoo>(
				Arrays.asList(new ThreadZoo(r), new ThreadZoo(r), new ThreadZoo(r)));

		for (int i = 0; i < arListThread.size(); i++) {
			ThreadZoo z = arListThread.get(i);
			z.setName(animals[i] + " : " + sounds[i]);
		}

		
//		arListThread.get(0).start();
		arListThread.get(0).animalCry(r);
//		arListThread.get(1).start();
		arListThread.get(1).animalCry(r);

		try {
			arListThread.get(1).join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arListThread.get(2).animalCry(r);
	}
}
