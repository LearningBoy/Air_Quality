package com.java.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Linkedlist {

	public static void main(String[] args) {

		int select = 0;

		int value = -1;

		int temp = 0;

		MyLinkedlist linkedlist = new MyLinkedlist(10);

		InputStreamReader ir = new InputStreamReader(System.in);

		BufferedReader in = new BufferedReader(ir);

		bh: while (true) {

			System.out.println("********* 链表操作   ***********");

			System.out.println("*         1、插入                                *");

			System.out.println("*         2、删除                                *");

			System.out.println("*         3、修改                                *");

			System.out.println("*         4、查询                                *");

			System.out.println("*         5、打印                                *");

			System.out.println("*         6、退出                                *");

			System.out.println("******************************");

			System.out.println("请选择链表的操作: ");

			try {

				select = Integer.parseInt(in.readLine());

			} catch (Exception e) {

				System.out.println("输入有误，返回主菜单");

				continue;

			}

			switch (select) {

			// 插入
			case 1:

				System.out.println("请输入要插入的数据：");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;

				}

				linkedlist.insert(value);

				break;

			// 删除
			case 2:

				System.out.println("请输入要删除的数据：");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;

				}

				linkedlist.delete(value);

				break;

			// 修改
			case 3:

				System.out.println("请输入要替换的数据：");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;

				}

				System.out.println("请输入新的数据：");

				try {

					temp = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;

				}

				linkedlist.update(value, temp);

				break;

			// 查询
			case 4:

				System.out.println("请输入要查询的数据：");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单");

					continue;

				}

				linkedlist.select(value);

				break;

			// 打印
			case 5:

				linkedlist.print();

				break;

			// 退出
			case 6:

				System.out.println("程序退出");

				break bh;

			default:

				System.out.println("选择的功能不存在，返回主菜单");

			}
		}
	}

}
