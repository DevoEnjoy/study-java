package level2;

import java.util.Random; // ������ ���� �Է��ϱ� ���� ���� ����Ʈ
import java.util.Scanner; // �÷��̾� �Է��� ���� ��ĳ�� ����Ʈ

public class NumBaseball_721 { // Ŭ���� �̸��� ���Ӹ�
    public static void main(String[] args) { // ���θ޼��� ����
        Random r = new Random(); // �����޼��� ��ü ����
        Scanner sc = new Scanner(System.in); // ��ĳ�ʸ޼��� ��ü ����
        int[] rnums = new int[3]; // �������ڸ� ���� �迭 ����
        int[] input_nums = { 0, 0, 0 }; // �÷��̾� �Է� ������ ���� �迭 ���� �� �ʱ�ȭ
        int times = 0; // �÷��̾� ����Ǯ�� Ƚ���� ���� ���� ����
        System.out.println("Line13");
        rnums[0] = r.nextInt(8) + 1;; // �������ڸ� ���� ���� �� ù��°�� �ٷ� �Է�
        System.out.println(rnums[0]);
        boolean num123 = (rnums[0] == rnums[1]) || (rnums[0] == rnums[2]) || (rnums[1] == rnums[2]);
        // �������ڰ� ���� ���� �� �ϳ��� ���� ��쿡 ���� boolean���� ���� ����
        while (num123) { // �� boolean���� ���� ��
            rnums[1] = r.nextInt(8) + 1; // �ι�° ���ڿ� �������ڸ� �ٽ� ����
            rnums[2] = r.nextInt(8) + 1; // ����° ���ڿ� �������ڸ� �ٽ� ����
        }
        System.out.println(rnums[1]);
        System.out.println(rnums[2]);
        System.out.println("Line21");
        while (rnums[0] != input_nums[0] || rnums[1] != input_nums[1] || rnums[2] != input_nums[2]) {
            // �������ڿ� �÷��̾� �Է� ���ڰ� �ϳ��� Ʋ���� while�� ������.
            // �ݴ��, ��� ������(�����̸�) while�� �������� ����.
            int strike = 0; // ���ӱ�� ��Ʈ����ũ�� ���� ���� ���� �� �ʱ�ȭ
            int ball = 0; // ���ӱ�� ���� ���� ���� ���� �� �ʱ�ȭ

            try {
                System.out.print("���� >> "); // �Է� �ȳ��޽���
//                input_nums[0] = sc.nextInt(); // ù��°�ڸ� �Է�
//                input_nums[1] = sc.nextInt(); // �ι�°�ڸ� �Է�
//                input_nums[2] = sc.nextInt(); // ����°�ڸ� �Է�
                for (int i = 0; i < 3; i++) {
                	input_nums[i] = sc.nextInt(); // ���ڸ� �Է�
				}

                boolean ip0 = (input_nums[0] >= 10) ||  (input_nums[0] <= 0);
                boolean ip1 = (input_nums[1] >= 10) ||  (input_nums[1] <= 0);
                boolean ip2 = (input_nums[2] >= 10) ||  (input_nums[2] <= 0);
                if (ip0 || ip1 || ip2) {
                    continue;
                }

            } catch (Exception e) {
                System.err.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
                continue;
            }

            times++; // �õ�Ƚ�� ������. ����� �Է����� ��쿡�� �����ϵ��� ��.

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
            // ���Ӱ�� ���
            System.out.println();
            // �������� ���� �ٹٲ�

        }

        System.out.printf("�����մϴ�! %d������ ������ �������ϴ�.", times);

    }
}