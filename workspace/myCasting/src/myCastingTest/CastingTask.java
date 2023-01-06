package myCastingTest;

//	넷플릭스

//	애니메이션, 영화, 드라마 클래스 선언
//	사용자가 선택한 영상이
//	애니메이션이라면 "자막지원"기능 사용
//	영화라면 "4D"기능 사용
//	드라마라면 "굿즈"기능 사용

public class CastingTask {

	String downCasting(Video video) {
		if (video instanceof Drama) {
			return "드라마 : 굿즈 판매";
//			return (Drama) son;
		} else if (video instanceof Film) {
			return "영화 : 4D";
//			return (Film) son;
		} else if (video instanceof Animation) {
			return "애니메이션 : 자막지원";
//			return (Animation) son;
		}
		return null;
	}

	public static void main(String[] args) {
		Video drama = new Drama(/* "빅뱅이론", 130 */);
		CastingTask ct = new CastingTask();
		System.out.println(ct.downCasting(drama));
	}
}
