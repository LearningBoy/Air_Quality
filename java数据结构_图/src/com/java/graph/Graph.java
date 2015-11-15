package com.java.graph;

import java.util.Scanner;

public class Graph {

	public static void main(String[] args) {

		int select = 0;

		int begin = -1;

		int end = -1;

		MyGraph graph = new MyGraph();

		Scanner scanner = new Scanner(System.in);
		
		bh: while (true) {

			System.out.println("======无向图的操作=======");

			System.out.println("1、深度优先遍历");

			System.out.println("2、广度优先遍历");

			System.out.println("3、最短路径");

			System.out.println("4、打印图");

			System.out.println("5、退出");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("输入有误，返回主菜单！");

				continue;

			}

			switch (select) {

			case 1:

				System.out.println("请输入一个顶点(1-8):");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单！");

					continue;

				}

				graph.depthFirstSearch(begin);

				break;

			case 2:

				System.out.println("请输入一个顶点(1-8)：");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单！");

					continue;

				}

				graph.breadthFirstSearch(begin);

				break;

			case 3:

				System.out.println("请输入一个开始顶点(1-8)：");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单！");

					continue;

				}

				System.out.println("请输入一个结束顶点(1-8)：");

				try {

					end = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("输入有误，返回主菜单！");

					continue;

				}

				graph.floyed(begin, end);

				break;

			case 4:

				graph.print();

				break;

			case 5:

				System.out.println("程序退出！");

				break bh;

			default:

				System.out.println("选择的功能不存在！程序返回主菜单！");

				break;

			}

		}

		scanner.close();

	}

}
