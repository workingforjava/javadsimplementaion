package com.jaykay.ds.graph;

public class DFSByRecursive {

	public static void main(String[] args) {

		UndirectedGraphByAdjacencyList g = new UndirectedGraphByAdjacencyList(5);

		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 0);
		g.addEdge(1, 3);
		g.addEdge(2, 4);

		traversal(g);

	}

	private static void traversal(UndirectedGraphByAdjacencyList g) {

		boolean[] visited = new boolean[g.getVertices()];

		for (int n = 0; n < g.getVertices(); n++) {

			if (!visited[n]) {
				dfs(g, n, visited);
			}

		}

	}

	private static void dfs(UndirectedGraphByAdjacencyList g, int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;
		System.out.printf("%d ", currentVertex);

		for (Integer n : g.getAdjacencyList().get(currentVertex)) {
			if (!visited[n]) {
				dfs(g, n, visited);
			}
		}

	}

}
