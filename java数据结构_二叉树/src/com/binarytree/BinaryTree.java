package com.binarytree;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {

		int select = 0;

		MyBinaryTree binaryTree = new MyBinaryTree(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("=========二叉树操作=========");

			System.out.println("         1、创建二叉树");

			System.out.println("         2、前序遍历");

			System.out.println("         3、中序遍历");

			System.out.println("         4、后序遍历");

			System.out.println("         5、退出");

			System.out.println("===========================");

			System.out.println("请选择二叉树的操作：");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("输入有误，返回主菜单！");

				continue;

			}

			switch (select) {

			case 1:// 创建树

				int array[] = { 93, 56, 87, 9, 75, 16, 62, 28, 41, 33 };

				binaryTree.buildBinaryTree(array);

				break;

			case 2:// 前序遍历

				binaryTree.preOrder();

				break;

			case 3:// 中序遍历

				binaryTree.midOrder();

				break;

			case 4:// 后序遍历

				binaryTree.postOrder();

				break;

			case 5:// 退出

				System.out.println("程序退出！");

				break bh;

			default:

				System.out.println("选择的功能不存在，返回主菜单！");

			}
		}

		scanner.close();
	}

}
