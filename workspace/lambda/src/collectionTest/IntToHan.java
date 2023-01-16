package collectionTest;

import java.util.HashMap;
import java.util.stream.IntStream;

public class IntToHan {
	
	public static void int2Hans(int nums) {
		String hans = "¿µÀÏÀÌ»ï»ç¿ÀÀ°Ä¥ÆÈ±¸";
		HashMap<Integer, String> hangle2 = new HashMap<Integer, String>();
		String tempStr = "" + nums;
		IntStream.range(0, 10).forEach(c -> hangle2.put(c, "" + hans.charAt(c)));
		IntStream.range(0, tempStr.length())
		.forEach(c -> System.out.print(hangle2.get(Integer.parseInt("" + tempStr.charAt(c)))));

	}
	
	public static void main(String[] args) {
//		String hans = "¿µÀÏÀÌ»ï»ç¿ÀÀ°Ä¥ÆÈ±¸";
//		HashMap<Integer, String> hangle2 = new HashMap<Integer, String>();
//		IntStream.range(0, 10).forEach(c -> hangle2.put(c, "" + hans.charAt(c)));
////		System.out.println(hangle2);	// {0=¿µ, 1=ÀÏ, 2=ÀÌ, 3=»ï, 4=»ç, 5=¿À, 6=À°, 7=Ä¥, 8=ÆÈ, 9=±¸}
//
//		Integer tempInt = 7518; // Å×½ºÆ® ÀÔ·ÂºÎ
//		String tempStr = "" + tempInt; // ¹®ÀÚ¿­ º¯È¯ºÎ
//
//		IntStream.range(0, tempStr.length())
//				.forEach(c -> System.out.print(hangle2.get(Integer.parseInt("" + tempStr.charAt(c)))));

	int2Hans(3975);
		
		
		
		
	}
}
