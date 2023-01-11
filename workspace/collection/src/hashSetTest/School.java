package hashSetTest;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student hds = new Student(1, "ÇÑµ¿¼®");
		students.add(hds);
		students.add(hds);
		System.out.println(students);
	}
}
