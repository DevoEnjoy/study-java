package classTest;

public class ClassTask2 {
////	최대값, 최소값 구하기
//	void getMaxAndMin(int[] arData, Result result) {
//		result.max = arData[0];
//		result.min = arData[0];
//		
//	}
	
//	학생번호, 국어점수, 영어점수, 수학점수를 입력받은 후 총합과 평균 구하기
	void getSumAndAvg(Student cScore) {
		cScore.avg();
		cScore.total();
	}
	
	
	public static void main(String[] args) {
		Student cScore = new Student(1, 90, 70, 80);
		ClassTask2 ct = new ClassTask2();
		ct.getSumAndAvg(cScore);
		System.out.println("sum: " + cScore.total + "\navg :" + cScore.avg);
		
		
		
	}
}
