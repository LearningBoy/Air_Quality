package com.java.stack;

import java.util.Scanner;

public class Stack {

	public static void main(String[] args) {

		int select = 0;

		int value = -1;

		MyStack stack = new MyStack(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("==========��ջ����==========");

			System.out.println("          1����ջ");

			System.out.println("          2����ջ");

			System.out.println("          3����ӡ");

			System.out.println("          4���˳�");

			System.out.println("��ѡ���ջ�Ĳ�����");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("�������󣬷������˵���");

				continue;

			}

			switch (select) {

			case 1:// ��ջ

				System.out.println("������Ҫ��ջ�����ݣ�");

				try {

					value = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;
				}

				stack.push(value);

				break;

			case 2:// ��ջ

				value = stack.pop();

				if (value != -1) {

					System.out.println("Ҫ��ջ������Ϊ��" + value);

				}
				break;

			case 3:// ��ӡ

				stack.print();

				break;

			case 4:// �˳�

				System.out.println("�����˳���");

				break bh;

			default:

				System.out.println("ѡ���ܲ����ڣ��������˵���");

			}
		}

		// �ر�������
		scanner.close();
	}

}
