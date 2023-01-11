package myHashMapTest;

import java.util.ArrayList;
import java.util.Random;

public class JSONTest {
	public static void main(String[] args) {
		Random r = new Random();
		String sex = "";
		int count = 10;
		ArrayList<Member> arListMember = new ArrayList<Member>();
		
		for (int i = 0; i < count; i++) {
			sex = r.nextInt(2) == 1 ? "MALE" : "FEMALE";
			arListMember.add(new Member("ljs" + i, "ÀÌÁØ»ó" + i, 20 + i, sex));
		}
		
		for (Member member : arListMember) {
			System.out.println(member.toString());
		}
		
	}
}
