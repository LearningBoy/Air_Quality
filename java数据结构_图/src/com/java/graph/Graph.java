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

			System.out.println("======����ͼ�Ĳ���=======");

			System.out.println("1��������ȱ���");

			System.out.println("2��������ȱ���");

			System.out.println("3�����·��");

			System.out.println("4����ӡͼ");

			System.out.println("5���˳�");

			try {

				select = scanner.nextInt();

			} catch (Exception e) {

				System.out.println("�������󣬷������˵���");

				continue;

			}

			switch (select) {

			case 1:

				System.out.println("������һ������(1-8):");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("�������󣬷������˵���");

					continue;

				}

				graph.depthFirstSearch(begin);

				break;

			case 2:

				System.out.println("������һ������(1-8)��");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("�������󣬷������˵���");

					continue;

				}

				graph.breadthFirstSearch(begin);

				break;

			case 3:

				System.out.println("������һ����ʼ����(1-8)��");

				try {

					begin = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("�������󣬷������˵���");

					continue;

				}

				System.out.println("������һ����������(1-8)��");

				try {

					end = scanner.nextInt();

				} catch (Exception e) {

					System.out.println("�������󣬷������˵���");

					continue;

				}

				graph.floyed(begin, end);

				break;

			case 4:

				graph.print();

				break;

			case 5:

				System.out.println("�����˳���");

				break bh;

			default:

				System.out.println("ѡ��Ĺ��ܲ����ڣ����򷵻����˵���");

				break;

			}

		}

		scanner.close();

	}

}
