package dateTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		LocalDateTime localDateTime = LocalDateTime.now();
		String dateForm = localDateTime.format(dateTimeFormatter);
//		System.out.println(now);
//		System.out.println(localDateTime);
		System.out.println(dateForm);
		
		
		
		
		
		
		
		
	}
}
