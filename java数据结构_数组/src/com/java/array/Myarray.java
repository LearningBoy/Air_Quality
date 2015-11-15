package com.java.array;

/**
 * ��װ�����࣬ʵ�����������ɾ���ġ���ȹ���
 * 
 * @author Yun
 *
 */
public class Myarray {

	// ��������ĳ���
	private int maxSize;

	private int array[];

	// ����������������������±�
	private int index = -1;

	public Myarray(int maxSize) {

		this.maxSize = maxSize;

		array = new int[maxSize];

	}

	/**********************************************************************
	 ***************************** ���뺯�� ********************************
	 **********************************************************************/
	public void insert(int value) {

		// �ж�����ռ��Ƿ�����
		if (index >= maxSize - 1) {

			System.out.println("�洢�ռ����������ܲ��룡");

			return;

		}

		// ����ǿ����飬���²����ֵ���ڵ�һ��λ��
		if (index == -1) {

			index = 0;

			array[0] = value;

			return;

		}

		// ��ֵ����ͷλ��
		if (value < array[0]) {

			for (int j = index; j >= 0; j--) {

				array[j + 1] = array[j];

			}

			array[0] = value;

			index++;

			return;

		}

		// ��ֵ�����м�λ��
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

		// ��ֵ����βλ��
		index++;

		array[index] = value;

	}

	/**********************************************************************
	 ***************************** ɾ������ ********************************
	 **********************************************************************/
	public void delete(int value) {

		// ����ǿ����飬����ɾ��
		if (index == -1) {

			System.out.println("����Ϊ�գ�����ɾ����");

			return;

		}

		// ��������
		for (int i = 0; i <= index; i++) {

			// Ѱ��ɾ��Ԫ�ص�λ��
			if (array[i] == value) {

				// ��ɾ��λ�ÿ�ʼ�������Ԫ��ǰ��
				for (int j = i; j < index; j++) {

					array[j] = array[j + 1];

				}

				// ������һ��Ԫ��
				array[index] = 0;

				// ��Ϊ����һ��Ԫ�أ����������������С���һ
				index--;

				// �ӵ�ǰλ�ÿ�ʼ������������
				i--;
			}
		}
	}

	/**********************************************************************
	 ***************************** �޸ĺ��� ********************************
	 **********************************************************************/
	public void update(int oldValue, int newValue) {

		int count = 0;

		// ����ǿ����飬�����޸�
		if (index == -1) {

			System.out.println("����Ϊ�գ������޸ģ�");

			return;

		}

		// ��������
		for (int i = 0; i < index; i++) {

			if (array[i] == oldValue) {

				array[i] = newValue;

				System.err.println("�±�Ϊ" + i + "��λ�ñ��޸ģ�");

				count++;
			}
		}

		if (count == 0) {

			System.out.println("Ҫ�޸ĵ�ֵδ�ҵ�");

		} else {

			System.out.println("���޸���" + count + "��λ�ã�");

			// ���޸ĺ��������������
			bubbleSort(index);

		}
	}

	/**********************************************************************
	 ***************************** ѡ���� ********************************
	 **********************************************************************/
	public void select(int value) {

		int count = 0;

		// ����ǿ����飬���ܲ�ѯ
		if (index == -1) {

			System.out.println("����Ϊ�գ����ܲ�ѯ��");

			return;

		}

		for (int i = 0; i < index; i++) {

			if (array[i] == value) {

				count++;

				System.out.println("���ҵ���" + count + "�������±�Ϊ" + i + "��λ���ϣ�");

			}
		}

		if (count == 0)

			System.out.println("������û��Ҫ���ҵ�ֵ��");
	}

	/**********************************************************************
	 ***************************** ������� ********************************
	 **********************************************************************/
	public void print() {

		if (index == -1) {

			System.out.println("�����飡");

			return;
		}

		System.out.println("�����ֵΪ:");

		for (int i = 0; i <= index; i++) {

			System.out.print(" [" + array[i] + "] ");

		}

		// ����
		System.out.println();
	}

	/**********************************************************************
	 ***************************** ð������ ********************************
	 **********************************************************************/
	public void bubbleSort(int maxIndex) {

		int temp = 0;

		// ���ƱȽϵķ�Χ
		for (int i = 0; i < maxIndex; i++) {

			// �Ƚ�һ��
			for (int j = 0; j < i; j--) {

				// ����
				if (array[j + 1] < array[j]) {

					temp = array[j + 1];

					array[j + 1] = array[j];

					array[j] = temp;

				}
			}
		}
	}
}
