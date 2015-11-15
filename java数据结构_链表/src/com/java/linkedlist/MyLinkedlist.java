package com.java.linkedlist;

/**
 * 链表类封装，实现链表增、删、改、查等功能
 * 
 * @author Yun
 *
 */
public class MyLinkedlist {

	// 数组长度
	private int maxSize;

	// 数据域
	private int data[];

	// 指针域
	private int next[];

	// 链表的头指针
	private int head = -1;

	public MyLinkedlist(int maxSize) {

		this.maxSize = maxSize;

		data = new int[maxSize];

		next = new int[maxSize];

		for (int i = 0; i < maxSize; i++) {

			// 表示还未被使用
			next[i] = -2;

		}

	}

	// 查找得到数组的空闲位置，即可用的数组下标
	private int getFreePos() {

		for (int i = 0; i < maxSize; i++) {

			if (next[i] == -2) {

				return i;

			}
		}

		return -1;

	}

	/****************************************************************
	 * 插入函数 *
	 ****************************************************************/
	public void insert(int value) {

		// 得到空闲的（即可用的）数组下标
		int freePos = getFreePos();

		// 判断数组空间是否用完
		if (freePos == -1) {

			System.out.println("存储空间已满，不能插入!");

			return;

		}

		// 创建新节点
		data[freePos] = value;

		next[freePos] = -1;

		// 如果链表为空，则将新节点放在第一个位置上
		if (head == -1) {

			// 头指针指向第一个节点
			head = freePos;

			return;

		}

		// 头指针插入头位置
		if (value < data[head]) {

			// 新节点指向原来的头节点
			next[freePos] = head;

			// 这时，新节点变成头节点，所以头指针指向新的头节点
			head = freePos;

			return;

		}

		int p = head;

		// 新节点插入中间位置，即p位置之后
		while (next[p] != -1) {

			if (data[p] <= value && data[next[p]] > value) {

				// 新节点指向p的下一个节点
				next[freePos] = next[p];

				// p指向的节点的指针指向新节点
				next[p] = freePos;

				return;

			}

			// p指针乡下移，指向下一个节点
			p = next[p];

		}

		// 新节点插入尾位置
		next[p] = freePos;

	}

	/****************************************************************
	 * 删除函数 *
	 ****************************************************************/
	public void delete(int value) {

		// 如果链表为空，则不能删除
		if (head == -1) {

			System.out.println("链表为空，不能删除！");

			return;

		}

		int p = head;

		// 删除头节点
		if (data[head] == value) {

			// p指向原来的头节点
			p = head;

			// head指向新的头节点，即第二个节点
			head = next[head];

			// 释放p指向的数据节点
			data[p] = 0;

			// 释放p指向的指针节点
			next[p] = -2;

			return;

		}

		p = head;

		int q = p;

		// 删除非头节点
		while (p != -1) {

			// 查找删除元素的节点位置
			if (data[p] == value) {

				// p的上一个节点指向p的下一个节点，即删除p节点
				next[q] = next[p];

				// 释放p所指向的数据节点
				data[p] = 0;

				// 释放p所指向的指针节点
				next[p] = -2;

				return;

			}

			// q指向当前节点，p指向下一个节点，这样q就指向p的前一个节点
			q = p;

			p = next[p];

		}
	}

	/****************************************************************
	 * 修改函数 *
	 ****************************************************************/
	public void update(int oldValue, int newValue) {

		// 如果是空链表，则不能修改
		if (head == -1) {

			System.out.println("链表为空，不能修改！");

			return;

		}

		int p = head;

		int q = p;

		// 遍历数组
		while (p != -1) {

			// 查找修改的节点位置
			if (data[p] == oldValue) {

				// 查找修改元素的位置，找到后赋新值
				data[p] = newValue;

				// p的上一个节点指向p的下一个节点，相当于删除p指向的节点
				next[q] = next[p];

				// 将修改的节点重新插入，以使其保持有序
				insert(data[p]);

				return;

			}

			// q指向当前结点，p指向下一个节点，这样q就相当于指向p的前一个节点
			q = p;

			p = next[p];

		}
	}

	/****************************************************************
	 * 选择函数 *
	 ****************************************************************/
	public void select(int value) {

		// 如果是空链表，则不能查询
		if (head == -1) {

			System.out.println("链表为空，不鞥查询");

			return;

		}

		int p = head;

		// 遍历链表,进行查询
		while (p != -1) {

			if (data[p] == value) {

				System.out.println("要查找的节点在" + p + "位置上！");

				return;
			}

			p = next[p];

		}

		System.out.println("链表中没有要查找的值！");

	}

	/****************************************************************
	 * 输出函数 *
	 ****************************************************************/
	public void print() {

		// 如果链表为空，则不能打印
		if (head == -1) {

			System.out.println("空链表！");

			return;
		}

		System.out.println("链表的值为：");

		int p = head;

		while (p != -1) {

			System.out.print("[" + data[p] + "]-->");

			p = next[p];

		}

		System.out.println("结束");
	}
}
