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
public class Diagraph {

	int NoOfVertex, count =0;
	int[][] adjacencyMatrix;
	int[][] treeMatrix;
	int[] visited;
	private Queue<Integer> queue;

	public Diagraph(int noOfVertex) {
		this.NoOfVertex = noOfVertex;
		adjacencyMatrix = new int[this.NoOfVertex][this.NoOfVertex];
		visited = new int[this.NoOfVertex];
		treeMatrix = new int[this.NoOfVertex][this.NoOfVertex];
	}

	public void addEdge(int fromVertex, int toVertex) {
		adjacencyMatrix[fromVertex][toVertex] = 1;
	}

	public void printMatrix(int[][] matrix) {

		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();

		s.append("  ");
		for (int i = 0; i < matrix.length; i++) {
			s.append(" " + i);
		}
		s.append(NEWLINE);

		for (int i = 0; i < matrix.length; i++) {
			s.append(" " + i);
			for (int j = 0; j < matrix.length; j++) {
				s.append(" " + matrix[i][j]);
			}
			s.append(NEWLINE);
		}
		System.out.println(s.toString());
	}

	public void bfs(int[][] adjacencyMatrix, int source) {
		queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = 1;
		int i, j;

		while (!queue.isEmpty()) {
			i = queue.remove();
			j = 0;
			System.out.print(i + " ");
			
			while (j <= adjacencyMatrix.length - 1) {
				if (adjacencyMatrix[i][j] == 1 && visited[j] == 0) {
					queue.add(j);
					treeMatrix[i][j] = 1;
					visited[j] = 1;
				}
				j++;
			}
			count++;
		}
		
		if(count < adjacencyMatrix.length){
			for (int k = 0; k < visited.length; k++) {
				if(visited[k] == 0){
					bfs(adjacencyMatrix, k);
				}
			}
		}
		System.out.println(" ");
	}
	
	public void dfs(int source){
		
		depthFirstSearch(source);
		if(count < adjacencyMatrix.length){
			for (int k = 0; k < visited.length; k++) {
				if(visited[k] == 0){
					depthFirstSearch(k);
				}
			}
		}

		
		
	}

	private void depthFirstSearch(int source) {
		visited[source] = 1;
		System.out.print(source + " ");
		
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			
			if(adjacencyMatrix[source][i] == 1 && visited[i] == 0){
				treeMatrix[source][i] = 1;
				count++;
				depthFirstSearch(i);
			}
		}
	}
	
}