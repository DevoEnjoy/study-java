package test;

import java.util.Random;
import java.util.Scanner;

public class Asd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // �Է� ���� �غ�(choice)
		Random r = new Random(); // ���� ���� �غ�(��ȣǥ)

		// ������ ���
		// 1. ������ ��й�ȣ ����
		// 2. ����ȣ ���� ���
		// 3. ��ٱ��� ���
		// 4. ��ٱ��� �ʱ�ȭ ���

		String adminCode = "0000"; // ������ ��й�ȣ�� ������ ����

		int hamPrice = 1500; // �ܹ��� �ʱⰡ��
		int gamPrice = 2000; // ����Ƣ�� �ʱⰡ��
		int colaPrice = 500; // �ݶ� �ʱⰡ��
		int hamCnt = 0; // �ܹ��� ������ ������ ����
		int gamCnt = 0; // ��Ƣ ������ ������ ����
		int colaCnt = 0;// �ݶ� ������ ������ ����

		String menu1 = "�ܹ���"; // ù��° �޴� �̸�
		String menu2 = "����Ƣ��";// �ι�° �޴� �̸�
		String menu3 = "�ݶ�"; // ����° �޴� �̸�

		String errMsg = "�ٽ� �Է��ϼ���."; // �߸� �Է����� ��� ����� ���� �޽���
		String goToMain = "���θ޴��� ���ư��ϴ�."; // ���θ޴��� ���ư� �� ����� �ȳ��޽���
		String profit = "���� �Ϸ�!"; // ���� �Ϸ�� ��� �޽���
		String fail = "���� ����!"; // ���� ���н� ��� �޽���

		while (true) { // ���θ޴�
			hamCnt = 0;
			gamCnt = 0;
			colaCnt = 0;
			System.out.println("�ڡ١ڡپ������ڡ١ڡ�");
			System.out.println("������������������������������������");
			System.out.println("��1.�ֹ��ϱ�        ��");
			System.out.println("��2.�����ڸ޴�  	 ��");
			System.out.println("������������������������������������");
			System.out.print("�Է� >> "); // �ֹ��ϱ�
										// Ȥ��
										// �����ڸ޴�
										// ����
			int choice = Integer.parseInt(sc.nextLine());// �Է��� ���� ���� choice

			if (choice == 1) { // �ֹ��ϱ� ȭ��
				while (true) {// ���ĸ޴���� while�� ���� �߰�ȣ
					System.out.println("�� ��������������������ǥ������������������\t��");
					System.out.printf("�� 1. %-4s\t-%5d�� ��\n", menu1, hamPrice); // �ܹ���
					System.out.printf("�� 2. %-4s\t-%5d�� ��\n", menu2, gamPrice); // ����Ƣ��
					System.out.printf("�� 3. %-4s\t-%5d�� ��\n", menu3, colaPrice);// �ݶ�
					System.out.println("�� ������������������������������������������\t��");
					System.out.println("4. �����ϱ�"); // �����ϱ�� �̵�
					System.out.println("5. ��ٱ��� ����"); // hamCnt, gamCnt, colaCnt �ʱ�ȭ
					System.out.println("6. ���θ޴��� ���ư���");// ���θ޴��� �̵�
					System.out.print("�Է� >> "); // �Է� �ȳ� �޽���
					choice = Integer.parseInt(sc.nextLine()); // �ֹ� �޴� ��ȣ �Է�
					int tempCnt = 0; // ���� ���� tempCnt ����
					if (choice == 1 || choice == 2 || choice == 3) {
						do {
							System.out.print("���� >> ");
							tempCnt = Integer.parseInt(sc.nextLine()); // ����
																		// ����
																		// tempCnt
																		// �Է�
						} while (tempCnt < 0); // ������ 0���� �۰� �Է��ϸ� �ٽ� �Է��ϰ� �̵�
						if (tempCnt == 0) { // ������ 0�� �Է��ϸ� ���ĸ޴��� �ٽ� �̵�
							continue; // ���ĸ޴��� �̵�
						}
					}

					if (choice == 1) { // 1. �ܹ��� ����
						hamCnt += tempCnt;
						System.out.printf("��ٱ��Ͽ� %s %d�� �߰� �Ϸ�!\n", menu1, hamCnt); // �޴�1 �ܹ��� ��ٱ��� �ȳ� �޽���
					} else if (choice == 2) { // 2. ����Ƣ�� ����
						gamCnt += tempCnt;
						System.out.printf("��ٱ��Ͽ� %s %d�� �߰� �Ϸ�!\n", menu2, gamCnt); // �޴�2 ����Ƣ�� ��ٱ��� �ȳ� �޽���
					} else if (choice == 3) { // 3. �ݶ� ����
						colaCnt += tempCnt;
						System.out.printf("��ٱ��Ͽ� %s %d�� �߰� �Ϸ�!\n", menu3, colaCnt); // �޴�3�ݶ� ��ٱ��� �ȳ� �޽���
					} else if (choice == 4) { // 4. �����ϱ�
						int total = hamCnt * hamPrice + gamCnt * gamPrice + colaCnt * colaPrice; // ���� �ʿ� �ݾ� ���� ����
						System.out.println("�����Ͻðڽ��ϱ�?"); // �������� ���� �޽���
						System.out.println("�� ���� �ݾ� : " + total); // �ʿ��� ���� �ݾ� �ȳ� �޽���
						System.out.print("�ݾ� �Է� >> "); // �ݾ� �Է� �ȳ� �޽���
						int money = Integer.parseInt(sc.nextLine()); // �ݾ� �Է� ���� money ����
						if (money >= total) { // �Է��� �ݾ��� ������ �ݾ׺��� ũ�ų� ���� ���(���� ������ ���)
							System.out.println("�Էµ� �ݾ� : \t" + money); // �Է��� �ݾ�
							System.out.println("�� ���� �ݾ� : \t" + total); // �ʿ��� ���� �ݾ�
							if (money > total) { // �Է� �ݾ��� ������ �ʿ��� �ݾ׺��� ���� ���
								System.out.println("��ȯ�� �ݾ� : \t" + (money - total)); // �ܵ� �ȳ� �޽���
							}
							System.out.printf("����ȣ : %04d\n", r.nextInt(9999) + 1); // ����ȣ ��� �޽���
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n�Ļ� ���ְ� �ϼ���!\n"); // �����Ϸ� �ȳ� �޽���

						} else { // money > total �Է� �ݾ��� ������ �ʿ��� �ݾ׺��� ���� ���
							System.out.println("�ܾ��� �����մϴ�."); // �ȳ� �޽���
							System.out.println(goToMain); // ���θ޴� ���� �޽���
						}
						break; // ���θ޴� ����

					} else if (choice == 5) { // ��ٱ��� �ʱ�ȭ
						hamCnt = 0;
						gamCnt = 0;
						colaCnt = 0;
					} else if (choice == 6) { // 6. ���θ޴��� ���ư���
						System.out.println(goToMain); // ���θ޴� ���� �޽���
						break; // ���θ޴� ����
					} else {
						System.out.println(errMsg);
					}
					// ���� ��ٱ��Ͽ� ����ִ� ���ĵ� ����ϱ�
					System.out.println();
					System.out.println("�� ����ٱ��Ϧ� ��");
					if (hamCnt >= 1) {
						System.out.printf("��%s\t: %d����\n", menu1, hamCnt);
					}
					if (gamCnt >= 1) {
						System.out.printf("��%s\t: %d����\n", menu2, gamCnt);
					}
					if (colaCnt >= 1) {
						System.out.printf("��%s\t: %d����\n", menu3, colaCnt);
					}
					System.out.println();
					System.out.println("�� ���������������� ��");
				} // ���ĸ޴����
					// while��
					// �ݴ�
					// �߰�ȣ

			} else if (choice == 2) { // �����ڸ޴� ȭ��
				System.out.print("��й�ȣ >> ");
				String code = sc.nextLine(); // �Է¹��� ��й�ȣ
				if (!adminCode.equals(code)) { // �����ں�й�ȣ�� �Էµ� ���� �ٸ��ٸ�
					System.out.println("�߸��� �����Դϴ�.");
					continue;

				}
				// ������� �Դٴ� �� ��й�ȣ�� �� �ԷµǾ��ٴ� ��.
				System.out.println("1.�����ϱ�");
				System.out.println("2.��й�ȣ�缳��");
				System.out.println("3.���� ����");
				System.out.print("�Է� >> ");
				choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					System.out.println("���õ� ����߽��ϴ�.");
					break;
				} else if (choice == 2) {
					System.out.print("�� ��й�ȣ �Է� >> ");
					String newPw = sc.nextLine();

					System.out.print("��й�ȣ Ȯ�� >> ");
					String tempPw = sc.nextLine();
					// ���� ������ ��й�ȣ�� ��й�ȣ Ȯ���� ���ٸ�
					// ���� ����! ��� �� ���θ޴��� �̵�,
					// ���� �ʴٸ� ���� ����! ��� �� ���θ޴��� �̵�
					if (!newPw.equals(tempPw)) {
						System.out.println(fail);
						continue;
					}
					System.out.println(profit);
					adminCode = newPw;

				} else if (choice == 3) {
					System.out.println("������ ������ �޴��� ������");
					System.out.println("1.�ܹ���\n2.����Ƣ��\n3.�ݶ�");
					System.out.print("�Է� >> ");
					choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						System.out.printf("%s ���� ���� : %d\n", menu1, hamPrice);
						System.out.println("�ٲ� ������ �Է��ϼ���.");
						System.out.print("�Է� >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("�Էµ� �ݾ� : %d\n", dummyPrice);
						System.out.println("�� �������� �����Ͻðڽ��ϱ�?");
						System.out.println("1.��\n2.�ƴϿ�(���θ޴��� �̵�)");
						System.out.println("�Է� >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							hamPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					} else if (choice == 2) {
						System.out.printf("%s ���� ���� : %d\n", menu2, gamPrice);
						System.out.println("�ٲ� ������ �Է��ϼ���.");
						System.out.print("�Է� >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("�Էµ� �ݾ� : %d\n", dummyPrice);
						System.out.println("�� �������� �����Ͻðڽ��ϱ�?");
						System.out.println("1.��\n2.�ƴϿ�(���θ޴��� �̵�)");
						System.out.println("�Է� >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							gamPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					} else if (choice == 3) {
						System.out.printf("%s ���� ���� : %d\n", menu3, hamPrice);
						System.out.println("�ٲ� ������ �Է��ϼ���.");
						System.out.print("�Է� >> ");
						int dummyPrice = Integer.parseInt(sc.nextLine());
						System.out.printf("�Էµ� �ݾ� : %d\n", dummyPrice);
						System.out.println("�� �������� �����Ͻðڽ��ϱ�?");
						System.out.println("1.��\n2.�ƴϿ�(���θ޴��� �̵�)");
						System.out.println("�Է� >> ");
						choice = Integer.parseInt(sc.nextLine());
						if (choice == 1) {
							colaPrice = dummyPrice;
							System.out.println(profit);
						} else if (choice == 2) {
						} else {
							System.out.println(errMsg);
						}
						System.out.println(goToMain);
						continue;

					}

				}

			} else { // 1.�ֹ��ϱ� 2.�����ڸ޴� ���� �ٸ� �����Է½�
				System.out.println(errMsg); // �����޽��� ���
			}
			System.out.println();
		} // ���θ޴�while ����
	}
}
