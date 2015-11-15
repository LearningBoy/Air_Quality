package com.binarytree;

/**
 * 二叉树类，封装二叉树操作
 * 
 * @author Yun
 *
 */
public class MyBinaryTree {

	// 树中节点的最大个数
	private int maxSize;

	// 节点的左指针域
	private int left[];

	// 节点的数据域
	private int data[];

	// 节点的右指针域
	private int right[];

	// 树的根节点的指针
	private int root = -1;

	// 构造方法
	public MyBinaryTree(int maxSize) {

		this.maxSize = maxSize;

		left = new int[maxSize];

		data = new int[maxSize];

		right = new int[maxSize];

		initMemory();

	}

	private void initMemory() {

		root = -1;

		// 初始化树的内存空间
		for (int i = 0; i < maxSize; i++) {

			left[i] = -2;

			data[i] = 0;

			right[i] = -2;

		}

	}

	// 创建二叉树
	public void buildBinaryTree(int array[]) {

		initMemory();

		int freePos = -1;

		for (int i = 0; i < array.length; i++) {

			// 找个空闲的数组下标
			freePos = findFreePos();

			if (freePos == -1) {

				System.out.println("树的存储空间已满，不能增加节点！");

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

		// 创建新节点
		left[freePos] = -1;

		data[freePos] = value;

		right[freePos] = -1;

		// 如果树为空，则新节点就是根节点，root指针指向新节点
		if (root == -1) {

			root = freePos;

			return;

		}

		int p = root;

		// 循环找到最低层的节点
		while (true) {

			// 到右子树找（大是右，小是左）
			if (value > data[p]) {

				// 如果当前节点有右子节点，P指针移到有子节点
				if (right[p] != -1) {

					p = right[p];

					// 否则，就是没有右子节点，则新节点就是当前节点的右子节点
				} else {

					right[p] = freePos;

					break;
				}

				// 到左子树找
			} else {

				// 如果当前节点有左子节点，p指针移到左子节点
				if (left[p] != -1) {

					p = left[p];

					// 否则，就是没有左子节点，则新节点就是当前结点的左子节点
				} else {

					left[p] = freePos;

					break;

				}
			}
		}
	}

	// 前序遍历二叉树
	public void preOrder() {

		if (root == -1) {

			System.out.println("空树！");

		} else {

			System.out.println("前序遍历：");

			getPreList(root);

			System.out.println();

		}
	}

	// 前序遍历的递归方法
	private void getPreList(int p) {

		if (p != -1) {

			System.out.print(data[p] + " ");

			getPreList(left[p]);

			getPreList(right[p]);

		}
	}

	// 中序遍历二叉树
	public void midOrder() {

		if (root == -1) {

			System.out.println("空树!");

		} else {

			System.out.println("中序遍历：");

			getMidList(root);

			System.out.println();
		}
	}

	// 中序遍历的递归方法
	public void getMidList(int p) {

		if (p != -1) {

			getMidList(left[p]);

			System.out.print(data[p] + " ");

			getMidList(right[p]);

		}
	}

	// 后序遍历二叉树
	public void postOrder() {

		if (root == -1) {

			System.out.println("空树！");

		} else {

			System.out.println("后序遍历：");

			getPostList(root);

			System.out.println();
		}
	}

	// 后序遍历的递归方法
	public void getPostList(int p) {

		if (p != -1) {

			getPostList(left[p]);

			getPostList(right[p]);

			System.out.print(data[p] + " ");
		}
	}
}
