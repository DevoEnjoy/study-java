package collectionTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class StreamTask {
	public static void main(String[] args) {
//		10~1까지 ArrayList에 담고 출력
//		ArrayList<Integer> arListInt2 = new ArrayList<Integer>();
//		IntStream.range(0, 9).forEach(v -> arListInt2.add(10 - v));
//		arListInt2.stream().forEach(System.out::println);
//		System.out.println("===========");

//		1~10까지 ArrayList에 담고 출력
//		ArrayList<Integer> arListInt = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 10).forEach(arListInt::add);
//		arListInt.stream().forEach(System.out::println);
//		System.out.println("===========");

//		ABCDEF를 각 문자별로 출력
//		String data = "ABCDEF";
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		ArrayList<Character> datasChar = new ArrayList<Character>();
//		IntStream.rangeClosed('A', 'F').forEach(c -> System.out.println((char)c));

//		data.chars().forEach(c -> System.out.print((char)c + " "));
//		data.chars().forEach(datas::add);

//		1~100까지 중 홀수만 ArrayList에 담고 출력
		
//		ArrayList<Integer> datas = new ArrayList<Integer>();
//		IntStream.range(1, 51).map(v -> v * 2 - 1).forEach(datas::add);
//		System.out.println(datas);
		
//		ArrayList<Integer> arListInt = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 100).forEach(c -> {
//			if(c%2==1) {
//				arListInt.add(c);
//			}
//		});
//		arListInt.forEach(System.out::println);

//		A~F까지 중 D제외하고 ArrayList에 담고 출력
		
//		IntStream.range('A', 'F').map(c -> c > 'C' ? c + 1: c).forEach(c -> System.out.println((char)c));
		
//		ArrayList<Character> arListChar = new ArrayList<Character>();
//		IntStream.rangeClosed('A', 'F').forEach(c -> {
//			if(c!='D') {
//				arListChar.add((char)c);
//			}
//		});
//		IntStream.rangeClosed('A', 'F').filter(c -> c != 'D').forEach(c -> arListChar.add((char) c));
//		arListChar.forEach(System.out::println);
		
//		5개의 문자열을 모두 소문자로 변경(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
//		ArrayList<String> arListString = new ArrayList<String>(Arrays.asList("Black", "WHITE", "reD", "yeLLow", "PINk"));
//		arListString.stream().map(c -> c.toLowerCase()).forEach(System.out::println);
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력
//		ArrayList<Integer> arListInt = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 100).filter(c -> c % 2 == 1).forEach(arListInt::add);
//		arListInt.forEach(System.out::println);
		
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
//		ArrayList<String> arListString = new ArrayList<String>(Arrays.asList("Apple","banana","Melon"));
//		arListString.stream().filter(c -> c.charAt(0)>='A' && c.charAt(0)<='Z').forEach(System.out::println);
		
//		한글을 정수로 변경
		String hans = "영일이삼사오육칠팔구";
		String jungSu = "일삼이사";
		jungSu.chars().map(hans::indexOf).forEach(System.out::print);
		
		
		HashMap<String, Integer> hangle = new HashMap<String, Integer>();
//		ArrayList<String> arListHans = new ArrayList<String>();
//		
		IntStream.range(0, 10).forEach(c -> hangle.put("" + hans.charAt(c), c));
////		System.out.println(hangle);	// {칠=7, 영=0, 육=6, 이=2, 오=5, 팔=8, 일=1, 삼=3, 사=4, 구=9}
//		IntStream.range(0, jungSu.length()).forEach(c -> System.out.print(hangle.get("" + (char)jungSu.chars().toArray()[c])));
		
		
//		ArrayList<String> arListHan = new ArrayList<String>(Arrays.asList("영","일", "이", "삼", "사", "오", "육", "칠", "팔", "구"));
//		IntStream.range(0, 10).forEach(c -> arListHan.set(c, "" + c));
//		arListHan.forEach(System.out::println);
		
////		정수를 한글로 변경
//		ArrayList<Integer> arListInt = new ArrayList<Integer>();
//		IntStream.range(0, 10).map(c -> arListInt.set(c, arListHan.get(c)));
		HashMap<Integer, String> hangle2 = new HashMap<Integer, String>();
		IntStream.range(0, 10).forEach(c -> hangle2.put(c, "" + hans.charAt(c)));
//		System.out.println(hangle2);	// {0=영, 1=일, 2=이, 3=삼, 4=사, 5=오, 6=육, 7=칠, 8=팔, 9=구}
		
		Integer tempInt = 3316;
		String tempStr = "" + tempInt;
		
		IntStream.range(0, tempStr.length()).forEach(c -> System.out.print(hangle2.get(Integer.parseInt("" + tempStr.charAt(c)))));
		
		
//		ArrayList<String> arListString = new ArrayList<String>();
//		tempInt
//		(c ->  hans.charAt(c))
		
//		.foreach(System.out::prinln);
		
		
		
		
		
		
	}
}
