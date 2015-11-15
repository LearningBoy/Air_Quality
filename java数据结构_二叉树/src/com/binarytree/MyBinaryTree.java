package com.binarytree;

/**
 * �������࣬��װ����������
 * 
 * @author Yun
 *
 */
public class MyBinaryTree {

	// ���нڵ��������
	private int maxSize;

	// �ڵ����ָ����
	private int left[];

	// �ڵ��������
	private int data[];

	// �ڵ����ָ����
	private int right[];

	// ���ĸ��ڵ��ָ��
	private int root = -1;

	// ���췽��
	public MyBinaryTree(int maxSize) {

		this.maxSize = maxSize;

		left = new int[maxSize];

		data = new int[maxSize];

		right = new int[maxSize];

		initMemory();

	}

	private void initMemory() {

		root = -1;

		// ��ʼ�������ڴ�ռ�
		for (int i = 0; i < maxSize; i++) {

			left[i] = -2;

			data[i] = 0;

			right[i] = -2;

		}

	}

	// ����������
	public void buildBinaryTree(int array[]) {

		initMemory();

		int freePos = -1;

		for (int i = 0; i < array.length; i++) {

			// �Ҹ����е������±�
			freePos = findFreePos();

			if (freePos == -1) {

				System.out.println("���Ĵ洢�ռ��������������ӽڵ㣡");

				return;

			} else {

				insertNode(freePos, array[i]);

			}

		}
	}

	private int findFreePos() {

		for (int i = 0; i < maxSize; i++) {

			if (left[i] == -2) {

				return i;

			}
		}

		return -1;

	}

	private void insertNode(int freePos, int value) {

		// �����½ڵ�
		left[freePos] = -1;

		data[freePos] = value;

		right[freePos] = -1;

		// �����Ϊ�գ����½ڵ���Ǹ��ڵ㣬rootָ��ָ���½ڵ�
		if (root == -1) {

			root = freePos;

			return;

		}

		int p = root;

		// ѭ���ҵ���Ͳ�Ľڵ�
		while (true) {

			// ���������ң������ң�С����
			if (value > data[p]) {

				// �����ǰ�ڵ������ӽڵ㣬Pָ���Ƶ����ӽڵ�
				if (right[p] != -1) {

					p = right[p];

					// ���򣬾���û�����ӽڵ㣬���½ڵ���ǵ�ǰ�ڵ�����ӽڵ�
				} else {

					right[p] = freePos;

					break;
				}

				// ����������
			} else {

				// �����ǰ�ڵ������ӽڵ㣬pָ���Ƶ����ӽڵ�
				if (left[p] != -1) {

					p = left[p];

					// ���򣬾���û�����ӽڵ㣬���½ڵ���ǵ�ǰ�������ӽڵ�
				} else {

					left[p] = freePos;

					break;

				}
			}
		}
	}

	// ǰ�����������
	public void preOrder() {

		if (root == -1) {

			System.out.println("������");

		} else {

			System.out.println("ǰ�������");

			getPreList(root);

			System.out.println();

		}
	}

	// ǰ������ĵݹ鷽��
	private void getPreList(int p) {

		if (p != -1) {

			System.out.print(data[p] + " ");

			getPreList(left[p]);

			getPreList(right[p]);

		}
	}

	// �������������
	public void midOrder() {

		if (root == -1) {

			System.out.println("����!");

		} else {

			System.out.println("���������");

			getMidList(root);

			System.out.println();
		}
	}

	// ��������ĵݹ鷽��
	public void getMidList(int p) {

		if (p != -1) {

			getMidList(left[p]);

			System.out.print(data[p] + " ");

			getMidList(right[p]);

		}
	}

	// �������������
	public void postOrder() {

		if (root == -1) {

			System.out.println("������");

		} else {

			System.out.println("���������");

			getPostList(root);

			System.out.println();
		}
	}

	// ��������ĵݹ鷽��
	public void getPostList(int p) {

		if (p != -1) {

			getPostList(left[p]);

			getPostList(right[p]);

			System.out.print(data[p] + " ");
		}
	}
}
