package graphs;

import java.util.Scanner;

public class Dijkstra {

	static boolean[] visited;
	static int[] distance;
	public static void dijkstraAlgorithm(int[][] matrix, int n) {
		visited = new boolean[n];
		distance = new int[n];
		distance[0] = 0;
		for(int i=1; i<n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<n; i++) {
			int v = findMinVertex(n);
			visited[v] = true;
			//explore neighbours of v
			for(int j=0; j<n; j++) {
				if(!visited[j] && matrix[v][j] > 0) {
					if(distance[j] > distance[v]+matrix[v][j]) {
						distance[j] = distance[v] + matrix[v][j];
					}
				}
			}
		}
	}
	
	
	private static int findMinVertex(int n) {
		int minVertex = -1;
		for(int i=0; i<n; i++) {
			if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int matrix[][] = new int[n][n];
		
		for(int i=0; i<e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			matrix[v1][v2] = w;
			matrix[v2][v1] = w;
		}
		
		dijkstraAlgorithm(matrix, n);
		
		for(int i=0; i<n; i++) {
			System.out.println(i + " " + distance[i]);
		}
		s.close();

	}

}
