package com.java.array;

/**
 * 封装数组类，实现数组的增、删、改、查等功能
 * 
 * @author Yun
 *
 */
public class Myarray {

	// 定义数组的长度
	private int maxSize;

	private int array[];

	// 定义数组中数据区的最大下标
	private int index = -1;

	public Myarray(int maxSize) {

		this.maxSize = maxSize;

		array = new int[maxSize];

	}

	/**********************************************************************
	 ***************************** 插入函数 ********************************
	 **********************************************************************/
	public void insert(int value) {

		// 判断数组空间是否用完
		if (index >= maxSize - 1) {

			System.out.println("存储空间已满，不能插入！");

			return;

		}

		// 如果是空数组，则新插入的值放在第一个位置
		if (index == -1) {

			index = 0;

			array[0] = value;

			return;

		}

		// 新值插入头位置
		if (value < array[0]) {

			for (int j = index; j >= 0; j--) {

				array[j + 1] = array[j];

			}

			array[0] = value;

			index++;

			return;

		}

		// 新值插入中间位置
		for (int i = 0; i <= index; i++) {

			if (array[i] <= value && array[i + 1] > value) {

				for (int j = index; j > i; j--) {

					array[j + 1] = array[j];

				}

				array[i] = value;

				index++;

				return;
			}
		}

		// 新值插入尾位置
		index++;

		array[index] = value;

	}

	/**********************************************************************
	 ***************************** 删除函数 ********************************
	 **********************************************************************/
	public void delete(int value) {

		// 如果是空数组，则不能删除
		if (index == -1) {

			System.out.println("数组为空，不能删除！");

			return;

		}

		// 遍历数组
		for (int i = 0; i <= index; i++) {

			// 寻找删除元素的位置
			if (array[i] == value) {

				// 从删除位置开始，后面的元素前移
				for (int j = i; j < index; j++) {

					array[j] = array[j + 1];

				}

				// 清空最后一个元素
				array[index] = 0;

				// 因为少了一个元素，所以数据区的最大小标减一
				index--;

				// 从当前位置开始，继续向后查找
				i--;
			}
		}
	}

	/**********************************************************************
	 ***************************** 修改函数 ********************************
	 **********************************************************************/
	public void update(int oldValue, int newValue) {

		int count = 0;

		// 如果是空数组，则不能修改
		if (index == -1) {

			System.out.println("数组为空，不能修改！");

			return;

		}

		// 遍历数组
		for (int i = 0; i < index; i++) {

			if (array[i] == oldValue) {

				array[i] = newValue;

				System.err.println("下标为" + i + "的位置被修改！");

				count++;
			}
		}

		if (count == 0) {

			System.out.println("要修改的值未找到");

		} else {

			System.out.println("共修改了" + count + "个位置！");

			// 将修改后的数组重新排序
			bubbleSort(index);

		}
	}

	/**********************************************************************
	 ***************************** 选择函数 ********************************
	 **********************************************************************/
	public void select(int value) {

		int count = 0;

		// 如果是空数组，则不能查询
		if (index == -1) {

			System.out.println("数组为空，不能查询！");

			return;

		}

		for (int i = 0; i < index; i++) {

			if (array[i] == value) {

				count++;

				System.out.println("已找到第" + count + "个，在下标为" + i + "的位置上！");

			}
		}

		if (count == 0)

			System.out.println("数组中没有要查找的值！");
	}

	/**********************************************************************
	 ***************************** 输出数组 ********************************
	 **********************************************************************/
	public void print() {

		if (index == -1) {

			System.out.println("空数组！");

			return;
		}

		System.out.println("数组的值为:");

		for (int i = 0; i <= index; i++) {

			System.out.print(" [" + array[i] + "] ");

		}

		// 换行
		System.out.println();
	}

	/**********************************************************************
	 ***************************** 冒泡排序 ********************************
	 **********************************************************************/
	public void bubbleSort(int maxIndex) {

		int temp = 0;

		// 控制比较的范围
		for (int i = 0; i < maxIndex; i++) {

			// 比较一趟
			for (int j = 0; j < i; j--) {

				// 交换
				if (array[j + 1] < array[j]) {

					temp = array[j + 1];

					array[j + 1] = array[j];

					array[j] = temp;

				}
			}
		}
	}
}
