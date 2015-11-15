package com.java.graph;

/**
 * 图类，封装类操作
 * 
 * @author Yun
 *
 */
public class MyGraph {

	// 表示图的数组
	private int graph[][];

	// 表示遍历时顶点是否访问过的数组，0为未访问，1为已访问
	private int visited[];

	// 顶点的个数
	private int vertexCount;

	// 构造方法，主要功能是表示图
	public MyGraph() {

		vertexCount = 8;

		visited = new int[vertexCount + 1];

		graph = new int[vertexCount + 1][vertexCount + 1];

		// 初始化数组，全部赋值99，表示不连通
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

	// 图的深度优先遍历算法
	public void depthFirstSearch(int vertex) {

		// 清空已访问顶点数组
		for (int i = 0; i <= vertexCount; i++) {

			visited[i] = 0;

		}

		System.out.print("深度优先遍历结果：");

		dfs(vertex);

		System.out.print("[end]");

		System.out.println();

	}

	// 图的深度优先遍历算法的递归方法
	private void dfs(int vertex) {

		// 设置当前顶点为已访问过
		visited[vertex] = 1;

		System.out.print("[" + vertex + "]->");

		// 搜索所有的顶点，看当前顶点vertex和哪些顶点连通
		for (int i = 1; i <= vertexCount; i++) {

			if (graph[vertex][i] != 99 && visited[i] == 0) {

				// 遍历顶点i
				dfs(i);

			}
		}
	}

	// 图的广度优先算法
	public void breadthFirstSearch(int vertex) {

		// 清空已访问顶点数组
		for (int i = 0; i <= vertexCount; i++) {

			visited[i] = 0;

		}

		// 定义数组表示队列
		int queue[] = new int[vertexCount + 1];

		// 表示队列的后端指针
		int rear = 0;

		// 表示队列的前端指针
		int front = 0;

		// 将当前顶点入队
		rear++;

		queue[rear] = vertex;

		// 设置当前顶点为已访问
		visited[vertex] = 1;

		System.out.print("广度优先遍历结果：");

		System.out.print("[" + vertex + "]->");

		// 如果队列不为空，就一直从队列中取顶点
		while (front != rear) {

			// 出队，从队列红取一个顶点
			front++;

			vertex = queue[front];

			// 搜索所有的顶点，找出与vertex连通的所有顶点
			for (int i = 1; i <= vertexCount; i++) {

				// 如果连通，且没有访问过
				if (graph[vertex][i] != 99 && visited[i] == 0) {

					// 则把与当前顶点相连通的顶点入队
					rear++;

					queue[rear] = i;

					// 并把其设为已访问过
					visited[i] = 1;

					System.out.print("[" + i + "]->");

				}
			}
		}

		System.out.print("[end]");

		System.out.println();
	}

	// 最短路径
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

		System.out.println(begin + "顶点到" + end + "顶点的最短距离为：" + shortPath[begin][end]);

	}

	// 打印图
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
