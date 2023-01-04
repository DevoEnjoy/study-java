package classTest;

public class Student {
	int number;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	
	
	

	public Student(int number, int kor, int eng, int math) {
		this.number = number;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = this.total / 3.0;
	}

	void total() {
		total = kor + eng + math;
	}

	void avg() {
		total();
		avg = total / 3;
	}

}
