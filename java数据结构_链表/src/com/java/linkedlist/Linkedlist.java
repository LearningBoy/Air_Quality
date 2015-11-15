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

			System.out.println("********* �������   ***********");

			System.out.println("*         1������                                *");

			System.out.println("*         2��ɾ��                                *");

			System.out.println("*         3���޸�                                *");

			System.out.println("*         4����ѯ                                *");

			System.out.println("*         5����ӡ                                *");

			System.out.println("*         6���˳�                                *");

			System.out.println("******************************");

			System.out.println("��ѡ������Ĳ���: ");

			try {

				select = Integer.parseInt(in.readLine());

			} catch (Exception e) {

				System.out.println("�������󣬷������˵�");

				continue;

			}

			switch (select) {

			// ����
			case 1:

				System.out.println("������Ҫ��������ݣ�");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;

				}

				linkedlist.insert(value);

				break;

			// ɾ��
			case 2:

				System.out.println("������Ҫɾ�������ݣ�");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;

				}

				linkedlist.delete(value);

				break;

			// �޸�
			case 3:

				System.out.println("������Ҫ�滻�����ݣ�");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;

				}

				System.out.println("�������µ����ݣ�");

				try {

					temp = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;

				}

				linkedlist.update(value, temp);

				break;

			// ��ѯ
			case 4:

				System.out.println("������Ҫ��ѯ�����ݣ�");

				try {

					value = Integer.parseInt(in.readLine());

				} catch (Exception e) {

					System.out.println("�������󣬷������˵�");

					continue;

				}

				linkedlist.select(value);

				break;

			// ��ӡ
			case 5:

				linkedlist.print();

				break;

			// �˳�
			case 6:

				System.out.println("�����˳�");

				break bh;

			default:

				System.out.println("ѡ��Ĺ��ܲ����ڣ��������˵�");

			}
		}
	}

}
