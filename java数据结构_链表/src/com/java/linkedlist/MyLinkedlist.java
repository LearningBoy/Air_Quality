package com.java.linkedlist;

/**
 * �������װ��ʵ����������ɾ���ġ���ȹ���
 * 
 * @author Yun
 *
 */
public class MyLinkedlist {

	// ���鳤��
	private int maxSize;

	// ������
	private int data[];

	// ָ����
	private int next[];

	// �����ͷָ��
	private int head = -1;

	public MyLinkedlist(int maxSize) {

		this.maxSize = maxSize;

		data = new int[maxSize];

		next = new int[maxSize];

		for (int i = 0; i < maxSize; i++) {

			// ��ʾ��δ��ʹ��
			next[i] = -2;

		}

	}

	// ���ҵõ�����Ŀ���λ�ã������õ������±�
	private int getFreePos() {

		for (int i = 0; i < maxSize; i++) {

			if (next[i] == -2) {

				return i;

			}
		}

		return -1;

	}

	/****************************************************************
	 * ���뺯�� *
	 ****************************************************************/
	public void insert(int value) {

		// �õ����еģ������õģ������±�
		int freePos = getFreePos();

		// �ж�����ռ��Ƿ�����
		if (freePos == -1) {

			System.out.println("�洢�ռ����������ܲ���!");

			return;

		}

		// �����½ڵ�
		data[freePos] = value;

		next[freePos] = -1;

		// �������Ϊ�գ����½ڵ���ڵ�һ��λ����
		if (head == -1) {

			// ͷָ��ָ���һ���ڵ�
			head = freePos;

			return;

		}

		// ͷָ�����ͷλ��
		if (value < data[head]) {

			// �½ڵ�ָ��ԭ����ͷ�ڵ�
			next[freePos] = head;

			// ��ʱ���½ڵ���ͷ�ڵ㣬����ͷָ��ָ���µ�ͷ�ڵ�
			head = freePos;

			return;

		}

		int p = head;

		// �½ڵ�����м�λ�ã���pλ��֮��
		while (next[p] != -1) {

			if (data[p] <= value && data[next[p]] > value) {

				// �½ڵ�ָ��p����һ���ڵ�
				next[freePos] = next[p];

				// pָ��Ľڵ��ָ��ָ���½ڵ�
				next[p] = freePos;

				return;

			}

			// pָ�������ƣ�ָ����һ���ڵ�
			p = next[p];

		}

		// �½ڵ����βλ��
		next[p] = freePos;

	}

	/****************************************************************
	 * ɾ������ *
	 ****************************************************************/
	public void delete(int value) {

		// �������Ϊ�գ�����ɾ��
		if (head == -1) {

			System.out.println("����Ϊ�գ�����ɾ����");

			return;

		}

		int p = head;

		// ɾ��ͷ�ڵ�
		if (data[head] == value) {

			// pָ��ԭ����ͷ�ڵ�
			p = head;

			// headָ���µ�ͷ�ڵ㣬���ڶ����ڵ�
			head = next[head];

			// �ͷ�pָ������ݽڵ�
			data[p] = 0;

			// �ͷ�pָ���ָ��ڵ�
			next[p] = -2;

			return;

		}

		p = head;

		int q = p;

		// ɾ����ͷ�ڵ�
		while (p != -1) {

			// ����ɾ��Ԫ�صĽڵ�λ��
			if (data[p] == value) {

				// p����һ���ڵ�ָ��p����һ���ڵ㣬��ɾ��p�ڵ�
				next[q] = next[p];

				// �ͷ�p��ָ������ݽڵ�
				data[p] = 0;

				// �ͷ�p��ָ���ָ��ڵ�
				next[p] = -2;

				return;

			}

			// qָ��ǰ�ڵ㣬pָ����һ���ڵ㣬����q��ָ��p��ǰһ���ڵ�
			q = p;

			p = next[p];

		}
	}

	/****************************************************************
	 * �޸ĺ��� *
	 ****************************************************************/
	public void update(int oldValue, int newValue) {

		// ����ǿ����������޸�
		if (head == -1) {

			System.out.println("����Ϊ�գ������޸ģ�");

			return;

		}

		int p = head;

		int q = p;

		// ��������
		while (p != -1) {

			// �����޸ĵĽڵ�λ��
			if (data[p] == oldValue) {

				// �����޸�Ԫ�ص�λ�ã��ҵ�����ֵ
				data[p] = newValue;

				// p����һ���ڵ�ָ��p����һ���ڵ㣬�൱��ɾ��pָ��Ľڵ�
				next[q] = next[p];

				// ���޸ĵĽڵ����²��룬��ʹ�䱣������
				insert(data[p]);

				return;

			}

			// qָ��ǰ��㣬pָ����һ���ڵ㣬����q���൱��ָ��p��ǰһ���ڵ�
			q = p;

			p = next[p];

		}
	}

	/****************************************************************
	 * ѡ���� *
	 ****************************************************************/
	public void select(int value) {

		// ����ǿ��������ܲ�ѯ
		if (head == -1) {

			System.out.println("����Ϊ�գ����E��ѯ");

			return;

		}

		int p = head;

		// ��������,���в�ѯ
		while (p != -1) {

			if (data[p] == value) {

				System.out.println("Ҫ���ҵĽڵ���" + p + "λ���ϣ�");

				return;
			}

			p = next[p];

		}

		System.out.println("������û��Ҫ���ҵ�ֵ��");

	}

	/****************************************************************
	 * ������� *
	 ****************************************************************/
	public void print() {

		// �������Ϊ�գ����ܴ�ӡ
		if (head == -1) {

			System.out.println("������");

			return;
		}

		System.out.println("�����ֵΪ��");

		int p = head;

		while (p != -1) {

			System.out.print("[" + data[p] + "]-->");

			p = next[p];

		}

		System.out.println("����");
	}
}
