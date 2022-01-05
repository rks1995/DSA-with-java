package graphs;

import java.util.Scanner;

public class Prims {

	static Scanner s = new Scanner(System.in);
	static int[][] matrix;
	static int[][] mst;
	static boolean[] visited;
	static int[] parent;
	static int[] weight;
	static int n, e;
	
	public static void primsAlgorithm() {
		mst = new int[n][n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			int v = findMinVertex();
			visited[v] = true;
			//exploring neighbours of v
			for(int j=0; j<n; j++) {
				if(matrix[v][j] > 0 && !visited[j]) {
					//update weight and parent matrix
					if(weight[j] > matrix[v][j]) {
						weight[j] = matrix[v][j];
						parent[j] = v; 
					}
				}
			}
		}
		
		//updating mst
		for(int i=1; i<n; i++) {
			int v1 = parent[i];
			int v2 = i;
			int w = weight[i];
			mst[v1][v2] = w;
			mst[v2][v1] = w;
		}
		
		
	}
	
	private static int findMinVertex() {
		int minVertex = -1;
		for(int i=0; i<n; i++) {
			if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		n = s.nextInt();
		e = s.nextInt();
		matrix = new int[n][n];
		parent = new int[n];
		weight = new int[n];
		// source -> vertex0
		parent[0] = -1;
		weight[0] = 0;
		for(int i=1; i<n; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			matrix[v1][v2] = w;
			matrix[v2][v1] = w;
		}
		
		primsAlgorithm();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(mst[i][j] > 0 && i<j) {
					System.out.println(i + " " + j + " "+ mst[i][j]);
				}
			}
		}
	}

}
