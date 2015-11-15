package com.java.graph;

/**
 * ͼ�࣬��װ�����
 * 
 * @author Yun
 *
 */
public class MyGraph {

	// ��ʾͼ������
	private int graph[][];

	// ��ʾ����ʱ�����Ƿ���ʹ������飬0Ϊδ���ʣ�1Ϊ�ѷ���
	private int visited[];

	// ����ĸ���
	private int vertexCount;

	// ���췽������Ҫ�����Ǳ�ʾͼ
	public MyGraph() {

		vertexCount = 8;

		visited = new int[vertexCount + 1];

		graph = new int[vertexCount + 1][vertexCount + 1];

		// ��ʼ�����飬ȫ����ֵ99����ʾ����ͨ
		for (int i = 1; i <= vertexCount; i++) {

			for (int j = 1; j <= vertexCount; j++) {

				graph[i][j] = 99;
			}

		}

		int relation[][] = { { 1, 2, 1 }, { 2, 1, 1 }, { 1, 3, 10 }, { 3, 1, 10 }, { 2, 4, 3 }, { 4, 2, 3 },
				{ 2, 5, 4 }, { 5, 2, 4 }, { 3, 6, 8 }, { 6, 3, 8 }, { 3, 7, 6 }, { 7, 3, 6 }, { 4, 8, 9 }, { 8, 4, 9 },
				{ 5, 8, 5 }, { 8, 5, 5 }, { 6, 8, 7 }, { 8, 6, 7 }, { 7, 8, 2 }, { 8, 7, 2 } };

		for (int i = 1; i <= relation.length; i++) {

			graph[relation[i - 1][0]][relation[i - 1][1]] = relation[i - 1][2];

		}

	}

	// ͼ��������ȱ����㷨
	public void depthFirstSearch(int vertex) {

		// ����ѷ��ʶ�������
		for (int i = 0; i <= vertexCount; i++) {

			visited[i] = 0;

		}

		System.out.print("������ȱ��������");

		dfs(vertex);

		System.out.print("[end]");

		System.out.println();

	}

	// ͼ��������ȱ����㷨�ĵݹ鷽��
	private void dfs(int vertex) {

		// ���õ�ǰ����Ϊ�ѷ��ʹ�
		visited[vertex] = 1;

		System.out.print("[" + vertex + "]->");

		// �������еĶ��㣬����ǰ����vertex����Щ������ͨ
		for (int i = 1; i <= vertexCount; i++) {

			if (graph[vertex][i] != 99 && visited[i] == 0) {

				// ��������i
				dfs(i);

			}
		}
	}

	// ͼ�Ĺ�������㷨
	public void breadthFirstSearch(int vertex) {

		// ����ѷ��ʶ�������
		for (int i = 0; i <= vertexCount; i++) {

			visited[i] = 0;

		}

		// ���������ʾ����
		int queue[] = new int[vertexCount + 1];

		// ��ʾ���еĺ��ָ��
		int rear = 0;

		// ��ʾ���е�ǰ��ָ��
		int front = 0;

		// ����ǰ�������
		rear++;

		queue[rear] = vertex;

		// ���õ�ǰ����Ϊ�ѷ���
		visited[vertex] = 1;

		System.out.print("������ȱ��������");

		System.out.print("[" + vertex + "]->");

		// ������в�Ϊ�գ���һֱ�Ӷ�����ȡ����
		while (front != rear) {

			// ���ӣ��Ӷ��к�ȡһ������
			front++;

			vertex = queue[front];

			// �������еĶ��㣬�ҳ���vertex��ͨ�����ж���
			for (int i = 1; i <= vertexCount; i++) {

				// �����ͨ����û�з��ʹ�
				if (graph[vertex][i] != 99 && visited[i] == 0) {

					// ����뵱ǰ��������ͨ�Ķ������
					rear++;

					queue[rear] = i;

					// ��������Ϊ�ѷ��ʹ�
					visited[i] = 1;

					System.out.print("[" + i + "]->");

				}
			}
		}

		System.out.print("[end]");

		System.out.println();
	}

	// ���·��
	public void floyed(int begin, int end) {

		int shortPath[][] = new int[vertexCount + 1][vertexCount + 1];

		for (int i = 1; i <= vertexCount; i++) {

			for (int j = 1; j <= vertexCount; j++) {

				shortPath[i][j] = graph[i][j];

			}
		}

		for (int k = 1; k <= vertexCount; k++) {

			for (int i = 1; i <= vertexCount; i++) {

				for (int j = 1; j <= vertexCount; j++) {

					if (i == k || j == k || i == j) {

						continue;

					}

					if (shortPath[i][k] + shortPath[k][j] < shortPath[i][j]) {

						shortPath[i][j] = shortPath[i][k] + shortPath[k][j];

					}
				}
			}
		}

		System.out.println(begin + "���㵽" + end + "�������̾���Ϊ��" + shortPath[begin][end]);

	}

	// ��ӡͼ
	public void print() {

		System.out.print(" ");

		for (int i = 1; i <= vertexCount; i++) {

			System.out.print(" " + i + "  ");
		}

		System.out.println();

		for (int i = 1; i <= vertexCount; i++) {

			System.out.print(i);

			for (int j = 1; j <= vertexCount; j++) {

				if (String.valueOf(graph[i][j]).length() == 1) {

					System.out.print(" " + graph[i][j] + "  ");

				} else {

					System.out.print(" " + graph[i][j] + " ");

				}
			}

			System.out.println();

		}
	}
}
