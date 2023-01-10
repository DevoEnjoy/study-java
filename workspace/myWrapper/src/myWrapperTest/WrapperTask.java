package myWrapperTest;

public class WrapperTask {
	public static void main(String[] args) {
		// 1, 12.5, 86.6F, 'Z', "Hi", false
		// 위 6개의 값을 6칸 배열에 담기
		Object[] arObjects = { 1, 12.5, 86.6F, 'Z', "Hi", false };
		for (int i = 0; i < arObjects.length; i++) {
			System.out.println(i + 1 + ". " + arObjects[i]);
		}

//		Object[] arObjects = new Object[6];
//		arObjects[0] = 1;
//		arObjects[1] = 12.5;
//		arObjects[2] = 86.6F;
//		arObjects[3] = 'Z';
//		arObjects[4] = "Hi";
//		arObjects[5] = false;

	}
}
