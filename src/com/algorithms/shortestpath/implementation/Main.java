package com.algorithms.shortestpath.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
	public final Integer vertexId;
	
	public Edge[] adjacencyArray;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	public Vertex(Integer argID) {
		vertexId = argID;
	}
	
	public boolean equals(Vertex vertex){
		return this.vertexId.equals(vertex.vertexId);
	}
	
	@Override
	public int compareTo(Vertex destVertex) {
		return Double.compare(minDistance, destVertex.minDistance);
	}
	
	public Edge getEdgeBetweenVertex(Vertex v){
		Edge edgeBetween = null;
		for (Edge edge : this.adjacencyArray) {
			if(v.equals(edge.destinationVertex)){
				edgeBetween = edge;
			}
		}
		return edgeBetween;
	}
}

class Edge {
	public final Vertex destinationVertex;
	public final double weightOfEdge;
	public boolean isShortestEdge = false;

	public Edge(Vertex argdest, double argWeight) {
		destinationVertex = argdest;
		weightOfEdge = argWeight;
	}
}

public class Main {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			for (Edge e : u.adjacencyArray) {
				Vertex v = e.destinationVertex;
				double weight = e.weightOfEdge;
				double distanceFromSource = u.minDistance + weight;
				if (distanceFromSource < v.minDistance) {
					e.isShortestEdge = true;
					v.minDistance = distanceFromSource;
					v.previous = u;
					vertexQueue.add(v);
				}else{
					e.isShortestEdge = false;
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		Vertex prev;
		while ((prev = target.previous) != null) {
			path.add(target);
			System.out.println("vertex from = " + prev.vertexId + " --------( " + prev.getEdgeBetweenVertex(target).weightOfEdge  +" )--------> " + " vertex To = " + target.vertexId);
			target = prev;
		}
		Collections.reverse(path);
		return path;
	}

	public static Edge getShortestEdge(Edge[] adjacencyArray){
		
		Edge shortestEdge = null;
		for (Edge edge : adjacencyArray) {
			if(edge.isShortestEdge){
				shortestEdge = edge;
			}
		}
		return shortestEdge;
	}
	
	public static void main(String[] args) {
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);

		v0.adjacencyArray = new Edge[] { new Edge(v1, 5), new Edge(v2, 11),
				new Edge(v3, 81), new Edge(v4, 56), new Edge(v8, 34) };
		v1.adjacencyArray = new Edge[] { new Edge(v0, 32), new Edge(v2, 3),
				new Edge(v4, 7), new Edge(v8, 45), new Edge(v5, 56) };
		v2.adjacencyArray = new Edge[] { new Edge(v9, 65), new Edge(v4, 78),
				new Edge(v1, 23) };
		v3.adjacencyArray = new Edge[] { new Edge(v0, 8), new Edge(v4, 2),
				new Edge(v2, 7), new Edge(v6, 78), new Edge(v7, 6) };
		v4.adjacencyArray = new Edge[] { new Edge(v1, 7), new Edge(v3, 2) };
		v5.adjacencyArray = new Edge[] { new Edge(v8, 7), new Edge(v3, 4),
				new Edge(v1, 2) };
		v6.adjacencyArray = new Edge[] { new Edge(v5, 17), new Edge(v0, 21) };
		v7.adjacencyArray = new Edge[] { new Edge(v8, 17), new Edge(v2, 21) };
		v8.adjacencyArray = new Edge[] { new Edge(v6, 57), new Edge(v2, 24) };
		v9.adjacencyArray = new Edge[] { new Edge(v7, 17), new Edge(v6, 8) };

		Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9 };
		computePaths(v0);
		for (Vertex v : vertices) {
			System.out.println("Distance to Vertex" + v.vertexId + ": "
					+ v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
		}
	}
}