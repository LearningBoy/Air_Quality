package com.binarytree;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {

		int select = 0;

		MyBinaryTree binaryTree = new MyBinaryTree(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("=========����������=========");

			System.out.println("         1������������");

			System.out.println("         2��ǰ�����");

			System.out.println("         3���������");

			System.out.println("         4���������");

			System.out.println("         5���˳�");

			System.out.println("===========================");

			System.out.println("��ѡ��������Ĳ�����");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("�������󣬷������˵���");

				continue;

			}

			switch (select) {

			case 1:// ������

				int array[] = { 93, 56, 87, 9, 75, 16, 62, 28, 41, 33 };

				binaryTree.buildBinaryTree(array);

				break;

			case 2:// ǰ�����

				binaryTree.preOrder();

				break;

			case 3:// �������

				binaryTree.midOrder();

				break;

			case 4:// �������

				binaryTree.postOrder();

				break;

			case 5:// �˳�

				System.out.println("�����˳���");

				break bh;

			default:

				System.out.println("ѡ��Ĺ��ܲ����ڣ��������˵���");

			}
		}

		scanner.close();
	}

}
