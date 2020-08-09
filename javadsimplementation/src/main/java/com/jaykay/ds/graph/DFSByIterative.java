package com.jaykay.ds.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSByIterative {

	static final int WHITE = 0, GRAY = 1, BLACK = 2;

	public static void main(String[] args) {

		UndirectedGraphByAdjacencyList g = new UndirectedGraphByAdjacencyList(5);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 0);
		g.addEdge(1, 3);
		g.addEdge(2, 4);

		dfsByIterative(g, 0);
		dfsByIterativeWithColor(g, 0);

	}

	private static void dfsByIterativeWithColor(UndirectedGraphByAdjacencyList g, int startVertex) {
		
		System.out.println("\n Iterative by color");

		int color[] = new int[g.getVertices()];

		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(startVertex);

		while (!stack.isEmpty()) {
			startVertex = stack.pop();

			if (color[startVertex] == WHITE) {

				color[startVertex] = GRAY;

				System.out.printf("%d ", startVertex);

				for (Integer n : g.getAdjacencyList().get(startVertex))
					stack.push(n);

				color[startVertex] = BLACK;

			}
		}

	}

	private static void dfsByIterative(UndirectedGraphByAdjacencyList g, int startVertex) {

		boolean[] visited = new boolean[g.getVertices()];

		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(startVertex);

		while (!stack.isEmpty()) {

			startVertex = stack.pop();

			if (!visited[startVertex]) {
				visited[startVertex] = true;
				System.out.printf("%d ", startVertex);

				// put all other vertices into stack one by one from the current index

				for (Integer n : g.getAdjacencyList().get(startVertex))
					stack.push(n);

			}

		}

	}

}
