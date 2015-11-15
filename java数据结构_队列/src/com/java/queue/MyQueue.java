package com.java.queue;

/**
 * �������װ��ʵ�ֳ��ӡ����ӵȹ���
 * 
 * @author Yun
 *
 */
public class MyQueue {

	// ���е��ڴ�ռ������±�
	private int maxSize;

	// ���е��ڴ�ռ�
	private int aQueue[];

	// ���е�ǰ��ָ��
	int front = -1;

	// ���еĺ��ָ��
	int rear = -1;

	public MyQueue(int maxSize) {

		this.maxSize = maxSize;

		aQueue = new int[maxSize];

	}

	/*************************************************************
	 * ���Ӻ��� *
	 *************************************************************/
	public void set(int value) {

		// ����������������ܽ���
		if (rear >= maxSize - 1) {

			System.err.println("�������������ܽ��ӣ�");

			return;

		}

		// ����Ԫ�ز����β
		rear++;

		aQueue[rear] = value;

	}

	/*************************************************************
	 * ���Ӻ��� *
	 *************************************************************/
	public int get() {

		// �����ͷ�±겻С�ڶ�β�±꣬���ʾ�ӿ�
		if (front >= rear) {

			System.out.println("����Ϊ�գ����ܳ���");

			return -1;

		}

		// ����
		int q = aQueue[front + 1];

		// ����һ��������м���ǰ��һλ
		for (int i = front + 1; i < rear; i++) {

			aQueue[i] = aQueue[i + 1];

		}

		aQueue[rear] = 0;
		
		rear--;

		return q;

	}

	/*************************************************************
	 * ��ӡ���� *
	 *************************************************************/
	public void print() {

		// ����Ϊ�գ��򲻴�ӡ
		if (front >= rear) {

			System.out.println("�ն��У�");

			return;

		}

		System.out.println("���е�����Ϊ��");

		for (int i = front + 1; i <= rear; i++) {

			System.out.print(" [" + aQueue[i] + "] ");

		}

		System.out.println();

	}
}
