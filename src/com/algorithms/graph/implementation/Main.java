/**
 * 
 */
package com.algorithms.graph.implementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul
 *
 */
public class Main {

	public static Diagraph graph;
	static int count = 0;
	static String spaceChar = "     ";
	public static void main(String[] args) {

		System.out.println("Graph =====");
		createGraph(10).printMatrix(graph.adjacencyMatrix);
		
		System.out.println("Graph BFS with Source as 7 =====");
		createGraph(10).bfs(graph.adjacencyMatrix, 7);
		graph.printMatrix(graph.treeMatrix);
		
		System.out.println("Graph BFS with Source as 3 =====");
		createGraph(10).bfs(graph.adjacencyMatrix, 3);
		graph.printMatrix(graph.treeMatrix);
		
		System.out.println("Graph DFS with Source as 3 =====");
		createGraph(10).dfs(3);
		System.out.println(" ");
		graph.printMatrix(graph.treeMatrix);
		
		System.out.println("Graph DFS with Source as 1 =====");
		createGraph(10).dfs(1);
		System.out.println(" ");
		graph.printMatrix(graph.treeMatrix);
	}

	public static Diagraph createGraph(int i) {
		graph = new Diagraph(i);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 9);
		graph.addEdge(5, 8);
		graph.addEdge(5, 6);
		graph.addEdge(6, 1);
		graph.addEdge(6, 2);
		graph.addEdge(6, 9);
		graph.addEdge(7, 0);
		graph.addEdge(7, 9);
		graph.addEdge(7, 3);
		graph.addEdge(7, 5);
		graph.addEdge(8, 3);
		graph.addEdge(8, 2);
		graph.addEdge(9, 1);
		graph.addEdge(9, 8);
		graph.addEdge(9, 7);
		
		return graph;
	}
}