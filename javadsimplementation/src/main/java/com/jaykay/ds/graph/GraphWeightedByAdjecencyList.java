package com.jaykay.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphWeightedByAdjecencyList {

	private int vertices;
	private List<List<WeightedVertex>> adjecencyList;

	public GraphWeightedByAdjecencyList(int noOfVertex) {

		vertices = noOfVertex;
		adjecencyList = new ArrayList<List<WeightedVertex>>();

		for (int i = 0; i < noOfVertex; i++) {
			adjecencyList.add(new ArrayList<>());
		}

	}

	public static void main(String[] args) {

		GraphWeightedByAdjecencyList weightedGraph = new GraphWeightedByAdjecencyList(4);
		weightedGraph.addEdge(0, 1, 19);
		weightedGraph.addEdge(2, 0, 15);
		weightedGraph.addEdge(2, 1, 17);
		weightedGraph.addEdge(3, 2, 12);
		weightedGraph.printAdjacencyList();
	}

	private void printAdjacencyList() {

		for (int i = 0; i < getVertices(); i++) {
			System.out.printf("Adjecency list of vertex %d is %s %s", i, adjecencyList.get(i), System.lineSeparator());
		}

	}

	private void addEdge(int from, int to, int weight) {

		getAdjecencyList().get(from).add(new WeightedVertex(to, weight));

	}

	public int getVertices() {
		return vertices;
	}

	public List<List<WeightedVertex>> getAdjecencyList() {
		return adjecencyList;
	}

	static class WeightedVertex {
		public Integer getVertex() {
			return vertex;
		}

		public Integer getWeight() {
			return weight;
		}

		final Integer vertex, weight;

		WeightedVertex(int vertex, int weight) {

			this.vertex = vertex;
			this.weight = weight;

		}

		public String toString() {
			return String.format("%d (weight %d)", vertex, weight);
		}
	}

}
