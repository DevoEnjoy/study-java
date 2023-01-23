package level2;

import java.util.Random; // 임의의 수를 입력하기 위한 랜덤 임포트
import java.util.Scanner; // 플레이어 입력을 위한 스캐너 임포트

public class NumBaseball_721 { // 클래스 이름은 게임명
    public static void main(String[] args) { // 메인메서드 시작
        Random r = new Random(); // 랜덤메서드 객체 선언
        Scanner sc = new Scanner(System.in); // 스캐너메서드 객체 선언
        int[] rnums = new int[3]; // 랜덤숫자를 담을 배열 선언
        int[] input_nums = { 0, 0, 0 }; // 플레이어 입력 변수를 담을 배열 선언 및 초기화
        int times = 0; // 플레이어 문제풀이 횟수를 담을 변수 선언
        System.out.println("Line13");
        rnums[0] = r.nextInt(8) + 1;; // 랜덤숫자를 담을 변수 중 첫번째는 바로 입력
        System.out.println(rnums[0]);
        boolean num123 = (rnums[0] == rnums[1]) || (rnums[0] == rnums[2]) || (rnums[1] == rnums[2]);
        // 랜덤숫자가 서로 같은 게 하나라도 있을 경우에 따른 boolean값을 담을 변수
        while (num123) { // 위 boolean값을 담은 값
            rnums[1] = r.nextInt(8) + 1; // 두번째 숫자에 랜덤숫자를 다시 대입
            rnums[2] = r.nextInt(8) + 1; // 세번째 숫자에 랜덤숫자를 다시 대입
        }
        System.out.println(rnums[1]);
        System.out.println(rnums[2]);
        System.out.println("Line21");
        while (rnums[0] != input_nums[0] || rnums[1] != input_nums[1] || rnums[2] != input_nums[2]) {
            // 랜덤숫자와 플레이어 입력 숫자가 하나라도 틀리면 while문 진입함.
            // 반대로, 모두 같으면(정답이면) while문 진입하지 않음.
            int strike = 0; // 게임기능 스트라이크를 담을 변수 선언 및 초기화
            int ball = 0; // 게임기능 볼을 담을 변수 선언 및 초기화

            try {
                System.out.print("숫자 >> "); // 입력 안내메시지
//                input_nums[0] = sc.nextInt(); // 첫번째자리 입력
//                input_nums[1] = sc.nextInt(); // 두번째자리 입력
//                input_nums[2] = sc.nextInt(); // 세번째자리 입력
                for (int i = 0; i < 3; i++) {
                	input_nums[i] = sc.nextInt(); // 각자리 입력
				}

                boolean ip0 = (input_nums[0] >= 10) ||  (input_nums[0] <= 0);
                boolean ip1 = (input_nums[1] >= 10) ||  (input_nums[1] <= 0);
                boolean ip2 = (input_nums[2] >= 10) ||  (input_nums[2] <= 0);
                if (ip0 || ip1 || ip2) {
                    continue;
                }

            } catch (Exception e) {
                System.err.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");
                continue;
            }

            times++; // 시도횟수 증감식. 제대로 입력했을 경우에만 증가하도록 함.

            for (int i = 0; i < input_nums.length; i++) {
                if (rnums[i] == input_nums[i]) {
                    strike += 1;
                } else {
                    if (i == 0) {
                        if (rnums[0] == input_nums[1] || rnums[0] == input_nums[2]) {
                            ball += 1;
                        }
                    } else if (i == 1) {
                        if (rnums[1] == input_nums[0] || rnums[1] == input_nums[2]) {
                            ball += 1;
                        }
                    } else if (i == 2) {
                        if (rnums[2] == input_nums[1] || rnums[2] == input_nums[0]) {
                            ball += 1;
                        }
                    }

                }
            }

            System.out.printf("%dS %dB\n", strike, ball);
            // 게임결과 출력
            System.out.println();
            // 가독성을 위한 줄바꿈

        }

        System.out.printf("축하합니다! %d번만에 문제를 맞혔습니다.", times);

    }
}