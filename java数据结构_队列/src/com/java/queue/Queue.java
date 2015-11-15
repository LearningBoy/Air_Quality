package com.java.queue;

import java.util.Scanner;

public class Queue {

	public static void main(String[] args) {

		int select = 0;

		int value = -1;

		MyQueue queue = new MyQueue(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("***************���в���*******************");

			System.out.println("*              1������                                                   *");

			System.out.println("*              2������                                                   *");

			System.out.println("*              3����ӡ                                                   *");

			System.out.println("*              4���˳�                                                   *");

			System.out.println("******************************************");

			System.out.println("��ѡ����еĲ�����");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("�������󣬷������˵���");

				continue;

			}

			switch (select) {

			// ����
			case 1:

				System.out.println("������Ҫ���ӵ����ݣ�");

				try {

					value = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("������󣬷������˵�!");

					continue;

				}

				queue.set(value);

				break;

			// ����
			case 2:

				value = queue.get();

				if (value != -1) {

					System.out.println("Ҫ���ӵ�����Ϊ" + value);

				}

				break;

			// ��ӡ
			case 3:

				queue.print();

				break;

			// �˳�
			case 4:

				System.out.println("�����˳���");

				break bh;

			default:

				System.out.println("ѡ��Ĺ��ܲ����ڣ�������ѡ��");

			}

		}

		scanner.close();

	}

}
