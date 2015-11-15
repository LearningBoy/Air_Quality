package com.java.stack;

/**
 * ��MyStack�Ƕ�ջ�࣬��װ�˶�ջ�Ĳ���
 * 
 * @author Yun
 *
 */
public class MyStack {

	// ��ջ���ڴ�ռ������±�
	private int maxSize;

	// ��ջ���ڴ�ռ�
	private int aStack[];

	// ��ջ���ڴ�ռ��ָ��
	private int top = -1;

	// ���췽��
	public MyStack(int maxSize) {

		this.maxSize = maxSize;

		aStack = new int[maxSize];
	}

	/************************
	 * ��ջ *
	 ************************/
	public void push(int value) {

		if (top >= maxSize - 1)

			System.out.println("��ջ���������ܽ�ջ��");

		else {

			top++;

			aStack[top] = value;

		}
	}

	/************************
	 * ��ջ *
	 ************************/
	public int pop() {

		int temp = -1;

		if (top < 0) {

			System.out.println("��ջ�ѿգ����ܳ�ջ��");

			return -1;

		}

		temp = aStack[top];

		top--;

		return temp;
	}

	/************************
	 * ��ӡջ *
	 ************************/
	public void print() {

		if (top < 0) {

			System.out.println("�ն�ջ��");

			return;
		}

		System.out.println("��ջ����Ϊ:");

		for (int i = top; i >= 0; i--) {

			System.out.print(" [" + aStack[i] + "]");
		}

		System.out.println();

	}
}
