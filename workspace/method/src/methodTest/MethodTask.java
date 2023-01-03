package methodTest;

public class MethodTask {

//	1~10까지 println()으로 출력하는 메소드
	public void printNums() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

//	"홍길동"을 n번 println()으로 출력하는 메소드
	public void pringHGD(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println("홍길동");
		}
	}

//	이름을 n번 println()으로 출력하는 메소드
	public void printName(String name, int times) {
		for (int i = 0; i < times; i++) {
			System.out.println(name);
		}
	}

//	세 정수의 뺄셈을 해주는 메소드
	public int subtract(int num1, int num2, int num3) {
		int result = num1 - num2 - num3;
		return result;
	}

//	두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
	public int[] func(int[] nums) {
		int[] result = null;

		if (nums[1] != 0) {
			result = new int[2];
			result[0] = nums[0] / nums[1];
			result[1] = nums[0] % nums[1];
		}
		return result;
	}

	void div(int[] arNums) {
		int[] result = null;
		if (arNums[1] != 0) {
			result = new int[2];
			result[0] = arNums[0] / arNums[1];
			result[1] = arNums[0] % arNums[1];
		}

	}

//	1~n까지의 합을 구해주는 메소드
	int sum(int end) {
		int sum = 0;
		for (int i = 0; i < end; i++) {
			sum += i + 1;
		}
		return sum;
	}

//	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int odd(int num) {
		return num++;
	}

//	문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String upperLower(String str) {
		char[] arStr = new char[str.length()];
		char temp = ' ';
		String result = "";
		for (int i = 0; i < arStr.length; i++) {
			arStr[i] = str.charAt(i);
			temp = arStr[i];
			if (temp >= 'a' && temp <= 'z') {
				temp -= ' ';
			} else if (temp >= 'A' && temp <= 'Z') {
				temp += ' ';
			} else {
				result += temp;
			}
		}

		return result;

	}

//	문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int howManyChars(String str, char pick) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == pick) {
				result++;
			}
		}
		return result;
	}

//	5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
	int indexFromNums(int[] ints, int index) {
		int result = 0;
		if (index >= 0) {
			result = ints[index];
		} else {
			result = -1;
		}
		return result;
	}

//	한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	int hanToInt(String arHanStr) {
		String hans = "공일이삼사오육칠팔구";
		char[] arHanChar = new char[arHanStr.length()];
		String result = "";
		for (int i = 0; i < arHanStr.length(); i++) {
//			arHanChar[i] = ;
			result += hans.indexOf(arHanStr.charAt(i));
		}

		return Integer.parseInt(result);
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	int[] maxAndMin(int[] ints) {
		int[] result = new int[2];
		int max = 0, min = 0;
		max = ints[0];
		min = ints[0];
		for (int i = 0; i < ints.length; i++) {
			if (max < ints[i]) {
				max = ints[i];
			} else if (min > ints[i]) {
				min = ints[i];
			}
		}
		result[0] = max;
		result[1] = min;

		return result;
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void)
	void maxAndMin(int[] ints, int[] result) {

		int max = 0, min = 0;
		max = ints[0];
		min = ints[0];
		for (int i = 0; i < ints.length; i++) {
			if (max < ints[i]) {
				max = ints[i];
			} else if (min > ints[i]) {
				min = ints[i];
			}
		}
		result[0] = max;
		result[1] = min;
	}

//	indexOf() 만들기
//	문자열과 문자를 입력 받은 뒤 해당 문자가 몇번째 인덱스에 있는지 검사하고
//	만약 해당 문자가 없으면 -1을 리턴한다.
	int indexOfT(String str, char c) {
		char temp = ' ';
//		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == c) {
				return i;
			}
		}
		return -1;
	}
	
	
	int indexOf(String str, char c) {
		char temp = ' ';
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i);
			if (temp == c) {
				result = i;
			} else {
				result = -1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MethodTask mt = new MethodTask();

		char r = 'r';
		String str = "Str";
		int result = mt.indexOf(str, r);
		if (result != -1) {
			System.out.printf("%s문자열 %d번째 인덱스에 %c 있음", str, result, r);
		} else {
			System.out.printf("%s에 %c 없음", str, r);
		}

//		String splitLine = "--------------";
//
//		mt.printNums();
//		System.out.println(splitLine);
//
//		mt.pringHGD(3);
//		System.out.println(splitLine);
//
//		mt.printName("이름", 5);
//		System.out.println(splitLine);
//
//		System.out.println(mt.subtract(9, 3, 1));
//		Scanner sc = new Scanner(System.in);
//		int[] nums = {sc.nextInt(), sc.nextInt()};

//		int[] nums = { 12, 0 };

//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(mt.func(nums)[i]);
//		}
//		System.out.println(mt.func(nums)[0] + ", " + mt.func(nums)[1]);;

//		System.out.println(mt.result[0] + ", " + mt.result[1]);

//		System.out.println(mt.sum(100));

//		System.out.println(mt.upperLower("StringAndTurttle"));

//		System.out.println(mt.howManyChars("EndEndoes", 'e'));

//		System.out.println(mt.hanToInt("사공공공사"));

//		int[] arInts = { 10, 2, 8, 4, 3 };
//		int[] arResult = new int[2];
//		mt.maxAndMin(arInts, arResult);
//		System.out.println(arResult[0] + ", " + arResult[1]);

	}
}
