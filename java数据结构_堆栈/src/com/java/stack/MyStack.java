package com.java.stack;

/**
 * 类MyStack是堆栈类，封装了堆栈的操作
 * 
 * @author Yun
 *
 */
public class MyStack {

	// 堆栈的内存空间的最大下标
	private int maxSize;

	// 堆栈的内存空间
	private int aStack[];

	// 堆栈的内存空间的指针
	private int top = -1;

	// 构造方法
	public MyStack(int maxSize) {

		this.maxSize = maxSize;

		aStack = new int[maxSize];
	}

	/************************
	 * 进栈 *
	 ************************/
	public void push(int value) {

		if (top >= maxSize - 1)

			System.out.println("堆栈已满，不能进栈！");

		else {

			top++;

			aStack[top] = value;

		}
	}

	/************************
	 * 出栈 *
	 ************************/
	public int pop() {

		int temp = -1;

		if (top < 0) {

			System.out.println("堆栈已空，不能出栈！");

			return -1;

		}

		temp = aStack[top];

		top--;

		return temp;
	}

	/************************
	 * 打印栈 *
	 ************************/
	public void print() {

		if (top < 0) {

			System.out.println("空堆栈！");

			return;
		}

		System.out.println("堆栈内容为:");

		for (int i = top; i >= 0; i--) {

			System.out.print(" [" + aStack[i] + "]");
		}

		System.out.println();

	}
}
