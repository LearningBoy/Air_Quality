package com.java.stack;

import java.util.Scanner;

public class Stack {

	public static void main(String[] args) {

		int select = 0;

		int value = -1;

		MyStack stack = new MyStack(10);

		Scanner scanner = new Scanner(System.in);

		bh: while (true) {

			System.out.println("==========堆栈操作==========");

			System.out.println("          1、进栈");

			System.out.println("          2、出栈");

			System.out.println("          3、打印");

			System.out.println("          4、退出");

			System.out.println("请选择堆栈的操作：");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("输入有误，返回主菜单！");

				continue;

			}

			switch (select) {

			case 1:// 进栈

				System.out.println("请输入要进栈的数据：");

				try {

					value = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;
				}

				stack.push(value);

				break;

			case 2:// 出栈

				value = stack.pop();

				if (value != -1) {

					System.out.println("要出栈的数据为：" + value);

				}
				break;

			case 3:// 打印

				stack.print();

				break;

			case 4:// 退出

				System.out.println("程序退出！");

				break bh;

			default:

				System.out.println("选择功能不存在，返回主菜单！");

			}
		}

		// 关闭输入流
		scanner.close();
	}

}
