package com.jaykay.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class DiGraphByAdjecencyList {

	private int vertices;

	public int getVertiecs() {
		return vertices;
	}

	public List<List<Integer>> getEdges() {
		return edges;
	}

	private List<List<Integer>> edges;

	public DiGraphByAdjecencyList(int v) {
		vertices = v;
		edges = new ArrayList<List<Integer>>(v);
		for (int i = 0; i < v; i++) {
			edges.add(new ArrayList<Integer>());
		}

	}

	public static void main(String[] args) {
		DiGraphByAdjecencyList graph = new DiGraphByAdjecencyList(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.printAdjacencyList();
	}

	private void addEdge(int i, int j) {
		edges.get(i).add(j);

	}

	private void printAdjacencyList() {
		for (int i = 0; i < vertices; i++) {
			System.out.printf("Adjacency list of vertex %d is %s %s", i, edges.get(i), System.lineSeparator());
		}

	}

}
