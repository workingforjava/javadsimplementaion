package com.jaykay.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphByAdjacencyList {
	private int vertices;

	private List<List<Integer>> adjacencyList;

	public UndirectedGraphByAdjacencyList(int v) {
		vertices = v;
		adjacencyList = new ArrayList<List<Integer>>(v);
		for (int i = 0; i < v; i++)
			adjacencyList.add(new ArrayList<Integer>());

	}

	public int getVertices() {
		return vertices;
	}

	public List<List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	public static void main(String[] args) {
		UndirectedGraphByAdjacencyList udGraph = new UndirectedGraphByAdjacencyList(3);
		udGraph.addEdge(0, 1);
		udGraph.addEdge(1, 2);
		udGraph.addEdge(2, 0);
		udGraph.printAdjacencyList();

	}

	private void printAdjacencyList() {
		for (int i = 0; i < vertices; i++) {
			System.out.printf("Adjacency list of vertex %d is %s %s", i, adjacencyList.get(i), System.lineSeparator());
		}

	}

	public void addEdge(int from, int to) {
		adjacencyList.get(from).add(to);
		adjacencyList.get(to).add(from);
	}

}
