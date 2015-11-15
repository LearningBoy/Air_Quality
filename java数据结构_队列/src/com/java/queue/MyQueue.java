package com.java.queue;

/**
 * 队列类封装，实现出队、进队等功能
 * 
 * @author Yun
 *
 */
public class MyQueue {

	// 队列的内存空间的最大下标
	private int maxSize;

	// 队列的内存空间
	private int aQueue[];

	// 队列的前端指针
	int front = -1;

	// 队列的后端指针
	int rear = -1;

	public MyQueue(int maxSize) {

		this.maxSize = maxSize;

		aQueue = new int[maxSize];

	}

	/*************************************************************
	 * 进队函数 *
	 *************************************************************/
	public void set(int value) {

		// 如果队列已满，则不能进队
		if (rear >= maxSize - 1) {

			System.err.println("队列已满，不能进队！");

			return;

		}

		// 将新元素插入队尾
		rear++;

		aQueue[rear] = value;

	}

	/*************************************************************
	 * 出队函数 *
	 *************************************************************/
	public int get() {

		// 如果队头下标不小于队尾下标，则表示队空
		if (front >= rear) {

			System.out.println("队列为空，不能出队");

			return -1;

		}

		// 出队
		int q = aQueue[front + 1];

		// 出队一个，则队列集体前移一位
		for (int i = front + 1; i < rear; i++) {

			aQueue[i] = aQueue[i + 1];

		}

		aQueue[rear] = 0;
		
		rear--;

		return q;

	}

	/*************************************************************
	 * 打印队列 *
	 *************************************************************/
	public void print() {

		// 队列为空，则不打印
		if (front >= rear) {

			System.out.println("空队列！");

			return;

		}

		System.out.println("队列的内容为：");

		for (int i = front + 1; i <= rear; i++) {

			System.out.print(" [" + aQueue[i] + "] ");

		}

		System.out.println();

	}
}
