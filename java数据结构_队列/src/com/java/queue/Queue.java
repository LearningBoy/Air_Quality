package com.java.queue;

import java.util.Scanner;

public class Queue {

	public static void main(String[] args) {

		int select = 0;

		int value = -1;

		MyQueue queue = new MyQueue(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("***************队列操作*******************");

			System.out.println("*              1、进队                                                   *");

			System.out.println("*              2、出队                                                   *");

			System.out.println("*              3、打印                                                   *");

			System.out.println("*              4、退出                                                   *");

			System.out.println("******************************************");

			System.out.println("请选择队列的操作：");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("输入有误，返回主菜单！");

				continue;

			}

			switch (select) {

			// 进队
			case 1:

				System.out.println("请输入要进队的数据：");

				try {

					value = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入错误，返回主菜单!");

					continue;

				}

				queue.set(value);

				break;

			// 出队
			case 2:

				value = queue.get();

				if (value != -1) {

					System.out.println("要出队的数据为" + value);

				}

				break;

			// 打印
			case 3:

				queue.print();

				break;

			// 退出
			case 4:

				System.out.println("程序退出！");

				break bh;

			default:

				System.out.println("选择的功能不存在，请重新选择！");

			}

		}

		scanner.close();

	}

}
