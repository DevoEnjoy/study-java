package streamTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		HashMap<String, Integer> testHM = new HashMap<String, Integer>();
		ArrayList<String> arListString = new ArrayList<String>();
		
		IntStream.rangeClosed(0, 10).forEach(v -> arListString.add("" + v));		
		
		
		
		
		
		
	}
}
